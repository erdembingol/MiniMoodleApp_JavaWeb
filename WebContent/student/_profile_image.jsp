<% Integer user = (Integer) request.getSession().getAttribute("studentId"); %>
<% if (user != null) { %>
	<div class="profile_image">
		<img src="<%=(String) request.getSession().getAttribute("studentProfileImage")%>" style="width: 50px; height: 60px;">
		<p style="font-size: small;">
			<b><%= (String) request.getSession().getAttribute("studentName") %></b>
		</p>
	</div>
<% } %>