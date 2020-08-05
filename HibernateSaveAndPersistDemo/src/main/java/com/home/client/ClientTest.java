package com.home.client;

import java.util.Date;

import org.hibernate.Session;

import com.home.entities.Employee;
import com.home.util.HibernateUtil;

public class ClientTest {

	public static void main(String[] args) {
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			session.beginTransaction();
			
			//persist return type is void
			session.persist(getEmployee1());
			
			//save return type is Serializable means return primary key
			Integer id=(Integer) session.save(getEmployee2());
			System.out.println("Employee created with Id:: "+id);
			
			session.saveOrUpdate(getEmployee3());
			
			session.getTransaction().commit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static Employee getEmployee1() {
		Employee employee=new Employee();
		employee.setEmployeeName("Paras");
		employee.setEmail("paras@gmail.com");
		employee.setDoj(new Date());
		employee.setSalary(16000.00);
		return employee;
	}
	
	private static Employee getEmployee2() {
		Employee employee=new Employee();
		employee.setEmployeeName("Prabhat Singh");
		employee.setEmail("prabhat.singh@gmail.com");
		employee.setDoj(new Date());
		employee.setSalary(17000.00);
		return employee;
	}
	
	private static Employee getEmployee3() {
		Employee employee=new Employee();
		employee.setEmployeeName("Shubham");
		employee.setEmail("shubham@gmail.com");
		employee.setDoj(new Date());
		employee.setSalary(18000.00);
		return employee;
	}
}
