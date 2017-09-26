package com.ct;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.filters.AddDefaultCharsetFilter;

/**
 * Servlet implementation class CustomerServlet
 */
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CustomerDAO customerDAO=new CustomerDAOJdbcImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String method=request.getParameter("method");
//		
//		switch (method) {
//		case "add":	add(request,response); break;
//		case "query":	query(request,response); break;
//		case "delete":	delete(request,response); break;
//		default:
//			break;
//		}
		String servletPath=request.getServletPath();
		String methodName=servletPath.substring(1,servletPath.length()-3);
		try {
			Method method= getClass().getDeclaredMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			try {
				method.invoke(this, request,response);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("delete");
		Integer id=Integer.parseInt(request.getParameter("id"));
		customerDAO.delete(id);
		List<Customer> customers=customerDAO.getAll();
		request.setAttribute("customers", customers);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
//		request.getRequestDispatcher("/query.do").forward(request, response);
	}


//	private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		//1.调用customerDAO
//		List<Customer> customers=customerDAO.getAll();
//		request.setAttribute("customers",customers);
//		request.getRequestDispatcher("/index.jsp").forward(request, response);
//	}
	
	private void update(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		// TODO Auto-generated method stub
		System.out.println("update");
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		String phone=request.getParameter("phone");
		
		Customer customer=new Customer();
		customer.setId(Integer.parseInt(id));
		customer.setName(name);
		customer.setAddress(address);
		customer.setPhone(phone);
		
		customerDAO.updatebyId(customer);
		response.sendRedirect("success.jsp");
	}

	private void add(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		// TODO Auto-generated method stub
		System.out.println("add");
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		String phone=request.getParameter("phone");
		
		Customer customer=new Customer();
		customer.setId(Integer.parseInt(id));
		customer.setName(name);
		customer.setAddress(address);
		customer.setPhone(phone);
		
		long count=customerDAO.getCountWithName(Integer.parseInt(id));
		if(count>0) {
			request.setAttribute("message","该用户id存在，请勿重复!");
			request.getRequestDispatcher("/newcustomer.jsp").forward(request, response);
		}else {
			customerDAO.save(customer);
			response.sendRedirect("success.jsp");
		}
		
	}
	private void edit(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		// TODO Auto-generated method stub
		System.out.println("edit");
		
		Integer id=Integer.parseInt(request.getParameter("id"));
		
		Customer customer=customerDAO.get(id);
		request.setAttribute("customer", customer);
		request.getRequestDispatcher("/update.jsp").forward(request, response);
	}
	private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("mohu");
		String name=request.getParameter("name").trim();
		if(name.equals("")) name=null;
		System.out.println(name);
		String address=request.getParameter("address").trim();
		System.out.println(address);
		if(address.equals("")) address=null;
		String phone=request.getParameter("phone").trim();
		if(phone.equals("")) phone=null;
		System.out.println(phone);
		List<Customer> customers=customerDAO.getMohu(name, address, phone);
		request.setAttribute("customers", customers);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
}
