package com.naver.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.naver.dto.MemberDTO;
import com.naver.service.MemberService;

@Controller
@RequestMapping("member")
public class MemberController {

	
	@Inject
	private MemberService mservice;
	
	@RequestMapping("list")
	public String list(Model model) {
		List<MemberDTO> list = mservice.list();
		model.addAttribute("list", list);
		
		return "member/list";
	}
}
