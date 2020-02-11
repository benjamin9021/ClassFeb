package plz;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class bUpdateCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		int num = Integer.parseInt(request.getParameter("num"));
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		
		BoardDAO dao = new BoardDAO();
		dao.update(new BoardDTO(num, id, title, content, null, 0, 0, 0, 0,0));
		return new CommandAction(true, "blist.do");
	}

}
