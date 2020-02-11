package plz;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class bDeleteCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println("딜리트 넘 :"+num);
		BoardDAO dao = new BoardDAO();
		dao.delete(num);
		
		return new CommandAction(true, "blist.do");
	}

}
