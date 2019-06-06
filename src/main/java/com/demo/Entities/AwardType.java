package com.demo.Entities;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * id name
 */

@Entity
@Table(name = "TABLE_AWARD_TYPE")
public class AwardType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(precision = 19, scale = 0)
	private BigDecimal id;

	@Column(name = "NAME", length = 255)
	@NotBlank
	private String typeName;
	
	/**
	 * The awards
	 * OneToMany
	 */
	@OneToMany(targetEntity = Award.class, mappedBy = "awardType", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Award> awardList;

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	@JsonIgnore
	public List<Award> getAwardList() {
		return awardList;
	}

	public void setAwardList(List<Award> awardList) {
		this.awardList = awardList;
	}
	
	public AwardType() {
		
	}
}
