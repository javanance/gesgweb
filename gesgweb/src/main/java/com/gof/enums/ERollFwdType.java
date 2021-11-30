//ERollFwdType.java
package com.gof.enums;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

import com.gof.interfaces.INcontRst;

public enum ERollFwdType {

PREV_CLOSE				(1, 1, 	true,	false, s-> s.getCtrPolno() )

,	PREV_LOSS_ALLO			(2, 2,	false,	false,s-> s.getProdCd())
,	PREV_REVERSAL			(3, 2, 	false,	false,s-> s.getProdCd())

,	INIT_RECOG				(4, 1,	false,	false,s-> s.getProdCd())
,   INIT_CLOSE				(5, 1,	true,	false,s-> s.getProdCd())	

,	LOSS_RECOG				(6, 3,	false,	false,s-> s.getProdCd())
,	INIT_LOSS_CLOSE			(7, 3,	true,	false,s-> s.getProdCd())

,	LOSS_TIME_RELEASE		(8, 4,	false,	false,s-> s.getProdCd())
,	LOSS_CF_RELEASE			(9, 4,	false,	false,s-> s.getProdCd())
,	LOSS_RA_RELEASE			(10,4,	 false,	false,s-> s.getProdCd())
,	LOSS_RELEASE_CLOSE		(11,4,	 true,	false,s-> s.getProdCd())

,   BEFORE_RELEASE			(12,1,	 false,	false,s-> s.getProdCd())

,   TIME_RELEASE			(13,1,	 false,	false,s-> s.getProdCd())	
,   TIME_EFFECT				(14,1,	 false,	false,s-> s.getProdCd())	
,   RATE_EFFECT				(15,1,	 false,	false,s-> s.getProdCd())	
,   ACCRET_INT				(16,1,	 false,	false,s-> s.getProdCd())

,	CF_RELEASE				(17,1,	 false,	false,s-> s.getProdCd())
,   CASH_RELEASE			(18,1,	 false,	false,s-> s.getProdCd())	

,   CURR_CHANGE_RELEASE		(19,1,	 false,	false,s-> s.getProdCd())
,   SERVICE_CLOSE			(20,1,	 true,	false,s-> s.getProdCd())	

,   TIME_CHANGE				(21,1,	 false,	false,s-> s.getProdCd())	
,   ACTU_CHANGE				(22,1,	 false,	false,s-> s.getProdCd())	
,   FINC_CHANGE				(23,1,	 false,	false,s-> s.getProdCd())	
,   DISC_CHANGE				(24,1,	 false,	false,s-> s.getProdCd())	
,   MOVE_CLOSE				(25,1,	 true,	false,s-> s.getProdCd())	

,   LOSS_REVERSAL			(26,5,	 false,	true,s-> s.getProdCd())	
,   LOSS_RESERVE			(27,5,	 false,	true,s-> s.getProdCd())	
,   LOSS_REVERSAL_CLOSE		(28,5,	 true,	false,s-> s.getProdCd())	

,   COVERAGE_RELEASE		(29,5,	 false,	false,s-> s.getProdCd())	
,   CURR_CLOSE				(30,1,	 true,	false,s-> s.getProdCd())	
,   CURR_LOSS_ALLO			(31,6,	 false,	false,s-> s.getProdCd())	
;
	private int orderNum;
	private int runGroup;
	private boolean isClose;
	
	private boolean applyOnlyPositive;
	
	private Function<INcontRst, String> keyFn;
	private Predicate<INcontRst>		keyPredicate;
	
	private ERollFwdType(int order,int runGroup, boolean isClose, boolean applyOnlyPositive, Function<INcontRst, String> keyFn) {
		this.orderNum = order;
		this.runGroup = runGroup;
		this.isClose = isClose;
		this.applyOnlyPositive = applyOnlyPositive;
		this.keyFn = keyFn;
		//this.keyPredicate = keyPredicate;
	}
	
	public int getOrderNum() {
		return orderNum;	
	}
	
	public boolean isClose() {
		return isClose;
	}
	
	public boolean isApplyOnlyPositive() {
		return applyOnlyPositive;
	}
	
	public boolean isApply(double boxValue) {
		if(applyOnlyPositive) {
			return boxValue >=0 ? true: false;
		}
		return true;
	}
	
	public Function<INcontRst, String> getKeyFn() {
		return keyFn;
	}
	
	public Predicate<INcontRst> getKeyPredicate() {
		return keyPredicate;
	}
	
	public int getRunGroup() {
		return runGroup;
	}
	
	public static Map<Integer, List<ERollFwdType>> getRollFwdTypeByGroup(){
		return Arrays.stream(ERollFwdType.values()).collect(groupingBy(ERollFwdType::getRunGroup, toList()));
	}
	
	public static List<ERollFwdType> getRollFwdTypeByGroup(int runGroup){
		return Arrays.stream(ERollFwdType.values()).filter(s->s.getRunGroup()==runGroup).collect(toList());
	}
}

