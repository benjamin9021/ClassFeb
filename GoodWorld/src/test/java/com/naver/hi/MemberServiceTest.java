package com.naver.hi;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.naver.repository.MemberDAO;
import com.naver.service.MemberService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"}) 
public class MemberServiceTest {
	
	@Inject
	private MemberService mservice;
	
	@Test
	public void testGetTime() {
		System.out.println(":::::::::::::::::::::::::::::");
		System.out.println(mservice.getTime());
		
		System.out.println(":::::::::::::::::::::::::::::");
	}

	@Test
	public void testGetList() {
		
		System.out.println(":::::::::::::::::::::::::::::");
		System.out.println(mservice.list());
		System.out.println(":::::::::::::::::::::::::::::");
	}
	
	
}
