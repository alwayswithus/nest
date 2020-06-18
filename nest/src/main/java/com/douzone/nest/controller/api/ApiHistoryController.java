package com.douzone.nest.controller.api;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.nest.dto.JsonResult;
import com.douzone.nest.service.HistoryService;
import com.douzone.nest.vo.HistoryVo;


@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class ApiHistoryController {
	@Autowired
	private HistoryService historyService;
	
	@GetMapping("/api/history/{projectNo}")
	public JsonResult selectHistory(@PathVariable("projectNo") Long projectNo) {
		List<HistoryVo> log = historyService.selectHistory(projectNo);
		return JsonResult.success(log);
	}
	
	/*
	 * 작성자:김우경
	 * 설명:히스토리추가
	 */
	@PostMapping("/api/history/insertHistory")
	public JsonResult insertHistory(@RequestBody JSONObject historyJson) {
		boolean result = historyService.insertHistory(historyJson);
		List<HistoryVo> log = historyService.selectHistory(Long.parseLong((String) (historyJson.get("projectNo"))));
//		System.out.println(log);
		return JsonResult.success(result ? log : -1);
//		return null;
	}
}
