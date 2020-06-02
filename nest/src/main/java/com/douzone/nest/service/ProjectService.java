package com.douzone.nest.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.nest.repository.ProjectRepository;
import com.douzone.nest.vo.ProjectVo;
import com.douzone.nest.vo.UserProjectVo;
import com.douzone.nest.vo.UserVo;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

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
	 * 작성자 : 한해용
	 * 설명 : 멤버 초대
	 */
	public boolean userInvite(UserVo userVo) {
		int userInsert = projectRepository.userInsert(userVo);
		int userProjectJoin = projectRepository.userProjectJoin(userVo);
		return (userInsert + userProjectJoin) == 2;
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
}
