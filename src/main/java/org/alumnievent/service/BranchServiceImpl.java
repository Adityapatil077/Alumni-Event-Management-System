package org.alumnievent.service;

import java.util.List;

import org.alumnievent.model.BranchModel;
import org.alumnievent.repository.BranchRepository;
import org.alumnievent.repository.BranchRepositoryImpl;

public class BranchServiceImpl implements BranchService {
	BranchRepository branchRepo = new BranchRepositoryImpl();
	@Override
	public int getBranchId(int CollegeId) {
		
		return branchRepo.getBranchId(CollegeId);
	}
	@Override
	public boolean isAddNewBranch(BranchModel model,int CollegeId) {
		
		return branchRepo.isAddNewBranch(model,CollegeId);
	}
	@Override
	public String getBranchNameById(int branchId, int collegeid) {
		
		return branchRepo.getBranchNameById(branchId, collegeid);
	}
	@Override
	public List<BranchModel> getCollegeWiseBranch(int collegeid) {
		
		return branchRepo.getCollegeWiseBranch(collegeid);
	}
	
}
