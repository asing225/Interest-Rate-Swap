package com.rbs.irs.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rbs.irs.dao.LoginManager;
import com.rbs.irs.entities.Trader;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		String traderid=request.getParameter("userid");
		String pwd=request.getParameter("password");
		//response.sendRedirect("http://www.google.com");
		//response.sendError(response.SC_BAD_REQUEST,"Not Right Home Page");
	    Trader trader=new Trader();
	    String tradername=null;
	    if(!traderid.equals(null)&&(!pwd.equals(null))&&((traderid.trim().length()!=0)&&pwd.trim().length()!=0))
	    		{
	    
	    try{
	    trader.setTraderId(Integer.parseInt(traderid));
	    trader.setPassword(pwd);
	    LoginManager loginmanager= new LoginManager();
	    tradername=loginmanager.LoginValidation(trader);
	    if((tradername!=null)&&(!tradername.equals("no Data")))
	    	request.getRequestDispatcher("success.html").forward(request, response);
	    else
	    {
	    out.println("<h3 class='headstyle'>Trader Id / Password Mismatch</h3>");
	    request.getRequestDispatcher("index.html").include(request,response);
	    }
	    
	}
catch(NumberFormatException n)
	    {
	out.println("<h3 class='headstyle'>Trader Id / Password Mismatch</h3>");
	request.getRequestDispatcher("index.html").include(request,response);
	    }
}
}
}