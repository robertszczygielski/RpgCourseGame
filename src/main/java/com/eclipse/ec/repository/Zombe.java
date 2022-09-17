package com.eclipse.ec.repository;

import com.eclipse.ec.domain.ForestCharacter;

public class Zombe extends com.eclipse.ec.repository.Enemie implements ForestCharacter {
	
	private int regeneration;

	public int getRegeneration() {
		return regeneration;
	}

	public void setRegeneration(int regeneration) {
		this.regeneration = regeneration;
	}

	@Override
	public String toString() {
		return "Zombe [regeneration=" + regeneration + "]";
	}
	
	

}
