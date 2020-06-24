package com.douzone.nest.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.nest.repository.CalendarRepository;
import com.douzone.nest.repository.KanbanBoardRepository;
import com.douzone.nest.repository.ProjectRepository;
import com.douzone.nest.vo.CheckListVo;
import com.douzone.nest.vo.CommentVo;
import com.douzone.nest.vo.FileVo;
import com.douzone.nest.vo.TagListVo;
import com.douzone.nest.vo.TaskListVo;
import com.douzone.nest.vo.TaskVo;
import com.douzone.nest.vo.UserProjectVo;
import com.douzone.nest.vo.UserVo;

@Service
public class CalendarService {

	@Autowired
	private CalendarRepository calendarRepository;
	
	@Autowired
	private KanbanBoardRepository kanbanBoardRepository;
	
	@Autowired ProjectRepository projectRepository;
	
	@SuppressWarnings("unchecked")
	public JSONObject selectTask(Long authUserNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		// 메인 {}
		JSONObject obj = new JSONObject();

		// allTask []
		JSONArray allTaskArray = new JSONArray();
		List<TaskVo> allTaskList = calendarRepository.selectTask(authUserNo);
		for(TaskVo taskVo : allTaskList) {
			// 하나의 task {}
			JSONObject task = new JSONObject();
			task.put("id", taskVo.getTaskNo());
			task.put("start", taskVo.getTaskStart());
			task.put("end", taskVo.getTaskEnd());
			task.put("taskPoint", taskVo.getTaskPoint());
			task.put("color", taskVo.getTaskLabel());
			task.put("taskState", taskVo.getTaskState());
			task.put("title", taskVo.getTaskContents());
			task.put("tasklistNo", taskVo.getTaskListNo());
			task.put("projectNo", taskVo.getProjectNo());
			
			map.put("taskNo", taskVo.getTaskNo());
			map.put("authUserNo", authUserNo);
			Long userNo = calendarRepository.selectUser(map);
			if(userNo == null) {
				userNo = (long) 0;
			}
			task.put("userNo", userNo);
			
			allTaskArray.add(task);
		}
		
		obj.put("allTask", allTaskArray);
		return obj;
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject selectTaskList(Long projectNo) {
		
		// 메인 {}
		JSONObject obj = new JSONObject();
		
		// allTaskList []
		JSONArray allTaskListArray = new JSONArray();
		List<TaskListVo> allTaskList = calendarRepository.selectTaskList(projectNo);
		for(TaskListVo tasklistVo : allTaskList) {
			// 하나의 tasklist {}
			JSONObject tasklist = new JSONObject();
			tasklist.put("tasklistNo", tasklistVo.getTaskListNo());
			tasklist.put("tasklistName", tasklistVo.getTaskListName());
			tasklist.put("tasklistOrder", tasklistVo.getTaskListOrder());
			tasklist.put("projectNo", tasklistVo.getProjectNo());
			
			allTaskListArray.add(tasklist);
		}
		
		obj.put("allTaskList", allTaskListArray);
		return obj;
	}
	
	public boolean taskAdd(TaskVo taskVo) {
		long taskOrder = calendarRepository.selectTaskOrder(taskVo) + 1;
		taskVo.setTaskOrder(taskOrder);
		int taskAdd = calendarRepository.taskAdd(taskVo);
		return taskAdd == 1;
	}

	public List<UserProjectVo> selectProjectNo(Long userNo) {
		return calendarRepository.selectProjectNo(userNo);
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject selectAllTasks(List<UserProjectVo> userProjectNo, Long authUserNo) {
		
		// 메인 {}
		JSONObject testobj = new JSONObject();
		JSONArray objArray = new JSONArray();
		
		
		for(UserProjectVo projectNo : userProjectNo) {
			JSONObject allProjects = new JSONObject();

			//allTaskLsit[]
			JSONArray allTaskLsitJSONArray = new JSONArray();
			
			List<TaskListVo> allTaskLsit = kanbanBoardRepository.selectAllTaskList(projectNo.getProjectNo());
			for (TaskListVo taskListVo : allTaskLsit) {
				// 하나의 TaskList{}
				JSONObject taskList = new JSONObject();
				taskList.put("taskListNo", taskListVo.getTaskListNo() + "");
				taskList.put("taskListName", taskListVo.getTaskListName());
				taskList.put("taskListOrder", taskListVo.getTaskListOrder());
				taskList.put("projectNo", taskListVo.getProjectNo());
				taskList.put("taskListState", taskListVo.getTaskListState());
	
				// tasks[]
				JSONArray tasksJSONArray = new JSONArray();
				List<TaskVo> tasks = kanbanBoardRepository.selectTasks(taskListVo.getTaskListNo());
				for (TaskVo taskVo : tasks) {
					// 하나의 Task{}
					JSONObject task = new JSONObject();
					task.put("taskNo", taskVo.getTaskNo() + "");
					task.put("taskStart", taskVo.getTaskStart());
					task.put("taskEnd", taskVo.getTaskEnd());
					task.put("taskPoint", taskVo.getTaskPoint());
					task.put("taskLabel", taskVo.getTaskLabel());
					task.put("taskState", taskVo.getTaskState());
					task.put("taskContents", taskVo.getTaskContents());
					task.put("taskOrder", taskVo.getTaskOrder());
					task.put("taskRegdate", taskVo.getTaskRegdate());
					task.put("taskWriter", taskVo.getTaskWriter());
					task.put("userName", taskVo.getUserName());
	
					// checkList[]
					JSONArray checkListJSONArray = new JSONArray();
					List<CheckListVo> checkLists = kanbanBoardRepository.selectCheckList(taskVo.getTaskNo());
					for (CheckListVo checkListVo : checkLists) {
						// 하나의 checkList{}
						JSONObject checkList = new JSONObject();
						checkList.put("checklistNo", checkListVo.getChecklistNo());
						checkList.put("checklistContents", checkListVo.getChecklistContents());
						checkList.put("checklistState", checkListVo.getChecklistState());
						checkList.put("taskNo", checkListVo.getTaskNo());
	
						checkListJSONArray.add(checkList);
					}
					task.put("checkList", checkListJSONArray);
	
					// tag[]
					JSONArray tagJSONArray = new JSONArray();
					List<TagListVo> tags = kanbanBoardRepository.selectTag(taskVo.getTaskNo());
					for (TagListVo tagVo : tags) {
						// 하나의 tagList{}
						JSONObject tagList = new JSONObject();
						tagList.put("tagNo", tagVo.getTagNo());
						tagList.put("taskNo", tagVo.getTaskNo());
						tagList.put("tagName", tagVo.getTagName());
						tagList.put("tagColor", tagVo.getTagColor());
						tagJSONArray.add(tagList);
					}
					task.put("tagList", tagJSONArray);
	
					// comments[]
					JSONArray commentsJSONArray = new JSONArray();
					List<CommentVo> comments = kanbanBoardRepository.selectComments(taskVo.getTaskNo());
					for (CommentVo commentVo : comments) {
						// 하나의 TaskList{}
						JSONObject commentList = new JSONObject();
						commentList.put("commentNo", commentVo.getCommentNo());
						commentList.put("commentRegdate", commentVo.getCommentRegdate());
						commentList.put("commentContents", commentVo.getCommentContents());
						commentList.put("commentLike", commentVo.getCommentLike());
						commentList.put("userNo", commentVo.getUserNo());
						commentList.put("userName", commentVo.getUserName());
						commentList.put("userEmail", commentVo.getUserEmail());
						commentList.put("userPhoto", commentVo.getUserPhoto());
						commentList.put("filePath", commentVo.getFilePath());
						commentList.put("originName", commentVo.getOriginName());
						commentList.put("fileRegDate", commentVo.getFileRegdate());
						commentList.put("taskNo", commentVo.getTaskNo());
						commentList.put("fileNo", commentVo.getFileNo());
						commentList.put("commentState", commentVo.getCommentState());
						commentList.put("fileState", commentVo.getFileState());
						
						commentsJSONArray.add(commentList);
					}
					task.put("commentList", commentsJSONArray);
	
					JSONArray fileJSONArray = new JSONArray();
					List<FileVo> fileList = kanbanBoardRepository.selectFileList(taskVo.getTaskNo());
					for (FileVo fileVo : fileList) {
						// 파일
						JSONObject file = new JSONObject();
	
						file.put("fileNo", fileVo.getFileNo());
						file.put("originName", fileVo.getOriginName());
						file.put("changeName", fileVo.getChangeName());
						file.put("filePath", fileVo.getFilePath());
						file.put("fileRegdate", fileVo.getFileRegdate());
						file.put("taskNo", fileVo.getTaskNo());
						file.put("fileState", fileVo.getFileState());
	
						fileJSONArray.add(file);
					}
					task.put("fileList", fileJSONArray);
	
					JSONArray memberJSONArray = new JSONArray();
					List<UserVo> memberList = kanbanBoardRepository.selectMemberList(taskVo.getTaskNo());
					for (UserVo memberVo : memberList) {
						//멤버
						JSONObject member = new JSONObject();
	
						member.put("userNo", memberVo.getUserNo());
						member.put("userRegdate", memberVo.getUserRegdate());
						member.put("userEmail", memberVo.getUserEmail());
						member.put("userName", memberVo.getUserName());
						member.put("userNumber", memberVo.getUserNumber());
						member.put("userBirth", memberVo.getUserBirth());
						member.put("userTitle", memberVo.getUserTitle());
						member.put("userDept", memberVo.getUserDept());
						member.put("userPhoto", memberVo.getUserPhoto());
						member.put("userGrade", memberVo.getUserGrade());
						memberJSONArray.add(member);
					}
					task.put("memberList", memberJSONArray);
	
					tasksJSONArray.add(task);
				}
				taskList.put("tasks", tasksJSONArray);
	
				allTaskLsitJSONArray.add(taskList);
			}
			allProjects.put("allTaskList", allTaskLsitJSONArray);
			
			Map <String, Object> roleMap = new HashMap<String, Object>();
			
			roleMap.put("projectNo", projectNo.getProjectNo());
			roleMap.put("authUserNo", authUserNo);
			
			Long authUserRole = kanbanBoardRepository.selectAuthUserRole(roleMap);
			
			allProjects.put("projectNo", projectNo.getProjectNo());  
			allProjects.put("authUserRole", authUserRole);
			
			objArray.add(allProjects);
		}
		
		
		testobj.put("allProjects",objArray);

		return testobj;
		
	}

	public JSONObject selectAllProjectMembers(List<UserProjectVo> userProjectNo, Long userNo) {
		// {}
		JSONObject testobj = new JSONObject();
		JSONArray objArray = new JSONArray();
		
		for(UserProjectVo projectNo : userProjectNo) {
			JSONObject allProjects = new JSONObject();

			//allProjectMembers []
			JSONArray allTaskLsitJSONArray = new JSONArray();
			
			List<UserVo> userList = projectRepository.projectMemberSelect(projectNo.getProjectNo());
			for(UserVo userVo : userList) {
				JSONObject members = new JSONObject();
				
				members.put("userNo", userVo.getUserNo());
				members.put("userName", userVo.getUserName());
				members.put("userEmail", userVo.getUserEmail());
				members.put("userTitle", userVo.getUserTitle());
				members.put("userDept", userVo.getUserDept());
				members.put("userRegdate", userVo.getUserRegdate());
				members.put("userPhoto", userVo.getUserPhoto());
				members.put("userBirth", userVo.getUserBirth());
				members.put("userGrade", userVo.getUserGrade());
				members.put("roleNo", userVo.getRoleNo());
				members.put("projectNo", userVo.getProjectNo());
				
				allTaskLsitJSONArray.add(members);
			}
			allProjects.put("members", allTaskLsitJSONArray);
			allProjects.put("projectNo", projectNo.getProjectNo());
			
			objArray.add(allProjects);
			testobj.put("allProjectMembers", objArray);
		}
		
		return testobj;
		
	}
}
