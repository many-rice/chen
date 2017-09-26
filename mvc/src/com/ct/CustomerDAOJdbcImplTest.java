package com.ct;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class CustomerDAOJdbcImplTest {

	private CustomerDAO customerDAO =new CustomerDAOJdbcImpl();
	@Test
	public void testGetAll() {
		List<Customer> customers=customerDAO.getAll();
		System.out.println(customers);
	}

	@Test
	public void testSave() {
		Customer customer=new Customer();
		customer.setId(1);
		customer.setAddress("shanghai");
		customer.setName("yanghao");
		customer.setPhone("546321987");
		
		customerDAO.save(customer);
		
		
	}

	@Test
	public void testGetInteger() {
		Customer customer=customerDAO.get(1);
		System.out.println(customer);
	}

	@Test
	public void testDelete() {
		customerDAO.delete(2);
	}

	@Test
	public void testGetCountWithName() {
		System.out.println(customerDAO.getCountWithName(1));
	}

}
