package kr.co.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.naver.dto.MemberDTO;



@Controller
public class TestController {
	
	
	
	
	@RequestMapping("test9")
	public @ResponseBody String test9() {
		return "hello world~!!!";
	}
	
	
	@RequestMapping("test8")
	public void name(@ModelAttribute("dto") MemberDTO dto) {
		
		
		
		
	}
	
	@RequestMapping("test7")
   
   public void test7(String title, Model model) {
      model.addAttribute("title", title);
      
      
   }
   @RequestMapping("test6/{i}")
   public String test6(@PathVariable("i")int curPage) {
      System.out.println(curPage);

      return "test6";
   }

   @RequestMapping("test5")
   public void test5(@RequestParam String id, @RequestParam String name, @RequestParam int age) {
      System.out.println(id);
      System.out.println(name);
      System.out.println(age);

   }

   @RequestMapping("/test4")
   public String test4(com.naver.dto.MemberDTO dto) {
      System.out.println(dto.getId());
      System.out.println(dto.getAge());
      System.out.println(dto.getName());

      return "test4";
   }

   @RequestMapping("/test3")
   public void test3(String id) {
      System.out.println(id);

   }

   @RequestMapping("/test2")
   public void test2(Model model) {
      model.addAttribute("name", "kim");
      model.addAttribute("age", 11);

   }

   @RequestMapping("/test1")
   public void test1() {
      System.out.println("test1");
   }

}