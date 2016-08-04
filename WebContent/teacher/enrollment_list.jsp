<%@page import="models.Student"%>
<%@page import="models.Course"%>
<%@ page import="models.Enrollment"%>
<%@ page import="jpa.JPA"%>
<%@ page import="java.util.List"%>

<jsp:include page="_header.jsp" />

<%
	List enrollments = (List) session.getAttribute("enrollments");
	String courseNo = (String) session.getAttribute("courseNo");
	List students = (List) session.getAttribute("students");
%>

<b><p style="font-size: 20px; background-color: #008080; color: #f28220; padding: 5px;">Enrollment List </p></b>

<div style="margin-left: 20px; margin-right: 20px;">
	<ul>
		<% if (enrollments == null || enrollments.isEmpty()) { %>
			<p>Not Found Request</p>
		<% } else { %>
			<div class="new_c_p">
				<a href="../TeacherAcceptEnrollment?studentId=all">Accept All</a>
			</div>
			
			<% for (int i = 0; i < enrollments.size(); i++) { %>
				<%
					Enrollment enrollment = (Enrollment) enrollments.get(i);
					int studentId = enrollment.getStudentId();
					Student student = (Student) JPA.readRecordWithID("models.Student", studentId);
				%>
				<li>
					<% if (student != null) { %>
						<img src="<%=student.getProfileImage()%>" style="width: 50px; height: 60px;"> 
						<p style="margin-top: -40px; margin-left: 70px;"><b><%= student.getStudentNumber() %> - <%= student.getName() %></b></p>
						<p style="margin-top: 40px;">Requesting enrollment for <b><%=courseNo%></b></p>
						<div class="new_c_p">
							<a href="../TeacherAcceptEnrollment?studentId=<%=studentId%>">Accept</a>
						</div>
					<% } %>
				</li>
			<% } %>
		<% } %>
	</ul>
</div>
	
<jsp:include page="_footer.jsp" />