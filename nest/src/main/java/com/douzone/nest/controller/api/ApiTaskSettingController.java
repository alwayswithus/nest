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
	
	@DeleteMapping("/api/tasksetting/checklist/{checklistNo}")
	public JsonResult checklistDelete(@PathVariable("checklistNo") Long checklistNo) {
		boolean result = taskSettingService.deleteChecklist(checklistNo);
		return JsonResult.success(result ? checklistNo : -1);
	}
	
}
