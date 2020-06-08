package com.douzone.nest.service;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.nest.repository.CalendarRepository;
import com.douzone.nest.vo.TaskVo;

@Service
public class CalendarService {

	@Autowired
	private CalendarRepository calendarRepository;
	
	@SuppressWarnings("unchecked")
	public JSONObject selectTask(Long authUserNo) {
		
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
			
			allTaskArray.add(task);
		}
		
		obj.put("allTask", allTaskArray);
		return obj;
	}
}
