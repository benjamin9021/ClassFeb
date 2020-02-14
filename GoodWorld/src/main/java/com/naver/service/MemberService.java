package com.naver.service;

import java.util.List;

import com.naver.dto.MemberDTO;


public interface MemberService {
	
	public abstract String getTime();
	public abstract List<MemberDTO>	list();
	
	
}
