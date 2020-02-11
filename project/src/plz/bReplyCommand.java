package plz;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class bReplyCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		int orinum = Integer.parseInt(request.getParameter("num"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String id = request.getParameter("id");
		
		BoardDAO dao = new BoardDAO();
		dao.reply(orinum,title,content,id);
		
		return new CommandAction(true, "bread.do?num="+dao.maxnum());
	}
	
}
