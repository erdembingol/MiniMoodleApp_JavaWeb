<jsp:include page="_header.jsp" />

<div class="container">
    <form id="signup" action="../TeacherCreateNewProject" method="post">
        <div class="form_header">
            <h3>New Project</h3>
        </div>
        
        <div class="sep"></div>
        
        <div class="inputs">
            
            <input type="text" placeholder="Name" name="name" autofocus />                   
            
            <textarea rows="5" cols="30" maxlength="150" placeholder="Definition" name="definition"></textarea>   
            
            <input type="submit" value="CREATE" />
                  
        </div>
    </form>
</div>

<jsp:include page="_footer.jsp"/>