package com.naver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.naver.dto.BoardVO;
import com.naver.dto.PageTo;
import com.naver.service.BoardService;

@Controller
@RequestMapping("board")
public class BoardController {

   @Autowired
   private BoardService bservice;

   @RequestMapping("list")
   public String list(Model model) {

      List<BoardVO> list = bservice.list();

      model.addAttribute("list", list);
      
      return "board/list";
   }

   @RequestMapping(value = "insert", method = RequestMethod.GET)
   public String insertui() {

      return "board/insert";
   }

   @RequestMapping(value = "insert", method = RequestMethod.POST)
   public String insert(Model model, BoardVO vo) {

      bservice.insert(vo);
      return "redirect:/board/listpage";
   }

   @RequestMapping(value = "read/{bno}", method = RequestMethod.GET)
   public String read(@PathVariable("bno") int bno, int curPage, Model model) {

      BoardVO vo = bservice.read(bno);

      model.addAttribute("vo", vo);
      
      model.addAttribute("curPage" , curPage);
      
      return "board/read";
   }

   @RequestMapping("delete/{bno}")
   public String delete(@PathVariable("bno") int bno) {

      bservice.delete(bno);

      return "redirect:/board/listpage";
   }

   @RequestMapping(value = "update", method = RequestMethod.GET)
   public String updateui(int bno, Model model , int curPage) {

      BoardVO vo = bservice.updateui(bno);
      System.out.println(bno);
      model.addAttribute("vo", vo);
      model.addAttribute("curPage",curPage);
      return "board/update";
   }

   @RequestMapping(value = "update", method = RequestMethod.POST)
   public String update(Model model, BoardVO vo , @RequestParam("curPage") int curPage) {
      
      bservice.update(vo);
      return "redirect:/board/listpage?curPage="+curPage;
   }

   @RequestMapping(value = "listpage", method = RequestMethod.GET)
   public void listpage(Model model, PageTo to) {

      to = bservice.listpage(to);
      // ������������������ �޾ƿͼ� �ٽ� to �� amount , total , start , begin , stop ���� �ִ´�.

      model.addAttribute("to", to);
   }

}