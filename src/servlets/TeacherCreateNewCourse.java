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

@WebServlet("/TeacherCreateNewCourse")
public class TeacherCreateNewCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/* Create new course and save it */
		String no = request.getParameter("no");
		String name = request.getParameter("name");
		String definition = request.getParameter("definition");
		Course course = new Course(definition, name, no);
		
		Integer teacherId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("teacherId")));
		Teacher teacher = (Teacher) JPA.readRecordWithID("models.Teacher", teacherId);
		
		/* Update the course information of teacher and save it */
		teacher.setCourse(course);
		course.setTeacher(teacher);
		JPA.createRecord(course);	
		JPA.updateRecord(teacher);
		
		/* Read course for teacher */
		request.getSession().setAttribute("my_course", course);

		response.sendRedirect("teacher/home.jsp");
		
	}

}
