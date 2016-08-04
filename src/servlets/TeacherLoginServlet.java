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

import jpa.JPA;
import models.Teacher;

@WebServlet("/TeacherLoginServlet")
public class TeacherLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getSession().getAttribute("teacherName") == null) {
			/* Get parameters */
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			/* Log in */
			Teacher teacher = login(email, password);
			if (teacher == null) {
				response.sendRedirect("teacher/login.jsp");
			} else {
				/* Add session parameters */
				request.getSession().setAttribute("teacherId", teacher.getUserId());
				request.getSession().setAttribute("teacherName", teacher.getName());
				request.getSession().setAttribute("teacherProfileImage", teacher.getProfileImage());
			}
		}
		
		/* Read courses for student */
		if(request.getSession().getAttribute("teacherName") != null)
			request.getRequestDispatcher("TeacherHomeServlet").forward(request, response);
		
	}
	
	private Teacher login(String email, String password) {
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("email", email);
		parameters.put("password", password);
		
		List<Object> list = JPA.readRecordWithParameter("Teacher", parameters);
		for (Object object : list) {
			Teacher t = (Teacher) object;
			if (t.getEmail().equals(email) && t.getPassword().equals(password))
				return t;
		}
		
		return null;
		
	}

}
