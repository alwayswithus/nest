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
				map.put("logContents", historyJson.get("senderName") +" 님이 " + historyJson.get("actionName") + " 으로 업무이름을 수정하셨습니다.");
				break;
			case "taskListInsert":
				map.put("logContents", historyJson.get("senderName") +" 님이 " + historyJson.get("actionName") + " 업무리스트를 추가하였습니다.");
				break;
			case "taskListDelete":
				map.put("logContents", historyJson.get("senderName") +" 님이 " + historyJson.get("actionName") + " 업무리스트를 삭제하였습니다.");
				break;
			case "taskDateUpdate":
				map.put("logContents", historyJson.get("senderName") +" 님이 " + historyJson.get("actionName") + " 업무의 마감일을 수정하였습니다.");
				break;
			case "taskMemberJoin":
				map.put("logContents", historyJson.get("senderName") +" 님이 " + historyJson.get("actionName") + " 업무에 멤버를 추가하였습니다.");
				break;
			case "checklistInsert":
				map.put("logContents", historyJson.get("senderName") +" 님이 " + historyJson.get("actionName") + " 업무에 체크리스트를 추가하였습니다.");
				break;
			case "checklistStateUpdate":
				map.put("logContents", historyJson.get("senderName") +" 님이 " + historyJson.get("actionName") + " 업무의 체크리스트 상태를 수정하였습니다.");
				break;
			case "commentInsert":
				map.put("logContents", historyJson.get("senderName") +" 님이 " + historyJson.get("actionName") + " 업무에 코멘트를 추가하였습니다.");
				break;
			case "taskDragNdrop":
				map.put("logContents", historyJson.get("senderName") +" 님이 " + historyJson.get("actionName") + " 업무의 위치를 변경하였습니다.");
				break;
			case "taskListDragNdrop":
				map.put("logContents", historyJson.get("senderName") +" 님이 " + historyJson.get("actionName") + " 업무리스트의 위치를 변경하였습니다.");
				break;
			case "taskStateUpdate":
				map.put("logContents", historyJson.get("senderName") +" 님이 " + historyJson.get("actionName") + " 업무 상태를 변경하였습니다.");
				break;
			case "taskInsert":
				map.put("logContents", historyJson.get("senderName") +" 님이 " + historyJson.get("actionName") + " 업무를 추가하였습니다.");
				break;
			case "taskDelete":
				map.put("logContents", historyJson.get("senderName") +" 님이 " + historyJson.get("actionName") + " 업무를 삭제하였습니다.");
				break;
			case "projectMemberInvite":
				map.put("logContents", historyJson.get("senderName") +" 님이 " + historyJson.get("actionName") + " 님을 초대하였습니다.");
				break;
			case "projectMemberJoin":
				map.put("logContents", historyJson.get("senderName") +" 님이 " + historyJson.get("actionName") + " 님을 프로젝트에 참여시켰습니다.");
				break;
			case "projectDateUpdate":
				map.put("logContents", historyJson.get("senderName") +" 님이 " + historyJson.get("actionName") + " 프로젝트의 업무마감일을 수정하였습니다.");
				break;
		}
		
		int result = historyRepository.insertHistory(map);
		return result == 1;
	}

}
