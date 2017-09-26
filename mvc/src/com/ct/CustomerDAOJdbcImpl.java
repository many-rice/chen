package com.ct;

import java.util.List;

public class CustomerDAOJdbcImpl extends DAO<Customer> implements CustomerDAO{

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		String sql="select * from customer";
		return getForList(sql);
	}

	@Override
	public void save(Customer customer) {
		// TODO Auto-generated method stub
		String sql="insert into customer values(?,?,?,?)";
		System.out.println(customer.getName());
		update(sql, customer.getId(),customer.getName(),customer.getAddress(),customer.getPhone());
	}

	@Override
	public Customer get(Integer id) {
		// TODO Auto-generated method stub
		String sql="select id,name,address,phone from customer where id=?";
		return get(sql,id);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		String sql="delete from customer where id=?";
	    update(sql, id);
	}

	@Override
	public long getCountWithName(Integer id) {
		String sql="select count(id) from customer where id=?";
		return getForValue(sql, id);
	}

	@Override
	public List<Customer> getMohu(String name, String address, String phone) {
		String sql="select * from customer where 1=1 ";
		int i1=0;
		int i2=0;
		int i3=0;
		if(name!=null) {
			sql+="and name = ?";
			i1++;
		}
		if(address!=null) {
			sql+="and address = ?";
			i2++;
		}
		if(phone !=null) {
			sql+="and phone=?";
			i3++;
		}
		Object [] args=null;
		int count=i1+i2+i3;
		int flag=0;
		if(count!=0) {
			args=new Object[count];
			if(i1!=0) args[0]=name;
			flag+=i1;
			if(i2!=0) args[flag]=address;
			flag+=i2;
			if(i3!=0) args[flag]=phone;
		}
		System.out.println("sql="+sql);
		return getForList(sql, args);
	}

	@Override
	public void updatebyId(Customer customer) {
		// TODO Auto-generated method stub
		String sql = "update customer set id=? ,name= ?, address=?,phone=? where id=?";
		update(sql, customer.getId(),customer.getName(),customer.getAddress(),customer.getPhone(),customer.getId());
	}
	
}
