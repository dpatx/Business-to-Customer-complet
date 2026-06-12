package com.zensar.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.dto.AdvertiseDto;
import com.zensar.service.AdvertiseService;

@RestController
@RequestMapping("/olx-advertise")
public class AdvertiseController {

	@Autowired
	AdvertiseService advertiseService;
	
	//Service 8
	@PostMapping(value="/advertise", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AdvertiseDto> postNewAdvertise(@RequestBody AdvertiseDto advertiseDto,
			@RequestHeader("Authorization")String authToken) {
		return new ResponseEntity<AdvertiseDto>(advertiseService.postNewAdvertise(advertiseDto, authToken), HttpStatus.OK);
	}
	
	//Service 13
	@GetMapping(value="/advertise/search/filtercriteria", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AdvertiseDto>> searchAdvertiseByFilterCriteria(
			@RequestParam(value="searchText", required=false) String searchText,
			@RequestParam(value="category", required=false) String category,
			@RequestParam(value="postedBy", required=false) String postedBy,
			@RequestParam(value="dateCondition", required=false) String dateCondition,
			@RequestParam(value="onDate", required=false)
				@DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate onDate,
			@RequestParam(value="fromDate", required=false)
				@DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate fromDate,
			@RequestParam(value="toDate", required=false)
				@DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate toDate,
			@RequestParam(value="sortBy", required=false) String sortBy,
			@RequestParam(value="pageNo", required=false, defaultValue = "0") int pageNo,
			@RequestParam(value="pageSize", required=false, defaultValue = "10") int pageSize
			) {
		return new ResponseEntity<List<AdvertiseDto>>(
				advertiseService.searchAdvertiseByFilterCriteria(searchText, category, postedBy, dateCondition, onDate, fromDate, toDate, sortBy, pageNo, pageSize), 
				HttpStatus.OK);
	}
}

// http://localhost:8080/olx-advertise/advertise/search/filtercriteria?onDate=03-06-2026&searchText=bag&dateCondition=equals&onDate=03-06-2026









