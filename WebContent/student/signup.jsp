<jsp:include page="_header.jsp"/>

<div class="container">
    <form id="signup" action="../StudentSignupServlet" method="post" enctype="multipart/form-data">
        <div class="form_header">
            <h3>Sign Up</h3>
        </div>
        
        <div class="sep"></div>
        
        <div class="inputs">
   
            <input type="text" placeholder="Student Number" name="studentNumber" autofocus />
            
            <input type="text" placeholder="Name" name="name">
        
            <input type="password" placeholder="Password" name="password" />
            
            <input type="text" placeholder="E-mail" name="email">
            
            <input type="file" accept='image/*' placeholder="Profile Image" name="profileImage">
            
            <input type="submit" value="SIGN UP" />
                  
        </div>
    </form>
</div>

<jsp:include page="_footer.jsp" />