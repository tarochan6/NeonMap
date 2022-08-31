package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import domain.Member;
import domain.Neon;

/**
 * Servlet implementation class MemberpageServlet
 */
@WebServlet("/member/neonList")
public class NeonListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NeonListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   	Member member = (Member) request.getSession().getAttribute("member");
		
			List<Neon> neons = null;
			try {
				neons = DaoFactory.createNeonDao().findByMember(member.getId());
			}catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("neons", neons);
	    	request.getRequestDispatcher("/WEB-INF/view/member/neonList.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

}
