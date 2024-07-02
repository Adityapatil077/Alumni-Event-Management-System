package org.alumnievent.service;

import java.util.List;

import org.alumnievent.model.AlumniModel;
import org.alumnievent.model.EventModel;



public interface EventService {
	public List<EventModel> ShowEventsAsPerCollege(int collegeid);
	public boolean addEvent(EventModel model,int CollegeId,int OrganizerId,int branchId);
	public List<EventModel> ShowOrganizerEvents(int collegeId,int organizerId);
	public int takeEcoIdByEventid(int eventId);
	public int finalAttendance(AlumniModel model,int ecoId);
	public List<EventModel> ShowEventsAsPerAlumni(int CollegeId, int AlumniId);
	public int isUpdateEvent(int eventId,EventModel model);
	public int isDeleteEvent(int eventId);
	public List<EventModel> showEventsOfBranchCollege(int BranchId, int Id);
	public int alumniAttendance(int alumniId, int ecoid);
	public List<EventModel> getEventsForFeedback(int alumniId);
	public int giveFeedBack(int AlumniId, int Ecoid,String AfeedBack);
	public List<Object[]> showCollegeEventFeedBack(int EventId);
	public int getEventCount();
}
