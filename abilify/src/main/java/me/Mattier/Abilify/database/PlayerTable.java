package me.Mattier.Abilify.database;

import com.alta189.simplesave.Field;
import com.alta189.simplesave.Id;
import com.alta189.simplesave.Table;

@Table(value = "abilify_player")
public class PlayerTable {
	@Id
	public int id;
	
	@Field
	public String player;
	
	@Field
	public int[] ability;
	
	@Field
	public int[] status;
	
	@Field
	public int[] ticks;
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof AbilityTable) {
			PlayerTable compare = (PlayerTable) o;
			if (compare.player.equals(player) && compare.ability == ability 
					&& compare.status.equals(status) && compare.ticks.equals(ticks))
				return true;
		}
		return false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public int[] getAbility() {
		return ability;
	}

	public void setAbility(int[] ability) {
		this.ability = ability;
	}

	public int[] getStatus() {
		return status;
	}

	public void setStatus(int[] status) {
		this.status = status;
	}

	public int[] getTicks() {
		return ticks;
	}

	public void setTicks(int[] ticks) {
		this.ticks = ticks;
	}
}
