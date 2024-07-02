package org.alumnievent.config;

import java.util.ArrayList;
import java.util.List;

import org.alumnievent.model.AlumniModel;

public class Repo extends DBConfig {

	List<AlumniModel> li = new ArrayList<>();
	public List<AlumniModel> getAllAlumni()
	{
		
		try {
			stmt = conn.prepareStatement("select *from alumni");
			rs = stmt.executeQuery();
			while(rs.next())
			{
				AlumniModel model = new AlumniModel();
				model.setAlumniId(rs.getInt(1));
				model.setAlumniName(rs.getString(2));
				model.setAlumniEmail(rs.getString(3));
				model.setAlumniContact(rs.getString(4));
				li.add(model);
			}
			return li.size()>0?li:null;
		}catch(Exception ex)
		{
			System.out.println("Error is : "+ex);
			return null;
		}
	}
	
	public List<AlumniModel> getAlumniByName(String name)
	{
		try {
			stmt = conn.prepareStatement("select *from alumni where AlumniName like '%"+name+"%' ");
			rs = stmt.executeQuery();
			while(rs.next())
			{
				AlumniModel model = new AlumniModel();
				model.setAlumniId(rs.getInt(1));
				model.setAlumniName(rs.getString(2));
				model.setAlumniEmail(rs.getString(3));
				model.setAlumniContact(rs.getString(4));
				li.add(model);
			}
			return li.size()>0?li:null;
		}catch(Exception ex)
		{
			System.out.println("Error is "+ex);
			return null;
		}
	}
}
