package com.naver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String sAge = request.getParameter("age");
		int age = -1;
		if (sAge != null) {
			age = Integer.valueOf(sAge);
		}
		MemberDAO dao = new MemberDAO();
		dao.update(new MemberDTO(id, name, age));
				
		
		return new CommandAction(true, "read.do?id="+id);
	}

}
