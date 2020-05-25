package com.douzone.nest.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class KanbanBoardRepository {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<Map<Object, String>> selectKanbanBoard() {
		return sqlSession.selectList("kanbanBoard.selectkanbanBoard");
	}

}
