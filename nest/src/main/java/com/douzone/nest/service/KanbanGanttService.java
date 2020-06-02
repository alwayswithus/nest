package com.douzone.nest.service;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.nest.repository.KanbanBoardRepository;
import com.douzone.nest.vo.TaskVo;

@Service
public class KanbanGanttService {
	@Autowired
	private KanbanBoardRepository kanbanBoardRepository;
	
	/*
	 * 
	 */
	@SuppressWarnings("unchecked")
	public JSONObject selectGantt(Long projectNo) {
		// 메인 {}
		JSONObject obj = new JSONObject();

		List<TaskVo> allTasks = kanbanBoardRepository.selectAllTasksByProjectNo(projectNo);

		JSONArray tasksJSONArray = new JSONArray();
		for (TaskVo taskVo : allTasks) {
			// 하나의 Task{}
			JSONObject task = new JSONObject();
			task.put("taskNo", taskVo.getTaskNo());
			task.put("taskStart", taskVo.getTaskStart());
			task.put("taskEnd", taskVo.getTaskEnd());
			task.put("taskPoint", taskVo.getTaskPoint());
			task.put("taskLabel", taskVo.getTaskLabel());
			task.put("taskState", taskVo.getTaskState());
			task.put("taskContents", taskVo.getTaskContents());
			task.put("taskOrder", taskVo.getTaskOrder());
			task.put("taskRegdate", taskVo.getTaskRegdate());
			task.put("taskWriter", taskVo.getTaskWriter());
			task.put("taskListOrder", taskVo.getTaskListOrder());
			
			task.put("id", taskVo.getTaskNo());
			task.put("start", taskVo.getTaskStart());
			task.put("end", taskVo.getTaskEnd());
			task.put("color", taskVo.getTaskLabel());
			task.put("name", taskVo.getTaskContents());
			
			tasksJSONArray.add(task);
		}

		obj.put("allTasks", tasksJSONArray);

		return obj;
	}



}
