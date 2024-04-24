package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListTanks;

/**
 * Servlet implementation class AddTankServlet
 */
@WebServlet("/addTankServlet")
public class AddTankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTankServlet() {
        super();
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * Gets user input variables from add form and adds a new tank record to the database, which is displayed on the list
		 */
		String country = request.getParameter("country");
		String model = request.getParameter("model");
		String gunCaliber = request.getParameter("gunCaliber");
		
		ListTanks li = new ListTanks(country, model, gunCaliber);
		ListTanksHelper lth = new ListTanksHelper();
		lth.insertTank(li);
		
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
