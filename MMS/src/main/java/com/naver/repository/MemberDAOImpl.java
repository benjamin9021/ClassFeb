package com.naver.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naver.dto.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO{

	@Autowired
	private SqlSession session;
	private final String NS = "com.naver.member";
	
	@Override
	public String getTime() {
		String msg = session.selectOne(NS+".getTime");
		return msg;
	}

	@Override
	public List<MemberDTO> list() {
		return session.selectList(NS+".list");
	}

	@Override
	public void insert(MemberDTO dto) {
		session.insert(NS+".insert",dto);
	}

	@Override
	public MemberDTO read(String id) {
		return session.selectOne(NS+".read",id);
	}

	@Override
	public MemberDTO updateui(String id) {
		return session.selectOne(NS+".updateui", id);
	}


	@Override
	public void update(MemberDTO dto) {
		session.update(NS+".update", dto);
	}

	@Override
	public void delete(String id) {
		session.delete(NS+".delete", id);
	}

}