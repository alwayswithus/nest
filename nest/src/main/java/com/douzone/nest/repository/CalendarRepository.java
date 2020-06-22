package com.douzone.nest.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.nest.vo.TaskListVo;
import com.douzone.nest.vo.TaskVo;
import com.douzone.nest.vo.UserProjectVo;

@Repository
public class CalendarRepository {

	@Autowired
	private SqlSession sqlSession;
	
	public List<TaskVo> selectTask(Long authUserNo) {
		return sqlSession.selectList("task.selectTask", authUserNo);
	}
	
	public Long selectUser(Map<String, Object> map) {
		Long userNo =  sqlSession.selectOne("task.selectUser", map);
		return userNo;
	}
	
	public List<TaskListVo> selectTaskList(Long projectNo) {
		return sqlSession.selectList("tasklist.selectTaskList", projectNo);
	}
	
	public int selectTaskOrder(TaskVo taskVo) {
		return sqlSession.selectOne("task.selectTaskOrder", taskVo);
	}
	
	public int taskAdd(TaskVo taskVo) {
		return sqlSession.insert("task.taskAdd", taskVo);
	}

	public List<UserProjectVo> selectProjectNo(Long userNo) {
		return sqlSession.selectList("userproject.selectProjectNo", userNo);
	}
}
