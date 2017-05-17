package pl.javastart.servlets;

import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ColorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {	response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html><head><title>My Servlet</title></head><body>");
        out.println("Serwlecik");
        out.println("<body></html>");

        out.close();
    }
}
