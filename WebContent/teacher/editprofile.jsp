<jsp:include page="_header.jsp" />

<div class="container">
	<form id="signup" action="../TeacherEditProfileServlet" method="post" enctype="multipart/form-data">	    
	    <div class="form_header">
	        <h3>Edit Profile</h3>
	    </div>
	    
	    <div class="sep"></div>
	        
        <div class="inputs">
            
            <input type="text" placeholder="Name" name="name" autofocus>
        
            <input type="password" placeholder="Password" name="password" />
            
            <input type="text" placeholder="E-mail" name="email">
            
            <input type="file" accept='image/*' placeholder="Profile Image" name="profileImage">
            
            <input type="submit" value="UPDATE" />
                  
        </div>
	</form>
</div>

<jsp:include page="_footer.jsp" />