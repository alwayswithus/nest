package com.douzone.nest.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.nest.repository.NotificationRepository;

@Service
public class NotificationService {
	
	@Autowired
	private NotificationRepository notificationRepository;

	@SuppressWarnings("unchecked")
	public JSONObject selectNotification(Long authUserNo) {
		Map map = new HashMap();
		
		map.put("dateMonth",null);
		map.put("dateDay",null);
		map.put("dateYear",null);
		
		// 메인 {}
		JSONObject obj = new JSONObject();
		
		// 날짜 JSON Array
		JSONArray dateJSONArray = new JSONArray();
		List<Map> dateList = notificationRepository.selectDate(authUserNo);
		
		for(Map dateMap : dateList) {
			JSONObject date = new JSONObject();
			date.put("dateMonth", dateMap.get("dateMonth"));
			date.put("dateDay", dateMap.get("dateDay"));
			date.put("dateYear", dateMap.get("dateYear"));	
			dateJSONArray.add(date);
		}
		
		// 알림 JSON Array
		JSONArray noticeSendJSONArray = new JSONArray();
		
		List<Map> noticeSendList = notificationRepository.selectNotice(authUserNo);
		
		for(Map noticeMap : noticeSendList) {
			JSONObject notice = new JSONObject();
			notice.put("noticeNo", noticeMap.get("noticeNo"));
			notice.put("messageCheck", noticeMap.get("messageCheck"));
			notice.put("userPhoto", noticeMap.get("userPhoto"));	
			notice.put("userName", noticeMap.get("userName"));	
			notice.put("userNo", noticeMap.get("userNo"));	
			notice.put("noticeMessage", noticeMap.get("noticeMessage"));	
			notice.put("noticeDate", noticeMap.get("noticeDate")+"");	
			notice.put("projectNo", noticeMap.get("projectNo"));	
			notice.put("projectTitle", noticeMap.get("projectTitle"));	
			notice.put("taskNo", noticeMap.get("taskNo"));	
			notice.put("taskContents", noticeMap.get("taskContents"));
			notice.put("noticeType", noticeMap.get("noticeType"));
			notice.put("taskListNo", noticeMap.get("taskListNo"));
			noticeSendJSONArray.add(notice);
		}
		
		obj.put("date", dateJSONArray);
		obj.put("notice", noticeSendJSONArray);

		return obj;
	}

	public boolean notificationMessageCheck(Long noticeNo) {
		return notificationRepository.notificationMessageCheck(noticeNo);
	}

}
