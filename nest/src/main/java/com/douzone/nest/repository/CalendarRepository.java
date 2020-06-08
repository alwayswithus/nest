package com.douzone.nest.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.nest.vo.TaskVo;

@Repository
public class CalendarRepository {

	@Autowired
	private SqlSession sqlSession;
	
	public List<TaskVo> selectTask(Long authUserNo) {
		return sqlSession.selectList("task.selectTask", authUserNo);
	}
}
