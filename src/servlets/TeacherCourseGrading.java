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
import models.CourseNote;
import models.ProjectNote;
import models.Student;

@WebServlet("/TeacherCourseGrading")
public class TeacherCourseGrading extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("courseNoteId");
		System.out.println("Course Note Id : " + id);
		if(id != null  && !id.equals("null")) {
			Integer courseNoteId = Integer.valueOf(id);
			CourseNote courseNote = (CourseNote) JPA.readRecordWithID("models.CourseNote", courseNoteId);
			
			Integer grade = Integer.valueOf(request.getParameter("grade"));
			courseNote.setNote(grade);
			
			JPA.updateRecord(courseNote);
		} else {
			Integer studentId = Integer.valueOf(request.getParameter("studentId"));
			Student student = (Student) JPA.readRecordWithID("models.Student", studentId);
			
			Integer courseId = Integer.valueOf(request.getParameter("courseId"));
			Course course = (Course) JPA.readRecordWithID("models.Course", courseId);
			
			System.out.println("Course Id : " + courseId + ", Student Id : " + studentId);
			
			Integer grade = Integer.valueOf(request.getParameter("grade"));
			
			CourseNote courseNote = new CourseNote();
			courseNote.setNote(grade);
			courseNote.setCourse(course);
			courseNote.setStudent(student);
			
			List<CourseNote> courseNotes = course.getCourseNotes();//
			courseNotes.add(courseNote);//
			course.setCourseNotes(courseNotes);//
			
			JPA.createRecord(courseNote);
			JPA.updateRecord(course);//
		}
		
		response.sendRedirect("TeacherGradeServlet?studentId=" + request.getParameter("studentId"));
		
	}

}
