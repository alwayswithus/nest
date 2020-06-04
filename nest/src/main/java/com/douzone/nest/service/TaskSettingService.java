package com.douzone.nest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.nest.repository.TaskSettingRepository;
import com.douzone.nest.vo.CheckListVo;
import com.douzone.nest.vo.TaskVo;

@Service
public class TaskSettingService {

	@Autowired
	private TaskSettingRepository taskSettingRepository;
	
	public boolean insertChecklist(CheckListVo checklistVo) {
		
		return 1 == taskSettingRepository.insertChecklist(checklistVo);
	}

	public boolean updateChecklist(CheckListVo checklistVo) {
		return 1 == taskSettingRepository.updateChecklist(checklistVo);
	}

	public boolean deleteChecklist(Long checklistNo) {
		return 1 == taskSettingRepository.deleteChecklist(checklistNo);
	}

	public boolean updatePoint(TaskVo taskVo) {
		return 1 == taskSettingRepository.updatePoint(taskVo);
	}

	public boolean updateTaskContents(TaskVo taskVo) {
		return 1 == taskSettingRepository.updateTaskContents(taskVo);
	}
	
}
