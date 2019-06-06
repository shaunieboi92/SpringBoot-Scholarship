package com.demo.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.Constants.SSTAConstants;
import com.demo.Exception.SSTAControllerException;
import com.demo.Model.Award;
import com.demo.Model.AwardType;
import com.demo.Model.Student;
import com.demo.Repository.AwardRepository;
import com.demo.Repository.AwardTypeRepository;

public interface AwardService {

	public List<Award> getListOfAwards();
	
	public void saveAward(Award award) throws SSTAControllerException;
	
	public Award getAward(long id) throws SSTAControllerException;
	
	public List <AwardType> getTypes();
	
	public List<Award> getListOfAwardsByAwardType(String typeName);
	
	public void deleteAward(long id) throws SSTAControllerException;
	
}
