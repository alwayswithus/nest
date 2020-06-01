package com.douzone.nest.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.nest.vo.CheckListVo;
import com.douzone.nest.vo.CommentVo;
import com.douzone.nest.vo.CopyTaskVo;
import com.douzone.nest.vo.FileVo;
import com.douzone.nest.vo.TagListVo;
import com.douzone.nest.vo.TaskListVo;
import com.douzone.nest.vo.TaskReOrderVo;
import com.douzone.nest.vo.TaskVo;
import com.douzone.nest.vo.UserVo;

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
	 * 설명 : 파일 select
	 */
	public List<FileVo> selectFileList(Long taskNo) {
		return sqlSession.selectList("kanbanBoard.selectFile", taskNo);
	}

	/*
	 * 작성자 : 최인효
	 * 설명 : 업무 포함 유저 select
	 */
	public List<UserVo> selectMemberList(Long taskNo) {
		return sqlSession.selectList("kanbanBoard.selectMemberList",taskNo);
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
	 * 설명 : 테스크리스트 insert
	 */
	public int taskListAdd(TaskListVo taskListVo) {
		return sqlSession.insert("kanbanBoard.taskListAdd", taskListVo);
	}
	
	/*
	 * 작성자 : 최인효
	 * 설명 : 테스크리스트 delete
	 */
	public int taskListDelete(TaskListVo taskListVo) {
		return sqlSession.delete("kanbanBoard.taskListDelete", taskListVo);
	}
	
	/*
	 * 작성자 : 최인효
	 * 설명 : 테그리스트 삭제시 정렬 update
	 */
	public int taskListDeleteReOrder(TaskListVo taskListVo) {
		return sqlSession.update("kanbanBoard.taskListDeleteReOrder", taskListVo);
	}
	
	/*
	 * 작성자 : 최인효
	 * 설명 : 테스크리스트 이름 변경
	 */
	public int taskListEditName(TaskListVo taskListVo) {
		return sqlSession.update("kanbanBoard.taskListEditName", taskListVo);
	}
	
	/*
	 * 작성자 : 최인효
	 * 설명 : 테스크리스트 DnD 정렬 update
	 */
	public int taskListDnDReOrder(TaskListVo taskListVo) {
		return sqlSession.update("kanbanBoard.taskListDnDReOrder", taskListVo);
	}
	
	/*
	 * 작성자 : 최인효
	 * 설명 : 테스크 추가
	 */
	public int taskInsert(Map task) {
		return sqlSession.insert("kanbanBoard.taskInsert", task);
	}
	

	/*
	 * 작성자 : 최인효
	 * 설명 : 테스크 추가 후 가져오기
	 */
	public TaskVo taskSelect(Long taskNo) {
		return sqlSession.selectOne("kanbanBoard.taskSelect", taskNo);
	}
	

	/*
	 * 작성자 : 최인효
	 * 설명 : 테스크 삭제
	 */
	public int taskDelete(Long reOrderTask) {
		return sqlSession.delete("kanbanBoard.taskDelete", reOrderTask);
	}
	
	/*
	 * 작성자 : 최인효
	 * 설명 : 테스크 복사
	 */
	public int copyTask(CopyTaskVo copyTask) {
		return sqlSession.insert("kanbanBoard.copyTask", copyTask);
	}
	
	/*
	 * 작성자 : 최인효
	 * 설명 : 테스크 복사 (태그)
	 */
	public int copyTag(TagListVo vo) {
		return sqlSession.insert("kanbanBoard.copyTag", vo);
	}

	/*
	 * 작성자 : 최인효
	 * 설명 : 테스크 복사 (멤버)
	 */
	public int copyUser(UserVo vo) {
		return sqlSession.insert("kanbanBoard.copyUser", vo);
	}

	/*
	 * 작성자 : 최인효
	 * 설명 : 테스크 복사 (체크리스트)
	 */
	public int copyCheckList(CheckListVo vo) {
		return sqlSession.insert("kanbanBoard.copyCheckList", vo);
	}

	/*
	 * 작성자 : 최인효
	 * 설명 : 테스크 정렬
	 */
	public int taskReOrder(TaskVo taskVo) {
		return sqlSession.update("kanbanBoard.taskDnDReOrder", taskVo);
	}


	/*
	 * 작성자 : 최인효
	 * 설명 : 다른 리스트로 테스크 이동(taskListNo 변경)
	 */
	public int taskInTaskListNoChange(TaskReOrderVo taskReOrder) {
		return sqlSession.update("kanbanBoard.taskInTaskListNoChange", taskReOrder);
	}

	/*
	 * 작성자 : 최인효
	 * 설명 : 테스크 체크 update
	 */
	public int taskStateUpdate(TaskVo taskVo) {
		return sqlSession.update("kanbanBoard.taskStateUpdate", taskVo);
	}












	

}
