package com.naver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller   // 1.���߿� ������ �����̳ʰ� �긦 Ȯ���ϰ� ���Ŀ� ��ü�� �������� ���� ���� �ľ�,
         // 2. ���� ��� 
@RequestMapping("/member")      //���߿� board ���� crud �� �����ǵ� �̷����ϸ� ��������ؼ��� ���´�.
public class MemberController {

//   ȸ�� ���񽺿� ���õ� crud �۾��� �����ϴ� mvc �ڵ鷯�� ����� �ּ���.
   
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