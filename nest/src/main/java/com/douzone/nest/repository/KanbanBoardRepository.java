package com.douzone.nest.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.nest.vo.CheckListVo;
import com.douzone.nest.vo.CommentVo;
import com.douzone.nest.vo.TagListVo;
import com.douzone.nest.vo.TaskListVo;
import com.douzone.nest.vo.TaskVo;

@Repository
public class KanbanBoardRepository {
	
	@Autowired
	private SqlSession sqlSession;
	/*
	 * 작성자 : 최인효
	 * 설명 : 테스크 리스트 select
	 */
	public List<TaskListVo> selectAllTaskList(Long projectNo) {
		return sqlSession.selectList("kanbanBoard.selectAllTaskList",projectNo);
	}
	

	/*
	 * 작성자 : 최인효
	 * 설명 : 테스트 select
	 */
	public List<TaskVo> selectTasks(Long taskListNo) {
		return sqlSession.selectList("kanbanBoard.selectTasks",taskListNo);
	}
	
	/**
	 * 작성자 : 최인효
	 * 설명 : 체크리스트 select
	 */
	public List<CheckListVo> selectCheckList(Long taskNo) {
		return sqlSession.selectList("kanbanBoard.selectCheckList",taskNo);
	}
	
	/*
	 * 작성자 : 최인효
	 * 설명 : 태그 select
	 */
	public List<TagListVo> selectTag(Long taskNo) {
		return sqlSession.selectList("kanbanBoard.selectTag",taskNo);
	}
	
	/*
	 * 작성자 : 최인효
	 * 설명 : 코멘트 select
	 */
	public List<CommentVo> selectComments(Long taskNo) {
		return sqlSession.selectList("kanbanBoard.selectComments",taskNo);
	}

	/*
	 * 작성자 : 최인효
	 * 설명 : 테스크 리스트 정렬 번호 select 
	 */
	public Long selectTaskListOrderNo(Long projectNo) {
		Long taskListOrderNo = sqlSession.selectOne("kanbanBoard.selectTaskListOrderNo", projectNo);
		return taskListOrderNo;
	}
	
	/*
	 * 작성자 : 최인효
	 * 설명 : taskList 추가
	 */
	public int taskListAdd(TaskListVo taskListVo) {
		int result = sqlSession.insert("kanbanBoard.taskListAdd", taskListVo);
		System.out.println(taskListVo);
		return result;
	}
	
	/*
	 * 작성자 : 최인효
	 * 설명 : 테스크 복사
	 */
	public int taskCopy(TaskVo taskVo) {
		return sqlSession.insert("kanbanBoard.taskCopy", taskVo);
	}







}
