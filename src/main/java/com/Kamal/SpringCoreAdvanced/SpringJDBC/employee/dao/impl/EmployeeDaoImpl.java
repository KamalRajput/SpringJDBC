package com.Kamal.SpringCoreAdvanced.SpringJDBC.employee.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.Kamal.SpringCoreAdvanced.SpringJDBC.employee.RowMappers.EmployeerowMapper;
import com.Kamal.SpringCoreAdvanced.SpringJDBC.employee.dao.EmployeeDao;
import com.Kamal.SpringCoreAdvanced.SpringJDBC.employee.dto.Employee;

@Component("empDaoImpl")
public class EmployeeDaoImpl implements EmployeeDao {

	/*
	 * here we are using JDBCTemplate and getting the data from DTO layer(Employee)
	 * flow : EmployeeDaoImpl->JdbcTemplate->DriverManagerDataSource
	 */
	@Autowired
	private JdbcTemplate jd;

	@Override
	public int create(Employee employee) {

		String sql = "insert into Employees values(?,?,?)";
		int result = jd.update(sql, employee.getId(), employee.getFirstName(), employee.getLastName());
		return result;
	}

	@Override
	public int update(Employee employee) {

		String sql = "update Employees set FirstName=? , lastName=? where id=?";
		int result = jd.update(sql, employee.getFirstName(), employee.getLastName(), employee.getId());
		return result;
	}

	@Override
	public int delete(int id) {

		String sql = "delete from  Employees where id=?";
		int result = jd.update(sql, id);
		return result;
	}

	@Override
	public Employee read(int id) {
		String sql = "Select *  from  Employees where id=?";
		EmployeerowMapper rm = new EmployeerowMapper();
		Employee queryForObject = jd.queryForObject(sql, rm, id);
		return queryForObject;
	}

	@Override
	public List<Employee> readAll() {
		String sql = "select * from Employees";
		EmployeerowMapper rm = new EmployeerowMapper();
		List<Employee> query = jd.query(sql, rm);
		return query;
	}

	public JdbcTemplate getJd() {
		return jd;
	}

	public void setJd(JdbcTemplate jd) {
		this.jd = jd;
	}

}
