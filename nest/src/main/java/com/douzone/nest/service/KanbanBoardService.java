package com.douzone.nest.service;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.nest.repository.KanbanBoardRepository;
import com.douzone.nest.vo.CheckListVo;
import com.douzone.nest.vo.CommentVo;
import com.douzone.nest.vo.FileVo;
import com.douzone.nest.vo.TagListVo;
import com.douzone.nest.vo.TaskListVo;
import com.douzone.nest.vo.TaskVo;

@Service
public class KanbanBoardService {

	@Autowired
	private KanbanBoardRepository kanbanBoardRepository;

	/*
	 * 작성자 : 최인효
	 * 설명 : taskList JSON 생성
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
				
				// checkList[]
				JSONArray checkListJSONArray = new JSONArray(); 
				List<CheckListVo> checkLists = kanbanBoardRepository.selectCheckList(taskVo.getTaskNo());
				for(CheckListVo checkListVo : checkLists) {
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
				for(TagListVo tagVo : tags) {
					// 하나의 tagList{}
					JSONObject tagList = new JSONObject(); 
					tagList.put("tagNo",tagVo.getTagNo());
					tagList.put("taskNo",tagVo.getTaskNo());
					tagList.put("tagName",tagVo.getTagName());
					tagList.put("tagColor",tagVo.getTagColor());
					tagJSONArray.add(tagList);
				}
				task.put("tagList", tagJSONArray);
				
				// comments[]
				JSONArray commentsJSONArray = new JSONArray(); 
				List<CommentVo> comments = kanbanBoardRepository.selectComments(taskVo.getTaskNo());
				for(CommentVo commentVo : comments) {
					// 하나의 TaskList{}
					JSONObject commentList = new JSONObject();
					commentList.put("commentNo",commentVo.getCommentNo());
					commentList.put("commentRegdate",commentVo.getCommentRegdate());
					commentList.put("commentContents",commentVo.getCommentContents());
					commentList.put("commentLike",commentVo.getCommentLike());
					commentList.put("userNo",commentVo.getUserNo());
					commentList.put("taskNo",commentVo.getTaskNo());
					commentList.put("fileNo",commentVo.getFileNo());
					
					
					JSONArray fileJSONArray = new JSONArray(); 
					List<FileVo> fileList = kanbanBoardRepository.selectFileList(taskVo.getTaskNo());
					for(FileVo fileVo : fileList) {
						// 하나의 TaskList{}
						JSONObject file = new JSONObject();
						
						file.put("fileNo",fileVo.getFileNo());
						file.put("originName",fileVo.getOriginName());
						file.put("changeName",fileVo.getChangeName());
						file.put("filePath",fileVo.getFilePath());
						file.put("fileRegdate",fileVo.getFileRegdate());
						file.put("taskNo",fileVo.getTaskNo());
						
						fileJSONArray.add(file);
					}
					commentList.put("fileList", fileJSONArray);
					
					
					commentsJSONArray.add(commentList);
				}
				task.put("commentList", commentsJSONArray);
				
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
	 * 설명 : taskList 추가
	 */
	public boolean taskListAdd(TaskListVo taskListVo) {
		Long taskListOrderNo = kanbanBoardRepository.selectTaskListOrderNo(taskListVo.getProjectNo());
		taskListVo.setTaskListOrder(taskListOrderNo+1);
		return 1 == kanbanBoardRepository.taskListAdd(taskListVo);
	}

	/*
	 * 작성자 : 최인효
	 * 설명 : task 복사
	 */
	public boolean taskCopy(TaskVo taskVo) {
		return 1 == kanbanBoardRepository.taskCopy(taskVo);
	}



}
