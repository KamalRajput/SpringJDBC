package com.Kamal.SpringCoreAdvanced.SpringJDBC;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Test {

	
	/*Normal Implementation
	 * In this clas we are using driverManagerDataSource and JdbcTemplate Only
	 *  
	 *  
	 *  */
	public static void main(String[] args) {
	ApplicationContext ctx=new ClassPathXmlApplicationContext("com/Kamal/SpringCoreAdvanced/SpringJDBC/config.xml");
	JdbcTemplate jd=(JdbcTemplate)ctx.getBean("template");
	String sql="insert into Employees values(?,?,?)";
	int result=jd.update(sql, 1,"Kamal","Rajput");
	System.out.println("number of records inserted:"+result);
	}

}
