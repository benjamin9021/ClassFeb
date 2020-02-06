package plz;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class mUpdateUiCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String id = request.getParameter("id");
		MemberDAO dao = new MemberDAO();
		MemberDTO dto =  dao.updateui(id);
		
		request.setAttribute("dto", dto);
		
		return new CommandAction(false, "mupdate.jsp");
	}

}
