package com.demo.Service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.demo.Entities.Award;
import com.demo.Repository.AwardRepository;
import com.demo.Response.SSTAServiceResponse;
import com.demo.Service.SSTAService;

//@Component
public class SSTAServiceImpl implements SSTAService {

//	@Autowired
//	AwardRepository awardRepository;
//
//	/**
//	 * Returns valid awards
//	 */
//	private List<Award> retrieveAwardList() {
//		Collection<Award> awdList = Optional.ofNullable(awardRepository
//				.findAllEffective(new Date())).orElse(new ArrayList<>());
//		return awdList.stream().collect(Collectors.toList());
//		// toString()
//
//	}

	@Override
	public SSTAServiceResponse processes(String request) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public SSTAServiceResponse processes(String request) {
//		
//	}
}
