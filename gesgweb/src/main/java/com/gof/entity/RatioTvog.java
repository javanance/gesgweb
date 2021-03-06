//RatioTvog.java
package com.gof.entity;
//Generated 2020. 1. 16 ���� 3:15:14 by Hibernate Tools 5.1.0.Beta1

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
* RstTvogRatio generated by hbm2java
*/
@Entity
@Table(name = "RATIO_TVOG")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RatioTvog implements java.io.Serializable {
	private static final long serialVersionUID = -8151467682976876533L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PK_SEQUENCE_JPA")
	private Long pkSeq;
	
	private String baseYymm;
	private String prodCd;
	private String tvogCalcType;
	
	private Double tvogRatio;
	private Double tvogAmt;
	
	private String lastModifiedBy;
	private LocalDateTime lastModifiedDate;
	
	@Override
	public boolean equals(Object arg0) {
		return super.equals(arg0);
	}
	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
