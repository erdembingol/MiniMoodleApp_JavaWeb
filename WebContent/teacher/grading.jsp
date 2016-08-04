<%@page import="models.Student"%>
<%@ page import="java.util.List"%>

<jsp:include page="_header.jsp" />

<% List students = (List) session.getAttribute("students"); %>

<b><p style="font-size: 20px; background-color: #008080; color: #f28220; padding: 5px;">Students </p></b>

<div style="margin-left: 20px; margin-right: 20px;">
	<ul>
		<% if (students == null || students.size() == 0) { %>
			<p>Not Found Student</p>
		<% } else { %>
			<% for(int i = 0; i < students.size(); i++) { %>
				<li>
					<% Student student = (Student) students.get(i);  %>
					<img src="<%=student.getProfileImage()%>" style="width: 50px; height: 60px;"> <br>
					<p style="margin-top: -40px; margin-left: 70px; margin-bottom: 30px;"><b><%= student.getStudentNumber() %> - <%= student.getName() %></b></p>
					
					<div class="new_c_p">
						<a href="../TeacherGradeServlet?studentId=<%= student.getUserId() %>">Grade</a>
					</div>
				</li>
			<% } %>
		<% } %>
	</ul>
</div>

<jsp:include page="_footer.jsp" />