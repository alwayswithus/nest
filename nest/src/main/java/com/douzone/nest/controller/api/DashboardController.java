package com.douzone.nest.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.nest.dto.JsonResult;
import com.douzone.nest.service.ProjectService;
import com.douzone.nest.vo.ProjectVo;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class DashboardController {
	@Autowired
	private ProjectService projectService;
	
	@GetMapping("/dashboard/api")
	public JsonResult dashboard() {
		List<ProjectVo> proVo = projectService.selectProject();
		System.out.println(proVo);
		return JsonResult.success(proVo);
	}
	
}
