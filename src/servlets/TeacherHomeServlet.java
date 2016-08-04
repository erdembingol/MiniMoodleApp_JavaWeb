package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jpa.JPA;
import models.Course;
import models.Teacher;

@WebServlet("/TeacherHomeServlet")
public class TeacherHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/* Get teacher */
		Integer teacherId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("teacherId")));
		Teacher teacher = (Teacher) JPA.readRecordWithID("models.Teacher", teacherId);
		
		/* Read teacher's course */
		Course my_course = teacher.getCourse(); 
		request.getSession().setAttribute("my_course", my_course);

		response.sendRedirect("teacher/home.jsp");
		
	}

}
