package kr.co.ca;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oracle.net.aso.i;

public class LoginCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pw");
		int pw = -1;
		if (pass != null) {
			pw = Integer.parseInt(pass);
		}
		
		MemberDTO login = new MemberDAO().login(id, pw);
		request.getSession().setAttribute("login", login);
		
		return new CommandAction(true, "list.do");
	}

}
