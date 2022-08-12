package com.policyapp.service;

import java.util.List;
import java.util.stream.Collectors;

import com.policyapp.dao.IPolicyDAO;
import com.policyapp.dao.PolicyDAOImpl;
import com.policyapp.exception.IdNotFoundException;
import com.policyapp.exception.PolicyNotFoundException;
import com.policyapp.model.Policy;

public class PolicyServiceImpl implements IPolicyService {
 IPolicyDAO policyDAO=new PolicyDAOImpl();
	@Override
	public List<Policy> getAll() {
		List<Policy> policies=policyDAO.findAll();
		List<Policy>policyList =policies
				.stream()
				.sorted((Policy p1, Policy p2) ->p1.getPolicyName().compareTo(p2.getPolicyName()) )
				.collect(Collectors.toList());
		return policyList;
	}

	@Override
	public List<Policy> getByType(String type) throws PolicyNotFoundException {
		List<Policy>policyList1=policyDAO
				.findByType(type)
				.stream()
				/* .filter(policy->policy.getType().equalsIgnoreCase(type)) */
				.sorted((p1,p2)->p1.getPolicyName().compareTo(p2.getPolicyName()))
				.collect(Collectors.toList());
		if(policyList1.isEmpty())
		{
			throw new PolicyNotFoundException("policy not found");
		}
		return policyList1;
	}

	@Override
	public List<Policy> getByCategory(String category) throws PolicyNotFoundException {
		List<Policy>policyList2=policyDAO
				.findByCategory(category)
				.stream()
				/* .filter(policy->policy.getCategory().equalsIgnoreCase(category)) */
				.sorted((p1,p2)->p1.getPolicyName().compareTo(p2.getPolicyName()))
				.collect(Collectors.toList());
		if(policyList2.isEmpty())
		{
			throw new PolicyNotFoundException("policy not found");
		}
		return policyList2;
		
	}

	@Override
	public List<Policy> getByHighSumAssured(double sumAssured) throws PolicyNotFoundException {
		List<Policy>policyList3=policyDAO
				.findByHighSumAssured(sumAssured)
				.stream()
				/* .filter(policy->policy.getSumAssured()==(sumAssured)) */
				.sorted((p1,p2)->p1.getPolicyName().compareTo(p2.getPolicyName()))
				.collect(Collectors.toList());
		if(policyList3.isEmpty())
		{
			throw new PolicyNotFoundException("policy not found");
		}
		return policyList3;
		
	}

	@Override
	public List<Policy> getByCoverage(String coverage) throws PolicyNotFoundException {
		List<Policy>policyList4=policyDAO
				.findByCoverage(coverage)
				.stream()
				/* .filter(policy->policy.getCoverage().equalsIgnoreCase(coverage)) */
				.sorted((p1,p2)->p1.getPolicyName().compareTo(p2.getPolicyName()))
				.collect(Collectors.toList());
		if(policyList4.isEmpty())
		{
			throw new PolicyNotFoundException("policy not found");
		}
		return policyList4;
	}

	@Override
	public List<Policy> getByLessPremium(double premium) throws PolicyNotFoundException {
		List<Policy>policyList5=policyDAO
				.findByLessPremium(premium)
				.stream()
				/* .filter(policy->policy.getPremium()==(premium)) */
				.sorted((p1,p2)->p1.getPolicyName().compareTo(p2.getPolicyName()))
				.collect(Collectors.toList());
		if(policyList5.isEmpty())
		{
			throw new PolicyNotFoundException("policy not found");
		}
		return policyList5;
	}

	@Override
	public Policy getById(int policyId) throws IdNotFoundException {
		Policy policyById=policyDAO.findById(policyId);
				if(policyById !=null) {
					return policyById;
				}
		throw new IdNotFoundException("id not exception");
	}

}
