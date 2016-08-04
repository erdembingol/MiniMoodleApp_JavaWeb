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

@WebServlet("/StudentHomeServlet")
public class StudentHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/* Get student */
		Integer studentId = Integer.valueOf(request.getSession().getAttribute("studentId").toString());
//		Student student = (Student) JPA.readRecordWithID("models.Student", studentId);
//		
//		/* Read courses of student */
//		List<Course> my_courses = student.getCourses();
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("MiniMoodleApp");
	    EntityManager entitymanager = emfactory.createEntityManager();
	      
	    String q = "Select c.* from course c, user u, join_course_student jcs WHERE u.userid = " + studentId + " and u.userid = jcs.userId and jcs.courseId = c.courseid";
		Query query = entitymanager.createNativeQuery(q, Course.class);
		List<Course> my_courses = query.getResultList();
		
		request.getSession().setAttribute("my_courses", my_courses);
		response.sendRedirect("student/home.jsp");
	}
	
}
