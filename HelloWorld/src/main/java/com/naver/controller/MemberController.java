package com.naver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller   // 1.나중에 스프링 컨테이너가 얘를 확인하고 추후에 객체로 만들지의 대한 유무 파악,
         // 2. 지금 얘는 
@RequestMapping("/member")      //나중에 board 에도 crud 가 있을건데 이렇게하면 멤버관련해서만 들어온다.
public class MemberController {

//   회원 서비스와 관련된 crud 작업을 지원하는 mvc 핸들러를 만들어 주세요.
   
   //C
   @RequestMapping(value = "insert",method = RequestMethod.POST)
   public String insert() {
      
      return null;
   }
   @RequestMapping ("insert")
   public String insertui() {
      

      return "member/insert";
   }
   
   
   //R
   @RequestMapping("list")
   public String list( ) {
      
      return null;
   }
   
   
   //U
   @RequestMapping(value = "update",method = RequestMethod.POST)
   public String update( ) {
      
      return null;
   }
   @RequestMapping("update")
   public String updateui( ) {
      
      return null;
   }
   
   
   
   //D
   @RequestMapping("delete")
   public String delete( ) {
      
      return null;
   }
   

   
   
   
}