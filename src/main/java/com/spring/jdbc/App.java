package com.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImpl;
import com.spring.jdbc.entities.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("my program started..");
//				it works but its not a recommended way to write code..
//				//spring jdbc -> application context.
//				ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
//				JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);
//				//insert query
//				String query = "insert into student(id,name,city) values(?,?,?)";
//				
//				//fire the query..
//				int result = template.update(query,451,"uttam kumar","kanpur");
//				
		
		
//		 Recommended way of coding in spring.
			
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
		StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
		
		Student student = new Student();
		student.setId(1666);
		student.setName("Rajesh");
		student.setCity("Pune");
		
		int result = studentDao.insert(student);
		System.out.println(result);
	}
}
