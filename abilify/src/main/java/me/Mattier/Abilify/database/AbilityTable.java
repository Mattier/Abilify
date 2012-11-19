package me.Mattier.Abilify.database;

import com.alta189.simplesave.Field;
import com.alta189.simplesave.Id;
import com.alta189.simplesave.Table;

@Table(value = "abilify_ability")
public class AbilityTable implements WrapperTable {
	@Id
	public int id;
	
	@Field
	public String mech;
	
	@Field
	public int[] mod;
	
	@Field
	public String name;
	
	@Field
	public String desc;
	
	@Field
	public String annc;
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof AbilityTable) {
			AbilityTable compare = (AbilityTable) o;
			if (compare.mech.equals(mech) && compare.mod == mod && compare.name.equals(name)
					&& compare.desc.equals(desc) && compare.annc.equals(annc))
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

	public String getMech() {
		return mech;
	}

	public void setMech(String mech) {
		this.mech = mech;
	}

	public int[] getMod() {
		return mod;
	}

	public void setMod(int[] mod) {
		this.mod = mod;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getAnnc() {
		return annc;
	}

	public void setAnnc(String annc) {
		this.annc = annc;
	}
}