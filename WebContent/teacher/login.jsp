<jsp:include page="_header.jsp" />

<div class="container">
    <form id="signup" action="../TeacherLoginServlet" method="post">
        <div class="form_header">
            <h3>Log In</h3>
        </div>
        
        <div class="sep"></div>
        
        <div class="inputs">
   
            <input type="text" placeholder="E-mail" name="email" autofocus />
        
            <input type="password" placeholder="Password" name="password" />
            
            <input type="submit" value="LOG IN" />
                  
        </div>
    </form>
</div>

<jsp:include page="_footer.jsp" />