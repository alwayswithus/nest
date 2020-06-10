package com.douzone.nest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.nest.repository.ProfileRepository;
import com.douzone.nest.vo.UserVo;

@Service
public class ProfileService {
	
	@Autowired
	private ProfileRepository profileRepository;
	
	public UserVo userSelect(Long userNo) {
		return profileRepository.userSelect(userNo);
	}

	public boolean updateUser(UserVo userVo) {
		return 1 == profileRepository.updateUser(userVo);
	}
}
