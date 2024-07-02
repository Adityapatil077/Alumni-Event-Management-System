package org.alumnievent.repository;

import org.alumnievent.config.DBConfig;
import org.alumnievent.model.CollegeModel;
import org.alumnievent.service.CollegeService;

public class CollegeRepositoryImpl extends DBConfig implements CollegeRepository {
	
	int collegeId = 0;
	int getCollegeId()
	{
		try {
			stmt = conn.prepareStatement("select  max(CollegeId) from colleges");
			rs=stmt.executeQuery();
			if(rs.next())
			{
				collegeId=rs.getInt(1);
			}
			return ++collegeId;
		}catch(Exception ex)
		{
			System.out.println("Error Id Not Present "+ex);
			return(-1);
		}
	}

	@Override
	public int verifyCollege(String email, String Pass) {
		try {
			stmt = conn.prepareStatement("select *from colleges where CollegeEmail = ? and "
					+ "CollegePassWord = ?");
			stmt.setString(1, email);
			stmt.setString(2, Pass);
			rs = stmt.executeQuery();
			if(rs.next())
			{
				return rs.getInt(1);
			}else {
				stmt = conn.prepareStatement("select *from oragnizer where  OrgnizerEmail = ? and OrgnizerPassword = ?");
				stmt.setString(1, email);
				stmt.setString(2, Pass);
				rs = stmt.executeQuery();
				if(rs.next())
				{
					return rs.getInt(1);
				}else {
					stmt = conn.prepareStatement("select *from alumni where AlumniEmail = ? and ALumniPassword = ?");
					stmt.setString(1, email);
					stmt.setString(2, Pass);
					rs = stmt.executeQuery();
					if(rs.next())
					{
						return rs.getInt(1);
					}else {
						return 0;
					}
				}
			}
			
		}catch(Exception ex)
		{
			System.out.println("Error is "+ex);
			return 0;
		}
	}

	@Override
	public boolean isRegistredNewCollege(CollegeModel cModel) {
		try {
			int collegeId = this.getCollegeId();
			stmt = conn.prepareStatement("insert into colleges  values(?,?,?,?,?,?)");
			stmt.setInt(1,collegeId);
			stmt.setString(2, cModel.getCollegeName());
			stmt.setString(3, cModel.getCollegeEmail());
			stmt.setString(4, cModel.getCollegeContact());
			stmt.setString(5, cModel.getCollegePassword());
			stmt.setString(6, cModel.getCollegeAddress());
			int value=stmt.executeUpdate();
			return value>0?true:false;
		}catch(Exception ex)
		{
			System.out.println("Error is : "+ex);
			return false;
		}
		
	}

	@Override
	public CollegeModel getAdminProfile(int Id) {
		try {
			stmt = conn.prepareStatement("select *from colleges  where CollegeId = ?");
			stmt.setInt(1,Id);
			rs= stmt.executeQuery();
			CollegeModel c = null;
			if(rs.next())
			{
				c = new CollegeModel();
				c.setCollegeId(rs.getInt(1));
				c.setCollegeName(rs.getString(2));
				c.setCollegeEmail(rs.getString(3));
				c.setCollegeContact(rs.getString(4));
				c.setCollegeAddress(rs.getString(6));
				
			}
			return c;
		}catch(Exception ex)
		{
			return null;
		}
	}

	@Override
	public String getCollegeNameById(int collegeid) {
		try {
			stmt=conn.prepareStatement("select  CollegeName from colleges where CollegeId=?"); 
			stmt.setInt(1, collegeid);
			  rs=stmt.executeQuery();
			  if(rs.next())
			  {
				  return rs.getString("CollegeName");
			  }
		      else {
				  return null;
			  }  
			
		}catch(Exception ex)
		{
			System.out.println("Error is "+ex);
			return null;
		}
	}

	

}
