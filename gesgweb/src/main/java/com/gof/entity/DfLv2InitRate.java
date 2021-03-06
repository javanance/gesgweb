//DfLv2InitRate.java
package com.gof.entity;

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
* DfLv2InitRate generated by hbm2java
*/
@Entity
@Table(name = "DF_LV2_INIT_RATE")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class DfLv2InitRate implements java.io.Serializable {
	private static final long serialVersionUID = -8151467682976876533L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PK_SEQUENCE_JPA")
	private Long pkSeq;
	
	private String gocId;
	private Double cfMonthNum;
	
	private String initCurveYymm;
	
	private Double initRate;
	private Double initFwdRate;
	
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
