<%@ page import="java.util.List"%>
<%@ page import="models.Course"%>

<jsp:include page="_header.jsp"/>

<% List courses = (List) session.getAttribute("courses"); %>

<b><p style="font-size: 20px; background-color: #008080; color: #f28220; padding: 5px;">All Courses </p></b>

<div style="margin-left: 20px; margin-right: 20px;">
	<ul>
		<% if (courses.isEmpty()) { %>
			<p>Not Found Course</p>
		<% } else { %>
			<% for (int i = 0; i < courses.size(); i++) { %>
				<li>
					<% Course course = (Course) courses.get(i); %>
					<img src="<%=course.getTeacher().getProfileImage()%>" style="width: 50px; height: 60px;">
					
					<b><p style="font-size: 20px; margin-top: -40px; margin-left: 70px;"><%= course.getNo() %> - <%= course.getName() %></p></b>
					
					<p style="margin-top: 30px;"><%=course.getDefinition()%></p>
					
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;=> Course Director : <b><%=course.getTeacher().getName()%></b></p>
					
					<div class="new_c_p">
						<a href="../StudentEnrollServlet?courseId=<%=course.getCourseId()%>">Enroll</a>
					</div>
				</li>
			<% } %>
		<% } %>
	</ul>
</div>

<jsp:include page="_footer.jsp" />