package com.douzone.nest.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.nest.repository.KanbanBoardRepository;

@Service
public class KanbanBoardService {

	@Autowired
	private KanbanBoardRepository kanbanBoardRepository;

	public JSONObject selectKanbanBoard() {
//		List<Map<String, Object>> listVo = new ArrayList<Map<String, Object>>();
//		Map<String, Object> vo = new HashMap<>();
//		
//		vo.put("test", kanbanBoardRepository.selectKanbanBoard());
//		kanbanBoardRepository.selectKanbanBoard();
		
        //최종 완성될 JSONObject 선언(전체)	
        JSONObject jsonObject = new JSONObject();
 
        //person의 JSON정보를 담을 Array 선언
        JSONArray personArray = new JSONArray();
 
        //person의 한명 정보가 들어갈 JSONObject 선언
        JSONObject personInfo = new JSONObject();

		return jsonObject;
	}

}
