//ELossStep.java
package com.gof.enums;

public enum ELossStep {
L1		(1,  true, 		false,	false)		//湲곗떆
,	L1_A	(1,  true, 		false,	true)		//湲곗떆
,	L1_S	(1,  true, 		false,	false)		//湲곗떆

,   L2		(2,  true, 		false,	false)		// 湲곗떆 + ?좉퀎??
, 	L2_A	(2,  true, 		false,	true)		//true  : 紐⑤뱺 CF 瑜?湲곗??쇰줈 Ratio 怨꾩궛
, 	L2_S	(2,  true,		false,	false)		//false : LOSS 諛곕텇 ??곷쭔?쇰줈 援ъ꽦??

,   L3		(3,  false, 	true,	false)	
,   L4		(4,  false, 	false,	false)

, 	L5		(5,  false, 	false,	false)		//湲곕쭚
, 	L5_A	(5,  false, 	false,	true)		//湲곕쭚
, 	L5_S	(5,  false, 	false,	false)		//湲곕쭚
;

private int order;
private boolean prevYn;
private boolean deltaYn;
private boolean allCfYn;

private ELossStep(int order, boolean prevYn, boolean deltaYn) {
this.order = order;
this.prevYn = prevYn;
this.deltaYn = deltaYn;
}

private ELossStep(int order, boolean prevYn, boolean deltaYn, boolean allCfYn) {
this.order = order;
this.prevYn = prevYn;
this.deltaYn = deltaYn;
this.allCfYn = allCfYn;
}

public int getOrder() {
return order;
}
public boolean prevYn() {
return prevYn;
}
public boolean deltaYn() {
return deltaYn;
}
public boolean allCfYn() {
return allCfYn;
}

}

