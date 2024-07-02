package org.alumnievent.model;

public class AlumniModel {
	@Override
	public String toString() {
		return "AlumniModel [AlumniId=" + AlumniId + ", AlumniName=" + AlumniName + ", AlumniEmail=" + AlumniEmail
				+ ", AlumniContact=" + AlumniContact + ", AlumniAddress=" + AlumniAddress + ", AlumniGender="
				+ AlumniGender + ", AlumniPassword=" + AlumniPassword + ", PassOutYear=" + PassOutYear + ", BranchId="
				+ BranchId + ", CollegeId=" + CollegeId + "]";
	}
	private int AlumniId;
	private String AlumniName;
	private String AlumniEmail;
	private String AlumniContact;
	private String AlumniAddress;
	private String AlumniGender;
	private String AlumniPassword;
	private int PassOutYear;
	public int getAlumniId() {
		return AlumniId;
	}
	public void setAlumniId(int alumniId) {
		AlumniId = alumniId;
	}
	public String getAlumniName() {
		return AlumniName;
	}
	public void setAlumniName(String alumniName) {
		AlumniName = alumniName;
	}
	public String getAlumniEmail() {
		return AlumniEmail;
	}
	public void setAlumniEmail(String alumniEmail) {
		AlumniEmail = alumniEmail;
	}
	public String getAlumniContact() {
		return AlumniContact;
	}
	public void setAlumniContact(String alumniContact) {
		AlumniContact = alumniContact;
	}
	public String getAlumniAddress() {
		return AlumniAddress;
	}
	public String getAlumniPassword() {
		return AlumniPassword;
	}
	public void setAlumniPassword(String alumniPassword) {
		AlumniPassword = alumniPassword;
	}
	public void setAlumniAddress(String alumniAddress) {
		AlumniAddress = alumniAddress;
	}
	public String getAlumniGender() {
		return AlumniGender;
	}
	public void setAlumniGender(String alumniGender) {
		AlumniGender = alumniGender;
	}
	
	public int getPassOutYear() {
		return PassOutYear;
	}
	public void setPassOutYear(int passOutYear) {
		PassOutYear = passOutYear;
	}
	public int getBranchId() {
		return BranchId;
	}
	public void setBranchId(int branchId) {
		BranchId = branchId;
	}
	public int getCollegeId() {
		return CollegeId;
	}
	public void setCollegeId(int collegeId) {
		CollegeId = collegeId;
	}
	private int BranchId;
	private int CollegeId;
	
}
