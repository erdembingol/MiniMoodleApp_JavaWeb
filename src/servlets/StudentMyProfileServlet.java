package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jpa.JPA;
import models.Student;

@WebServlet("/StudentMyProfileServlet")
public class StudentMyProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		/* Get student */
		Integer studentId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("studentId")));
		Student student = (Student) JPA.readRecordWithID("models.Student", studentId);
		
		request.getSession().setAttribute("student", student);
		
		response.sendRedirect("student/myprofile.jsp");
		
	}

}
