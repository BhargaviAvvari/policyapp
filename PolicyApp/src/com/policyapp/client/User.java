package com.policyapp.client;

import com.policyapp.exception.IdNotFoundException;
import com.policyapp.exception.PolicyNotFoundException;
import com.policyapp.service.IPolicyService;
import com.policyapp.service.PolicyServiceImpl;

public class User {

	public static void main(String[] args) {
		
		  IPolicyService policyService=new PolicyServiceImpl();
		  policyService.getAll().forEach(System.out::println);
		 System.out.println("..........");
          try {
			policyService.getByType("endowment").forEach(System.out::println);
		} catch (PolicyNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          System.out.println("..........");
          try {
			policyService.getByCategory("general").forEach(System.out::println);
			System.out.println(policyService.getById(1001));
		} catch (PolicyNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
