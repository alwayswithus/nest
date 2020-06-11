package com.douzone.nest.controller.api;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.nest.dto.JsonResult;
import com.douzone.nest.service.CalendarService;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class ApiCalendarController {
	
	@Autowired
	private CalendarService calendarService;
	
	@GetMapping("api/calendar/{authUserNo}")
	public JsonResult calendar(@PathVariable("authUserNo") Long authUserNo) {
		JSONObject taskVo = calendarService.selectTask(authUserNo);
		return JsonResult.success(taskVo);
	}
	
	@PostMapping("api/calendar/{projectNo}")
	public JsonResult taskList(@PathVariable("projectNo") Long projectNo) {
		JSONObject taskListVo = calendarService.selectTaskList(projectNo);
		return JsonResult.success(taskListVo);
	}
}
