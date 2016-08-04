<%@ page import="models.Student" %>

<jsp:include page="_header.jsp"/>

<% Student student = (Student) session.getAttribute("student"); %>

<b><p style="font-size: 20px; background-color: #008080; color: #f28220; padding: 5px;">My Profile </p></b>

<div class="container">
	<div class="featured">
		<img src="<%= student.getProfileImage() %>" style="width: 180px; height: 190px;"><br>
		<p>
		  	<br><b>Student Number : </b><%= student.getStudentNumber()%><br>
		</p>
		
		<p>
		  	<b>Name : </b><%= student.getName() %><br>
		</p>
		
		<p>
		  	<b>E-mail : </b><%= student.getEmail() %><br>
		</p>
		
		<p>
		  	<b>Password : </b><%= student.getPassword() %>
		</p>
	</div>
</div>

<jsp:include page="_footer.jsp"/>