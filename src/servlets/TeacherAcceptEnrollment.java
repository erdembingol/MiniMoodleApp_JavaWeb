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
import models.Enrollment;
import models.Student;
import models.Teacher;

@WebServlet("/TeacherAcceptEnrollment")
public class TeacherAcceptEnrollment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String temp = request.getParameter("studentId");
		Integer studentId = (temp.equals("all") ? null : Integer.valueOf(temp));
		
		Integer teacherId = Integer.valueOf(request.getSession().getAttribute("teacherId").toString());
		Teacher teacher = (Teacher) JPA.readRecordWithID("models.Teacher", teacherId);

		Course course = teacher.getCourse();
		List<Student> students = course.getStudents();

		List<Object> enrollments = getEnrollments(course.getCourseId());
		for (int i = 0; i < enrollments.size(); i++) {
			Enrollment enrollment = (Enrollment) enrollments.get(i);
			
			int student_id;
			if (studentId == null) {
				student_id = enrollment.getStudentId();
			} else {
				if (enrollment.getStudentId() == studentId) {
					student_id = studentId;
				} else {
					continue;
				}
			}
			
			Student student = (Student) JPA.readRecordWithID("models.Student", student_id);
			students.add(student);
			
			JPA.deleteRecord(enrollment);
		}
		
		course.setStudents(students);
		JPA.updateRecord(course);
		
		request.getRequestDispatcher("TeacherEnrollmentListServlet").forward(request, response);
		
	}
	
	private List<Object> getEnrollments(int courseId) {
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("courseId", courseId);
		
		List<Object> enrollments = JPA.readRecordWithParameter("Enrollment", parameters);
		
		return enrollments;
		
	}

}
