package com.example.medicalapp.API.SymptomModel;

import com.google.gson.annotations.SerializedName;

public class SymptomResponse{

	@SerializedName("ID")
	private int iD;

	@SerializedName("Name")
	private String name;

	public void setID(int iD){
		this.iD = iD;
	}

	public int getID(){
		return iD;
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
			"SymptomResponse{" + 
			"iD = '" + iD + '\'' + 
			",name = '" + name + '\'' + 
			"}";
		}
}