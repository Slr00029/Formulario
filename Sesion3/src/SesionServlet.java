

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SesionServlet")

public class SesionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String apellidos = request.getParameter("apellidos");
		
		//Añadimos nombre,apellidos email a request y a sesion
		request.setAttribute("nombre", nombre);
		request.setAttribute("apellidos", apellidos);
		request.setAttribute("email", email);
		
		HttpSession sesion = request.getSession(true);
		sesion.setAttribute("nombre", nombre);
		sesion.setAttribute("apellidos", apellidos);
		sesion.setAttribute("email", email);
		
		String url = "/META-INF/Sesion.jsp";
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		HttpSession sesion = request.getSession(true);
		sesion.setMaxInactiveInterval(4);
		
		
		if(sesion.getAttribute("nombre") == null && sesion.getAttribute("apellidos") == null && sesion.getAttribute("email") == null) {
			String url = "/Registro.html";
			getServletContext().getRequestDispatcher(url).forward(request, response);
		} else {
			String url = "/META-INF/Sesion.jsp";
			getServletContext().getRequestDispatcher(url).forward(request, response);
		}
		
}
}
