//DfLv1CurrRate.java
package com.gof.entity;
//Generated 2020. 1. 16 ���� 3:15:14 by Hibernate Tools 5.1.0.Beta1

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.EnumMap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.gof.enums.EBoxModel;
import com.gof.enums.ECompound;
import com.gof.interfaces.Compoundable;
import com.gof.util.DateUtil;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
* DfLv1CurrRate generated by hbm2java
*/
@Entity
@Table(name = "DF_LV1_CURR_RATE")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class DfLv1CurrRate implements java.io.Serializable , Compoundable{
	private static final long serialVersionUID = -8151467682976876533L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PK_SEQUENCE_JPA")
	private Long pkSeq;
	
	private String baseYymm;
	private String irCurveId;
	private Double cfMonthNum;
	
	private Double rfRate;
	private Double spread;
	
	private Double adjRfRate;
	private Double adjRfFwdRate;
	
	private String lastModifiedBy;
	private LocalDateTime lastUpdateDate;
	
	@Override
	public boolean equals(Object arg0) {
		return super.equals(arg0);
	}
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	public double getAppliedRate() {
		return adjRfRate;
	}
	
	public Double getForwardingCfMonthNum(double forwardingNum) {
		return cfMonthNum - forwardingNum;
	}
	
	public double getDf() {
		return ECompound.Annualy.getDf(getAppliedRate(), cfMonthNum/12.0); 
	}
	
	public double getForward(double forwardingNum, double forwardTermRate) {
		double nearDf = ECompound.Annualy.getDf(forwardTermRate, forwardingNum);
		double fwdDf = getDf() / nearDf;
		return Math.pow(fwdDf, 12.0 / (cfMonthNum - forwardingNum))-1; 
	}
	
	@Override
	public ECompound getCompound() {
		return ECompound.Annualy;
	}
	
	@Override
	public LocalDate getBaseDate() {
		return DateUtil.convertFrom(baseYymm); 
	}
	@Override
	public double getCurrTimeFactor() {
		if(cfMonthNum < 0.0 ) {
			return 0.0;
		}
		return cfMonthNum/12.0;
	}
	
	@Override
	public double getPrevTimeFactor() {
		return cfMonthNum  / 12.0;  
	}
	
	@Override
	public double getPrevRate() {
		return getAppliedRate();
	}
	@Override
	public double getCurrRate() {
		return getAppliedRate();
	}
	@Override
	public double getFirstNewContTimeFactor() {
		return cfMonthNum  / 12.0;  
	}
	@Override     
	public double getSecondNewContTimeFactor() {
		return cfMonthNum  / 12.0;  
	}
	@Override
	public double getThirdNewContTimeFactor() {
		return cfMonthNum  / 12.0;
	}
	@Override
	public double getPrevSysRate() {
		return getAppliedRate();
	}
	@Override
	public double getInitRate() {
		return getAppliedRate();
	}
	@Override
	public double getCurrSysRate() {
		return getAppliedRate();
	}
	@Override
	public double getFirstNewContRate() {
		return getAppliedRate();
	}
	@Override
	public double getSecondNewContRate() {
		return getAppliedRate();
	}
	@Override
	public double getThirdNewContRate() {
		return getAppliedRate();
	}
	@Override
	public EnumMap<EBoxModel, Double> getBoxValueMap() {
		return null;
	}
}
