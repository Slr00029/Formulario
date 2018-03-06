import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Sesion")



public class Acceso extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
String user = request.getParameter("user");
String clave = request.getParameter("password");

if( user.equals("admin") && clave.equals("1234")) {
	
}
else {
	String url = "/Registro.html";
	getServletContext().getRequestDispatcher(url).forward(request, response);
}
}
}