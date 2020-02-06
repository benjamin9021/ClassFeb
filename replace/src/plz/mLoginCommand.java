package plz;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class mLoginCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		MemberDTO login =new MemberDAO().login(request.getParameter("id"),request.getParameter("pw"));
		request.getSession().setAttribute("login", login);
		return new CommandAction(true, "blist.do");
	}

}
