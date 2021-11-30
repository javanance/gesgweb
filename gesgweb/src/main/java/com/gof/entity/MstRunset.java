//MstRunset.java
package com.gof.entity;
//Generated 2020. 1. 16 ���� 3:15:14 by Hibernate Tools 5.1.0.Beta1

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.gof.enums.EBoolean;
import com.gof.enums.ECoa;
import com.gof.enums.ERsDivType;
import com.gof.util.DateUtil;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
* MstRunset generated by hbm2java
*/
@Entity
@Table(name = "MST_RUNSET")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class MstRunset implements java.io.Serializable {
	private static final long serialVersionUID = -8151467682976876533L;

	@Id private String runsetId;
	
	@Enumerated(EnumType.STRING)
	private ECoa coaId;
	private int seq;
	
	private String deltaGroup;				//TODO ?? convert to Enum
	private String priorDeltaGroup;
	
	private String rsDivId;

	@Enumerated(EnumType.STRING)
	private ERsDivType rsDivType;
	
	
	@Enumerated(EnumType.STRING)
	private EBoolean prevYn;
	
	@Enumerated(EnumType.STRING)
	private EBoolean tenorAdjYn;
	
	@Enumerated(EnumType.STRING)
	private EBoolean newContYn;
	private Integer slidingNum;

	private String comments;
	private String lastModifiedBy;
	private LocalDateTime lastModifiedDate;
	
//	public EBoolean getPrevYn() {
//		return rsDivType.getPrevYn();
//	}

	@Override
	public boolean equals(Object arg0) {
		return super.equals(arg0);
	}
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	public int getTenorAdjNum() {
		return  tenorAdjYn.isTrueFalse()? slidingNum -1 :  slidingNum ;
	}
	
//	public String getCurveYymm(String stBssd, String newContRateDiv) {
//		if(newContRateDiv.equals("CURR")) {
//			return getCashFlowYymm(stBssd);
//		}
//		return stBssd;
//	}
	
	public String getCashFlowYymm(String stBssd) {
//		return DateUtil.addMonthToString(stBssd, slidingNum);
		int adj = tenorAdjYn.isTrueFalse()? slidingNum -1 :  slidingNum ;
		return  DateUtil.addMonthToString(stBssd, adj );
	}
	
	public String getGenYymm(String stBssd) {
		return DateUtil.addMonthToString(stBssd, slidingNum);
	}
	
	public String getRsDivTypeName() {
		return rsDivType.name();
	}
	@Override
	public String toString() {
		return runsetId;
	}
}