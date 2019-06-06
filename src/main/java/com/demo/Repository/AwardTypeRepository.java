package com.demo.Repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.Entities.AwardType;

@Repository
public interface AwardTypeRepository extends JpaRepository<AwardType, BigDecimal> {
	/**
	 * find List by AwardType Name
	 */
	@Query("SELECT f FROM AwardType f where LOWER (f.typeName) = LOWER(:typeName)")
	AwardType findByName(@Param("typeName") String typeName);
}
