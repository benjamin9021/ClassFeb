package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReadCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String snum = request.getParameter("num");
		
		int num = 1;
		if (snum!=null) {
			num = Integer.parseInt(snum);
		}
		
		BoardDTO dto = new BoardDAO().read(num);
		
		request.setAttribute("dto", dto);
		
		return new CommandAction(false, "read.jsp");
	}

}
