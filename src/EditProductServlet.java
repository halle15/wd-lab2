

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import music.models.Product;

/**
 * Servlet implementation class EditProductServlet
 */
@WebServlet("/EditProduct")
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public EditProductServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String key = request.getParameter("key");
		String desc = request.getParameter("description");
		String price = request.getParameter("price");
		Product p;
		if((key != null) || (desc != null) || (price != null)) {
		 p = new Product(key, desc, Double.parseDouble(price));
		}
		else {
		 p = new Product("", "", 0);
		}
		request.setAttribute("product", p);
		request.getRequestDispatcher("editProduct.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
