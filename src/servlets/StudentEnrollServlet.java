package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jpa.JPA;
import models.Enrollment;

@WebServlet("/StudentEnrollServlet")
public class StudentEnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Integer courseId = Integer.valueOf(request.getParameter("courseId"));
		Integer studentId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("studentId")));
	
		Enrollment enrollment = new Enrollment(studentId, courseId);
		JPA.createRecord(enrollment);
		
		response.sendRedirect("StudentAllCoursesServlet");
		
	}
	
}
