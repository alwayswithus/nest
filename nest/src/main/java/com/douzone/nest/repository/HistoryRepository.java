package com.douzone.nest.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.nest.vo.HistoryVo;

@Repository
public class HistoryRepository {

	@Autowired
	private SqlSession sqlSession;
	
	public List<HistoryVo> selectHistory(Long projectNo) {
		return sqlSession.selectList("history.selectHistory", projectNo);
	}

	public int insertHistory(Map<String, Object> map) {
		return sqlSession.insert("history.insertHistory", map);
	}

}
