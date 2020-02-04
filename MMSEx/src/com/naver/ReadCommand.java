package com.naver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReadCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		String id = request.getParameter("id");
		MemberDTO dto = new MemberDAO().read(id);
		
		request.setAttribute("dto", dto);
		
		return new CommandAction(false, "read.jsp");
	}

}
