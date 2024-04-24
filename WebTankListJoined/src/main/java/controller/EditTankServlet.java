package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListTanks;

/**
 * Servlet implementation class EditItemServlet
 */
@WebServlet("/editTankServlet")
public class EditTankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditTankServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * Gets user input variables from edit form and updates the specified id in database
		 */
		try {
			ListTanksHelper lth = new ListTanksHelper();
			String country = request.getParameter("country");
			String model = request.getParameter("model");
			String gunCaliber = request.getParameter("gunCaliber");
			Integer id = Integer.parseInt(request.getParameter("id"));
			
			ListTanks tankToEdit = lth.searchForTankById(id);
			
			tankToEdit.setCountry(country);
			tankToEdit.setModel(model);
			tankToEdit.setGunCaliber(gunCaliber);
			
			lth.updateTank(tankToEdit);
			
		} catch (NumberFormatException e) { // will print this error into console if no tank was selected for editing from the list
			System.out.println("Forgot to select a tank first");
		}
		
		getServletContext().getRequestDispatcher("/viewTanksServlet").forward(request, response);
	}

}
