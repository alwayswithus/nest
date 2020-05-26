package com.douzone.nest.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.nest.dto.JsonResult;
import com.douzone.nest.service.TagListService;
import com.douzone.nest.vo.TagListVo;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class TagListController {
	@Autowired
	private TagListService tagListService;
	
	@GetMapping("/api/taglist")
	public JsonResult tagList() {
		List<TagListVo> tagListVo = tagListService.selectTagList();
		System.out.println(tagListVo);
		
		return JsonResult.success(tagListVo);
	}
	
	@PostMapping("/api/taglist/add")
	public JsonResult tagListAdd(
			@RequestBody TagListVo tagListVo) {
		System.out.println(tagListVo);
		boolean result = tagListService.tagInsert(tagListVo);
		return JsonResult.success(result ? tagListVo : -1);
	}
	
	@DeleteMapping("/api/taglist/delete")
	public JsonResult tagListDelete(
			@RequestBody Long tagNo) {
		System.out.println(tagNo);
		boolean result = tagListService.tagDelete(tagNo);
		return JsonResult.success(result ? tagNo : -1);
	}
}
