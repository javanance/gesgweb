//RstRollFwd.java
package com.gof.entity;
//Generated 2020. 1. 16 ���� 3:15:14 by Hibernate Tools 5.1.0.Beta1

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.gof.enums.ECoa;
import com.gof.enums.EOperator;
import com.gof.enums.ERollFwdType;
import com.gof.interfaces.IBoxRst;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
* RstRollFwd generated by hbm2java
*/
@Entity
@Table(name = "RST_ROLL_FWD")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class RstRollFwd implements java.io.Serializable, IBoxRst {
	private static final long serialVersionUID = -8151467682976876533L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PK_SEQUENCE_JPA")
	private Long pkSeq;	
	
	
	private String baseYymm;
	private String gocId;
	
	@Enumerated(EnumType.STRING)
	private ECoa coaId;
	
	private String 	runsetId;				//TODO Enum change
//	@Id	private String 	calcId;					//TODO Enum change
	
	@ManyToOne
	@JoinColumn(name = "CALC_ID")
	private MstCalc	mstCalc;					//TODO Enum change

	@Enumerated(EnumType.STRING)
	private ERollFwdType	rollFwdType;		//TODO Enum change
	
	private int rollFwdSeq;
	private int runsetSeq;
	
	@Enumerated(EnumType.STRING)
	private EOperator operatorType;
	
	private Double boxAmt;
	private Double deltaAmt;
	private Double closeAmt;
	
	private String remark;
	private String lastModifiedBy;
	private LocalDateTime lastModifiedDate;
	
	
	
//	public double getAppliedAmt() {
//		if(ECalcMethod.CSM_PREV.equals(mstCalc.getCalcMethod())) {
////		if(mstCalc.getCalcMethod()!=null && mstCalc.getCalcMethod().equals(ECalcMethod.CSM_PREV)) {
//			return Math.max(boxAmt, 0.0);
//		}
//		return boxAmt;
//	}
	
	public String getPk() {
		return rollFwdType+getCalcId();
	}
	
	public String getCalcId() {
		return mstCalc.getCalcId();
	}
	
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
			 	 	.append(coaId).append(",")
			 	 	.append(rollFwdType).append(",")
			 	 	.append(runsetId).append(",")
			 	 	.append(mstCalc.getCalcId())
			 	 	.toString(); 
	}

	@Override
	public Double getBoxValue() {
		
		return rollFwdType.isClose()? closeAmt:boxAmt;
	}
}