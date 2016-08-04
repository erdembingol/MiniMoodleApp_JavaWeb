<%@page import="models.Course"%>
<%@page import="models.CourseNote"%>
<%@page import="models.Project"%>
<%@page import="models.ProjectNote"%>
<%@ page import="java.util.List"%>
<%@ page import="java.lang.Integer" %>
<%@ page import="jpa.JPA" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>

<jsp:include page="_header.jsp"/>

<%! 
	Integer getProjectNoteFor(Integer studentId, Integer projectId) {	
		List projectNotes = (List)JPA.readRecord("models.ProjectNote");
		for (int i = 0; i < projectNotes.size(); i++) {
			ProjectNote projectNote = (ProjectNote) projectNotes.get(i);
			if(projectNote.getProject().getProjectId() == projectId && projectNote.getStudent().getUserId() == studentId)
				return projectNote.getNote();
		}
	
		return null;
	}
%>
<%!
	Integer getCourseNoteFor(Integer studentId, Integer courseId) {
		List courseNotes = (List)JPA.readRecord("models.CourseNote");
		for (int i = 0; i < courseNotes.size(); i++) {
			CourseNote courseNote = (CourseNote) courseNotes.get(i);
			if(courseNote.getCourse().getCourseId() == courseId && courseNote.getStudent().getUserId() == studentId)
				return courseNote.getNote();
		}
		
		return null;
	}
%>

<% List courses = (List) request.getSession().getAttribute("courses"); %>
<% Integer studentId = Integer.valueOf(request.getSession().getAttribute("studentId").toString()); %>

<b><p style="font-size: 20px; background-color: #008080; color: #f28220; padding: 5px;">Grades</p></b>
<% if(courses == null || courses.size() == 0) { %>
	<p>Not Found Grade</p>
<% } else { %>
	<% for (int i = 0; i < courses.size(); i++) { %>
		<% Course course = (Course)courses.get(i); %> 
		<table border="1">
		    <caption>Course and Project Grade for <i><strong><%= course.getName() %></strong></i></caption>
		    <tr>
		        <th>Project Name</th>
		        <th>Grade</th>
		        <th>Created Date</th>
		    </tr>
		    
		    <% List projects = course.getProjects(); %>
		    <% for (int j = 0; j < projects.size(); j++) { %>
		    	<% Project project = (Project)projects.get(j); %> 
		    	<tr>
	                <td><%= project.getName() %></td>
	                <td>
		                <% Integer projectNote = getProjectNoteFor(studentId, project.getProjectId()); %>
		                <% if(projectNote != null) { %>
			                <%= projectNote %>
			            <% } else { %>
			                <b>Not Graded</b>
			            <% } %>
					</td>
	                <td></td>
	            </tr>
		    <% } %>
		
		    <tr>
		        <td><b>Course Grade</b></td>
		        <td>
		        	<% Integer courseNote = getCourseNoteFor(studentId, course.getCourseId()); %>
		            <% if(courseNote != null) { %>
		                <%= courseNote %>
		            <% } else { %>
		                <b>Not Graded</b>
		            <% } %>
		        </td>
		        <td></td>
		    </tr>
		</table>
		
		<hr>
	<% } %>
<% } %>
<jsp:include page="_footer.jsp"/>