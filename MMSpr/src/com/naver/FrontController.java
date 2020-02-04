package com.naver;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ca.CheckIDCommand;
import kr.co.ca.MDeleteCommand;
import kr.co.ca.MInsertUICommand;
import kr.co.ca.MListCommand;
import kr.co.ca.MLoginCommand;
import kr.co.ca.MLoginUICommand;
import kr.co.ca.MLogoutCommand;
import kr.co.ca.MReadCommand;
import kr.co.ca.MUpdateCommand;
import kr.co.ca.MUpdateUICommand;

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
		
		if (what.equalsIgnoreCase("/blist.do")) {
			com = new BListCommand();
		}else if (what.equalsIgnoreCase("/binsertui.do")) {
			com = new BInsertUICommand();
		}else if (what.equalsIgnoreCase("/binsert.do")) {
			com = new BInsertCommand();
		}else if (what.equalsIgnoreCase("/bread.do")) {
			com = new BReadCommand();
		}else if (what.equalsIgnoreCase("/bdelete.do")) {
			com = new BDeleteCommand();
		}else if (what.equalsIgnoreCase("/bupdateui.do")) {
			com = new BUpdateUICommand();
		}else if (what.equalsIgnoreCase("/bupdate.do")) {
			com = new BUpdateCommand();
		}else if (what.equalsIgnoreCase("/breplyui.do")) {
			com = new ReplyUICommand();
		}else if (what.equalsIgnoreCase("/breply.do")) {
			com = new ReplyCommand();
		}else if (what.equalsIgnoreCase("/mlist.do")) {
			com = new MListCommand();
		}else if (what.equalsIgnoreCase("/mlogin.do")) {
			com = new MLoginCommand();
		} else if (what.equalsIgnoreCase("/mloginui.do")) {
			com = new MLoginUICommand();
		} else if (what.equalsIgnoreCase("/mlogout.do")) {
			com = new MLogoutCommand();
		} else if (what.equalsIgnoreCase("/mread.do")) {
			com = new MReadCommand();
		} else if (what.equalsIgnoreCase("/mupdate.do")) {
			com = new MUpdateCommand();
		} else if (what.equalsIgnoreCase("/mupdateui.do")) {
			com = new MUpdateUICommand();
		} else if (what.equalsIgnoreCase("/minsert.do")) {
			/* com = new InsertCommand(); */
		} else if (what.equalsIgnoreCase("/minsertui.do")) {
			com = new MInsertUICommand();
		} else if (what.equalsIgnoreCase("/checkid.do")) {
			com = new CheckIDCommand();
		} else if (what.equalsIgnoreCase("/mdelete.do")) {
			com = new MDeleteCommand();
		}

		
		if (com != null) {
			CommandAction action = com.execute(request, response);
			if (action != null) {
				if (action.isRedirect()) {
					response.sendRedirect(action.getWhere());
				}else {
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
