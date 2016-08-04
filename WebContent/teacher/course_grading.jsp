<jsp:include page="_header.jsp" />

<% String studentId = request.getParameter("studentId"); %>
<% String courseId = request.getParameter("courseId"); %>
<% String courseNoteId = request.getParameter("courseNoteId"); %>

<div class="container">
    <form id="signup" action="../TeacherCourseGrading?studentId=<%=studentId%>&courseId=<%=courseId%>&courseNoteId=<%=courseNoteId%>" method="post">
        <div class="form_header">
            <h3>Course Grade</h3>
        </div>
        
        <div class="sep"></div>
        
        <div class="inputs">
            
            <input type="text" placeholder="Enter course grade" name="grade" autofocus />                    
            
            <input type="submit" value="UPDATE" />
                  
        </div>
    </form>
</div>

<jsp:include page="_footer.jsp" />