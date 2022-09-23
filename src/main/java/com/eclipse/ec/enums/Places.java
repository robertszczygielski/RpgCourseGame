package com.eclipse.ec.enums;

public enum Places {
	
	GRAVEYARD,
	CASTLE,
	SWAMP;
	
	public boolean isZombePlace() {
		return GRAVEYARD == this;
	}
}