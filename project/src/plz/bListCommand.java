package plz;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class bListCommand implements Command {

   @Override
   public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
         throws IOException, ServletException {
      String sCurPage = request.getParameter("curPage");
      String option = request.getParameter("option");
      String searchtext = request.getParameter("searchtext");
      
      int curPage = 1;
      if(sCurPage != null) {
         curPage = Integer.parseInt(sCurPage);
      }
       if (searchtext == null)      searchtext = "";
       if(option==null) option = "title";
      BoardDAO dao = new BoardDAO();
      PageTO to =dao.list(curPage,option,searchtext);
      
      request.setAttribute("option", option);
      request.setAttribute("searchtext",searchtext);
      request.setAttribute("list",to.getList());
      request.setAttribute("to", to);
       return new CommandAction(false, "blist.jsp");
   }

}