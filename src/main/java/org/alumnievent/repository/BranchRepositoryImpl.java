package org.alumnievent.repository;

import java.util.ArrayList;
import java.util.List;

import org.alumnievent.config.DBConfig;
import org.alumnievent.model.BranchModel;

public class BranchRepositoryImpl extends DBConfig implements BranchRepository{
	int BranchId;
	int BId = 0;
	int getAutoBranchId()
	{
		try {
			stmt = conn.prepareStatement("select  max(BranchId) from branch");
			rs=stmt.executeQuery();
			if(rs.next())
			{
				BId=rs.getInt(1);
			}
			return ++BId;
		}catch(Exception ex)
		{
			System.out.println("Error Id Not Present "+ex);
			return(-1);
		}
	}
	@Override
	public int getBranchId(int CollegeId) {
		try {
			stmt = conn.prepareStatement("select BranchId from branch where CollegeId = "+CollegeId);
			rs = stmt.executeQuery();
			if(rs.next())
			{
				BranchId = rs.getInt(1);
			}
			return BranchId;
		}catch(Exception ex)
		{
			System.out.println("Error is BranchId "+ex);
			return -1;
		}
	}
	@Override
	public boolean isAddNewBranch(BranchModel model,int CollegeId) {
		try
		{   String bname;
		boolean  flag=false;
			stmt=conn.prepareStatement("select *from branch where CollegeId=?");
			stmt.setInt(1, CollegeId);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				bname=rs.getString("BranchName");
				if(bname.equals(model.getBranchName()))
				{
					flag=true;
				}
			}
			if(!flag)
			
			{
			int bid=this.getAutoBranchId();
			stmt = conn.prepareStatement("insert into branch values(?,?,?)");
			stmt.setInt(1,bid);
			stmt.setString(2,model.getBranchName());
			stmt.setInt(3, CollegeId);
			int value = stmt.executeUpdate();
			return value>0?true:false;
			}
			else {
				System.out.println("alredy there");
				return false;
			}
		}catch(Exception ex)
		{
			System.out.println("Error Branch Not Added"+ex);
			return false;
		}
	}
	@Override
	public String getBranchNameById(int branchId, int collegeid) {
			try {
				String branchName = null;
				stmt = conn.prepareStatement("select BranchName from branch where BranchId = ? and CollegeId = ?");
				stmt.setInt(1,branchId);
				stmt.setInt(2, collegeid);
				rs = stmt.executeQuery();
				if(rs.next())
				{
					branchName = rs.getString("BranchName");
				}
				return branchName!=null?branchName:null;
			}catch(Exception ex)
			{
				System.out.println("Error is "+ex);
			}
		return null;
	}
	@Override
	public List<BranchModel> getCollegeWiseBranch(int collegeid) {
		try {
			List<BranchModel> list=new ArrayList<BranchModel>();
			BranchModel bModel;
			stmt=conn.prepareStatement("select *from branch where CollegeId=?");
			stmt.setInt(1, collegeid);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				bModel=new BranchModel(); 
				bModel.setBranchId(rs.getInt(1));
				bModel.setBranchName(rs.getString(2));
				bModel.setCollegeId(rs.getInt(3));
				
				list.add(bModel);	
			}
			return list!=null?list:null;
		}catch(Exception ex)
		{
			System.out.println("Exception is"+ex);
			return null;
		}
	}

}
