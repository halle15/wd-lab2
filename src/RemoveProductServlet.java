
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import music.models.Product;

import java.io.IOException;
/**
 * Servlet implementation class RemoveProductServlet
 */
@WebServlet({ "/RemoveProductServlet", "/removeProduct" })
public class RemoveProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RemoveProductServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		String desc = request.getParameter("description");
		String price = request.getParameter("price");
		Product p;
		if(price == null) {
			p = new Product("fail", "fail", -1);
		}
		else {
		p = new Product(code, desc, Double.parseDouble(price));
		}
		
		
		
		request.setAttribute("product", p);
		request.getRequestDispatcher("confirmDelete.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		doGet(request, response);
		
	}

}
