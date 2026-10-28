package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerDao implements CustomerService{

	@Autowired 
	ChildRepository cr;
	
	@Override
	public void register(Customer c1) {
		cr.save(c1);
		
	}

	@Override
	public List<Customer> getallinfo() {
		return cr.findAll();
	}

	@Override
	public Customer getsingleInfo(String cid) {
		return cr.findById(cid).orElse(null);
	}

	@Override
	public void del(String id) {
		cr.deleteById(id);
	}

	@Override
	public Customer patch(String id, Customer c1) {
		 Customer c = cr.findById(id).orElse(null);

	        if (c != null) {
	            c.setCname(c1.getCname());
	            c.setCemail(c1.getCemail());
	            c.setCpass(c1.getCpass());

	            return cr.save(c);
	        }
		return null;
	}

}
