package com.douzone.nest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.nest.repository.UserRepository;
import com.douzone.nest.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	// DB에서 유저 가저오기
	public UserVo getUser(UserVo vo) {
		UserVo result = userRepository.findByEmailAndPassword(vo);
		System.out.println(result);
		return result;
	}

}
