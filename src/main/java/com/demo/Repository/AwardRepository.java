package com.demo.Repository;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.demo.Entities.Award;


@Repository
public interface AwardRepository extends JpaRepository<Award, BigDecimal> {

	/**
	 * Find by valid date
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	@Query("SELECT f FROM Award f where LOWER(:toDate) >= LOWER (f.startDate) AND LOWER(:toDate) <= LOWER(f.endDate)")
	Collection<Award> findAllEffective(@Param("toDate") Date toDate);

}
