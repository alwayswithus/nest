package com.douzone.nest.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.nest.dto.JsonResult;
import com.douzone.nest.service.TaskSettingService;
import com.douzone.nest.vo.CheckListVo;
import com.douzone.nest.vo.TagListVo;
import com.douzone.nest.vo.TaskUserVo;
import com.douzone.nest.vo.TaskVo;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
public class ApiTaskSettingController {
	
	@Autowired
	private TaskSettingService taskSettingService;
	
	/*
	 * 작성자:김우경
	 * 설명: checklist insert
	 */
	@PostMapping("/api/tasksetting/checklist/add")
	public JsonResult checklistInsert(@RequestBody CheckListVo checklistVo) {
		boolean result = taskSettingService.insertChecklist(checklistVo);
		return JsonResult.success(result ? checklistVo : -1);
	}
	
	/*
	 * 작성자:김우경
	 * 설명: checklist update
	 */
	@PostMapping("/api/tasksetting/checklist/update")
	public JsonResult checklistUpdate(@RequestBody CheckListVo checklistVo) {
		boolean result = taskSettingService.updateChecklist(checklistVo);

		return JsonResult.success(result ? checklistVo : -1);
	}
	
	/*
	 * 작성자:김우경
	 * 설명: checklist update
	 */
	@DeleteMapping("/api/tasksetting/checklist/{checklistNo}")
	public JsonResult checklistDelete(@PathVariable("checklistNo") Long checklistNo) {
		boolean result = taskSettingService.deleteChecklist(checklistNo);
		return JsonResult.success(result ? checklistNo : -1);
	}
	
	/*
	 * 작성자:김우경
	 * 설명:업무 중요도 업데이트
	 */
	@PostMapping("/api/tasksetting/point/update")
	public JsonResult pointUpdate(@RequestBody TaskVo taskVo) {
		boolean result = taskSettingService.updatePoint(taskVo);
		return JsonResult.success(result ? taskVo : -1);
	}
	
    /*
     * 작성자: 김우경
     * 설명: 업무 내용 업데이트
     */
	@PostMapping("/api/tasksetting/task/{taskNo}")
	public JsonResult taskContentsUpdate(
			@PathVariable("taskNo") Long taskNo,
			@RequestBody String taskContents) {
		TaskVo taskVo = new TaskVo();
		taskVo.setTaskNo(taskNo);
		taskVo.setTaskContents(taskContents);
		boolean result = taskSettingService.updateTaskContents(taskVo);
		return JsonResult.success(result ? taskVo : -1);
	}
	
	/*
	 * 작성자 : 최인효
	 * 설명 : 업무 날짜 변경
	 */
	@PostMapping("/api/tasksetting/calendar/update")
	public JsonResult taskDateUpdate(@RequestBody TaskVo TaskVo) {
		boolean result = taskSettingService.taskDateUpdate(TaskVo);
		return  JsonResult.success(result ? TaskVo : -1);
	}
	
    /*
     * 작성자 : 김우경
     * 설명 : 업무 멤버 추가하기
     */
	@PostMapping("/api/task/member/add")
	public JsonResult taskMemberAdd(@RequestBody TaskUserVo taskUserVo ) {
		boolean result = taskSettingService.taskUserInsert(taskUserVo);
		return JsonResult.success(result ? taskUserVo : -1);
	}
	
	 /*
     * 작성자 : 김우경
     * 설명 : 업무 멤버 삭제하기
     */
	@DeleteMapping("/api/task/member/{userNo}/{taskNo}")
	public JsonResult taskMemberDelete(
			@PathVariable("userNo") Long userNo,
			@PathVariable("taskNo") Long taskNo) {
		
		TaskUserVo taskUserVo = new TaskUserVo();
		
		taskUserVo.setUserNo(userNo);
		taskUserVo.setTaskNo(taskNo);
		
		boolean result = taskSettingService.taskUserDelete(taskUserVo);
		return JsonResult.success(result ? taskUserVo : -1);
	}
	
	/*
	 * 작성자:김우경
	 * 설명: 업무 라벨 색상 수정
	 */
	@PostMapping("/api/tasksetting/tasklabel/{taskNo}")
	public JsonResult taskLabel(
			@PathVariable("taskNo") Long taskNo,
			@RequestBody String color) {
		
		System.out.println(taskNo + " : " + color);
		
		boolean result = taskSettingService.updateTaskLabel(taskNo, color);
		return JsonResult.success(result ? taskNo : -1);
	}
	
	/*
	 * 작성자:김우경
	 * 설명:태그 수정
	 */
	@PostMapping("/api/tasksetting/tag/update")
	public JsonResult tagUpdate(
			@RequestBody TagListVo taglistVo) {
		boolean result = taskSettingService.updateTag(taglistVo);
		return JsonResult.success(result ? taglistVo : -1);
	}
	
}
