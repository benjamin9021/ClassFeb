package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReplyCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String sNum = request.getParameter("num");
		int orinum =-1;
		if (sNum != null) {
			orinum = Integer.parseInt(sNum);
		}
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String author = request.getParameter("author");
		BoardDAO dao = new BoardDAO();
		dao.reply(orinum, title,content,author);
		
		return new CommandAction(true, "list.do");
	}

}
