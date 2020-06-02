package com.douzone.nest.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.nest.vo.CheckListVo;

@Repository
public class TaskSettingRepository {
	
	@Autowired
	private SqlSession sqlSession;
	
	public int insertChecklist(CheckListVo checklistVo) {
		return sqlSession.insert("tasksetting.insertChecklist", checklistVo);
	}

	public int updateChecklist(CheckListVo checklistVo) {
		return sqlSession.update("tasksetting.updateChecklist", checklistVo);
	}

	public int deleteChecklist(Long checklistNo) {
		return sqlSession.delete("tasksetting.deleteChecklist", checklistNo);
	}
}
