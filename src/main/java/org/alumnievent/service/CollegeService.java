package org.alumnievent.service;

import org.alumnievent.model.CollegeModel;

public interface CollegeService {
	public int verifyCollege(String email,String Pass);
	public boolean isRegistredNewCollege(CollegeModel cModel);
	public CollegeModel getAdminProfile(int CollegeId);
	public String getCollegeNameById(int collegeid);
}
