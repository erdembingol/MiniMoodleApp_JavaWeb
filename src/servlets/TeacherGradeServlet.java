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
import models.CourseNote;
import models.Project;
import models.Student;
import models.Teacher;

@WebServlet("/TeacherGradeServlet")
public class TeacherGradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer studentId = Integer.valueOf(request.getParameter("studentId"));
		Student student = (Student) JPA.readRecordWithID("models.Student", studentId);
		
		Integer teacherId = Integer.valueOf(request.getSession().getAttribute("teacherId").toString());
		Teacher teacher = (Teacher) JPA.readRecordWithID("models.Teacher", teacherId);
		
		System.out.println("Teacher Id : " + teacherId + ", Student Id : " + studentId);
		
		Course course = teacher.getCourse();
		List<Project> projects = course.getProjects();
		
		List<CourseNote> courseNotes = course.getCourseNotes();
		CourseNote courseNote = null;
		for (int i = 0; i < courseNotes.size(); i++) {
			if (courseNotes.get(i).getStudent().getUserId() == student.getUserId()) {
				courseNote = courseNotes.get(i);
				break;
			}
		}
		
		/***************************************************/
		
//		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("MiniMoodleApp");
//	    EntityManager entitymanager = emfactory.createEntityManager();
//	      
//	    String q = "Select cn.* from coursenote cn, user u, course c WHERE u.userid = " + studentId + " and u.userid = cn.STUDENT_USERID and cn.COURSE_COURSEID = c.courseid";
//		Query query = entitymanager.createNativeQuery(q, CourseNote.class);
//		List<CourseNote> courseNotes = query.getResultList();
//		CourseNote courseNote = null;
//		if(courseNotes != null && !courseNotes.isEmpty())
//			courseNote = courseNotes.get(0);
		
		/**************************************************/
		
		request.getSession().setAttribute("student", student);
		request.getSession().setAttribute("projects", projects);
		request.getSession().setAttribute("courseNote", courseNote);
		request.getSession().setAttribute("teacher", teacher);
		
		response.sendRedirect("teacher/grade.jsp");
		
	}

}
