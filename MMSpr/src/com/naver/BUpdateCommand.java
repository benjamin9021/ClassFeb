package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BUpdateCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
	      BoardDAO dao = new BoardDAO();

	      String sNum = request.getParameter("num");

	      int num = -1;
	      if (sNum != null) {
	         num = Integer.parseInt(sNum);
	      }
	      String title = request.getParameter("title");
	      String id = request.getParameter("id");
	      String content = request.getParameter("content");

	      dao.update(new BoardDTO(num, id, title, content, null, 0, 0, 0, 0));
	      return new CommandAction(true, "blist.do");
	   }

}
