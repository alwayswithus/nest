package com.douzone.nest.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.nest.vo.FileVo;

@Repository
public class FileRepository {
	
	@Autowired
	private SqlSession sqlSession;
	
	public int insertFile(FileVo fileVo) {
		return sqlSession.insert("file.insertFile",fileVo);
	}

}
