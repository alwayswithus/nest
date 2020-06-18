package com.douzone.nest.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.nest.repository.HistoryRepository;
import com.douzone.nest.vo.HistoryVo;

@Service
public class HistoryService {

	@Autowired
	private HistoryRepository historyRepository;
	
	public List<HistoryVo> selectHistory(Long projectNo) {
		return historyRepository.selectHistory(projectNo);
	}

	/*
	 * 작성자:김우경
	 * 설명:히스토리추가
	 */
	public boolean insertHistory(JSONObject historyJson) {
		Map<String, Object> map = new HashMap<>();
		
		map.put("logDate", historyJson.get("historyDate"));
		map.put("projectNo", historyJson.get("projectNo"));
		
		switch((String) historyJson.get("historyType")) {
			case "taskContentsUpdate":
				map.put("logContents", historyJson.get("senderName") +" 님이 " + historyJson.get("actionName") + "으로 업무이름을 수정하셨습니다.");
				break;
		}
		
		int result = historyRepository.insertHistory(map);
		return result == 1;
	}

}
