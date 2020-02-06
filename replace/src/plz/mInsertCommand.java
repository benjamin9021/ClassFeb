package plz;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class mInsertCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String id =request.getParameter("id");
		String name = request.getParameter("name");
		String pw = request.getParameter("pw");
		String birthday = request.getParameter("birthday");
		int nKey = 10;
		MemberDAO dao = new MemberDAO();
		dao.insert(new MemberDTO(id, name, pw, birthday,null,nKey));
		return new CommandAction(true, "mlist.do");
	}

}
