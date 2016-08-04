<%@ page import="models.Course" %>
<%@ page import="java.util.List" %>

<jsp:include page="_header.jsp"/>

<% List my_courses = (List) session.getAttribute("my_courses"); %>

<b><p style="font-size: 20px; background-color: #008080; color: #f28220; padding: 5px;">My Courses </p></b>

<div style="margin-left: 20px; margin-right: 20px;">
	<ul>
		<% if (my_courses.isEmpty()) { %>
			<p>Not Found Course</p>
		<% } else { %>
			<% for (int i = 0; i < my_courses.size(); i++) { %>
				<li>
					<% Course course = (Course) my_courses.get(i); %>
					<div>
						<div class="course">
							<b><i><a style="font-size: 20px;" href="../StudentCourseServlet?courseId=<%=course.getCourseId()%>"><%= course.getNo() %> - <%= course.getName() %></a></i></b>
		                </div></br></br></br>
		                <p>
		                    <%= course.getDefinition() %>
		                </p>
		                <br>
		                <div class="new_c_p">
		                	<p>Course Director : <a href="../StudentViewTeacherProfileServlet?teacherId=<%=course.getTeacher().getUserId()%>"><%= course.getTeacher().getName() %></a></p>
						</div>
					</div>
				</li>
			<% } %>
		<% } %>
	</ul>
</div>

<jsp:include page="_footer.jsp"/>