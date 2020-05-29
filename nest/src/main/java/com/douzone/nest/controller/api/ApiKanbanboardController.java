package com.douzone.nest.controller.api;


import java.util.List;

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

public class ApiKanbanboardController {
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
		System.out.println(kanbanJson);
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
		return  JsonResult.success(result ? taskListVo : -1);
	}
	
	/*
	 * 작성자 : 최인효
	 * 설명 : 테스크리스트 DnD 정렬
	 */
	@PostMapping("/api/taskList/reOrder")
	public JsonResult taskListReOrder(@RequestBody List<TaskListVo> taskLists) {
		boolean result = kanbanboardService.taskListDnDReOrder(taskLists);
		return  JsonResult.success(result ? taskLists : -1);
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
	
	/*
	 * 작성자 : 최인효
	 * 설명 : 테스크 DnD 정렬
	 */
	@PostMapping("/api/task/reOrder")
	public JsonResult taskReOrder(@RequestBody List<TaskVo> taskVo) {
		System.out.println(taskVo);
		boolean result = kanbanboardService.taskReOrder(taskVo);
		return  JsonResult.success(result ? taskVo : -1);
	}

}
