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
import models.Project;
import models.Teacher;

@WebServlet("/TeacherCreateNewProject")
public class TeacherCreateNewProject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* Create new project */
		String name = request.getParameter("name");
		String definition = request.getParameter("definition");
		Project project = new Project(definition, name);
		JPA.createRecord(project);
		
		/* Get teacher */
		Integer teacherId = Integer.valueOf(request.getSession().getAttribute("teacherId").toString());
		Teacher teacher = (Teacher) JPA.readRecordWithID("models.Teacher", teacherId);
	
		/* Associate the course, teacher and project */
		Course course = teacher.getCourse();
		List<Project> projects = course.getProjects();
		projects.add(project);
		project.setCourse(course);
		course.setProjects(projects);
		teacher.setCourse(course);
		course.setTeacher(teacher);

		/* Update course and teacher */
		JPA.updateRecord(course);
		JPA.updateRecord(teacher);
		
		/* Read course for teacher */
		teacher = (Teacher) JPA.readRecordWithID("models.Teacher", teacherId);
		request.getSession().setAttribute("my_course", teacher.getCourse());

		response.sendRedirect("teacher/home.jsp");
		
	}

}
