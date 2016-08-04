package servlets;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

import jpa.JPA;
import models.Teacher;

@WebServlet("/TeacherSignupServlet")
@MultipartConfig
public class TeacherSignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* Get parameters and upload image for profile */
		Map<String, Object> parameters = getParametersAndUploadImage(request);
		
		/* Sign up */
		boolean isSaved = signup(parameters);
		
		if (!isSaved)
			response.sendRedirect("student/signup.jsp?message=This email is already exist!");
		else
			response.sendRedirect("teacher/login.jsp");
		
	}
	
	private Map<String, Object> getParametersAndUploadImage(HttpServletRequest request) {
		
		Map<String, Object> parameters = new HashMap<>();

		if(ServletFileUpload.isMultipartContent(request)){
            try {
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
              
                String folderPath = getServletContext().getRealPath("") + File.separator + "data";
                File f = new File(folderPath);
                if(!f.exists()) f.mkdir();
                
                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                        String fileName = new File(item.getName()).getName();
                        String filePath = folderPath + File.separator + fileName;
                        File file = new File(filePath);
                        item.write(file);

                        String newFilePath = folderPath + File.separator + f.list().length + "." + fileName.split("[.]")[1];
                        parameters.put("profileImage", "\\MiniMoodleApp\\data\\" + f.list().length + "." + fileName.split("[.]")[1]);
                        FileUtils.moveFile(FileUtils.getFile(filePath), FileUtils.getFile(newFilePath));
                    } else {
                    	String fieldName = item.getFieldName();
                        if (fieldName.equals("name")) {
                        	parameters.put("name", item.getString());
                        } else if (fieldName.equals("email")) {
                        	parameters.put("email", item.getString());
                        } else if (fieldName.equals("password")) {
                        	parameters.put("password", item.getString());
                        }
                    }
                }
            } catch (Exception ex) {
               request.setAttribute("message", "File Upload Failed due to " + ex);
            }         
        }
		
		return parameters;
		
	}
	
	private boolean signup(Map<String, Object> parameters) {
		
		Map<String, Object> parameter = new HashMap<>();
		parameter.put("email", parameters.get("email"));
		List<Object> list = (List<Object>) JPA.readRecordWithParameter("models.Teacher", parameter);
		if (!list.isEmpty()) {
			new File((String) parameters.get("profileImage")).delete();
			return false;
		}
		
		Teacher teacher = new Teacher();
		teacher.setName((String) parameters.get("name"));
		teacher.setEmail((String) parameters.get("email"));
		teacher.setPassword((String) parameters.get("password"));
		teacher.setProfileImage((String) parameters.get("profileImage"));
		
		JPA.createRecord(teacher); 
		
		return true;
		
	}

}
