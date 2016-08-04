package jpa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import models.Course;
import models.Student;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MiniMoodleApp");
		EntityManager em = emf.createEntityManager();
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("studentNumber", "000000");
		parameters.put("password", "000");
		List<Object> list = JPA.readRecordWithParameter("Student", parameters);

		System.out.println(list.size());
		
		for (Object object : list) {
			Student s = (Student) object;
			List<Course> courses = s.getCourses();
			System.out.println(s.getStudentNumber());
			for(Course course : courses) {
				System.out.println(course.getName());
			}
		}

	}

}
