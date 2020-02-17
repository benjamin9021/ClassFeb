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

	@Override
	public void insert(MemberDTO dto) {
		
		mdao.insert(dto);
	}

	@Override
	public MemberDTO read(String id) {
		
		return mdao.read(id);
	}
	
	@Override
	public MemberDTO updateui(String id) {
		return mdao.updateui(id);
	}

	@Override
	public void update(MemberDTO dto) {
		mdao.update(dto);
	}

	@Override
	public void delete(String id) {
		
		mdao.delete(id);
	}

	
}
