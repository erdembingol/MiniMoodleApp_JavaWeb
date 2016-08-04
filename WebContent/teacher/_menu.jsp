<% String user = (String) request.getSession().getAttribute("teacherName"); %>
<% if (user == null) { %>
	<ul>
		<li><a href="login.jsp">Log In</a></li>
		<li><a href="signup.jsp">Sign Up</a></li>
	</ul>
<% } else { %>
	<ul>
		<li><a href="../TeacherHomeServlet">Home</a></li>
		<li><a href="../TeacherMyProfileServlet">My Profile</a></li>
		<li><a href="editprofile.jsp">Edit Profile</a></li>
		<li><a href="../TeacherEnrollmentListServlet">Enrollment List</a></li>
		<li><a href="../TeacherGradingServlet">Grading</a></li>
		<li><a href="../TeacherLogoutServlet">Logout</a></li>
	</ul>
<% } %>