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
		int nKey = Integer.parseInt(request.getParameter("nkey"));
		String signupday = request.getParameter("signupday");
		MemberDAO dao = new MemberDAO();
		System.out.println(pw);
		
		dao.insert(new MemberDTO(id, pw, name, birthday, nKey, signupday));
		return new CommandAction(true, "blist.do");
	}

}
