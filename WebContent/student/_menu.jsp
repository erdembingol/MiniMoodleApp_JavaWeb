<% String user = (String) request.getSession().getAttribute("studentName"); %>
<% if (user == null) { %>
	<ul>
		<li><a href="login.jsp">Log In</a></li>
		<li><a href="signup.jsp">Sign Up</a></li>
	</ul>
<% } else { %>
	<ul>
		<li><a href="../StudentHomeServlet">Home</a></li>
		<li><a href="../StudentMyProfileServlet">My Profile</a></li>
		<li><a href="editprofile.jsp">Edit Profile</a></li>
		<li><a href="../StudentAllCoursesServlet">All Courses</a></li>
		<li><a href="../StudentGradesServlet">Grades</a></li>
		<li><a href="../StudentLogoutServlet">Logout</a></li>
	</ul>
<% } %>