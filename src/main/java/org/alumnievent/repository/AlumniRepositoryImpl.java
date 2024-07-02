package org.alumnievent.repository;

import java.util.ArrayList;
import java.util.List;

import org.alumnievent.config.DBConfig;
import org.alumnievent.model.AlumniModel;
import org.alumnievent.service.AlumniService;
import org.alumnievent.service.BranchService;
import org.alumnievent.service.BranchServiceImpl;

public class AlumniRepositoryImpl extends DBConfig implements AlumniRepository {

	BranchService bService = new BranchServiceImpl();
	int AlumniId = 0;

	int getAlumniId() {
		try {
			stmt = conn.prepareStatement("select  max(AlumniId) from alumni");
			rs = stmt.executeQuery();
			if (rs.next()) {
				AlumniId = rs.getInt(1);
			}
			return ++AlumniId;
		} catch (Exception ex) {
			System.out.println("Error Id Not Present " + ex);
			return (-1);
		}
	}

	public List<AlumniModel> getAllAlumni(int Id) {
		try {
			List<AlumniModel> list = new ArrayList<>();
			stmt = conn.prepareStatement("select *from alumni where CollegeId = ?");
			stmt.setInt(1, Id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				AlumniModel aModel = new AlumniModel();
				aModel.setAlumniId(rs.getInt("AlumniId"));
				aModel.setAlumniName(rs.getString("AlumniName"));
				aModel.setAlumniEmail(rs.getString("AlumniEmail"));
				aModel.setAlumniContact(rs.getString("AlumniContact"));
				aModel.setAlumniAddress(rs.getString("AlumniAddress"));
				aModel.setAlumniGender(rs.getString("AlumniGender"));
				aModel.setPassOutYear(rs.getInt("PassOutYear"));
				list.add(aModel);
			}
			return list.size() > 0 ? list : null;
		} catch (Exception ex) {
			System.out.println("Error is " + ex);
			return null;
		}
	}

	@Override
	public boolean isRegisteredNewAlumni(AlumniModel model) {
		try {
			int Id = this.getAlumniId();
			stmt = conn.prepareStatement("insert into alumni values(?,?,?,?,?,?,?,?,?,?)");
			stmt.setInt(1, Id);
			stmt.setString(2, model.getAlumniName());
			stmt.setString(3, model.getAlumniEmail());
			stmt.setString(4, model.getAlumniContact());
			stmt.setString(5, model.getAlumniAddress());
			stmt.setString(6, model.getAlumniGender());
			stmt.setString(7, "Pass@123");
			stmt.setInt(8, model.getPassOutYear());
			stmt.setInt(9, model.getBranchId());
			stmt.setInt(10, model.getCollegeId());
			int value = stmt.executeUpdate();
			return value > 0 ? true : false;
		} catch (Exception ex) {
			System.out.println("Error is New ALumni" + ex);
			return false;
		}

	}

	@Override
	public boolean isDeleteAlumniById(int aId) {
		try {
			stmt = conn.prepareStatement("delete from alumni where  AlumniId=?");
			stmt.setInt(1, aId);
			int value = stmt.executeUpdate();
			return value > 0 ? true : false;
		} catch (Exception ex) {
			System.out.println("Error is " + ex);
			return false;
		}
	}

	@Override
	public boolean isUpdateAlumniById(AlumniModel model) {
		try {
			stmt = conn.prepareStatement(
					"update alumni set  AlumniEmail=?,AlumniContact=?,AlumniAddress=? where   AlumniId=?");
			stmt.setString(1, model.getAlumniEmail());
			stmt.setString(2, model.getAlumniContact());
			stmt.setString(3, model.getAlumniAddress());
			stmt.setInt(4, model.getAlumniId());
			int value = stmt.executeUpdate();
			return value > 0 ? true : false;
		} catch (Exception ex) {
			System.out.println("Error is : " + ex);
		}
		return false;
	}

	public List<AlumniModel> getAlumniByEvent(int collegeId, int BranchId) {
		try {
			List<AlumniModel> li = new ArrayList<AlumniModel>();
			stmt = conn.prepareStatement(
					"select AlumniId,AlumniName,AlumniEmail,AlumniContact,AlumniAddress,AlumniGender,PassOutYear from alumni where CollegeId =? and BranchId=?");
			stmt.setInt(1, collegeId);
			stmt.setInt(2, BranchId);
			rs = stmt.executeQuery();
			while (rs.next()) {
				AlumniModel aModel = new AlumniModel();
				aModel.setAlumniId(rs.getInt("AlumniId"));
				aModel.setAlumniName(rs.getString("AlumniName"));
				aModel.setAlumniEmail(rs.getString("AlumniEmail"));
				aModel.setAlumniContact(rs.getString("AlumniContact"));
				aModel.setAlumniAddress(rs.getString("AlumniAddress"));
				aModel.setAlumniGender(rs.getString("AlumniGender"));
				aModel.setPassOutYear(rs.getInt("PassOutYear"));
				li.add(aModel);

			}
			return li.size() > 0 ? li : null;
		} catch (Exception ex) {
			System.out.println("Error is " + ex);
			return null;
		}

	}

	@Override
	public List<AlumniModel> getAllAlumniOfCollegeBranchWise(int branchId, int CollegeId) {
		try {
			AlumniModel model = null;
			List<AlumniModel> list = new ArrayList<AlumniModel>();
			stmt = conn.prepareStatement("Select AlumniId, AlumniEmail from alumni where BranchId=? and CollegeId=?");
			stmt.setInt(1, branchId);
			stmt.setInt(2, CollegeId);

			rs = stmt.executeQuery();
			while (rs.next()) {
				model = new AlumniModel();
				model.setAlumniId(rs.getInt("AlumniId"));
				model.setAlumniEmail(rs.getString("AlumniEmail"));
				list.add(model);
			}
			return list.size() > 0 ? list : null;

		} catch (Exception ex) {
			System.out.println("Error is getAllAlumniofCollege : " + ex);
			return null;
		}

	}

	@Override
	public AlumniModel getAlumniProfile(int alumniid) {
		AlumniModel amodel = null;
		try {
			stmt = conn.prepareStatement("select *from alumni where AlumniId=?");
			stmt.setInt(1, alumniid);
			rs = stmt.executeQuery();
			while (rs.next()) {
				amodel = new AlumniModel();
				amodel.setAlumniName(rs.getString("AlumniName"));
				amodel.setAlumniEmail(rs.getString("AlumniEmail"));
				amodel.setAlumniContact(rs.getString("AlumniContact"));
				amodel.setAlumniAddress(rs.getString("AlumniAddress"));
				amodel.setPassOutYear(rs.getInt("PassOutYear"));
				amodel.setAlumniGender(rs.getString("AlumniGender"));
			}

			return amodel != null ? amodel : null;

		} catch (Exception ex) {
			System.out.println("Error is" + ex);
			return null;
		}
	}

	@Override
	public int getCollegeIdOfAlumni(int alumniid) {
		try {
			int collegeId = 0;
			stmt = conn.prepareStatement("select CollegeId from alumni where AlumniId=?");
			stmt.setInt(1, alumniid);
			rs = stmt.executeQuery();
			if (rs.next()) {
				collegeId = rs.getInt("collegeId");
				return collegeId;
			} else {
				return 0;
			}
		} catch (Exception ex) {
			System.out.println("Error is" + ex);
			return 0;
		}
	}

	@Override
	public List<AlumniModel> getAlumniBySearch(int collegeId, int BranchId, String Search) {
		try {
			List<AlumniModel> list = new ArrayList<AlumniModel>();
			stmt = conn.prepareStatement(
					"select AlumniId,AlumniName,AlumniEmail,AlumniContact,AlumniAddress,AlumniGender,PassOutYear from alumni where CollegeId =? and BranchId=? and AlumniName like'"
							+ Search + "%'");
			stmt.setInt(1, collegeId);
			stmt.setInt(2, BranchId);
			rs = stmt.executeQuery();
			while (rs.next()) {
				AlumniModel aModel = new AlumniModel();
				aModel.setAlumniId(rs.getInt("alumniId"));
				aModel.setAlumniName(rs.getString("alumniName"));
				aModel.setAlumniEmail(rs.getString("alumniEmail"));
				aModel.setAlumniContact(rs.getString("alumniContact"));
				aModel.setAlumniAddress(rs.getString("alumniAddress"));
				aModel.setAlumniGender(rs.getString("alumniGender"));
				aModel.setPassOutYear(rs.getInt("PassoutYear"));
				list.add(aModel);
			}
			return list.size() > 0 ? list : null;
		} catch (Exception ex) {
			System.out.println("Exception is" + ex);
			return null;
		}
	}

	@Override
	public List<AlumniModel> getSortedAlumniByYear(int EventId) {
		List<AlumniModel> list = new ArrayList<>();
		AlumniModel model = null;
		try {
			stmt = conn.prepareStatement(
					"SELECT a.AlumniId,a.AlumniName,a.AlumniEmail,a.AlumniContact,a.PassOutYear FROM alumni a JOIN attendance att ON a.AlumniId = att.AlumniId JOIN eventcollegeoragnizerjoin ecoj ON att.EventCollegeOragnizerId = ecoj.EventCollegeOragnizerId JOIN event e ON ecoj.EventId = e.EventId WHERE e.EventId = ? AND att.status = 1 ORDER BY a.PassOutYear ASC");
			stmt.setInt(1, EventId);
			rs = stmt.executeQuery();
			while (rs.next()) {
				model = new AlumniModel();
				model.setAlumniId(rs.getInt("alumniId"));
				model.setAlumniName(rs.getString("alumniName"));
				model.setAlumniEmail(rs.getString("alumniEmail"));
				model.setAlumniContact(rs.getString("alumniContact"));
				model.setPassOutYear(rs.getInt("PassOutYear"));
				list.add(model);
			}
			return list;
		} catch (Exception ex) {
			System.out.println("Exception is" + ex);
			return null;
		}

	}

	@Override
	public List<AlumniModel> getPresentAlumni(int EventId) {
		List<AlumniModel> list = new ArrayList<>();
		AlumniModel model = null;
		try {
			stmt = conn.prepareStatement(
					"SELECT a.AlumniId,a.AlumniName,a.AlumniEmail,a.AlumniContact,a.PassOutYear FROM alumni a JOIN attendance att ON a.AlumniId = att.AlumniId JOIN eventcollegeoragnizerjoin ecoj ON att.EventCollegeOragnizerId = ecoj.EventCollegeOragnizerId JOIN event e ON ecoj.EventId = e.EventId WHERE e.EventId = ? AND att.status = 1");
			stmt.setInt(1, EventId);
			rs = stmt.executeQuery();
			while (rs.next()) {
				model = new AlumniModel();
				model.setAlumniId(rs.getInt("alumniId"));
				model.setAlumniName(rs.getString("alumniName"));
				model.setAlumniEmail(rs.getString("alumniEmail"));
				model.setAlumniContact(rs.getString("alumniContact"));
				model.setPassOutYear(rs.getInt("PassOutYear"));
				list.add(model);
			}
			return list;
		} catch (Exception ex) {
			System.out.println("Exception is" + ex);
			return null;
		}
	}

	@Override
	public List<AlumniModel> getAbsentAlumni(int EventId) {
		List<AlumniModel> list = new ArrayList<>();
		AlumniModel model = null;
		try {
			stmt = conn.prepareStatement(
					"SELECT a.AlumniId,a.AlumniName,a.AlumniEmail,a.AlumniContact,a.PassOutYear FROM alumni a LEFT JOIN attendance att ON a.AlumniId = att.AlumniId  JOIN eventcollegeoragnizerjoin ecoj ON att.EventCollegeOragnizerId = ecoj.EventCollegeOragnizerId  JOIN event e ON ecoj.EventId = e.EventId WHERE e.EventId = ? AND att.status = 0;");
			stmt.setInt(1, EventId);
			rs = stmt.executeQuery();
			while (rs.next()) {
				model = new AlumniModel();
				model.setAlumniId(rs.getInt("alumniId"));
				model.setAlumniName(rs.getString("alumniName"));
				model.setAlumniEmail(rs.getString("alumniEmail"));
				model.setAlumniContact(rs.getString("alumniContact"));
				model.setPassOutYear(rs.getInt("PassOutYear"));
				list.add(model);
			}
			return list;
		} catch (Exception ex) {
			System.out.println("Exception is" + ex);
			return null;
		}
	}

	@Override
	public List<AlumniModel> getSeniorAlumni(int EventId) {
		List<AlumniModel> list = new ArrayList<>();
		AlumniModel model = null;
		try {
			stmt = conn.prepareStatement("WITH SeniorAlumni AS (\r\n" + "    SELECT a.PassOutYear\r\n"
					+ "    FROM alumni a\r\n" + "    JOIN attendance att ON a.AlumniId = att.AlumniId\r\n"
					+ "    JOIN eventcollegeoragnizerjoin ecoj ON att.EventCollegeOragnizerId = ecoj.EventCollegeOragnizerId\r\n"
					+ "    JOIN event e ON ecoj.EventId = e.EventId\r\n"
					+ "    WHERE e.EventId = ? AND att.status = 1\r\n" + "    ORDER BY a.PassOutYear ASC\r\n"
					+ "    LIMIT 1\r\n" + ")\r\n"
					+ "SELECT a.AlumniId, a.AlumniName, a.AlumniEmail, a.AlumniContact, a.PassOutYear\r\n"
					+ "FROM alumni a\r\n" + "JOIN attendance att ON a.AlumniId = att.AlumniId\r\n"
					+ "JOIN eventcollegeoragnizerjoin ecoj ON att.EventCollegeOragnizerId = ecoj.EventCollegeOragnizerId\r\n"
					+ "JOIN event e ON ecoj.EventId = e.EventId\r\n"
					+ "JOIN SeniorAlumni sa ON a.PassOutYear = sa.PassOutYear\r\n"
					+ "WHERE e.EventId = ? AND att.status = 1;");
			stmt.setInt(1, EventId);
			stmt.setInt(2, EventId);
			rs = stmt.executeQuery();
			while (rs.next()) {
				model = new AlumniModel();
				model.setAlumniId(rs.getInt("alumniId"));
				model.setAlumniName(rs.getString("alumniName"));
				model.setAlumniEmail(rs.getString("alumniEmail"));
				model.setAlumniContact(rs.getString("alumniContact"));
				model.setPassOutYear(rs.getInt("PassOutYear"));
				list.add(model);
			}
			return list;
		} catch (Exception ex) {
			System.out.println("Error is" + ex);
			return null;
		}
	}

	@Override
	public int isUpdateAlumni(int alumniId, String Contact, String Address) {
		try {
			stmt=conn.prepareStatement("update alumni set AlumniContact=?,AlumniAddress=? where AlumniId=?");
			stmt.setString(1,Contact);
			stmt.setString(2,Address);
			stmt.setInt(3, alumniId);
			int value=stmt.executeUpdate();
			if(value==1)
			{
				return 1;
			}
			else
			{
				return 0;
			}
			
		}catch(Exception ex)
		{
			System.out.println("Error is"+ex);
			return 0;
		}

	}

}
