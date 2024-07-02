package org.alumnievent.service;

import java.util.List;

import org.alumnievent.model.CollegeModel;
import org.alumnievent.model.OragnizerModel;
import org.alumnievent.repository.OragnizerRepository;
import org.alumnievent.repository.OragnizerRepositoryImpl;

public class OragnizerServiceImpl implements OragnizerService {
	OragnizerRepository oRepo = new OragnizerRepositoryImpl();
	@Override
	public List<OragnizerModel> getAllOragnizer() {
		// TODO Auto-generated method stub
		return oRepo.getAllOragnizer();
	}
	@Override
	public boolean isRegisteredNewOragnizer(OragnizerModel model) {
		return oRepo.isRegisteredNewOragnizer(model);
	}
	@Override
	public boolean isDeleteOragnizerById(int oId) {
		
		return oRepo.isDeleteOragnizerById(oId);
	}
	@Override
	public boolean isUpdateOragnizerById(OragnizerModel model) {
		
		return oRepo.isUpdateOragnizerById(model);
	}
	@Override
	public OragnizerModel getOrganizerProfile(int oragnizerId) {
		
		return oRepo.getOrganizerProfile(oragnizerId);
	}
	@Override
	public List<CollegeModel> getAllCollege() {
		
		return oRepo.getAllCollege();
	}
	@Override
	public List<CollegeModel> getcoleveOrganizedByOrganizer(int organizerId) {
		
		return oRepo.getcoleveOrganizedByOrganizer(organizerId);
	}
	@Override
	public int isUpdateOrganizer(int organizerId, String contact, String Address) {
		
		return oRepo.isUpdateOrganizer(organizerId, contact, Address);
	}
	@Override
	public int getOragnizerCount() {
		
		return oRepo.getOragnizerCount();
	}
}
