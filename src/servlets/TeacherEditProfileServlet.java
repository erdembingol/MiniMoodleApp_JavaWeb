package servlets;

import java.io.File;
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
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

import jpa.JPA;
import models.Teacher;

@WebServlet("/TeacherEditProfileServlet")
public class TeacherEditProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/* Get parameters and upload image */
		Map<String, String> parameters = getParametersAndUploadImage(request);
		
		/* Check if parameters is empty or not */
		boolean isEmpty = false;
		for (Map.Entry<String, String> entry : parameters.entrySet()) {
			if (entry.getValue() == null) {
				isEmpty = true;
				break;
			}
		}
		
		if (isEmpty) {
			response.sendRedirect("teacher/editprofile.jsp");
		} else {
			/* Get teacher */
			Integer teacherId = Integer.valueOf(request.getSession().getAttribute("teacherId").toString());
			Teacher teacher = (Teacher) JPA.readRecordWithID("models.Teacher", teacherId);
			
			/* Delete previous profile image from folder */
			new File(teacher.getProfileImage()).delete();
			
			/* Update teacher parameters */
			teacher.setName(parameters.get("name"));
			teacher.setEmail(parameters.get("email"));
			teacher.setPassword(parameters.get("password"));
			teacher.setProfileImage(parameters.get("profileImage"));
			
			/* Update teacher */
			JPA.updateRecord(teacher); 
			
			/* Add session parameters */
			request.getSession().setAttribute("teacherId", teacher.getUserId());
			request.getSession().setAttribute("teacherName", teacher.getName());
			request.getSession().setAttribute("teacherProfileImage", teacher.getProfileImage());
	
			response.sendRedirect("teacher/myprofile.jsp");
		}
		
	}

	private Map<String, String> getParametersAndUploadImage(HttpServletRequest request) {
		
		Map<String, String> parameters = new HashMap<>();

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
                    	String fieldname = item.getFieldName();
                        if (fieldname.equals("name")) {
                        	parameters.put("name", item.getString());
                        } else if (fieldname.equals("email")) {
                        	parameters.put("email", item.getString());
                        } else if (fieldname.equals("password")) {
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

}
