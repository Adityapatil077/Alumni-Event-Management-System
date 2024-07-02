package org.alumnievent.repository;

import java.util.ArrayList;
import java.util.List;

import org.alumnievent.config.DBConfig;
import org.alumnievent.model.AlumniModel;
import org.alumnievent.model.CollegeModel;
import org.alumnievent.model.OragnizerModel;

public class OragnizerRepositoryImpl extends DBConfig implements OragnizerRepository {
	List<OragnizerModel> list = new ArrayList<>();
	
	int OragnizerId = 0;
	public int getOragnizerId()
	{
		try {
			stmt = conn.prepareStatement("select  max(OragnizerId) from oragnizer");
			rs=stmt.executeQuery();
			if(rs.next())
			{
				OragnizerId=rs.getInt(1);
			}
			return ++OragnizerId;
		}catch(Exception ex)
		{
			System.out.println("Error Id Not Present "+ex);
			return(-1);
		}
	}
	@Override
	public List<OragnizerModel> getAllOragnizer() {
		try {
			stmt = conn.prepareStatement("select *from oragnizer");
			rs = stmt.executeQuery();
			while(rs.next())
			{
				OragnizerModel oModel = new OragnizerModel();
				oModel.setOrganizerId(rs.getInt("OragnizerId"));
				oModel.setOrganizerName(rs.getString("OrgnizerName"));
				oModel.setOrganizerEmail(rs.getString("OrgnizerEmail"));
				oModel.setOrganizerContact(rs.getString("OrgnizerContact"));
				oModel.setOrganizerAddress(rs.getString("OrgnizerAddress"));
				list.add(oModel);
			}
			return list.size()>0?list:null;
		}catch(Exception ex)
		{
			System.out.println("Error is "+ex);
			return null;
		}
	}
	@Override
	public boolean isRegisteredNewOragnizer(OragnizerModel model) {
		try {
			int Id = this.getOragnizerId();
			stmt = conn.prepareStatement("insert into oragnizer values(?,?,?,?,?,?)");
			stmt.setInt(1,Id);
			stmt.setString(2, model.getOrganizerName());
			stmt.setString(3, model.getOrganizerEmail());
			stmt.setString(4,model.getOrganizerContact());
			stmt.setString(5, model.getOrganizerAddress());
			stmt.setString(6, model.getOrganizerPassword());
			int value = stmt.executeUpdate();
			return value>0?true:false;
			
		}catch(Exception ex)
		{
			System.out.println("Error is "+ex);
			return false;
		}
	}
	@Override
	public boolean isDeleteOragnizerById(int oId) {
		try {
			stmt = conn.prepareStatement("delete from oragnizer where OragnizerId=?");
			stmt.setInt(1, oId);
			int value = stmt.executeUpdate();
			return value>0?true:false;
		}catch(Exception ex)
		{
			System.out.println("Error is "+ex);
			return false;
		}
		
	}
	@Override
	public boolean isUpdateOragnizerById(OragnizerModel model) {
		try {
			stmt = conn.prepareStatement("update oragnizer set OrgnizerEmail=?,OrgnizerContact=?,OrgnizerAddress=? where  OragnizerId=?");
			stmt.setString(1, model.getOrganizerEmail());
			stmt.setString(2, model.getOrganizerContact());
			stmt.setString(3,model.getOrganizerAddress());
			stmt.setInt(4,model.getOrganizerId());
			int value = stmt.executeUpdate();
			return value>0?true:false;
		}catch(Exception ex)
		{
			System.out.println("Error is : "+ex);
		}
		return false;
	}
	@Override
	public OragnizerModel getOrganizerProfile(int oragnizerId) {
		try {
			OragnizerModel omodel=null;
			stmt=conn.prepareStatement("select *from oragnizer where  OragnizerId=?");
			stmt.setInt(1, oragnizerId);
			rs=stmt.executeQuery();
			if(rs.next())
			{
				 omodel=new  OragnizerModel();
				 omodel.setOrganizerName(rs.getString(2));
				 omodel.setOrganizerEmail(rs.getString(3));
				 omodel.setOrganizerContact(rs.getString(4));
				 omodel.setOrganizerAddress(rs.getString(5));
			}
			return omodel!=null?omodel:null;
			
		}catch(Exception ex)
		{
			System.out.println("Error is"+ex);
		}
		return null;
	}
	@Override
	public List<CollegeModel> getAllCollege() {
		CollegeModel model=null;
	    List <CollegeModel> list=new ArrayList<CollegeModel>();
	    try {
	    	stmt=conn.prepareStatement("select * from colleges");
	    	rs=stmt.executeQuery();
	    	while(rs.next())
	    	{
	    		model=new CollegeModel();
	    		model.setCollegeId(rs.getInt(1));
	    		model.setCollegeName(rs.getString(2));
	    		model.setCollegeEmail(rs.getString(3));
	    		model.setCollegeContact(rs.getString(4));
	    		model.setCollegeAddress(rs.getString(5));
	    		model.setCollegePassword(rs.getString(6));
	    		list.add(model);
	    	}
	    	return list!=null?list:null;
	    	
	    }catch(Exception ex)
	    {
	    	System.out.println("Exception is"+ex);
			return null;
	    }
	}
	@Override
	public List<CollegeModel> getcoleveOrganizedByOrganizer(int organizerId) {
		List<CollegeModel> list = new ArrayList<>();
	    try {
	      
	        stmt = conn.prepareStatement("SELECT Distinct c.CollegeId, c.CollegeName, c.CollegeEmail, c.CollegeContact, c.CollegeAddress, c.CollegePassWord FROM colleges c JOIN collegeoragnizerjoin coj ON c.CollegeId = coj.CollegeId JOIN eventcollegeoragnizerjoin ecoj ON coj.CollegeOragnizerId = ecoj.CollegeOragnizerId JOIN oragnizer o ON coj.OragnizerId = o.OragnizerId WHERE o.OragnizerId = ?");
	        stmt.setInt(1, organizerId);
	     
	        rs = stmt.executeQuery();
	  
	        while (rs.next()) {
	           
	            CollegeModel model = new CollegeModel();
	            model.setCollegeId(rs.getInt("collegeId"));
	            model.setCollegeName(rs.getString("collegeName"));
	            model.setCollegeEmail(rs.getString("collegeEmail"));
	            model.setCollegeContact(rs.getString("collegeContact"));
	            model.setCollegeAddress(rs.getString("collegeAddress"));
	            model.setCollegePassword(rs.getString("collegePassword"));
	            list.add(model);
	        
	        }
	      
	        return list;
	    } catch (Exception ex) {
	        System.out.println("Error: " + ex.getMessage());
	      
	        return null;
	    }
	}
	@Override
	public int isUpdateOrganizer(int organizerId, String contact, String Address) {
		try {
			stmt=conn.prepareStatement("update oragnizer set orgnizercontact=?,OrgnizerAddress=? where OragnizerId=?");
			stmt.setString(1,contact);
			stmt.setString(2,Address);
			stmt.setInt(3,organizerId);
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
	@Override
	public int getOragnizerCount() {
		try {
			stmt = conn.prepareStatement("select count(*) from oragnizer;");
			rs = stmt.executeQuery();
			while(rs.next())
			{
				return rs.getInt(1);
			}
		}catch(Exception ex)
		{
			System.out.println("Error is : "+ex);
		}
		return 0;
	}

}
