package com.douzone.nest.controller.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.nest.service.NotificationService;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController

public class ApiNotificationController {
	@Autowired
	private NotificationService apiNotificationService;

	

}
