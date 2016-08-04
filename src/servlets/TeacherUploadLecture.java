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
import models.Course;
import models.Teacher;

@WebServlet("/TeacherUploadLecture")
public class TeacherUploadLecture extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* Get parameters, upload image and save file object */
		Map<String, String> parameters = getParametersAndUploadImage(request);
		models.File file = new models.File(parameters.get("name"), parameters.get("path"));
		JPA.createRecord(file);
		
		/* Get teacher */
		Integer teacherId = Integer.valueOf(request.getSession().getAttribute("teacherId").toString());
		Teacher teacher = (Teacher) JPA.readRecordWithID("models.Teacher", teacherId);
		
		/* Update course and teacher */
		Course course = teacher.getCourse();
		List<models.File> lectures = course.getLectures();
		lectures.add(file);
		course.setLectures(lectures);
		teacher.setCourse(course);
		JPA.updateRecord(teacher);
		JPA.updateRecord(course);
		
		/* Read course for teacher */
		teacher = (Teacher) JPA.readRecordWithID("models.Teacher", teacherId);
		request.getSession().setAttribute("my_course", teacher.getCourse());

		response.sendRedirect("teacher/home.jsp");
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
                    		System.out.println(item.getName());
                        String filename = item.getName();
                        filename = org.apache.commons.io.FilenameUtils.getName(item.getName());
                        	System.out.println(filename);
                        parameters.put("name", filename);
                        parameters.put("path", java.io.File.separator + "data" + java.io.File.separator + filename);
                        	System.out.println(java.io.File.separator + "data" + java.io.File.separator + filename);
                        item.write( new java.io.File(getServletContext().getRealPath("") + java.io.File.separator + "data" + java.io.File.separator + filename));
                    }
                }
            } catch (Exception ex) {
                System.out.println("File Upload Failed due to ");
                ex.printStackTrace();
                request.setAttribute("message", "File Upload Failed due to " + ex);
            }         
        }
		
		return parameters;
		
	}

}
