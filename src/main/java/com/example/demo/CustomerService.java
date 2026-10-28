package com.example.demo;

import java.util.List;

public interface CustomerService {
	
	public void register(Customer c1);
	
	public List<Customer> getallinfo();
	
	public Customer getsingleInfo(String cid);
	
	public void del(String id);
	
	public Customer patch(String id, Customer c1);
}
