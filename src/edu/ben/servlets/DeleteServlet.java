package edu.ben.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.DAO.ProductDAO;
import edu.ben.model.Cart;
import edu.ben.model.Product;

/**
 * Servlet implementation class DeleteProduct
 */
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
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

		System.out.println("in the servlet");
		String prodID = request.getParameter("prodID");
		ProductDAO dao = new ProductDAO();
		Product p = dao.findByID(Integer.parseInt(prodID));
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		cart.remove(p);
		
		request.getSession().setAttribute("cart", cart);
		
		getServletContext().getRequestDispatcher("/mycart.jsp").forward(request, response);
		
		
//		doGet(request, response);
	}

}
