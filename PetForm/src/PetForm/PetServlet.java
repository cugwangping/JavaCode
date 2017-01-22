package PetForm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PetServlet
 */
public class PetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private String Pet(int petWeight, int petLeg){
		if(petLeg==0)
			return "a goldfish";
		else if(petLeg==4){
			if(petWeight<5)
				return "a cat";
			else if(petWeight>=5&&petWeight<25)
				return "a dog";
		}
		return "a house plant";
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			doPost(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		// get the input values
		int petWeight = 0, petLeg = 0;
		try {
			petWeight = Integer.parseInt(request.getParameter("weight"));
			petLeg = Integer.parseInt(request.getParameter("legs"));
		} catch (NumberFormatException nfe) {
			petWeight = petLeg = -1; // Get an invalid number
		}

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		out.println(" <html> <body> <h1>Pet</h1> <p>");
		out.println("You want " + petLeg + "   --legged pet weighing "
				+ petWeight + "kg.");

		String pet = Pet(petWeight, petLeg);
		out.println("<P> We recommend getting <b>" + pet);
		out.println("</b> <hr> </body> </html> ");

		out.close();
	}

}
