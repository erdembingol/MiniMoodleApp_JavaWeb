package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jpa.JPA;
import models.Course;
import models.Student;
import models.Teacher;

@WebServlet("/TeacherGradingServlet")
public class TeacherGradingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Integer teacherId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("teacherId")));
		Teacher teacher = (Teacher) JPA.readRecordWithID("models.Teacher", teacherId);
		
		Course course = teacher.getCourse();
		
		if (course != null) {
			List<Student> students = course.getStudents(); 
			request.getSession().setAttribute("students", students);
		}
		
		response.sendRedirect("teacher/grading.jsp");
		
	}

}
