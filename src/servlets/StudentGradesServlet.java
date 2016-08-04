package servlets;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jpa.JPA;
import models.Course;
import models.Student;

@WebServlet("/StudentGradesServlet")
public class StudentGradesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Integer studentId = Integer.valueOf(request.getSession().getAttribute("studentId").toString());
//		Student student = (Student) JPA.readRecordWithID("models.Student", studentId);
//		List<Course> courses = student.getCourses();

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("MiniMoodleApp");
	    EntityManager entitymanager = emfactory.createEntityManager();
	      
	    String q = "Select c.* from course c, user u, join_course_student jcs WHERE u.userid = " + studentId + " and u.userid = jcs.userId and jcs.courseId = c.courseid";
		Query query = entitymanager.createNativeQuery(q, Course.class);
		List<Course> courses = query.getResultList();
		
		request.getSession().setAttribute("courses", courses);	
		response.sendRedirect("student/grades.jsp");
		
	}

}
