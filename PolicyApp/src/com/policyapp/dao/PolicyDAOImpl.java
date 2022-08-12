package com.policyapp.dao;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.policyapp.exception.IdNotFoundException;
import com.policyapp.exception.PolicyNotFoundException;
import com.policyapp.model.Policy;

public class PolicyDAOImpl implements IPolicyDAO {

	@Override
	public List<Policy> findAll() {
		return showAllPolicies();
	}

	@Override
	public List<Policy> findByType(String type) throws PolicyNotFoundException {
		
		return showAllPolicies().stream().filter(policy->policy.getType().equalsIgnoreCase(type))
				.collect(Collectors.toList());
	}

	@Override
	public List<Policy> findByCategory(String category) throws PolicyNotFoundException {
		// TODO Auto-generated method stub
		return showAllPolicies().stream().filter(policy->policy.getCategory().equalsIgnoreCase(category))
				.collect(Collectors.toList());
	}

	@Override
	public List<Policy> findByHighSumAssured(double sumAssured) throws PolicyNotFoundException {
		// TODO Auto-generated method stub
		return showAllPolicies().stream().filter(policy->policy.getSumAssured()>(sumAssured))
				.collect(Collectors.toList());
	}

	@Override
	public List<Policy> findByCoverage(String coverage) throws PolicyNotFoundException {
		// TODO Auto-generated method stub
		return showAllPolicies().stream().filter(policy->policy.getCoverage().equalsIgnoreCase(coverage))
				.collect(Collectors.toList());
	}

	@Override
	public List<Policy> findByLessPremium(double premium) throws PolicyNotFoundException {
		// TODO Auto-generated method stub
		return showAllPolicies().stream().filter(policy->policy.getPremium()<(premium))
				.collect(Collectors.toList());
	}

	@Override
	public Policy findById(int policyId) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Policy>policyById=showAllPolicies().stream().filter(policy->policy.getPolicyNum() == policyId)
				.findFirst();
		if(policyById.isPresent()) {
			return policyById.get();
		}
				return null;
	}
	private List<Policy> showAllPolicies(){
		return Arrays.asList(
		new Policy ("jeevan sathi",1001,2000,"term",10,"marriage","general",200000),
		new Policy ("jeevan anand",1002,3000,"endowment",40,"life","life",500000),
		new Policy ("life saral",1003,1600,"pension",50,"retirement","general",200000),
		new Policy ("bajaj alliance",1004,2000,"endowment",20,"accidents","motor",1200000),
		new Policy ("tata alliance",1005,2000,"term",40,"sickness","health",600000),
		new Policy ("clicktoprotect",1006,2000,"ulip",60,"child","wealth",200000));
	}

}
