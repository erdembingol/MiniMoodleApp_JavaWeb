package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TeacherLogoutServlet")
public class TeacherLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/* Delete session parameters */
		request.getSession().setAttribute("teacherId", null);
		request.getSession().setAttribute("teacherName", null);
		request.getSession().setAttribute("teacherProfileImage", null);
		
		response.sendRedirect("teacher/login.jsp");
		
	}

}
