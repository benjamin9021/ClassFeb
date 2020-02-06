package plz;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class bUpdateUiCommnad implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		int num = Integer.parseInt(request.getParameter("num"));
		
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.updateui(num);
		
		request.setAttribute("dto", dto);
		
		return new CommandAction(false, "bupdate.jsp");
	}

}
