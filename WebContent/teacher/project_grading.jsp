<jsp:include page="_header.jsp" />

<% String studentId = request.getParameter("studentId"); %>
<% String projectId = request.getParameter("projectId"); %>
<% String projectNoteId = request.getParameter("projectNoteId"); %>

<div class="container">
    <form id="signup" action="../TeacherProjectGrading?studentId=<%=studentId%>&projectId=<%=projectId%>&projectNoteId=<%=projectNoteId%>" method="post">
        <div class="form_header">
            <h3>Project Grade</h3>
        </div>
        
        <div class="sep"></div>
        
        <div class="inputs">
            
            <input type="text" placeholder="Enter project grade" name="grade" autofocus />                    
            
            <input type="submit" value="UPDATE" />
                  
        </div>
    </form>
</div>

<jsp:include page="_footer.jsp" />