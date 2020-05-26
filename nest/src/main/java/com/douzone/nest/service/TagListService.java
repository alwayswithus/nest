package com.douzone.nest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.nest.repository.TagListRepository;
import com.douzone.nest.vo.TagListVo;

@Service
public class TagListService {

	@Autowired
	private TagListRepository tagListRepository;
	
	public List<TagListVo> selectTagList() {
		return tagListRepository.selectTagList();
	}
	public boolean tagInsert(TagListVo tagListVo) {
		return 1 == tagListRepository.tagInsert(tagListVo);
	}
	public boolean tagDelete(Long tagNo) {
		return tagListRepository.tagDelete(tagNo) > 0;
	}

}
