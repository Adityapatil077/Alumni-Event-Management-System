package org.alumnievent.service;

import java.util.List;

import org.alumnievent.model.AlumniModel;
import org.alumnievent.model.EventModel;
import org.alumnievent.repository.AlumniRepository;
import org.alumnievent.repository.AlumniRepositoryImpl;
import org.alumnievent.repository.EventRepository;
import org.alumnievent.repository.EventRepositoryImpl;

public class AlumniServiceImpl implements AlumniService {
	AlumniRepository alumniService = new AlumniRepositoryImpl();
	EventRepository eventRepo = new EventRepositoryImpl();
	@Override
	public List<AlumniModel> getAllAlumni(int AlumniId) {
		
		return alumniService.getAllAlumni(AlumniId);
	}
	@Override
	public boolean isRegisteredNewAlumni(AlumniModel model) {
		
		return alumniService.isRegisteredNewAlumni(model);
	}
	@Override
	public boolean isDeleteAlumniById(int aId) {
		
		return alumniService.isDeleteAlumniById(aId);
	}
	@Override
	public boolean isUpdateAlumniById(AlumniModel model) {
		
		return alumniService.isUpdateAlumniById(model);
	}
	@Override
	public List<AlumniModel> getAlumniByEvent(int collegeId, int BranchId) {
		
		return alumniService.getAlumniByEvent(collegeId, BranchId);
	}
	@Override
	public List<AlumniModel> getAllAlumniOfCollegeBranchWise(int branchId, int CollegeId) {
		
		return alumniService.getAllAlumniOfCollegeBranchWise(branchId, CollegeId);
	}
	@Override
	public AlumniModel getAlumniProfile(int alumniid) {
		
		return alumniService.getAlumniProfile(alumniid);
	}
	@Override
	public int getCollegeIdOfAlumni(int alumniid) {
		
		return alumniService.getCollegeIdOfAlumni(alumniid);
	}
	@Override
	public List<AlumniModel> getAlumniBySearch(int collegeId, int BranchId, String Search) {
		// TODO Auto-generated method stub
		return alumniService.getAlumniBySearch(collegeId, BranchId, Search);
	}
	@Override
	public List<AlumniModel> getSortedAlumniByYear(int EventId) {
		
		return alumniService.getSortedAlumniByYear(EventId);
	}
	@Override
	public List<AlumniModel> getPresentAlumni(int EventId) {
		// TODO Auto-generated method stub
		return alumniService.getPresentAlumni(EventId);
	}
	@Override
	public List<AlumniModel> getAbsentAlumni(int EventId) {
		// TODO Auto-generated method stub
		return alumniService.getAbsentAlumni(EventId);
	}
	@Override
	public List<AlumniModel> getSeniorAlumni(int EventId) {
		// TODO Auto-generated method stub
		return alumniService.getSeniorAlumni(EventId);
	}
	@Override
	public int isUpdateAlumni(int alumniId, String Contact, String Address) {
		
		return  alumniService.isUpdateAlumni(alumniId, Contact, Address);
	};
	
	
}
