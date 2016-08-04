<%@page import="models.Student"%>
<%@page import="models.Project"%>
<%@page import="models.ProjectNote"%>
<%@page import="models.CourseNote"%>
<%@page import="models.File"%>
<%@page import="models.FileUpload"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@page import="models.Teacher"%>

<jsp:include page="_header.jsp" />

<%! 
	List<File> getUploadedFilesFor (Project project, Student student) {
		
		List<File> uploadedFilesForStudent = new ArrayList<File>(); 
	
		List<FileUpload> uploadedFiles = project.getUploadedFiles();
		for (int i = 0; i < uploadedFiles.size(); i++) {
			if (uploadedFiles.get(i).getStudent().getUserId() == student.getUserId())
				uploadedFilesForStudent.add(uploadedFiles.get(i).getFile());
		}
		
		return uploadedFilesForStudent;
	
	}
%>

<%!
	ProjectNote getProjectNoteFor (Project project, Student student) {
		
		List<ProjectNote> projectNotes = project.getProjectNotes();

		for (int i = 0; i < projectNotes.size(); i++) {
			if (projectNotes.get(i).getStudent().getUserId() == student.getUserId())
				return projectNotes.get(i);
		}
		
		return null;
	
	}
%>

<% Student student = (Student) session.getAttribute("student"); %>
<% List projects = (List) session.getAttribute("projects"); %>
<% CourseNote courseNote = (CourseNote) session.getAttribute("courseNote"); %>
<% Teacher teacher = (Teacher) session.getAttribute("teacher"); %>

<div>
	<ul>
		<li>
			<div>
				<img src="<%=student.getProfileImage()%>" style="width: 80px; height: 100px;"> <br>
				<br>
				<b><%= student.getStudentNumber() %> - <%= student.getName() %></b>
				<p>
					<%= student.getEmail() %>
				</p>
			</div>
		</li>

		<b><p style="font-size: 20px; background-color: #008080; color: #f28220; padding: 5px;">Projects</p></b>
		<% for (int i = 0; i < projects.size(); i++) { %>
			<li>
				<% Project project = (Project) projects.get(i); %>
				<div>
					<h3>
						<b><i><%= project.getName() %></i></b><br>
					</h3>
					<p>
						<%= project.getDefinition() %>
					</p>
					<% List<File> files = getUploadedFilesFor(project, student); %>
					<p>
					<% if ( !files.isEmpty()) { %>
						<% for (int j = 0; j < files.size(); j++) { %>
							&nbsp;&nbsp;&nbsp;=>&nbsp;&nbsp;
							<a href="../TeacherDownloadFileServlet?path=<%=files.get(j).getPath()%>&back=TeacherGradeServlet" target="_blank"><%=files.get(j).getName()%></a><br>
						<% } %>
					<% } else { %>
						&nbsp;&nbsp;&nbsp;=>&nbsp;&nbsp;File not uploaded<br>
					<% } %>
					<% ProjectNote projectNote = getProjectNoteFor(project, student); %>
					&nbsp;&nbsp;&nbsp;=>&nbsp;&nbsp;<b>Grade:</b>
					<% if (projectNote == null) { %>
						Not Graded<br>
						<a href="project_grading.jsp?studentId=<%=student.getUserId() %>&projectId=<%=project.getProjectId() %>">Add Project Note</a>
					<% } else { %>
						<%=projectNote.getNote()%><br>
						<a href="project_grading.jsp?studentId=<%=student.getUserId() %>&projectId=<%=project.getProjectId() %>&projectNoteId=<%=projectNote.getProjectNoteId()%>">Edit Project Note</a>
					<% } %>
					</p>
				</div>
			</li>
		<% } %>
		<li>
			<div>
				<p>
				<b>Course Note :</b>
				<% if (courseNote == null) { %>
					Not Graded<br>
					<a href="course_grading.jsp?studentId=<%=student.getUserId() %>&courseId=<%=teacher.getCourse().getCourseId() %>">Add Course Note</a>
				<% } else { %>
					<%=courseNote.getNote()%><br>
					<a href="course_grading.jsp?studentId=<%=student.getUserId() %>&courseId=<%=teacher.getCourse().getCourseId() %>&courseNoteId=<%=courseNote.getCourseNoteId()%>">Edit Course Note</a>
				<% } %>
				</p>
			</div>
		</li>
	</ul>
</div>

<jsp:include page="_footer.jsp" />