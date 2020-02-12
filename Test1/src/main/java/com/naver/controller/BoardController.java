package com.naver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("board")
public class BoardController {

	
	@RequestMapping("list")
	public String list(Model model) {
		model.addAttribute("name","kim");
		model.addAttribute("age","21");
		
		return "board/list";
	}
	
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert() {
		return "redirect:/board/list";
	}
	@RequestMapping("insert")
	public String insertui() {
		return "redirect:/insert";
	}
	
}
