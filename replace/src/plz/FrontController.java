package plz;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cPath = request.getContextPath();
		String what = uri.substring(cPath.length());
		
		Command com = null;
		if(what.equalsIgnoreCase("/mlist.do")) {
			com = new mListCommand();
		} else if(what.equalsIgnoreCase("/mloginui.do")) {
			com = new mLoginUiCommand();
		} else if(what.equalsIgnoreCase("/mlogin.do")) {
			com = new mLoginCommand();
		} else if(what.equalsIgnoreCase("/mlogout.do")){
			com = new mLogoutCommand();
		} else if(what.equalsIgnoreCase("/mread.do")) {
			com = new mReadComand();
		} else if(what.equalsIgnoreCase("/mupdateui.do")) {
			com = new mUpdateUiCommand();
		} else if(what.equalsIgnoreCase("/mupdate.do")) {
			com = new mUpdateCommand();
		} else if(what.equalsIgnoreCase("/minsertui.do")) {
			com = new mInsertUiCommand();
		} else if(what.equalsIgnoreCase("/minsert.do")) {
			com = new mInsertCommand();
		} else if(what.equalsIgnoreCase("/mcheckid.do")) {
			com = new mCheckIdCommand();
		} else if(what.equalsIgnoreCase("/mdelete.do")) {
			com = new mDeleteCommand();
		} else if(what.equalsIgnoreCase("/blist.do")) {
			com = new bListCommand();
		} else if (what.equalsIgnoreCase("/binsertui.do")) {
			com = new bInsertUiCommand();
		} else if(what.equalsIgnoreCase("/binsert.do")) {
			com = new bInsertCommand();
		} else if(what.equalsIgnoreCase("/bread.do")) {
			com = new bReadCommand();
		} else if(what.equalsIgnoreCase("/bdelete.do")) {
			com = new bDeleteCommand();
		} else if(what.equalsIgnoreCase("/bupdateui.do")) {
			com = new bUpdateUiCommnad();
		}   else if(what.equalsIgnoreCase("/bupdate.do")) { 
			com = new bUpdateCommand(); 
		} else if(what.equalsIgnoreCase("/breplyui.do")) {
			com = new bReplyUiCommand();
		} else if(what.equalsIgnoreCase("/breply.do")) {
			com = new bReplyCommand();
		} 
		
		if(com!= null) {
			CommandAction action = com.execute(request, response);
			if (action != null) {
				if (action.isRedirect()) {
					response.sendRedirect(action.getWhere());
				} else {
					request.getRequestDispatcher(action.getWhere()).forward(request, response);
				} 
			}
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
