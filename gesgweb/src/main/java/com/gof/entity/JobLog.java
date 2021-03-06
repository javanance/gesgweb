//JobLog.java
package com.gof.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name ="JOB_INFO")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class JobLog implements Serializable{
	private static final long serialVersionUID = -8151467682976876533L;
	
//	 SEQ PK부여
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PK_SEQUENCE_JPA")
	private Long pkSeq;
	
	private String jobId;
	private String calcStart;

	private String calcEnd;
	private String jobNm;
	private String baseYymm;
	private String calcDate;
//	private Double calcElps;
	private String calcElps;
	private String calcScd;
	private String esgLogInfo;
	
	@Transient
	private LocalDateTime jobStart;
	
	private String lastModifiedBy;
	private LocalDateTime lastUpdateDate;
	
	
	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		return super.equals(arg0);
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
}

