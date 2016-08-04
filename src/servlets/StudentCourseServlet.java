package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jpa.JPA;
import models.Course;
import models.Student;

@WebServlet("/StudentCourseServlet")
public class StudentCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer courseId = Integer.valueOf(request.getParameter("courseId"));	
		Course course = (Course) JPA.readRecordWithID("models.Course", courseId);
		
		Integer studentId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("studentId")));	
		Student student = (Student) JPA.readRecordWithID("models.Student", studentId);
		
		request.getSession().setAttribute("course", course);
		request.getSession().setAttribute("student", student);
		
		response.sendRedirect("student/course.jsp");
		
	}

}
