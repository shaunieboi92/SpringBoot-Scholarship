package com.demo.Repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.Model.AwardType;

@Repository
public interface AwardTypeRepository extends JpaRepository<AwardType, BigDecimal> {
	/**
	 * find List by AwardType Name
	 */
	AwardType findByName(@Param("typeName") String typeName);
}
