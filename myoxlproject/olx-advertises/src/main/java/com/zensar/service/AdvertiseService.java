package com.zensar.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.zensar.dto.AdvertiseDto;
import com.zensar.entity.AdvertiseEntity;

public interface AdvertiseService {

	public List<AdvertiseDto> searchAdvertiseByFilterCriteria(
			String searchText, String category, String postedBy, String dateCondition, LocalDate onDate,
			LocalDate fromDate, LocalDate toDate, String sortBy, int pageNo, int pageSize);
	
	public AdvertiseDto postNewAdvertise(AdvertiseDto advertiseDto,String authToken);
}
