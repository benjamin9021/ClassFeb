package plz;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class mListCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		List<MemberDTO> list = new MemberDAO().list();
		request.setAttribute("list",list);
		
		return new CommandAction(false, "mlist.jsp");
	}

}
