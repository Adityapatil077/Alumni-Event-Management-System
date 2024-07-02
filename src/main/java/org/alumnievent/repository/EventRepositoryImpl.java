package org.alumnievent.repository;

import java.util.ArrayList;
import java.util.List;

import org.alumnievent.config.DBConfig;
import org.alumnievent.model.AlumniModel;
import org.alumnievent.model.EventModel;
import org.alumnievent.service.AlumniService;
import org.alumnievent.service.AlumniServiceImpl;

import java.sql.*;

public class EventRepositoryImpl extends DBConfig implements EventRepository {
	List<EventModel> list = new ArrayList<EventModel>();

	private int getEventIdInIncrement() {
		try {
			int Eventid = 0;
			stmt = conn.prepareStatement("select max(EventId) from event");
			rs = stmt.executeQuery();
			if (rs.next()) {
				Eventid = rs.getInt(1);
			}
			return ++Eventid;

		} catch (Exception ex) {
			System.out.println("Error is" + ex);
			return 0;
		}
	}

	private int getCollegeOrganizerIdInIncrement() {
		try {
			int CollegeOrganizerId = 0;
			stmt = conn.prepareStatement("select max(CollegeOragnizerId) from collegeoragnizerjoin");
			rs = stmt.executeQuery();
			if (rs.next()) {
				CollegeOrganizerId = rs.getInt(1);
			}
			return ++CollegeOrganizerId;

		} catch (Exception ex) {
			System.out.println("Error is" + ex);
			return 0;
		}
	}

	private int getEventCollegeOrganizerIdInIncrement() {
		try {
			int EventCollegeOrganizerId = 0;
			stmt = conn.prepareStatement("select max(EventCollegeOragnizerId) from eventcollegeoragnizerjoin");
			rs = stmt.executeQuery();
			if (rs.next()) {
				EventCollegeOrganizerId = rs.getInt(1);
			}
			return ++EventCollegeOrganizerId;

		} catch (Exception ex) {
			System.out.println("Error is" + ex);
			return 0;
		}
	}

	@Override
	public List<EventModel> ShowEventsAsPerCollege(int CollegeId) {

		try {
			EventModel emodel;
			stmt = conn.prepareStatement(
					"select e.EventId,e.BranchId,e.EventName,e.Description,e.Venue,e.Date from event e Inner join eventcollegeoragnizerjoin ecoj on e.EventId=ecoj.EventId Inner join collegeoragnizerjoin coj on ecoj.CollegeOragnizerId = coj.CollegeOragnizerId where coj.CollegeId=?");
			stmt.setInt(1, CollegeId);
			rs = stmt.executeQuery();
			while (rs.next()) {
				emodel = new EventModel();
				emodel.setEventId(rs.getInt(1));
				emodel.setBranchId(rs.getInt(2));
				emodel.setEventName(rs.getString(3));
				emodel.setDescription(rs.getString(4));
				emodel.setVenue(rs.getString(5));
				emodel.setDate(rs.getDate(6));
				list.add(emodel);
			}
			return list != null ? list : null;
		} catch (Exception ex) {
			System.out.println("Error is" + ex);
			return null;
		}

	}

	@Override
	public boolean addEvent(EventModel model, int CollegeId, int OrganizerId, int branchId) {
		AlumniService aService = new AlumniServiceImpl();

		List<AlumniModel> li = aService.getAllAlumniOfCollegeBranchWise(branchId, CollegeId);

		try {
			int eventId = this.getEventIdInIncrement();

			stmt = conn.prepareStatement("insert into event values(?,?,?,?,?,?)");
			stmt.setInt(1, eventId);
			stmt.setInt(6, model.getBranchId());
			stmt.setString(2, model.getEventName());
			stmt.setString(5, model.getDescription());
			stmt.setString(3, model.getVenue());
			stmt.setDate(4, model.getDate());
			int value1 = stmt.executeUpdate();
			if (value1 == 1) {
				int collegeOrganizerId = this.getCollegeOrganizerIdInIncrement();

				stmt = conn.prepareStatement("insert into collegeoragnizerjoin values(?,?,?)");
				stmt.setInt(1, CollegeId);
				stmt.setInt(2, OrganizerId);
				stmt.setInt(3, collegeOrganizerId);
				int value2 = stmt.executeUpdate();
				if (value2 == 1) {
					int eventCollegeOrganizerId = this.getEventCollegeOrganizerIdInIncrement();

					stmt = conn.prepareStatement("insert into  eventcollegeoragnizerjoin values(?,?,?)");
					stmt.setInt(1, eventId);
					stmt.setInt(2, collegeOrganizerId);
					stmt.setInt(3, eventCollegeOrganizerId);
					int value3 = stmt.executeUpdate();
					if (value3 == 1) {
						int result = 0;
						for (AlumniModel Am : li) {
							System.out.println("alumni id is" + Am.getAlumniId());
							System.out.println("ecoid is" + eventCollegeOrganizerId);
							stmt = conn.prepareStatement("Insert into attendance values(?,?,?,'0')");
							stmt.setInt(1, Am.getAlumniId());
							stmt.setInt(2, eventCollegeOrganizerId);
							stmt.setInt(3, 0);

							result = stmt.executeUpdate();

						}
						if (result == 1) {
							return true;
						} else {
							return false;
						}

					} else {
						return false;
					}

				} else {
					return false;
				}

			} else {
				return false;
			}

		} catch (Exception ex) {
			System.out.println("Error is addEvent : " + ex);
			return false;
		}
	}

	@Override
	public List<EventModel> ShowOrganizerEvents(int collegeId, int organizerId) {

		List<EventModel> list = new ArrayList<EventModel>();
		try {
			EventModel emodel;

			stmt = conn.prepareStatement(
					"SELECT Distinct e.EventId,e.BranchId, e.EventName, e.Description, e.Venue, e.Date FROM event e JOIN branch b ON e.BranchId = b.BranchId JOIN colleges c ON b.CollegeId = c.CollegeId JOIN collegeoragnizerjoin coj ON c.CollegeId = coj.CollegeId JOIN oragnizer o ON coj.OragnizerId = o.OragnizerId WHERE c.CollegeId =? AND o.OragnizerId =?");
			stmt.setInt(1, collegeId);
			stmt.setInt(2, organizerId);
			rs = stmt.executeQuery();
			while (rs.next()) {
				emodel = new EventModel();
				emodel.setEventId(rs.getInt(1));
				emodel.setBranchId(rs.getInt(2));
				emodel.setEventName(rs.getString(3));
				emodel.setDescription(rs.getString(4));
				emodel.setVenue(rs.getString(5));
				emodel.setDate(rs.getDate(6));
				list.add(emodel);
			}
			return list != null ? list : null;
		} catch (Exception ex) {
			System.out.println("Error is " + ex);
			return null;
		}
	}

	@Override
	public int takeEcoIdByEventid(int eventId) {
		// TODO Auto-generated method stub
		try {
			int Ecoid = 0;
			stmt = conn.prepareStatement(
					"SELECT DISTINCT a.EventCollegeOragnizerId FROM attendance a JOIN  eventcollegeoragnizerjoin ecoj ON a.EventCollegeOragnizerId = ecoj.EventCollegeOragnizerId JOIN event e ON ecoj.EventId = e.EventId WHERE e.EventId=?");
			stmt.setInt(1, eventId);
			rs = stmt.executeQuery();
			if (rs.next()) {
				Ecoid = rs.getInt(1);
			}
			return Ecoid;
		} catch (Exception ex) {
			System.out.println("Error is " + ex);
			return 0;
		}
	}

	@Override
	public int finalAttendance(AlumniModel model, int ecoId) {
		// TODO Auto-generated method stub
		try {
			stmt = conn.prepareStatement(
					"update attendance set status=" + 1 + " where AlumniId=? and EventCollegeOragnizerId=?");
			stmt.setInt(1, model.getAlumniId());
			stmt.setInt(2, ecoId);
			int value = stmt.executeUpdate();
			if (value == 1) {
				return 1;
			} else {
				return 0;
			}

		} catch (Exception ex) {
			System.out.println("error is" + ex);
			return 0;
		}
	}

	@Override
	public List<EventModel> ShowEventsAsPerAlumni(int CollegeId, int AlumniId) {
		List<EventModel> list = new ArrayList<EventModel>();
		try {
			EventModel emodel;
			stmt = conn.prepareStatement(
					"select e.EventName,e.Venue,e.Description,e.Date from event e inner join branch b on e.BranchId = b.BranchId inner join colleges c on b.CollegeId = c.CollegeId inner join alumni a on b.BranchId = a.BranchId and c.CollegeId = a.CollegeId where c.CollegeId=? and a.AlumniId=?");
			stmt.setInt(1, CollegeId);
			stmt.setInt(2, AlumniId);
			rs = stmt.executeQuery();
			while (rs.next()) {
				emodel = new EventModel();
				emodel.setEventName(rs.getString(1));
				emodel.setDescription(rs.getString(2));
				emodel.setVenue(rs.getString(3));
				emodel.setDate(rs.getDate(4));
				list.add(emodel);
			}
			return list != null ? list : null;
		} catch (Exception ex) {
			System.out.println("Error is" + ex);
			return null;
		}
	}

	@Override
	public int isUpdateEvent(int eventId, EventModel model) {
		try {
			stmt = conn.prepareStatement(
					"update event set BranchId=?,EventName=?,Description=?, Venue=?, Date=? where EventId=?");
			stmt.setInt(1, model.getBranchId());
			stmt.setString(2, model.getEventName());
			stmt.setString(3, model.getDescription());
			stmt.setString(4, model.getVenue());
			stmt.setDate(5, model.getDate());
			stmt.setInt(6, eventId);
			int value = stmt.executeUpdate();
			if (value == 1) {
				return 1;
			} else {
				return 0;
			}

		} catch (Exception ex) {
			System.out.println("Error is" + ex);
			return 0;
		}
	}

	@Override
	public int isDeleteEvent(int eventId) {
		try {
			stmt = conn.prepareStatement("delete from event where EventId=?");
			stmt.setInt(1, eventId);
			int value = stmt.executeUpdate();
			if (value == 1) {
				return 1;
			} else {
				return 0;
			}
		} catch (Exception ex) {
			System.out.println("Error is" + ex);
			return 0;
		}
	}

	@Override
	public List<EventModel> showEventsOfBranchCollege(int BranchId, int Id) {
		List<EventModel> list = new ArrayList<EventModel>();
		EventModel model = null;
		try {
			stmt = conn.prepareStatement(
					"SELECT e.EventId,e.BranchId,e.EventName,e.Venue,e.Date,e.Description FROM event e JOIN branch b ON e.BranchId = b.BranchId WHERE b.CollegeId =? AND b.BranchId =?");
			stmt.setInt(1, Id);
			stmt.setInt(2, BranchId);
			rs = stmt.executeQuery();
			while (rs.next()) {
				model = new EventModel();
				model.setEventId(rs.getInt("eventId"));
				model.setBranchId(rs.getInt("branchId"));
				model.setEventName(rs.getString("eventName"));
				model.setVenue(rs.getString("venue"));
				model.setDate(rs.getDate("Date"));
				model.setDescription(rs.getString("description"));
				list.add(model);
			}
			return list;
		} catch (Exception ex) {
			System.out.println("Error is" + ex);
			return null;
		}
	}

	@Override
	public int alumniAttendance(int alumniId, int ecoid) {
		try {
			stmt = conn
					.prepareStatement("update attendance set status=? where AlumniId=? and EventCollegeOragnizerId=?");
			stmt.setInt(1, 1);
			stmt.setInt(2, alumniId);
			stmt.setInt(3, ecoid);
			int value = stmt.executeUpdate();
			if (value == 1) {
				return 1;
			} else {
				return 0;
			}

		} catch (Exception ex) {
			System.out.println("Error is" + ex);
			return 0;
		}
	}

	@Override
	public List<EventModel> getEventsForFeedback(int alumniId) {
		List<EventModel> list = new ArrayList<EventModel>();
		EventModel model = null;
		try {
			stmt = conn.prepareStatement(
					"SELECT e.eventId, e.eventName FROM event e JOIN  eventcollegeoragnizerjoin ecoj ON e.EventId = ecoj.EventId JOIN attendance a ON ecoj.EventCollegeOragnizerId = a.EventCollegeOragnizerId WHERE a.AlumniId=? AND a.status = 1");
			stmt.setInt(1, alumniId);
			rs = stmt.executeQuery();
			while (rs.next()) {
				model = new EventModel();
				model.setEventId(rs.getInt(1));
				model.setEventName(rs.getString(2));
				list.add(model);
			}
			return list;
		} catch (Exception ex) {
			System.out.println("Error is getEventsForFeedback" + ex);
			return null;
		}
	}

	@Override
	public int giveFeedBack(int AlumniId, int Ecoid, String AfeedBack) {
		int feedbackid = 0;
		try {
			stmt = conn.prepareStatement(
					"select feedbackId from attendance where AlumniId=? and EventCollegeOragnizerId=?");
			stmt.setInt(1, AlumniId);
			stmt.setInt(2, Ecoid);
			rs = stmt.executeQuery();
			if (rs.next()) {
				feedbackid = rs.getInt("feedbackId");
			}
			stmt = conn.prepareStatement("Insert into feedback values(?,?)");
			stmt.setInt(1, feedbackid);
			stmt.setString(2, AfeedBack);
			int value = stmt.executeUpdate();
			if (value == 1) {
				return 1;
			} else {
				return 0;
			}

		} catch (Exception ex) {
			System.out.println("Exception is giveFeedBack" + ex);
			return 0;
		}
	}

	@Override
	public List<Object[]> showCollegeEventFeedBack(int EventId) {
		List<Object[]> list = new ArrayList<>();
		try {
			stmt = conn.prepareStatement(
					"SELECT a.AlumniName,f.Feedback FROM event e JOIN  eventcollegeoragnizerjoin ecoj ON e.EventId = ecoj.EventId JOIN collegeoragnizerjoin coj ON ecoj.CollegeOragnizerId = coj.CollegeOragnizerId JOIN attendance at ON ecoj.EventCollegeOragnizerId= at.EventCollegeOragnizerId JOIN alumni a ON at.AlumniId = a.AlumniId JOIN feedback f ON at.FeedbackId = f.FeedbackId WHERE e.EventId = ?");
			stmt.setInt(1, EventId);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Object obj[] = new Object[] { rs.getString(1), rs.getString(2) };
				list.add(obj);
			}
			return list;
		} catch (Exception ex) {
			System.out.println("error is" + ex);
			return null;
		}

	}

	@Override
	public int getEventCount() {
		try {
			stmt = conn.prepareStatement("sele");
		}catch(Exception ex)
		{
			System.out.println("Error is "+ex);
		}
		return 0;
	}

}
