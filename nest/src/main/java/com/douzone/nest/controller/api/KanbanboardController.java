package com.douzone.nest.controller.api;


import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.nest.dto.JsonResult;
import com.douzone.nest.service.KanbanBoardService;
import com.douzone.nest.vo.TaskVo;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController

public class KanbanboardController {
	@Autowired
	private KanbanBoardService kanbanboardService;

	@GetMapping("/api/kanbanMain")
	public JsonResult kanbanMain() {
		Long projectNo = 5L;
		JSONObject kanbanJson = kanbanboardService.selectKanbanBoard(projectNo);
		return JsonResult.success(kanbanJson);
	}
	
	@PostMapping("/api/task/copy")
	public JsonResult tagListAdd(@RequestBody TaskVo taskVo) {
//		boolean result = kanbanboardService.taskCopy(taskVo);
		taskVo.setTaskNo(999L);
		return  JsonResult.success(taskVo);
	}

}
