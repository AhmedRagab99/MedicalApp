package com.example.medicalapp.API.DrugModel;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class RecordsItem{

	@SerializedName("immunotherapy")
	private boolean immunotherapy;

	@SerializedName("name")
	private String name;

	@SerializedName("anti_neoplastic")
	private boolean antiNeoplastic;

	@SerializedName("alias")
	private List<String> alias;

	@SerializedName("chembl_id")
	private String chemblId;

	@SerializedName("fda_approved")
	private boolean fdaApproved;

	public void setImmunotherapy(boolean immunotherapy){
		this.immunotherapy = immunotherapy;
	}

	public boolean isImmunotherapy(){
		return immunotherapy;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setAntiNeoplastic(boolean antiNeoplastic){
		this.antiNeoplastic = antiNeoplastic;
	}

	public boolean isAntiNeoplastic(){
		return antiNeoplastic;
	}

	public void setAlias(List<String> alias){
		this.alias = alias;
	}

	public List<String> getAlias(){
		return alias;
	}

	public void setChemblId(String chemblId){
		this.chemblId = chemblId;
	}

	public String getChemblId(){
		return chemblId;
	}

	public void setFdaApproved(boolean fdaApproved){
		this.fdaApproved = fdaApproved;
	}

	public boolean isFdaApproved(){
		return fdaApproved;
	}

	@Override
 	public String toString(){
		return 
			"RecordsItem{" + 
			"immunotherapy = '" + immunotherapy + '\'' + 
			",name = '" + name + '\'' + 
			",anti_neoplastic = '" + antiNeoplastic + '\'' + 
			",alias = '" + alias + '\'' + 
			",chembl_id = '" + chemblId + '\'' + 
			",fda_approved = '" + fdaApproved + '\'' + 
			"}";
		}
}