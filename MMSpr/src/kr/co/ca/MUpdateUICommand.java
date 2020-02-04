package kr.co.ca;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naver.Command;
import com.naver.CommandAction;

public class MUpdateUICommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		
		MemberDAO dao = new MemberDAO();
		
		MemberDTO dto = dao.updateui(id);
		
		request.setAttribute("dto", dto);
		
		return new CommandAction(false, "mupdate.jsp");
	}

}
