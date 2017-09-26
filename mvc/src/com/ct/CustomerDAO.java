package com.ct;

import java.util.List;

public interface CustomerDAO {
	public List<Customer> getAll();
	
	public void save(Customer customer);
	
	public Customer get(Integer id);
	
	public void delete(Integer id);
	
	/**
	 * ���غ�name��ȵļ�¼����
	 * @param name
	 * @return
	 */
	public long getCountWithName(Integer id);
	
	public List<Customer>  getMohu(String name,String address,String phone);
	
	public void updatebyId(Customer customer);
}
