package com.douzone.nest.service;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.nest.repository.KanbanBoardRepository;
import com.douzone.nest.vo.CheckListVo;
import com.douzone.nest.vo.CommentVo;
import com.douzone.nest.vo.CopyTaskVo;
import com.douzone.nest.vo.FileVo;
import com.douzone.nest.vo.TagListVo;
import com.douzone.nest.vo.TaskListVo;
import com.douzone.nest.vo.TaskReOrderVo;
import com.douzone.nest.vo.TaskUserVo;
import com.douzone.nest.vo.TaskVo;
import com.douzone.nest.vo.UserVo;

@Service
public class KanbanBoardService {

	@Autowired
	private KanbanBoardRepository kanbanBoardRepository;

	/*
	 * 작성자 : 최인효 
	 * 설명 : 테스크리스트 JSON 생성
	 */
	@SuppressWarnings("unchecked")
	public JSONObject selectKanbanBoard(Long projectNo) {

		// 메인 {}
		JSONObject obj = new JSONObject();

		// allTaskLsit[]
		JSONArray allTaskLsitJSONArray = new JSONArray();
		List<TaskListVo> allTaskLsit = kanbanBoardRepository.selectAllTaskList(projectNo);
		for (TaskListVo taskListVo : allTaskLsit) {
			// 하나의 TaskList{}
			JSONObject taskList = new JSONObject();
			taskList.put("taskListNo", taskListVo.getTaskListNo() + "");
			taskList.put("taskListName", taskListVo.getTaskListName());
			taskList.put("taskListOrder", taskListVo.getTaskListOrder());
			taskList.put("projectNo", taskListVo.getProjectNo());

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
					commentList.put("userPhoto", commentVo.getUserPhoto());
					commentList.put("filePath", commentVo.getFilePath());
					commentList.put("originName", commentVo.getOriginName());
					commentList.put("fileRegDate", commentVo.getFileRegdate());
					commentList.put("taskNo", commentVo.getTaskNo());
					commentList.put("fileNo", commentVo.getFileNo());

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

					fileJSONArray.add(file);
				}
				task.put("fileList", fileJSONArray);

				JSONArray memberJSONArray = new JSONArray();
				List<UserVo> memberList = kanbanBoardRepository.selectMemberList(taskVo.getTaskNo());
				for (UserVo memberVo : memberList) {
					// 멤버
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

					memberJSONArray.add(member);
				}
				task.put("memberList", memberJSONArray);

//				task.put("taskListNo", taskVo.getTaskListNo());
//				task.put("projectNo", taskVo.getProjectNo());

				tasksJSONArray.add(task);
			}
			taskList.put("tasks", tasksJSONArray);

			allTaskLsitJSONArray.add(taskList);
		}
		obj.put("allTaskList", allTaskLsitJSONArray);

		return obj;
	}

	/*
	 * 작성자 : 최인효 
	 * 설명 : 테스크리스트 insert
	 */
	public boolean taskListAdd(TaskListVo taskListVo) {
		Long taskListOrderNo = kanbanBoardRepository.selectTaskListOrderNo(taskListVo.getProjectNo());
		if(taskListOrderNo == null) {
			taskListOrderNo = 0L;
		}		
		taskListVo.setTaskListOrder(taskListOrderNo + 1L);
		
		return 1 == kanbanBoardRepository.taskListAdd(taskListVo);
	}

	/*
	 * 작성자 : 최인효 
	 * 설명 : 테스크리스트 delete
	 */
	public boolean taskListDelete(TaskListVo taskListVo) {
//		 result = 1 == kanbanBoardRepository.taskListInTaskDelete(taskListVo.getTaskListNo());
		 boolean result = 1 == kanbanBoardRepository.taskListDelete(taskListVo);
		if (result) {
			result = -1 != kanbanBoardRepository.taskListDeleteReOrder(taskListVo);
		}
		return result;
	}

	/*
	 * 작성자 : 최인효 
	 * 설명 : 테스크리스트 이름 변경
	 */
	public boolean taskListEditName(TaskListVo taskListVo) {
		return 1 == kanbanBoardRepository.taskListEditName(taskListVo);
	}

	/*
	 * 작성자 : 최인효 
	 * 설명 : 테스크리스트 DnD 정렬
	 */
	public boolean taskListDnDReOrder(List<TaskListVo> taskLists) {
		boolean result=true;
		for(TaskListVo vo : taskLists) {
			result = -1 != kanbanBoardRepository.taskListDnDReOrder(vo);
		}
		return result;
	}
	
	/*
	 * 작성자 : 최인효
	 * 설명 : 테스크 추가
	 */
	public TaskVo taskInsert(Map taskInfo) {
		TaskVo task = null;
		boolean result = 1 == kanbanBoardRepository.taskInsert(taskInfo);
		if(result) {
			task = kanbanBoardRepository.taskSelect(Long.parseLong(taskInfo.get("taskNo").toString()));
		}
		return task;
	}
	
	/*
	 * 작성자 : 최인효
	 * 설명 : 테스크 삭제
	 */
	public boolean taskDelete(TaskReOrderVo taskInfo) {
		boolean result = -1 != kanbanBoardRepository.taskDelete(taskInfo.getReOrderTask());
		for(TaskVo vo : taskInfo.getStartTasks()) {
			System.out.println(vo);
			result = -1 != kanbanBoardRepository.taskReOrder(vo);
		}
		return result;
	}

	/*
	 * 작성자 : 최인효 
	 * 설명 : 테스크 복사
	 */
	public boolean copyTask(CopyTaskVo copyTask) {
		
		boolean result=true;
		result = -1 != kanbanBoardRepository.copyTask(copyTask);
		
		for(TagListVo vo : copyTask.getTagList()) {
			vo.setTaskNo(copyTask.getTaskNo());
			result = -1 != kanbanBoardRepository.copyTag(vo);
		}
		
		for(UserVo vo : copyTask.getMemberList()) {
			vo.setRoleNo(copyTask.getTaskNo());
			result = -1 != kanbanBoardRepository.copyUser(vo);
		}
		
		for(CheckListVo vo : copyTask.getCheckList()) {
			vo.setTaskNo(copyTask.getTaskNo());
			result = -1 != kanbanBoardRepository.copyCheckList(vo);
		}
		
		return result;
	}
	
	/*
	 * 작성자 : 최인효 
	 * 설명 :  최인효
	 * 설명 : 테스크 정렬
	 */
	public boolean taskReOrderSameList(List<TaskVo> taskVo) {
		boolean result=true;
		for(TaskVo vo : taskVo) {
			result = -1 != kanbanBoardRepository.taskReOrder(vo);
		}
		return result;
	}

	/*
	 * 작성자 : 최인효
	 * 설명 : 테스크 DnD 정렬(다른 리스트)
	 */
	public boolean taskReOrderOtherList(TaskReOrderVo taskReOrder) {
		boolean result=true;
		for(TaskVo vo : taskReOrder.getStartTasks()) {
			result = -1 !=kanbanBoardRepository.taskReOrder(vo);
		}
		
		for(TaskVo vo : taskReOrder.getEndTasks()) {
			result = -1 !=kanbanBoardRepository.taskReOrder(vo);
		}
		
		result = -1 != kanbanBoardRepository.taskInTaskListNoChange(taskReOrder);
		return result;
	}

	/*
	 * 작성자 : 최인효
	 * 설명 : 테스크 체크 update
	 */
	public boolean taskStateUpdate(TaskVo taskVo) {
		return -1 != kanbanBoardRepository.taskStateUpdate(taskVo);
	}
  
	/*
	 * 작성자 : 김우경
	 * 설명 : 업무 멤버 추가
	 */
	public boolean taskUserInsert(TaskUserVo taskUserVo) {
		return 1 == kanbanBoardRepository.taskUserInsert(taskUserVo);
	}

	/*
	 * 작성자 : 김우경
	 * 설명 : 업무 멤버 삭제
	 */
	public boolean taskUserDelete(TaskUserVo taskUserVo) {
		return 1 == kanbanBoardRepository.taskUserDelete(taskUserVo);
	}



}
