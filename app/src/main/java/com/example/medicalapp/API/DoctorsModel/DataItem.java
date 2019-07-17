package com.example.medicalapp.API.DoctorsModel;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("uid")
	private String uid;

	@SerializedName("specialties")
	private List<SpecialtiesItem> specialties;

	@SerializedName("licenses")
	private List<LicensesItem> licenses;

	@SerializedName("insurances")
	private List<InsurancesItem> insurances;

	@SerializedName("ratings")
	private List<Object> ratings;

	@SerializedName("npi")
	private String npi;

	@SerializedName("profile")
	private Profile profile;

	@SerializedName("educations")
	private List<Object> educations;

	@SerializedName("practices")
	private List<PracticesItem> practices;

	public void setUid(String uid){
		this.uid = uid;
	}

	public String getUid(){
		return uid;
	}

	public void setSpecialties(List<SpecialtiesItem> specialties){
		this.specialties = specialties;
	}

	public List<SpecialtiesItem> getSpecialties(){
		return specialties;
	}

	public void setLicenses(List<LicensesItem> licenses){
		this.licenses = licenses;
	}

	public List<LicensesItem> getLicenses(){
		return licenses;
	}

	public void setInsurances(List<InsurancesItem> insurances){
		this.insurances = insurances;
	}

	public List<InsurancesItem> getInsurances(){
		return insurances;
	}

	public void setRatings(List<Object> ratings){
		this.ratings = ratings;
	}

	public List<Object> getRatings(){
		return ratings;
	}

	public void setNpi(String npi){
		this.npi = npi;
	}

	public String getNpi(){
		return npi;
	}

	public void setProfile(Profile profile){
		this.profile = profile;
	}

	public Profile getProfile(){
		return profile;
	}

	public void setEducations(List<Object> educations){
		this.educations = educations;
	}

	public List<Object> getEducations(){
		return educations;
	}

	public void setPractices(List<PracticesItem> practices){
		this.practices = practices;
	}

	public List<PracticesItem> getPractices(){
		return practices;
	}

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"uid = '" + uid + '\'' + 
			",specialties = '" + specialties + '\'' + 
			",licenses = '" + licenses + '\'' + 
			",insurances = '" + insurances + '\'' + 
			",ratings = '" + ratings + '\'' + 
			",npi = '" + npi + '\'' + 
			",profile = '" + profile + '\'' + 
			",educations = '" + educations + '\'' + 
			",practices = '" + practices + '\'' + 
			"}";
		}
}