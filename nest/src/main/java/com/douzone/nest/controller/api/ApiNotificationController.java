package com.douzone.nest.controller.api;


import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.nest.dto.JsonResult;
import com.douzone.nest.service.NotificationService;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController

public class ApiNotificationController {
	@Autowired
	private NotificationService notificationService;

	@GetMapping("/api/notification/{authUserNo}")
	public JsonResult notification(@PathVariable("authUserNo") Long authUserNo) {
		JSONObject notificationJson = notificationService.selectNotification(authUserNo);
		return JsonResult.success(notificationJson);
	}
	
	@GetMapping("/api/notification/new/{authUserNo}")
	public JsonResult newNotification(@PathVariable("authUserNo") Long authUserNo) {
		JSONObject notificationJson = notificationService.selectNewNotification(authUserNo);
		return JsonResult.success(notificationJson);
	}
	
	@PostMapping("/api/notification/update/{noticeNo}/{userNo}")
	public JsonResult notificationMessageCheck(@PathVariable("noticeNo") Long noticeNo, @PathVariable("userNo") Long userNo) {
		boolean result = notificationService.notificationMessageCheck(noticeNo,userNo);
		return  JsonResult.success(result ? noticeNo : -1);
	}
	
	@PostMapping("/api/notification/insertNotice")
	public JsonResult insertNotice(@RequestBody JSONObject noticeJson ) {
		boolean result = notificationService.insertNotice(noticeJson);
		return  JsonResult.success(result ? noticeJson : -1);
	}

}
