package kr.co.ca;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.naver.Command;
import com.naver.CommandAction;

import oracle.net.aso.i;

public class MLoginCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
	
		
		MemberDTO login = new MemberDAO().login(id, pw);
		request.getSession().setAttribute("login", login);
		
		return new CommandAction(true, "mlist.do");
	}

}
