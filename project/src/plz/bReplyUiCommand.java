package plz;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class bReplyUiCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		int num =Integer.parseInt(request.getParameter("num"));
		
		request.setAttribute("num", num);
		return new CommandAction(false, "breply.jsp");
	}

}
