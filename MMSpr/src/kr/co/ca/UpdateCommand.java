package kr.co.ca;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String pass = request.getParameter("pw");
		String name = request.getParameter("name");
		String birthday = request.getParameter("birthday");
		int pw = -1;
		if (pass != null) {
			pw = Integer.valueOf(pass);
		}
		MemberDAO dao = new MemberDAO();
//		dao.update(new MemberDTO(id, name, age));
				
		
		return new CommandAction(true, "read.do?id="+id);
	}

}
