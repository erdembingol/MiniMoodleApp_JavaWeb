package servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jpa.JPA;
import models.Course;
import models.Teacher;

@WebServlet("/TeacherEnrollmentListServlet")
public class TeacherEnrollmentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Integer teacherId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("teacherId")));
		Teacher teacher = (Teacher) JPA.readRecordWithID("models.Teacher", teacherId);
		
		Course course = teacher.getCourse();
		
		List<Object> students = JPA.readRecord("Student");
		
		if (course != null) {
			List<Object> enrollments = getEnrollments(course.getCourseId());
			request.getSession().setAttribute("enrollments", enrollments);
			request.getSession().setAttribute("courseNo", course.getNo());
			request.getSession().setAttribute("students", students);
		}
		
		response.sendRedirect("teacher/enrollment_list.jsp");
		
	}

	private List<Object> getEnrollments(int courseId) {
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("courseId", courseId);
		
		List<Object> enrollments = JPA.readRecordWithParameter("Enrollment", parameters);
		
		return enrollments;
		
	}
	
}
