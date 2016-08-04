<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="models.Course"%>
<%@ page import="models.File"%>
<%@ page import="models.Student"%>
<%@ page import="models.FileUpload"%>
<%@ page import="models.Project"%>
<%@ page import="java.util.List"%>
<%@ page import="java.nio.charset.StandardCharsets"%>

<jsp:include page="_header.jsp"/>

<% Course course = (Course) session.getAttribute("course"); %>
<% Student student = (Student) session.getAttribute("student"); %>

<div style="margin-left: 20px; margin-right: 20px;">
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
					<a href="../StudentDownloadFileServlet?path=<%=lecture.getPath()%>" target="_blank"><%=lecture.getName()%></a></br></p>
				<% } %>
			</li>
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
							<a href="../StudentDownloadFileServlet?path=<%=file.getPath()%>" target="_blank"><%=file.getName()%></a></p><br>
						<% } %>
						
						<div class="fileUpload">
							<% List<FileUpload> uploadedFiles = project.getUploadedFiles(); %>
							<p><b>Uploaded Files</b> <br></p>
			                <% for (FileUpload uploadedFile : uploadedFiles) { %>
			                	<% if (uploadedFile.getStudent().getUserId() == student.getUserId()) { %>
			                		<p>
			                		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=>&nbsp;&nbsp;
			                		<a href="../StudentDownloadFileServlet?path=<%=uploadedFile.getFile().getPath()%>" target="_blank"><%=uploadedFile.getFile().getName()%></a>
			                		</p>
			                	<% } %>
			                <% } %>
							<form action="../StudentUploadFileServlet?projectId=<%=project.getProjectId()%>&courseId=<%=course.getCourseId()%>" method="post" enctype="multipart/form-data" accept-charset="UTF-8">
								<p>Select File: <input type="file" name="projectFile">								
								<input type="submit" value="UPLOAD"></p>
							</form>
						</div>
					</div>
				</li>
			<% } %>
		</ul>
	</div>
</div>

<jsp:include page="_footer.jsp"/>