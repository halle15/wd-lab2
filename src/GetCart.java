


import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import music.models.CartEntry;
import music.models.Product;

/**
 * Servlet implementation class GetCart
 */
@WebServlet({ "/GetCart", "/getCart" })
public class GetCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HashMap<String, CartEntry> l; // use hashmap to make replacing easier.
	

	
    /**
     * Default constructor. 
     */
    public GetCart() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s = request.getSession();
		if(s.getAttribute("entries") == null) {
			l = new HashMap<String, CartEntry>();
			s.setAttribute("entries", l);
			s.setAttribute("entries", l);
			double total = 0.0;
			for(CartEntry c : l.values()) {
				total += c.getProduct().getPrice() * c.getQty();
			}
			s.setAttribute("total", NumberFormat.getCurrencyInstance().format(total));
			request.getRequestDispatcher("cart.jsp").include(request, response);
			return;
		}
		else {
			l = (HashMap<String, CartEntry>) s.getAttribute("entries");
			s.setAttribute("entries", l);
			double total = 0.0;
			for(CartEntry c : l.values()) {
				total += c.getProduct().getPrice() * c.getQty();
			}
			s.setAttribute("total", NumberFormat.getCurrencyInstance().format(total));
			request.getRequestDispatcher("cart.jsp").include(request, response);
			return;
		}

		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s = request.getSession();
		
		
		String code = request.getParameter("code");
		String description = request.getParameter("description");
		int qty = 1;
		double price = Double.parseDouble(request.getParameter("price"));
		
		
		if(request.getParameter("mode").equals("e")) {
			
		
			qty = Integer.parseInt(request.getParameter("qty"));
			CartEntry e = new CartEntry(new Product(code, description, price), qty);
			l.put(code, e);
		
			s.setAttribute("entries", l);
		}
		else if(request.getParameter("mode").equals("a")) {
			if(s.getAttribute("entries") == null) {
				l = new HashMap<String, CartEntry>();
			}
			else {
				l = (HashMap<String, CartEntry>) s.getAttribute("entries");
			}
			
			Product p = new Product(code, description, price);
			
			l.put(code, new CartEntry(p, qty));
			
		}
		
		
		doGet(request, response);
	}

}
