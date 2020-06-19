package com.douzone.nest.controller.api;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.nest.dto.JsonResult;
import com.douzone.nest.service.CalendarService;
import com.douzone.nest.vo.TaskVo;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class ApiCalendarController {
	
	@Autowired
	private CalendarService calendarService;
	
	private final SimpMessagingTemplate template;
	
	@Autowired
	public ApiCalendarController(SimpMessagingTemplate template) {
		this.template = template;
	}
	
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
	
	@PostMapping("api/calendar/taskadd")
	public JsonResult taskAdd(@RequestBody TaskVo taskVo) {
		boolean result = calendarService.taskAdd(taskVo);
		return JsonResult.success(result ? taskVo : -1);
	}
	
	@MessageMapping("/calendar/all") // react -> spring 송신
//	@SendTo("/topic/all")	// spring -> react 송신
	@SuppressWarnings("unchecked")
	public void send(Map<Object, Object> eventSocketData) {
		System.out.println("123123");
		List<Object> list = (List<Object>) eventSocketData.get("membersNo");
		for(int i=0; i<list.size(); i++) {
			template.convertAndSend("/topic/calendar/all/" + list.get(i), eventSocketData);
		}
	}
}
