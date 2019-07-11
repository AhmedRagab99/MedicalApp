package com.example.medicalapp.API.InferamidicaModel;


import com.google.gson.annotations.SerializedName;

public class MentionsItem{

	@SerializedName("orth")
	private String orth;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private String id;

	@SerializedName("common_name")
	private String commonName;

	@SerializedName("type")
	private String type;

	@SerializedName("choice_id")
	private String choiceId;

	public void setOrth(String orth){
		this.orth = orth;
	}

	public String getOrth(){
		return orth;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setCommonName(String commonName){
		this.commonName = commonName;
	}

	public String getCommonName(){
		return commonName;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setChoiceId(String choiceId){
		this.choiceId = choiceId;
	}

	public String getChoiceId(){
		return choiceId;
	}

	@Override
 	public String toString(){
		return 
			"MentionsItem{" + 
			"orth = '" + orth + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",common_name = '" + commonName + '\'' + 
			",type = '" + type + '\'' + 
			",choice_id = '" + choiceId + '\'' + 
			"}";
		}
}