package com.ct;

import java.util.List;

public interface CustomerDAO {
	public List<Customer> getAll();
	
	public void save(Customer customer);
	
	public Customer get(Integer id);
	
	public void delete(Integer id);
	
	/**
	 * 返回和name相等的记录数。
	 * @param name
	 * @return
	 */
	public long getCountWithName(Integer id);
	
	public List<Customer>  getMohu(String name,String address,String phone);
	
	public void updatebyId(Customer customer);
}
