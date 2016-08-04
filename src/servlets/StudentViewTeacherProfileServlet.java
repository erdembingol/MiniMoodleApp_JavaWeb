package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jpa.JPA;
import models.Teacher;

@WebServlet("/StudentViewTeacherProfileServlet")
public class StudentViewTeacherProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer teacherId = Integer.valueOf(request.getParameter("teacherId"));
		Teacher teacher = (Teacher) JPA.readRecordWithID("models.Teacher", teacherId);
		request.getSession().setAttribute("teacher", teacher);
		
		response.sendRedirect("student/teacher_profile.jsp");
		
	}

}
