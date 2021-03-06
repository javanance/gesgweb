//RstBoxGoc.java
package com.gof.entity;
//Generated 2020. 1. 16 ���� 3:15:14 by Hibernate Tools 5.1.0.Beta1

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.gof.enums.EBoolean;
import com.gof.enums.EContStatus;
import com.gof.enums.ELiabType;
import com.gof.interfaces.IBoxRst;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
* RstEpv generated by hbm2java
*/
@Entity
@Table(name = "RST_BOX")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RstBoxGoc implements java.io.Serializable, IBoxRst {
	private static final long serialVersionUID = -8151467682976876533L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PK_SEQUENCE_JPA")
	private Long pkSeq;	
	
	
	
	private String baseYymm;
	private String gocId;
	
	@Enumerated(EnumType.STRING)
	private ELiabType liabType;

	@ManyToOne
	@JoinColumn(name = "RUNSET_ID")
	private MstRunset mstRunset;
	
	private String calcId;
	
	@Enumerated(EnumType.STRING)
	private EContStatus stStatus;
	
	@Enumerated(EnumType.STRING)
	private EContStatus endStatus;
	
	@Enumerated(EnumType.STRING)
	private EBoolean newContYn;
	
	private Integer slidingNum;	 
	private Double cfAmt;
	private Double prevCfAmt;
	private Double deltaCfAmt;
	private Double boxValue;
	private Double appliedRate;
	
	private String remark;
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
	@Override
	public String toString() {
	 	 StringBuilder builder = new StringBuilder();
	 	 return builder
	 	 	.append(baseYymm).append(",")
	 	 	.append(gocId).append(",")
	 	 	.append(liabType).append(",")
	 	 	.append(mstRunset.getRunsetId()).append(",")
	 	 	.append(calcId).append(",")
	 	 	.append(stStatus).append(",")
	 	 	.append(endStatus).append(",")
	 	 	.append(newContYn).append(",")
	 	 	.append(cfAmt).append(",")
	 	 	.toString(); 
	}
	
	
	public String getPk() {
	 	 StringBuilder builder = new StringBuilder();
	 	 return builder
	 	 	.append(baseYymm).append(",")
	 	 	.append(gocId).append(",")
	 	 	.append(liabType).append(",")
	 	 	.append(mstRunset).append(",")
	 	 	.append(calcId).append(",")
	 	 	.append(stStatus).append(",")
	 	 	.append(endStatus).append(",")
	 	 	.append(newContYn).append(",")
	 	 	.toString(); 
	}
	public RstBoxGoc(String baseYymm, String gocId, ELiabType liabType, MstRunset mstRunset, String calcId, EContStatus stStatus,
			EContStatus endStatus, EBoolean newContYn, Double cfAmt, Double prevCfAmt, Double deltaCfAmt, Double boxValue) {
		
		this.baseYymm = baseYymm;
		this.gocId = gocId;
		this.liabType = liabType;
		this.mstRunset = mstRunset;
		this.calcId = calcId;
		this.stStatus = stStatus;
		this.endStatus = endStatus;
		this.newContYn = newContYn;
		this.cfAmt = cfAmt;
		this.prevCfAmt = prevCfAmt;
		this.deltaCfAmt = deltaCfAmt;
		this.boxValue = boxValue;
		
		this.slidingNum=0;
		this.appliedRate=0.0;
//		this.lastModifiedBy=GmvConstant.getLastModifier();
		this.lastModifiedDate= LocalDateTime.now();
	}
	
	public RstBoxGoc(String baseYymm, String gocId, ELiabType liabType, MstRunset mstRunset, String calcId, Double boxValue) {
		this.baseYymm = baseYymm;
		this.liabType =liabType;
		this.gocId = gocId;
		this.mstRunset = mstRunset;
		this.calcId = calcId;
		this.boxValue = boxValue;
	}
	
	@Override
	public String getRunsetId() {
		return mstRunset.getRunsetId();
	}
	
}