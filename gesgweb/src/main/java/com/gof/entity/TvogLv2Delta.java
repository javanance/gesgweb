//TvogLv2Delta.java
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
* RstRa generated by hbm2java
*/
@Entity
@Table(name = "TVOG_LV2_DELTA")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TvogLv2Delta implements java.io.Serializable {
	private static final long serialVersionUID = -8151467682976876533L;

	@Id
	@SequenceGenerator(name="PK_SEQUENCE_JPA", sequenceName="PK_SEQUENCE", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PK_SEQUENCE_JPA")
	private Long pkSeq;	
	
	
	private String baseYymm;
	private String gocId;
	
	
//	@ManyToOne
//	@JoinColumn(name = "RUNSET_ID")
//	@Id private MstRunsetOther runset;
	private String runsetId;
	private String deltaGroup;
	
	
	private Double tvogAmt;
	private Double prevTvogAmt;
	private Double deltaTvogAmt;
	
	private String priorDeltaGroup;

	
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