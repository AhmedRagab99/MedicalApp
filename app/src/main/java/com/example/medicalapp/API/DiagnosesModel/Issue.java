package com.example.medicalapp.API.DiagnosesModel;

import com.google.gson.annotations.SerializedName;


public class Issue{

	@SerializedName("Accuracy")
	private double accuracy;

	@SerializedName("Ranking")
	private int ranking;

	@SerializedName("ProfName")
	private String profName;

	@SerializedName("IcdName")
	private String icdName;

	@SerializedName("ID")
	private int iD;

	@SerializedName("Icd")
	private String icd;

	@SerializedName("Name")
	private String name;

	public void setAccuracy(double accuracy){
		this.accuracy = accuracy;
	}

	public double getAccuracy(){
		return accuracy;
	}

	public void setRanking(int ranking){
		this.ranking = ranking;
	}

	public int getRanking(){
		return ranking;
	}

	public void setProfName(String profName){
		this.profName = profName;
	}

	public String getProfName(){
		return profName;
	}

	public void setIcdName(String icdName){
		this.icdName = icdName;
	}

	public String getIcdName(){
		return icdName;
	}

	public void setID(int iD){
		this.iD = iD;
	}

	public int getID(){
		return iD;
	}

	public void setIcd(String icd){
		this.icd = icd;
	}

	public String getIcd(){
		return icd;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	@Override
 	public String toString(){
		return 
			"Issue{" + 
			"accuracy = '" + accuracy + '\'' + 
			",ranking = '" + ranking + '\'' + 
			",profName = '" + profName + '\'' + 
			",icdName = '" + icdName + '\'' + 
			",iD = '" + iD + '\'' + 
			",icd = '" + icd + '\'' + 
			",name = '" + name + '\'' + 
			"}";
		}
}