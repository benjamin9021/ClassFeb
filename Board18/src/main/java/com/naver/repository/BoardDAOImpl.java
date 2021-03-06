package com.naver.repository;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.naver.dto.BoardVO;
import com.naver.dto.PageTo;

@Repository
public class BoardDAOImpl implements BoardDAO{

	@Inject
	private SqlSession session;
	
	private final String NS = "com.naver.board";
	
	@Override
	public List<BoardVO> list() {
		
		return session.selectList(NS+".list");
	}

	@Override
	public void insert(BoardVO vo) {		
		session.insert(NS+".insert",vo); 
	}

	@Override
	public void updateReadcnt(int bno) {

		session.update(NS+".updateReadcnt", bno);
	}

	
	@Override
	public BoardVO read(int bno) {

		return session.selectOne(NS+".read", bno);
	}

	@Override
	public BoardVO updateui(int bno) {
		return session.selectOne(NS+".updateui", bno);
	}

	@Override
	public void update(BoardVO vo) {
		session.update(NS+".update", vo);
	}

	@Override
	public void delete(int bno) {
		session.delete(NS+".delete",bno);
	}

	@Override
	public int getamount() {
		
		return session.selectOne(NS+".getamount");
	}

	@Override
	public List<BoardVO> getlistpage(PageTo to) {
		RowBounds rb = new RowBounds(to.getStartNum()-1,to.getPerPage());
		
		return session.selectList(NS+".getlistpage", null, rb);
	}

	
}
