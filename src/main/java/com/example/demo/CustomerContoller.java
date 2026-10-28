package com.example.demo;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerContoller {
	
	@Autowired
	CustomerService cs;
	
	@GetMapping("/demo")
	public String one() {
		return "Welcome First API!!!";
	}
	
	@PostMapping("/savedata")
	public String two(@RequestBody Customer ck) {
		ck.setCid(UUID.randomUUID().toString());
		cs.register(ck);
		return "Register Successful!!!";
	}
	
	@GetMapping("/fetchall")
	public List<Customer> three() {
		List<Customer> l1=cs.getallinfo();
		return l1;	
	}
	
	@GetMapping("/fetchsingleInfo/{id}")
	public Customer four(@PathVariable("id") String x) {
		Customer ck=cs.getsingleInfo(x);
		return ck;
	}
	
	@DeleteMapping("/deldata/{id}")
	public String five(@PathVariable("id") String id) {
		cs.del(id);
		return "Record deleted";
	}
	
	 // EDIT- Fetch existing customer details
    @GetMapping("/edit/{id}")
    public Customer edit(@PathVariable String id) {
        return cs.getsingleInfo(id);
    }

    @PatchMapping("/patch/{id}")
    public Customer patch(@PathVariable String id,@RequestBody Customer c1) {
        return cs.patch(id, c1);
    }
}

