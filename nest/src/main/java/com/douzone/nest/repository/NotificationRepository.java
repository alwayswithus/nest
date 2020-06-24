package com.douzone.nest.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NotificationRepository {
	@Autowired
	private SqlSession sqlSession;

	public List<Map> selectDate(Long authUserNo) {
		return sqlSession.selectList("notification.selectDate",authUserNo);
	}

	public List<Map> selectNotice(Long authUserNo) {
		return sqlSession.selectList("notification.selectNotice",authUserNo);
	}
	
	public List<Map<String,Object>> selectNewNotice(Long authUserNo) {
		return sqlSession.selectList("notification.selectNewNotice",authUserNo);
	}

	public boolean notificationMessageCheck(Long noticeNo, Long userNo) {
		HashMap<String, Long> map = new HashMap<String, Long>();
		map.put("noticeNo", noticeNo);
		map.put("userNo",userNo);
		return -1 != sqlSession.update("notification.messageCheck",map);
	}

	public int insertNoticeMessage(Map noticeMessageMap) {
		return sqlSession.insert("notification.insertNoticeMessage",noticeMessageMap);
	}

	public int insertNoticeMsgBox(Map noticeMsgBoxMap) {
		return sqlSession.insert("notification.insertNoticeMsgBox",noticeMsgBoxMap);
	}
}
