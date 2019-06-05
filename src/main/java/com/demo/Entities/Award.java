package com.demo.Entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "TABLE_AWARD")
public class Award {
	
//	private List<Award> awards;
	
	public Award(BigDecimal id, String awardName, String awardDesc,
			Date startDate, Date endDate, Student student) {
		super();
		this.id = id;
		this.awardName = awardName;
		this.awardDesc = awardDesc;
		this.startDate = startDate;
		this.endDate = endDate;
		this.student = student;
	}

	/**
	 * Id
	 */
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(precision = 19, scale = 0)
	private BigDecimal id;
	
	/**
	 * awardName
	 */
	@Column(name = "AWARD_NAME", length = 255)
	private String awardName;
	
	/**
	 * AwardDescription
	 */
	@Column(name = "AWARD_DESCRIPTION", length = 255)
	private String awardDesc;
	
	/**
	 * StartDate
	 */
	@Column(name = "EFFECTIVE_DATE", length = 255)
	private Date startDate;
	
	/**
	 * EndDate
	 */
	@Column(name = "END_DATE", length = 255)
	private Date endDate;
	
	 /** The Student */
	@ManyToOne
	@JoinColumn(name = "STUDENT_ID")
	private Student student;
	
	
	public String getAwardDesc() {
		return awardDesc;
	}

	public void setAwardDesc(String awardDesc) {
		this.awardDesc = awardDesc;
	}

	public String getAwardName() {
		return awardName;
	}

	public void setAwardName(String awardName) {
		this.awardName = awardName;
	}
	

	
	/**
	   * Gets the Student.
	   *
	   * @return the student
	   */
	public Student getStudent() {
		return student;
	}

   /**
    * Sets the Student.
    *
    * @param Student
    */

	public void setStudent(Student student) {
		this.student = student;
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}
	
//	@Override
//	  public String toString() {
//	    return "name=" + this.awardName + "|" + "descr=" + awardDesc;
//	  }
	
	/**
	 * Default Constructor
	 */
	public Award() {
	}
	
}
