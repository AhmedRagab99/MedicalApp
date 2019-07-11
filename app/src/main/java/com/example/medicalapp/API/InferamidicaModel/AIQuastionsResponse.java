package com.example.medicalapp.API.InferamidicaModel;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class AIQuastionsResponse{

	@SerializedName("mentions")
	private List<MentionsItem> mentions;

	@SerializedName("obvious")
	private boolean obvious;

	public void setMentions(List<MentionsItem> mentions){
		this.mentions = mentions;
	}

	public List<MentionsItem> getMentions(){
		return mentions;
	}

	public void setObvious(boolean obvious){
		this.obvious = obvious;
	}

	public boolean isObvious(){
		return obvious;
	}

	@Override
 	public String toString(){
		return 
			"AIQuastionsResponse{" + 
			"mentions = '" + mentions + '\'' + 
			",obvious = '" + obvious + '\'' + 
			"}";
		}
}