package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListTanks;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/**
		 * Grabs the value from the button the user clicked in tank-list.jsp
		 */
		ListTanksHelper lth = new ListTanksHelper();
		String act = request.getParameter("doToTank");
		
		String path = "/viewTanksServlet";
		
		/**
		 * Decision structure based on what button the user clicked
		 */
		if (act.equals("delete")) { // deletes selected tank record
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ListTanks tankToDelete = lth.searchForTankById(tempId);
				lth.deleteTank(tankToDelete);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a tank");
			}
			
		} else if (act.equals("edit")) { // sends user back to index.jsp to use the edit form to edit selected tank
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ListTanks tankToEdit = lth.searchForTankById(tempId);
				request.setAttribute("tankToEdit", tankToEdit);
				path = "/index.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a tank");
			}
			
		} else if (act.equals("add")) { // sends user back to index.jsp so they can use the add form
			path = "/index.jsp";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
		
	}

}
