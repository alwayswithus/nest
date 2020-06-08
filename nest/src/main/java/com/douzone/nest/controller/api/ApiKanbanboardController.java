package com.douzone.nest.controller.api;


import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.nest.dto.JsonResult;
import com.douzone.nest.service.KanbanBoardService;
import com.douzone.nest.vo.CopyTaskVo;
import com.douzone.nest.vo.TaskListVo;
import com.douzone.nest.vo.TaskReOrderVo;
import com.douzone.nest.vo.TaskUserVo;
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
	@GetMapping("/api/kanbanMain/{projectNo}/{authUserNo}")
	public JsonResult kanbanMain(@PathVariable("projectNo") Long projectNo,@PathVariable("authUserNo") Long authUserNo) {
		JSONObject kanbanJson = kanbanboardService.selectKanbanBoard(projectNo,authUserNo);
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
	 * 설명 : 테스크 추가
	 */
	@PostMapping("/api/task/insert")
	public JsonResult taskInsert(@RequestBody Map taskInfo) {
		TaskVo task = kanbanboardService.taskInsert(taskInfo);
		System.out.println(task);
		return  JsonResult.success(task);
	}
	
	/*
	 * 작성자 : 최인효
	 * 설명 : 테스크 삭제
	 */
	@PostMapping("/api/task/delete")
	public JsonResult taskDelete(@RequestBody TaskReOrderVo taskInfo) {
		boolean result = kanbanboardService.taskDelete(taskInfo);
		return  JsonResult.success(result ? taskInfo : -1);
	}
	
	/*
	 * 작성자 : 최인효
	 * 설명 : 테스크 복사 insert
	 */
	@PostMapping("/api/task/copy/insert")
	public JsonResult copyTask(@RequestBody CopyTaskVo copyTask) {
		boolean result = kanbanboardService.copyTask(copyTask);
		return  JsonResult.success(result ? copyTask : -1);
	}
	
	/*
	 * 작성자 : 최인효
	 * 설명 : 테스크 체크 update
	 */
	@PostMapping("/api/task/state")
	public JsonResult taskStateUpdate(@RequestBody TaskVo taskVo) {
		boolean result = kanbanboardService.taskStateUpdate(taskVo);
		return  JsonResult.success(true ? taskVo : -1);
	}
	
	/*
	 * 작성자 : 최인효
	 * 설명 : 테스크 정렬(같은 리스트)
	 */
	@PostMapping("/api/task/reOrder/sameList")
	public JsonResult taskReOrderSameList(@RequestBody List<TaskVo> taskVo) {
		boolean result = kanbanboardService.taskReOrderSameList(taskVo);
		return  JsonResult.success(result ? taskVo : -1);
	}
	
	/*
	 * 작성자 : 최인효
	 * 설명 : 테스크 DnD 정렬(다른 리스트)
	 */
	@PostMapping("/api/task/reOrder/otherList")
	public JsonResult taskReOrderOtherList(@RequestBody TaskReOrderVo TaskReOrder) {
		boolean result = kanbanboardService.taskReOrderOtherList(TaskReOrder);
		return  JsonResult.success(result ? TaskReOrder : -1);
	}	

}
