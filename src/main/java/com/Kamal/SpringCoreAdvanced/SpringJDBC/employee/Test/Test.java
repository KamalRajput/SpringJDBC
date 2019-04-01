package com.Kamal.SpringCoreAdvanced.SpringJDBC.employee.Test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Kamal.SpringCoreAdvanced.SpringJDBC.employee.dao.EmployeeDao;
import com.Kamal.SpringCoreAdvanced.SpringJDBC.employee.dto.Employee;

public class Test {

	
	/*Here we are injecting JDBCTemplate into EmployeDaoImpl Class .
	 *  Test these functionalities individually.
	 *  
	 *  */
	public static void main(String[] args) {
	ApplicationContext ctx=new ClassPathXmlApplicationContext("com/Kamal/SpringCoreAdvanced/SpringJDBC/employee/Test/config.xml");
	EmployeeDao empdao=(EmployeeDao)ctx.getBean("empDaoImpl");
	Employee employee=new Employee();
	employee.setId(101);
	employee.setFirstName("john");
	employee.setLastName("ferguson");
	
	/*int create = empdao.create(employee);
	int delete=empdao.delete(1);
	int update=empdao.update(employee);
	Employee read = empdao.read(101); */
	List<Employee> readAll = empdao.readAll();

	System.out.println("number of records inserted:"+readAll);
	}

}
