package com.douzone.nest.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
		
		return JsonResult.success(tagListVo);
	}
	
	@PostMapping("/api/tag/add")
	public JsonResult tagAdd(
			@RequestBody TagListVo tagListVo) {
		boolean result = tagListService.taskTagInsert(tagListVo);
		return JsonResult.success(result ? tagListVo : -1);
	}
	
	@DeleteMapping("/api/tag/delete/{taskNo}/{tagNo}")
	public JsonResult tagDelete(
			@PathVariable("taskNo") Long taskNo,
			@PathVariable("tagNo") Long tagNo) {
		
		TagListVo tagListVo = new TagListVo();
		tagListVo.setTagNo(tagNo);
		tagListVo.setTaskNo(taskNo);
		
		boolean result = tagListService.taskTagDelete(tagListVo);
		return JsonResult.success(result ? tagListVo : -1);
	}
	
	@PostMapping("/api/taglist/add")
	public JsonResult tagListAdd(
			@RequestBody TagListVo tagListVo) {
		boolean result = tagListService.tagInsert(tagListVo);
		return JsonResult.success(result ? tagListVo : -1);
	}
	
	@DeleteMapping("/api/taglist/delete")
	public JsonResult tagListDelete(
			@RequestBody Long tagNo) {
		
		boolean result = tagListService.tagDelete(tagNo);
		return JsonResult.success(result ? tagNo : -1);
	}
}
