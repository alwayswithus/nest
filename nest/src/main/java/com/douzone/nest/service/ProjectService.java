package com.douzone.nest.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.douzone.nest.repository.ProjectRepository;
import com.douzone.nest.repository.UserRepository;
import com.douzone.nest.vo.FileVo;
import com.douzone.nest.vo.ProjectVo;
import com.douzone.nest.vo.UserProjectVo;
import com.douzone.nest.vo.UserVo;
import com.douzone.util.MailHandler;
import com.douzone.util.MailController;
import com.douzone.util.TempKey;

@Service
public class ProjectService {
	
	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private UserRepository userRepository;

	@SuppressWarnings("unchecked")
	public JSONObject selectProject(long authUserNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		// 메인 {}
		JSONObject obj = new JSONObject();

		// allProject []
		JSONArray allProjectArray = new JSONArray();
		List<ProjectVo> allProjectList = projectRepository.selectProject(authUserNo);
		for(ProjectVo projectVo : allProjectList) {
			// 하나의 project {}
			JSONObject project = new JSONObject();
			project.put("projectNo", projectVo.getProjectNo());
			project.put("projectTitle", projectVo.getProjectTitle());
			project.put("projectDesc", projectVo.getProjectDesc());
			project.put("projectStart", projectVo.getProjectStart());
			project.put("projectEnd", projectVo.getProjectEnd());
			project.put("projectState", projectVo.getProjectState());
			project.put("projectRegDate", projectVo.getProjectRegDate());
			project.put("projectWriter", projectVo.getProjectWriter());
			project.put("projectWriterName", projectVo.getProjectWriterName());
			project.put("taskCount", projectVo.getTaskCount());
			project.put("completedTask", projectVo.getCompletedTask());
			project.put("roleNo", projectVo.getRoleNo());

			// members []
			JSONArray memberArray = new JSONArray();
			map.put("projectNo", projectVo.getProjectNo());
			map.put("userNo", authUserNo);
			List<UserVo> userList = projectRepository.selectUser(map);
			for(UserVo userVo : userList) {
				// 하나의 member {}
				JSONObject member = new JSONObject();
				member.put("userNo", userVo.getUserNo());
				member.put("roleNo", userVo.getRoleNo());
				member.put("userName", userVo.getUserName());
				member.put("userEmail", userVo.getUserEmail());
				member.put("userPhoto", userVo.getUserPhoto());
				member.put("userGrade", userVo.getUserGrade());

				memberArray.add(member);
			}
			project.put("members", memberArray);

			allProjectArray.add(project);
		}

		obj.put("allProject", allProjectArray);

		return obj;
	}
	/*
	 * 작성자 : 한해용
	 * 설명 : 프로젝트 추가
	 */
	public boolean projectAdd(ProjectVo projectVo, long authUserNo) {

		// 프로젝트 먼저 insert (member X) => projectNo를 가져오기 위해서
		int projectNotMember = projectRepository.insertProjectNotMember(projectVo);

		Map<String, Object> map = new HashMap<String, Object>();;
		map.put("projectNo", projectVo.getProjectNo());
		map.put("userNo", authUserNo);
		
		int authUser = projectRepository.insertAuthUser(map);
		int projectWithMember = 0;

		if(projectVo.getMembers().isEmpty()) {
			return (projectNotMember + authUser) == 2;
		}
		else {
			for(UserVo member : projectVo.getMembers()) {			
				map.put("projectNo", projectVo.getProjectNo());
				map.put("userNo", member.getUserNo());
				
				// userproject 테이블에 insert
				if(authUserNo == member.getUserNo()) {
					projectWithMember = 1;
					continue;
				}
				projectWithMember = projectRepository.insertUserProject(map);
			}
			return (projectNotMember + authUser + projectWithMember) == 3;
		}
	}
	
	/*
	 * 작성자 : 한해용
	 * 설명 : 멤버 추가
	 */
	public boolean userAdd(UserProjectVo userProjectVo) {
		return projectRepository.userAdd(userProjectVo) == 1;
	}
	
	/*
	 * 작성자 : 한해용
	 * 설명 : 멤버 삭제
	 */
	public boolean userDelete(UserProjectVo userProjectVo) {
		return projectRepository.userDelete(userProjectVo) == 1;
	}
	
	/*
	 * 작성자 : 허길행
	 * 설명 : 맴버 체크
	 */
	public UserVo userCk(UserVo userVo) {
		UserVo cc = projectRepository.userCC(userVo);
		if(null!=cc) {
			cc.setProjectNo(userVo.getProjectNo());
			return cc;
		}
		else {
			if(1==projectRepository.userInsert(userVo))
				return userVo;
			else
				return null;
		}
	}
	
	/*
	 * 작성자 : 한해용
	 * 설명 : 멤버 초대
	 */
	public boolean userInvite(UserVo userVo) {
		int userProjectJoin = projectRepository.userProjectJoin(userVo);
		
		/* 인증 이메일 발송 코드...*/
		// 인증키 생성
        String key = new TempKey().getKey(50, false);
        // 데이터 베이스에 인증키 세팅
        userVo.setUserKey(key);
        userRepository.setEmailConfirm(userVo);
        // 메일 발송용 컨트롤러 생성 및 발송 메서드 실행...
        try {
        	MailController mailController = new MailController(new MailHandler(mailSender));
        	mailController.userInviteMailSend(userVo.getUserEmail(), key);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
        //이메일 발송 확인
        System.out.println("프로젝트 멤버 초대 메일발송!");
		
		return (userProjectJoin) == 1;
	}
	
	/*
	 * 작성자 : 한해용
	 * 설명 : 프로젝트 제목 수정
	 */
	public boolean titleUpdate(ProjectVo projectVo) {
		int titleUpdate = projectRepository.titleUpdate(projectVo);
		return titleUpdate == 1;
	}
	
	/*
	 * 작성자 : 한해용
	 * 설명 : 프로젝트 설명 수정
	 */
	public boolean descUpdate(ProjectVo projectVo) {
		int titleUpdate = projectRepository.descUpdate(projectVo);
		return titleUpdate == 1;
	}
	
	/*
	 * 작성자 : 한해용
	 * 설명 : 프로젝트 상태 수정
	 */
	public boolean stateUpdate(ProjectVo projectVo) {
		int stateUpdate = projectRepository.stateUpdate(projectVo);
		return stateUpdate == 1;
  }
  
	public List<UserVo> projectMemberSelect(Long projectNo) {
		return projectRepository.projectMemberSelect(projectNo);
	}

	/*
	 * 작성자 : 최인효
	 * 설명 : 프로젝트 마감 날짜 수정 
	 */
	public boolean projectDateUpdate(ProjectVo projectVo) {
		int dateUpdate = projectRepository.projectDateUpdate(projectVo);
		return dateUpdate == 1;
  }
	
	/*
	 * 작성자:김우경
	 * 설명:프로젝트 별 파일 select
	 */
	public List<FileVo> selectFile(Long projectNo) {
		return projectRepository.selectFile(projectNo);
	}
	
	public boolean projectDelete(ProjectVo projectVo) {
		int userProjectUpdate = projectRepository.userProjectUpdate(projectVo);
		int userProjectDelete = projectRepository.userProjectDelete(projectVo);
		return (userProjectUpdate + userProjectDelete) == 2;
	}
	
	public boolean notTransferDelete(ProjectVo projectVo) {
		int notTransferDelete = projectRepository.notTransferDelete(projectVo);
		return notTransferDelete == 1;
	}
	
	public boolean foreverdelete(ProjectVo projectVo) {
		int foreverdelete = projectRepository.foreverdelete(projectVo);
		return foreverdelete == 1;
	}
}
