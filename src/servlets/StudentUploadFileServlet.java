package servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import jpa.JPA;
import models.FileUpload;
import models.Project;
import models.Student;

@WebServlet("/StudentUploadFileServlet")
public class StudentUploadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Map<String, String> parameters = getParametersAndUploadImage(request);
		models.File file = new models.File(parameters.get("name"), parameters.get("path"));
		JPA.createRecord(file);
		
		Integer studentId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("studentId")));
		Student student = (Student) JPA.readRecordWithID("models.Student", studentId);
		
		Integer projectId = Integer.valueOf(request.getParameter("projectId"));
		Project project = (Project) JPA.readRecordWithID("models.Project", projectId);
		List<FileUpload> uploadedFiles = project.getUploadedFiles();
		FileUpload fileUpload = new FileUpload(student, project, file);
		uploadedFiles.add(fileUpload);
		project.setUploadedFiles(uploadedFiles);
		JPA.updateRecord(project);
		
		response.sendRedirect("StudentCourseServlet?courseId=" + request.getParameter("courseId"));
		
	}
	
	private Map<String, String> getParametersAndUploadImage(HttpServletRequest request) throws IOException {
		
		Map<String, String> parameters = new HashMap<>();
		
		request.setCharacterEncoding("utf-8");

		if(ServletFileUpload.isMultipartContent(request)){
            try {
            	FileItemFactory factory = new DiskFileItemFactory();
            	ServletFileUpload upload = new ServletFileUpload(factory);
            	upload.setHeaderEncoding("UTF-8");
                List<FileItem> multiparts = upload.parseRequest(request);
              
                java.io.File f = new java.io.File(getServletContext().getRealPath("") + java.io.File.separator + "data");
                if(!f.exists()) f.mkdir();
                
                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                        String filename = item.getName();
                        parameters.put("name", filename);
                        parameters.put("path", java.io.File.separator + "data" + java.io.File.separator + filename);
                        item.write( new java.io.File(getServletContext().getRealPath("") + java.io.File.separator + "data" + java.io.File.separator + filename));
                    }
                }
            } catch (Exception ex) {
               request.setAttribute("message", "File Upload Failed due to " + ex);
            }         
        }
		
		return parameters;
		
	}

}
