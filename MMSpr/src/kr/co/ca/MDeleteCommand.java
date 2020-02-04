package kr.co.ca;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.naver.Command;
import com.naver.CommandAction;

public class MDeleteCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		MemberDAO dao = new MemberDAO();
		dao.delete(id);

		return new CommandAction(true, "mlist.do");
	}

}
