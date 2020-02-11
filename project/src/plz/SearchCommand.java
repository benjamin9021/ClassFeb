package plz;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchCommand implements Command {

   @Override
   public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
         throws IOException, ServletException {
      String option = request.getParameter("option");
      String beforesearchtext = request.getParameter("searchtext");
      
      String sCurPage = request.getParameter("curPage");
      
      String searchtext = new String(beforesearchtext.getBytes("euc-kr"),"8859_1");
      
      System.out.println("인코딩후 서치데이터입니다  " + searchtext);
      
      int curPage = 1;
      if (sCurPage != null) {
         curPage = Integer.parseInt(sCurPage);
      }
      if (searchtext == null) searchtext = "";
      if (option==null) option = "title";
      BoardDAO dao = new BoardDAO();
      
      
      PageTO to =dao.list(curPage,option,searchtext);
      System.out.println(option + "   " + searchtext);
      request.setAttribute("option", option);
      request.setAttribute("searchtext",searchtext);
      request.setAttribute("list",to.getList());
      request.setAttribute("to", to);
      System.out.println("서치커맨드 끝");
      return new CommandAction(true, "blist.do?option="+option+"&searchtext="+searchtext+"&curPage="+curPage);

   }
}