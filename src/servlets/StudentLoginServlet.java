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
import models.Student;

@WebServlet("/StudentLoginServlet")
public class StudentLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getSession().getAttribute("studentName") == null) {
			/* Get parameters */
			String studentNumber = request.getParameter("studentNumber");
			String password = request.getParameter("password");
			
			/* Log in */
			Student student = login(studentNumber, password);
			if (student == null) {
				response.sendRedirect("student/login.jsp");
			} else {
				/* Add session parameters */
				request.getSession().setAttribute("studentId", student.getUserId());
				request.getSession().setAttribute("studentName", student.getName());
				request.getSession().setAttribute("studentProfileImage", student.getProfileImage());
			}
		}
		
		if(request.getSession().getAttribute("studentName") != null)
			request.getRequestDispatcher("StudentHomeServlet").forward(request, response);
		
	}
	
	private Student login(String studentNumber, String password) {

		Map<String, Object> parameters = new HashMap<>();
		parameters.put("studentNumber", studentNumber);
		parameters.put("password", password);
		
		List<Object> list = JPA.readRecordWithParameter("Student", parameters);
		for (Object object : list) {
			if (object instanceof Student) {
				Student s = (Student) object;
				if (s.getStudentNumber().equals(studentNumber) && s.getPassword().equals(password))
					return s;
			}
		}
		
		return null;
	}

}
