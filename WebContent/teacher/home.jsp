<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="models.Course"%>
<%@ page import="models.File"%>
<%@ page import="models.Project"%>
<%@ page import="java.util.List"%>

<jsp:include page="_header.jsp" />

<% Course course = (Course) session.getAttribute("my_course"); %>

<div style="margin-left: 20px; margin-right: 20px;">
	<% if (course != null) { %>
		<b><p style="font-size: 25px;"><%= course.getNo() %> - <%= course.getName() %></p></b>
		<p>
			<%= course.getDefinition() %>
		</p>
		
		<div class="seperator"></div>
	
		<b><p style="font-size: 20px; background-color: #008080; color: #f28220; padding: 5px;">Lectures</p></b>
		<div style="margin-left: 20px; margin-right: 20px;">
			<ul>
				<li>
					<% List<File> lectures = course.getLectures(); %>
					<% for (File lecture : lectures) { %>
						<p>&nbsp;&nbsp;&nbsp;=>&nbsp;&nbsp;
						<a href="../TeacherDownloadFileServlet?path=<%=lecture.getPath()%>&back=TeacherHomeServlet" target="_blank"><%=lecture.getName()%></a></br></p>
					<% } %>
				</li>
				<div class="fileUpload">
					<form action="../TeacherUploadLecture" method="post" enctype="multipart/form-data" accept-charset="UTF-8">
						<p>Select Lecture: <input type="file" name="lecture">
						<input type="submit" value="UPLOAD"></p>
					</form>
				</div>
			</ul>
		</div>
		
		<div class="seperator"></div>
	
		<b><p style="font-size: 20px; background-color: #008080; color: #f28220; padding: 5px;">Projects</p></b>
		<div style="margin-left: 20px; margin-right: 20px;">
			<ul>
				<% List<Project> projects = course.getProjects(); %>
				<% for (Project project : projects) { %>
					<li>
						<div>
							<h3>
								<b><i><%= project.getName() %></i></b>
							</h3>
							<p>
								<%= project.getDefinition() %>
							</p>
			
							<% List<File> files = project.getFiles(); %>
							<% for (File file : files) { %>
								<p>&nbsp;&nbsp;&nbsp;=> &nbsp;&nbsp;
								<a href="../TeacherDownloadFileServlet?path=<%=file.getPath()%>" target="_blank"><%=file.getName()%></a></p><br>
							<% } %>
							
							<div class="fileUpload">
								<form action="../TeacherUploadProjectFile?projectId=<%=project.getProjectId()%>&back=TeacherHomeServlet" method="post" enctype="multipart/form-data" accept-charset="UTF-8">
									<p>Select Project File: <input type="file" name="projectFile">						
									<input type="submit" value="UPLOAD"></p>
								</form>
							</div>
						</div>
					</li>
				<% } %>
				<div class="new_c_p">
					<a href="new_project.jsp">Create new project</a>
				</div>
			</ul>
		</div>
	<% } else { %>
		<div class="container">
			<div class="new_c_p">
				<a href="new_course.jsp">Create new course</a>
			</div>
		</div>
	<% } %>
</div>

<jsp:include page="_footer.jsp" />