<% Integer user = (Integer) request.getSession().getAttribute("teacherId"); %>
<% if (user != null) { %>
	<div class="profile_image">
		<img src="<%=(String) request.getSession().getAttribute("teacherProfileImage")%>" style="width: 50px; height: 60px;">
		<p style="font-size: small;">
			<b><%= (String) request.getSession().getAttribute("teacherName") %></b>
		</p>
	</div>
<% } %>