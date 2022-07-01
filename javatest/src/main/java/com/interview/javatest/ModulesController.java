package com.interview.javatest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ModulesController {

	@Autowired
	private JavaTestService service;
	
	@PostMapping("/students")
	public ResponseEntity<?> getStudentFilter(@RequestBody List<Integer> scoreList){
		try {
			List<String> studentlist = service.filterStudentsOnScore(scoreList);
			return ResponseEntity.ok(studentlist);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/trains")
	public ResponseEntity<?> getMinNumofPlatform(@RequestBody TrainModel requestModel){
		try {
			List<String> arrtime = requestModel.getArrival();
			List<String> deptime = requestModel.getDeparture();
			Integer numOfPlatfomrs = service.findNumberOfPlatforms(arrtime, deptime);
			Map<String, Integer> response = new HashMap<String, Integer>();
			response.put("platforms", numOfPlatfomrs);
			return ResponseEntity.ok(response);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
