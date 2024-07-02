package org.alumnievent.service;

import java.util.List;

import org.alumnievent.model.AlumniModel;
import org.alumnievent.model.EventModel;
import org.alumnievent.repository.EventRepository;
import org.alumnievent.repository.EventRepositoryImpl;

public class EventServiceImpl implements EventService{
	EventRepository eRepo = new EventRepositoryImpl();
	@Override
	public List<EventModel> ShowEventsAsPerCollege(int collegeid) {
		
		return eRepo.ShowEventsAsPerCollege(collegeid);
	}
	@Override
	public boolean addEvent(EventModel model, int CollegeId, int OrganizerId,int branchId) {
		
		return eRepo.addEvent(model, CollegeId, OrganizerId, branchId);
	}
	@Override
	public List<EventModel> ShowOrganizerEvents(int collegeId, int organizerId) {
		
		return eRepo.ShowOrganizerEvents(collegeId, organizerId);
	}
	@Override
	public int takeEcoIdByEventid(int eventId) {
		// TODO Auto-generated method stub
		return eRepo.takeEcoIdByEventid(eventId);
	}
	@Override
	public int finalAttendance(AlumniModel model, int ecoId) {
		// TODO Auto-generated method stub
		return eRepo.finalAttendance(model, ecoId);
	}
	@Override
	public List<EventModel> ShowEventsAsPerAlumni(int CollegeId, int AlumniId) {
		
		return eRepo.ShowEventsAsPerAlumni(CollegeId, AlumniId);
	}
	@Override
	public int isUpdateEvent(int eventId, EventModel model) {
		
		return eRepo.isUpdateEvent(eventId, model);
	}
	@Override
	public int isDeleteEvent(int eventId) {
		
		return eRepo.isDeleteEvent(eventId);
	}
	@Override
	public List<EventModel> showEventsOfBranchCollege(int BranchId, int Id) {
		
		return eRepo.showEventsOfBranchCollege(BranchId, Id);
	}
	@Override
	public int alumniAttendance(int alumniId, int ecoid) {
		
		return eRepo.alumniAttendance(alumniId, ecoid);
	}
	@Override
	public List<EventModel> getEventsForFeedback(int alumniId) {
		
		return eRepo.getEventsForFeedback(alumniId);
	}
	@Override
	public int giveFeedBack(int AlumniId, int Ecoid, String AfeedBack) {
		
		return eRepo.giveFeedBack(AlumniId, Ecoid, AfeedBack);
	}
	@Override
	public List<Object[]> showCollegeEventFeedBack(int EventId) {
		// TODO Auto-generated method stub
		return eRepo.showCollegeEventFeedBack(EventId);
	}
	@Override
	public int getEventCount() {
		// TODO Auto-generated method stub
		return eRepo.getEventCount();
	}



}
