package com.douzone.nest.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.nest.repository.CalendarRepository;
import com.douzone.nest.vo.TaskListVo;
import com.douzone.nest.vo.TaskVo;

@Service
public class CalendarService {

	@Autowired
	private CalendarRepository calendarRepository;
	
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
}
