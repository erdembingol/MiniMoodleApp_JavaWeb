package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jpa.JPA;
import models.Project;
import models.ProjectNote;
import models.Student;

@WebServlet("/TeacherProjectGrading")
public class TeacherProjectGrading extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("projectNoteId");
		System.out.println("Project Note Id : " + id);
		if(id != null && !id.equals("null")) {
			Integer projectNoteId = Integer.valueOf(id);
			ProjectNote projectNote = (ProjectNote) JPA.readRecordWithID("models.ProjectNote", projectNoteId);
			
			Integer grade = Integer.valueOf(request.getParameter("grade"));
			projectNote.setNote(grade);
			
			JPA.updateRecord(projectNote);
		} else {
			Integer studentId = Integer.valueOf(request.getParameter("studentId"));
			Student student = (Student) JPA.readRecordWithID("models.Student", studentId);
			
			Integer projectId = Integer.valueOf(request.getParameter("projectId"));
			Project project = (Project) JPA.readRecordWithID("models.Project", projectId);
			
			Integer grade = Integer.valueOf(request.getParameter("grade"));
			
			ProjectNote projectNote = new ProjectNote();
			projectNote.setNote(grade);
			projectNote.setProject(project);
			projectNote.setStudent(student);
			
			List<ProjectNote> projectNotes = project.getProjectNotes();//
			projectNotes.add(projectNote);//
			project.setProjectNotes(projectNotes);//
			
			JPA.createRecord(projectNote);
			JPA.updateRecord(project);//
		}
		
		response.sendRedirect("TeacherGradeServlet?studentId=" + request.getParameter("studentId"));
		
	}

}
