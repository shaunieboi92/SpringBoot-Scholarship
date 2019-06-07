package com.demo.Controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Constants.SSTAConstants;
import com.demo.Exception.SSTAControllerException;
import com.demo.Model.Award;
import com.demo.Model.AwardType;
import com.demo.Repository.AwardRepository;
import com.demo.Repository.AwardTypeRepository;
import com.demo.Service.AwardService;
import com.demo.Service.StudentService;

@RestController
@RequestMapping(SSTAConstants.MAIN)
public class AwardController {

	@Autowired
	private AwardService awardService;

	/**
	 * findAwardbyId
	 * 
	 * @param id
	 * @return Award
	 */
	@GetMapping(value = SSTAConstants.AWARD + "/{id}")
	public ResponseEntity<Award> findAwardbyId(@PathVariable Long id)
			throws NumberFormatException, SSTAControllerException {
		return new ResponseEntity<Award>(awardService.getAward(id), HttpStatus.OK);
	}

	/**
	 * getListOfAwards
	 * 
	 * @return List
	 */
	@GetMapping(value = SSTAConstants.AWARD)
	public List<Award> getListOfAwards() {
		return awardService.getListOfAwards();
	}

	/**
	 * gettingListofAwardTypes
	 * 
	 * @return list
	 */
	@RequestMapping(value = SSTAConstants.AWARD + SSTAConstants.AWARD_TYPE)
	public List<AwardType> getListOfAwardType() {
		return awardService.getTypes();
	}

	/**
	 * gettingListofAwardByAwardType
	 * 
	 * @return list
	 */
	@RequestMapping(value = SSTAConstants.AWARD + SSTAConstants.AWARD_TYPE
			+ "/{typeName}")
	public List<Award> getListOfAwardsByAwardType(
			@PathVariable String typeName) {
		return awardService.getListOfAwardsByAwardType(typeName);
	}
}
