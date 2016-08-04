<%@ page import="models.Teacher" %>

<jsp:include page="_header.jsp"/>

<% Teacher teacher = (Teacher) session.getAttribute("teacher"); %>

<b><p style="font-size: 20px; background-color: #008080; color: #f28220; padding: 5px;">Course Director Profile</p></b>

<div class="container">
	<div class="featured">
		<img src="<%=teacher.getProfileImage()%>" style="width: 180px; height: 190px;"><br>
		<p>
		  	<br><b>Name : </b><%= teacher.getName() %><br>
		</p>
		
		<p>
		  	<b>E-mail : </b><%= teacher.getEmail() %><br>
		</p>
	</div>
</div>

<jsp:include page="_footer.jsp" />