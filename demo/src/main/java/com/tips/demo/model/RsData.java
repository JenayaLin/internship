package com.tips.demo.model;

import java.util.ArrayList;

public class RsData {
	
	private String fetchingStatus = "Success";
	private ArrayList<Topic> reponseArrayList = new ArrayList<Topic>();

	public String getFetchingStatus() {
		return fetchingStatus;
	}

	public void setFetchingStatus(String fetchingStatus) {
		this.fetchingStatus = fetchingStatus;
	}

	public ArrayList<Topic> getReponseArrayList() {
		return reponseArrayList;
	}

	public void setReponseArrayList(ArrayList<Topic> reponseArrayList) {
		this.reponseArrayList = reponseArrayList;
		;
	}

}
