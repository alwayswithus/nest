package com.douzone.nest.controller.api;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.nest.dto.JsonResult;
import com.douzone.nest.service.KanbanGanttService;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
public class ApiGanttController {
	
	@Autowired
	private KanbanGanttService kanbanganttService;
	
	
	@PostMapping("/api/kanbanGantt/{projectNo}")
	public JsonResult kanbanGantt(@PathVariable("projectNo") Long projectNo) {
		JSONObject kanbanJson = kanbanganttService.selectGantt(projectNo);
		return JsonResult.success(kanbanJson);
	}
}
