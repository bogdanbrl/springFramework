package com.criptex.springFramework;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.criptex.service.WelcomeService;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet("/WelcomeServletModified_afterCreatingService")
public class WelcomeServletModified_afterCreatingService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServletModified_afterCreatingService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. create the data and add it to the request object
		// Invoking business layer
		WelcomeService welcomeService = new WelcomeService();
		List<String> welcomeMessage = welcomeService.getWelcomeMessage("Bogdan");
		request.setAttribute("myWelcomeMessage", welcomeMessage);
		
		
		// 2. retrive request dispatcher
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("welcomeModified_afterCreatingNewServlet.jsp");
		
		// 3. forward request to the view
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
