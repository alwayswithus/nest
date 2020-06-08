package com.douzone.nest.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.nest.vo.CheckListVo;
import com.douzone.nest.vo.TaskUserVo;
import com.douzone.nest.vo.TaskVo;

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

	public int updatePoint(TaskVo taskVo) {
		return sqlSession.update("tasksetting.updatePoint", taskVo);
	}

	public int updateTaskContents(TaskVo taskVo) {
		return sqlSession.update("tasksetting.updateTaskContents", taskVo);
	}
	
	/*
	 * 작성자 : 최인효
	 * 설명 : 업무 날짜 변경
	 */
	public int taskDateUpdate(TaskVo taskVo) {
		System.out.println(taskVo);
		return sqlSession.update("kanbanBoard.taskDateUpdate", taskVo);
	}
	
	/*
	 * 작성자 : 김우경
	 * 설명 : 업무 멤버 추가
	 */
	public int taskUserInsert(TaskUserVo taskUserVo) {
		return sqlSession.insert("kanbanBoard.insertTaskUser",taskUserVo);
	}
	
	/*
	 * 작성자 : 김우경
	 * 설명 : 업무 멤버 삭제
	 */
	public int taskUserDelete(TaskUserVo taskUserVo) {
		return sqlSession.delete("kanbanBoard.deleteTaskUser", taskUserVo);
	}
}
