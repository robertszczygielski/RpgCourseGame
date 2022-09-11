package com.eclipse.ec.enums;

public enum Wapens {
	
	SWORD(5),
	DAGGER(3),
	STICK(1);
	
	private final int extraHit;
	
	private Wapens(int extraHit) {
		this.extraHit = extraHit;
	}
	
	public int getExtraHit() {
		return this.extraHit;
	}
}
