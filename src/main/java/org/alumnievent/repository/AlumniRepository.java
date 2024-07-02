package org.alumnievent.repository;

import java.util.List;

import org.alumnievent.model.AlumniModel;

public interface AlumniRepository {
	public List<AlumniModel> getAllAlumni(int AlumniId);
	public boolean isRegisteredNewAlumni(AlumniModel model);
	public boolean isDeleteAlumniById(int Id);
	public boolean isUpdateAlumniById(AlumniModel model);
	public List<AlumniModel> getAlumniByEvent(int collegeId,int BranchId);
	public List<AlumniModel> getAllAlumniOfCollegeBranchWise(int branchId,int  CollegeId);
	public AlumniModel getAlumniProfile(int alumniid);
	public int getCollegeIdOfAlumni(int alumniid);
	public List<AlumniModel> getAlumniBySearch(int collegeId, int BranchId, String Search);
	public List<AlumniModel> getSortedAlumniByYear(int EventId);
	public List<AlumniModel> getPresentAlumni(int EventId);
	public List<AlumniModel> getAbsentAlumni(int EventId);
	public List<AlumniModel> getSeniorAlumni(int EventId);
	
	public int isUpdateAlumni(int alumniId,String Contact,String Address);
}
