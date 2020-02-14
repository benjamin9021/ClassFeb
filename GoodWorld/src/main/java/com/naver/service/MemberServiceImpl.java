package com.naver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.dto.MemberDTO;
import com.naver.repository.MemberDAO;


@Service 
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAO mdao;
	
	@Override
	public String getTime() {
		return mdao.getTime();
	}

	@Override
	public List<MemberDTO> list() {
		return mdao.list();
	}
	
}
