package com.interview.javatest;

import java.util.List;

public class TrainModel {
	
	private List<String> arrival;
	private List<String> departure;
	public TrainModel(List<String> arrival, List<String> departure) {
		super();
		this.arrival = arrival;
		this.departure = departure;
	}
	public List<String> getArrival() {
		return arrival;
	}
	public void setArrival(List<String> arrival) {
		this.arrival = arrival;
	}
	public List<String> getDeparture() {
		return departure;
	}
	public void setDeparture(List<String> departure) {
		this.departure = departure;
	}
	@Override
	public String toString() {
		return "TrainModel [arrival=" + arrival + ", departure=" + departure + "]";
	}

}
