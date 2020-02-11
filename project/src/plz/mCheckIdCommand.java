package plz;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class mCheckIdCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String id = request.getParameter("id");
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.read(id);
		
		if (id.length() < 4) {
			response.getWriter().print("아이디는 4글자이상만 가능합니다.");
			}else {
			if (dto != null) {
				response.getWriter().print("사용이 불가능한 아이디 입니다.");
			} else {
				response.getWriter().print("사용이 가능한 아이디 입니다.");
			} 
		}
		return null;
	}

}
