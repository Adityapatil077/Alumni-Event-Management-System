package org.alumnievent.service;

import java.util.List;

import org.alumnievent.model.CollegeModel;
import org.alumnievent.model.OragnizerModel;

public interface OragnizerService {
	public List<OragnizerModel> getAllOragnizer();
	public boolean isRegisteredNewOragnizer(OragnizerModel model);
	public boolean isDeleteOragnizerById(int oId);
	public boolean isUpdateOragnizerById(OragnizerModel model);
	public OragnizerModel getOrganizerProfile(int oragnizerId );
	public List<CollegeModel> getAllCollege();
	public List<CollegeModel> getcoleveOrganizedByOrganizer(int organizerId);
	public int isUpdateOrganizer(int organizerId,String contact,String Address);
	public int getOragnizerCount();
}
