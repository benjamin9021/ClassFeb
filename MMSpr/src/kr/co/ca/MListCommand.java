package kr.co.ca;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naver.Command;
import com.naver.CommandAction;

public class MListCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		List<MemberDTO> list = new MemberDAO().list();
		request.setAttribute("list", list);
		return new CommandAction(false, "mlist.jsp");
	}

}
