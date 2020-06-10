package com.douzone.nest.service;

import java.util.ArrayList;
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

	/*
	 * 작성자 : 최인효 설명 : 알림 정보 가져오기
	 */
	@SuppressWarnings("unchecked")
	public JSONObject selectNotification(Long authUserNo) {
		Map map = new HashMap();

		map.put("dateMonth", null);
		map.put("dateDay", null);
		map.put("dateYear", null);

		// 메인 {}
		JSONObject obj = new JSONObject();

		// 날짜 JSON Array
		JSONArray dateJSONArray = new JSONArray();
		List<Map> dateList = notificationRepository.selectDate(authUserNo);

		for (Map dateMap : dateList) {
			JSONObject date = new JSONObject();
			date.put("dateMonth", dateMap.get("dateMonth"));
			date.put("dateDay", dateMap.get("dateDay"));
			date.put("dateYear", dateMap.get("dateYear"));
			dateJSONArray.add(date);
		}

		// 알림 JSON Array
		JSONArray noticeSendJSONArray = new JSONArray();

		List<Map> noticeSendList = notificationRepository.selectNotice(authUserNo);

		for (Map noticeMap : noticeSendList) {
			JSONObject notice = new JSONObject();
			notice.put("noticeNo", noticeMap.get("noticeNo"));
			notice.put("messageCheck", noticeMap.get("messageCheck"));
			notice.put("userPhoto", noticeMap.get("userPhoto"));
			notice.put("userName", noticeMap.get("userName"));
			notice.put("userNo", noticeMap.get("userNo"));
			notice.put("noticeMessage", noticeMap.get("noticeMessage"));
			notice.put("noticeDate", noticeMap.get("noticeDate") + "");
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

	/*
	 * 작성자 : 최인효 설명 : 알림 읽음 표시
	 */
	public boolean notificationMessageCheck(Long noticeNo) {
		return notificationRepository.notificationMessageCheck(noticeNo);
	}

	/*
	 * 작성자 : 최인효 설명 : 알림 추가
	 */
	@SuppressWarnings("unchecked")
	public boolean insertNotice(JSONObject noticeJson) {
		Map noticeMessageMap = new HashMap();

		noticeMessageMap.put("senderNo", noticeJson.get("senderNo"));
		noticeMessageMap.put("taskNo", noticeJson.get("taskNo"));
		noticeMessageMap.put("projectNo", noticeJson.get("projectNo"));
		noticeMessageMap.put("noticeType", noticeJson.get("noticeType"));
		noticeMessageMap.put("noticeNo", null);

		switch ((String) noticeJson.get("noticeType")) {
		case "projectJoin":
			noticeMessageMap.put("message", "님을 프로젝트에 참여시켰습니다.");
			break;
		case "projectDateChange":
			noticeMessageMap.put("message", noticeJson.get("senderName") + "님이 프로젝트의 일정을 변경하였습니다.");
			break;
		case "taskJoin":
			noticeMessageMap.put("message", "님을 업무에 배정하였습니다.");
			break;
		case "taskDateChange":
			noticeMessageMap.put("message", noticeJson.get("senderName") + "님이 업무 일정을 변경하였습니다.");
			break;
		case "taskPointChange":
			noticeMessageMap.put("message", noticeJson.get("senderName") + "님이 업무의 중요도를 변경하였습니다.");
			break;
		case "taskCheckListInsert":
			noticeMessageMap.put("message", noticeJson.get("senderName") + "님이 체크리스트를 추가하였습니다.");
			break;
		case "commentInsert":
			noticeMessageMap.put("message", noticeJson.get("senderName") + "님이 코멘트를 작성하였습니다.");
			break;
		case "commentLike":
			noticeMessageMap.put("message", "님의 코멘트에 좋아요를 표시하였습니다.");
			break;
		}

		int noticeMessageInsert = notificationRepository.insertNoticeMessage(noticeMessageMap);
		int noticeMsgBoxInsert = -1;
		ArrayList<Integer> receiverList = (ArrayList<Integer>) noticeJson.get("receiver");

		for (int receiver : receiverList) {
			Map noticeMsgBoxMap = new HashMap();
			noticeMsgBoxMap.put("noticeNo", noticeMessageMap.get("noticeNo"));
			noticeMsgBoxMap.put("receiverNo", receiver);

			noticeMsgBoxInsert = notificationRepository.insertNoticeMsgBox(noticeMsgBoxMap);

			if (noticeMsgBoxInsert == -1) {
				return false;
			}
		}
		return noticeMessageInsert != -1 && noticeMsgBoxInsert != -1;
	}

}
