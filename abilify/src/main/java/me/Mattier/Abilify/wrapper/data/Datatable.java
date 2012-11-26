package me.Mattier.Abilify.wrapper.data;

import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.spout.api.datatable.ManagedHashMap;
import org.spout.api.datatable.SerializableMap;
import org.spout.api.map.DefaultedKey;

public final class Datatable implements SerializableMap {
	private final ManagedHashMap dataMap;

	public Datatable(ManagedHashMap data) {
		this.dataMap = data;
	}

	public Datatable(byte[] data) {
		this.dataMap = new ManagedHashMap();
		if (data != null && data.length > 0) {
			try {
				this.dataMap.deserialize(data);
			} catch (IOException e) {
				throw new RuntimeException("Invalid DatatableComponent byte array", e);
			}
		}
	}

	public Datatable() {
		this((byte[]) null);
	}

	public ManagedHashMap getBaseMap() {
		return dataMap;
	}
	
	public <T extends Serializable> Serializable addDefault(Default<T> key) {
		return dataMap.put(key.getKeyString(), key.getDefaultValue());
	}
	
	public Datatable copy() {
		return new Datatable((ManagedHashMap) deepCopy());
	}

	@Override
	public <T extends Serializable> T put(DefaultedKey<T> key, T value) {
		return dataMap.put(key, value);
	}

	@Override
	public <T extends Serializable> T putIfAbsent(DefaultedKey<T> key, T value) {
		return dataMap.putIfAbsent(key, value);
	}

	@Override
	public Serializable get(Object key) {
		return dataMap.get(key);
	}

	@Override
	public <T extends Serializable> T get(DefaultedKey<T> key) {
		return dataMap.get(key);
	}

	@Override
	public <T extends Serializable> T get(Object key, T defaultValue) {
		return dataMap.get(key, defaultValue);
	}

	@Override
	public boolean containsKey(Object key) {
		return dataMap.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return dataMap.containsValue(value);
	}

	@Override
	public int size() {
		return this.dataMap.size();
	}

	@Override
	public boolean isEmpty() {
		return this.dataMap.isEmpty();
	}

	@Override
	public Serializable remove(Object key) {
		return this.dataMap.remove(key);
	}

	@Override
	public void putAll(Map<? extends String, ? extends Serializable> m) {
		this.dataMap.putAll(m);
	}

	@Override
	public void clear() {
		this.dataMap.clear();
	}

	@Override
	public Set<String> keySet() {
		return this.dataMap.keySet();
	}

	@Override
	public Collection<Serializable> values() {
		return this.dataMap.values();
	}

	@Override
	public Set<java.util.Map.Entry<String, Serializable>> entrySet() {
		return this.dataMap.entrySet();
	}

	@Override
	public Serializable put(String key, Serializable value) {
		return this.dataMap.put(key, value);
	}

	@Override
	public Serializable putIfAbsent(String key, Serializable value) {
		return this.dataMap.put(key, value);
	}

	@Override
	public byte[] serialize() {
		return dataMap.serialize();
	}

	@Override
	public void deserialize(byte[] data) throws IOException {
		dataMap.deserialize(data);
	}

	@Override
	public void deserialize(byte[] data, boolean wipe) throws IOException {
		dataMap.deserialize(data, wipe);
	}

	@Override
	public SerializableMap deepCopy() {
		return dataMap.deepCopy();
	}

	@Override
	public <T> T get(String key, Class<T> clazz) {
		return dataMap.get(key, clazz);
	}
}
