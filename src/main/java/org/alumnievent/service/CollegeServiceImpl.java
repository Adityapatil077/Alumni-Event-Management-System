package org.alumnievent.service;

import org.alumnievent.model.CollegeModel;
import org.alumnievent.repository.CollegeRepository;
import org.alumnievent.repository.CollegeRepositoryImpl;

public class CollegeServiceImpl implements CollegeService{
	CollegeRepository collegeRepo = new CollegeRepositoryImpl();
	@Override
	public int verifyCollege(String email, String Pass) {
		return collegeRepo.verifyCollege(email, Pass);
	}
	@Override
	public boolean isRegistredNewCollege(CollegeModel cModel) {
		
		return collegeRepo.isRegistredNewCollege(cModel);
	}
	@Override
	public CollegeModel getAdminProfile(int CollegeId) {
		
		return collegeRepo.getAdminProfile(CollegeId);
	}
	@Override
	public String getCollegeNameById(int collegeid) {
		
		return collegeRepo.getCollegeNameById(collegeid);
	}

}
