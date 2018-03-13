

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SesionServlet")

public class SesionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String apellidos = request.getParameter("apellidos");
		
		request.setAttribute("nombre", nombre);
		request.setAttribute("apellidos", apellidos);
		request.setAttribute("email", email);
		String url = "/META-INF/Sesion.jsp";
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}
	
}
