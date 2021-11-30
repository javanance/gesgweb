//EServiceTiming.java
package com.gof.enums;

import lombok.Getter;

@Getter
public enum EServiceTiming {

	  ALL(true, true)
	, CURRENT(true, false)
	, FUTURE(false, true);

	private boolean isCurrent;
	private boolean isFuture;
//	private Predicate<CfLv4Df>	predicate;

	private EServiceTiming(boolean isCurrent, boolean isFuture) {
		this.isFuture = isFuture;
		this.isCurrent = isCurrent;
//		this.predicate = predicate;
	}

//	public boolean isApplied(CfLv4Df cf) {
//		return predicate.test(cf);
//	}

}
