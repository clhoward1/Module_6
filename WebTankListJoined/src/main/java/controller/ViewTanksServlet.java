package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewTanksServlet
 */
@WebServlet("/viewTanksServlet")
public class ViewTanksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewTanksServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * When link is clicked, send user to tank list page.
		 * 
		 * Servlet assigns showAllTanks from ListTanksHelper method to "allTanks" to send to tank-list.jsp, which can use to to display all
		 * records.
		 */
		ListTanksHelper lth = new ListTanksHelper();
		
		request.setAttribute("allTanks", lth.showAllTanks());
		
		String path = "/tank-list.jsp";
		
		/**
		 * If database is empty, stay on index page.
		 */
		if(lth.showAllTanks().isEmpty()){
			path = "/index.jsp";
		}

		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
