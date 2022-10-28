

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import music.models.Product;

/**
 * Servlet implementation class GetProducts
 */
@WebServlet("/GetProducts")
public class GetProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
		HashMap<String, Product> p = fillMap();
		//List<Product> pr;
	
    /**
     * Default constructor. 
     */
    public GetProducts	() {
    	
    	/*
    	this.p = new HashMap<String, Product>();
    	this.pr = music.data.ProductIO.getProducts();
    	for(Product product : this.pr) {
    		p.put(product.getCode(), product);
    	}
    	*/
    }
    
    public HashMap<String, Product> fillMap(){
    	HashMap<String, Product> hm = new HashMap<String, Product>();
    	
    	for(Product product : music.data.ProductIO.getProducts()) {
    		hm.put(product.getCode(), product);
    	}
    	
    	return hm;
    	
    }
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		request.setAttribute("entry", p);

		String xx = request.getParameter("st"); //determines which page this hashmap is deployed to
		if(xx.equals("1")) {
			request.getRequestDispatcher("searchResults.jsp").include(request, response);
		}
		else {
			request.getRequestDispatcher("productMaint.jsp").include(request, response);
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String code;
		if(request.getParameter("code") != null) {
			code = request.getParameter("code");
		}
		else {
			doGet(request, response);
			return;
		}
		 
		int delete = Integer.parseInt(request.getParameter("delete"));
		if(delete == 1) {
			p.remove(code);
			doGet(request,response);
			return;
		}
		String description = request.getParameter("description");
		double price = -1;
		if(request.getParameter("price") == null ) {
			
			request.setAttribute("error", 1);
			doGet(request, response);
			return;
		}
		price = Double.valueOf(request.getParameter("price"));
		p.put(code, new Product(code, description, price));
		
		
		request.setAttribute("st", "0");
		doGet(request, response);
	}
	
	public void removeProduct(String product) {
		p.remove(product);
	}

}
