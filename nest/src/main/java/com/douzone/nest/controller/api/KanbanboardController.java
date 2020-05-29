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
import com.douzone.nest.vo.TaskListVo;
import com.douzone.nest.vo.TaskVo;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController

public class KanbanboardController {
	@Autowired
	private KanbanBoardService kanbanboardService;

	/*
	 * 작성자 : 최인효
	 * 설명 : 테스크 리스트 select
	 */
	@GetMapping("/api/kanbanMain")
	public JsonResult kanbanMain() {
		Long projectNo = 5L;
		JSONObject kanbanJson = kanbanboardService.selectKanbanBoard(projectNo);
		return JsonResult.success(kanbanJson);
	}
	
	/*
	 * 작성자 : 최인효
	 * 설명 : 테스크 리스트 추가
	 */
	@PostMapping("/api/taskList/add")
	public JsonResult taskListAdd(@RequestBody TaskListVo taskListVo) {
		boolean result = kanbanboardService.taskListAdd(taskListVo);
		return  JsonResult.success(result ? taskListVo : -1);
	}
	
	/*
	 * 작성자 : 최인효
	 * 설명 : 테스크 리스트 삭제
	 */
	@PostMapping("/api/taskList/delete")
	public JsonResult taskListDelete(@RequestBody TaskListVo taskListVo) {
		boolean result = kanbanboardService.taskListDelete(taskListVo);
		return  JsonResult.success(result ? taskListVo : -1);
	}
	
	/*
	 * 작성자 : 최인효
	 * 설명 : 테스크리스트 이름 변경
	 */
	@PostMapping("/api/taskList/editName")
	public JsonResult taskListEditName(@RequestBody TaskListVo taskListVo) {
		boolean result = kanbanboardService.taskListEditName(taskListVo);
		return  JsonResult.success(true ? taskListVo : -1);
	}
	
	/*
	 * 작성자 : 최인효
	 * 설명 : 테스크 복사
	 */
	@PostMapping("/api/task/copy")
	public JsonResult taskCopy(@RequestBody TaskVo taskVo) {
//		boolean result = kanbanboardService.taskCopy(taskVo);
		return  JsonResult.success(true ? taskVo : -1);
	}

}
