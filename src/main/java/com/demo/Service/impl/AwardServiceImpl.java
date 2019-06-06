package com.demo.Service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.PersistenceException;

import org.hibernate.JDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.demo.Constants.SSTAConstants;
import com.demo.Constants.SSTAErrorConstants;
import com.demo.Exception.ResourceNotFoundException;
import com.demo.Exception.SSTAControllerException;
import com.demo.Model.Award;
import com.demo.Model.AwardType;
import com.demo.Model.Student;
import com.demo.Repository.AwardRepository;
import com.demo.Repository.AwardTypeRepository;
import com.demo.Service.AwardService;

@Service
public class AwardServiceImpl implements AwardService {

	@Autowired
	AwardRepository awardRepository;

	@Autowired
	AwardTypeRepository awardTypeRepository;

	@Override
	@Transactional
	public List<Award> getListOfAwards() {
		Collection<Award> awdList = Optional
				.ofNullable(awardRepository.findAllEffective(new Date()))
				.orElse(new ArrayList<>());
		return awdList.stream().collect(Collectors.toList());
	}

	@Override
	@Transactional
	public Award getAward(long id)
			throws NumberFormatException, SSTAControllerException {
		return awardRepository.findById(id)
				.orElseThrow(() -> new SSTAControllerException(
						SSTAErrorConstants.A1001.getErrorCode(),
						SSTAErrorConstants.A1001.getErrorMessage(),
						this.getClass().getCanonicalName(),
						new ResourceNotFoundException(id)));

	}

	@Override
	@Transactional
	public void saveAward(Award award) throws SSTAControllerException {
		try {
			awardRepository.save(award);
		} catch (UnexpectedRollbackException | PersistenceException e) {
			throw new SSTAControllerException(
					SSTAErrorConstants.A1001.getErrorCode(),
					SSTAErrorConstants.A1001.getErrorMessage(),
					this.getClass().getCanonicalName(), e);
		}
	}

	@Override
	@Transactional
	public List<AwardType> getTypes() {
		return awardTypeRepository.findAll();
	}

	@Override
	@Transactional
	public void deleteAward(long id) throws SSTAControllerException {
		try {
			awardRepository.deleteById(id);
		} catch (JDBCException e) {
			throw new SSTAControllerException(
					SSTAErrorConstants.A1001.getErrorCode(),
					SSTAErrorConstants.A1001.getErrorMessage(),
					this.getClass().getCanonicalName(), e);
		}
	}

	@Override
	@Transactional
	public List<Award> getListOfAwardsByAwardType(String typeName) {
		return awardTypeRepository.findByName(typeName).getAwardList();
	}
}
