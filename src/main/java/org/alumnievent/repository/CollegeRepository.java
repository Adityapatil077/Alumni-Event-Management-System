package org.alumnievent.repository;

import org.alumnievent.model.CollegeModel;

public interface CollegeRepository {
	public int verifyCollege(String email,String Pass);
	public boolean isRegistredNewCollege(CollegeModel cModel);
	public CollegeModel getAdminProfile(int CollegeId);
	public String getCollegeNameById(int collegeid);
}
