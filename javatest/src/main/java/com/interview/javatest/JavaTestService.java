package com.interview.javatest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TimeZone;

import org.springframework.stereotype.Service;

@Service
public class JavaTestService {
	
//	Use nested conditional operators to solve this problem:
	/*
	 * Students with academic scores >= 90 are represented by A, those with scores
	 * between 60 and 89 are represented by B, and those with scores below 60 are
	 * represented by C.
	 */
	public List<String> filterStudentsOnScore(List<Integer> scoreList) {
		int score = 0;
		List<String> studentList = new ArrayList<>();
		String student = "";
		for(int i=0; i<scoreList.size(); i++) {
			score = scoreList.get(i);
			if(score>=90) {
				student = "A";
			}else if(score>60 && score<89) {
				student = "B";
			}else if(score<=60) {
				student = "C";
			}
			studentList.add(student);
		}
		System.out.println(studentList);
		return studentList;
	}
	
//	Product availability problem
	public Boolean checkServiceAvailability(String timeZone) {
		Boolean isAvailable = false;
		String format = "HH:mm";
		SimpleDateFormat isdf = new SimpleDateFormat(format);
		isdf .setTimeZone(TimeZone.getTimeZone(timeZone));
	    String timestamp = isdf.format(new Date());
	    Integer intTime = Integer.parseInt(timestamp.replace(":", "").trim());
	    System.out.println(timestamp);
	    if(intTime>=900 && intTime<=1800) {
	    	isAvailable = true;
	    }else
	    	isAvailable = false;
	    System.out.println(isAvailable);
		return isAvailable;
	}
	
//	Number calling function
	public void bankCounterSortin() {
		Queue<Integer> q1 = new LinkedList<Integer>();
		Queue<Integer> q2 = new LinkedList<Integer>();
		Queue<Integer> q3 = new LinkedList<Integer>();
		q1.add(1);
		q1.add(2);
		q1.add(3);
		q1.add(4);
		
		q2.add(5);
		q2.add(6);
		q2.add(7);
		
		q3.add(8);
		q3.add(9);
		q3.add(10);
		
		int i =1;
		int q1size = q1.size();
		int q2size = q2.size();
		int q3size = q3.size();
		while(i<=q1size || i<=q2size || i<=q3size) {
			if(!q1.isEmpty()) {
				int window1 = q1.poll();
				System.out.println("window 1 call no.: "+window1);
				System.out.println("remaining queue: "+q1);
			}
			
			if(!q2.isEmpty()) {
				int window2 = q2.poll();
				System.out.println("windown 2 call no.: "+window2);
				System.out.println("remaining queue: "+q2);
			}
			
			if(!q3.isEmpty()) {
				int window3 = q3.poll();
				System.out.println("window 3 call no.: "+window3);
				System.out.println("remaining queue: "+q3);
			}
			i++;
		}
	}
	
//	 Find the minimum number of platforms in a train station
	public Integer findNumberOfPlatforms(List<String> arrtime, List<String> deptime) {
		Boolean containstrue = false;
		Integer minNumOfPlatform = 1;
		for(int i=0; i<deptime.size(); i++) {
			Integer depAt = Integer.parseInt(deptime.get(i).replace(":", "").trim());
			List<Boolean> occupied = new ArrayList<Boolean>();
			for(int j=i+1; j<arrtime.size(); j++) {
				Integer arrAt = Integer.parseInt(arrtime.get(j).replace(":", "").trim());
				if(depAt>arrAt) {
					occupied.add(true);
				}else
					occupied.add(false);
			}
			System.out.println(occupied);
			for(int k =0; k<occupied.size(); k++) {
				if(occupied.get(k)==true || occupied.isEmpty()) {
					containstrue = true;
					break;
				}else
					containstrue = false;
			}
			if(containstrue==true) {
				minNumOfPlatform = minNumOfPlatform + 1;
			}
		}
		System.out.println("number of platforms: "+minNumOfPlatform);
		return minNumOfPlatform;
	}
	
//	public static void main(String[] args) {
//		ScoreFilterService service = new ScoreFilterService();
//		service.findNumberOfPlatforms();
//	}
	
}
