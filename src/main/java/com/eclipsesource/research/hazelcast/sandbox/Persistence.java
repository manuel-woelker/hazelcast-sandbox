package com.eclipsesource.research.hazelcast.sandbox;

import java.util.Collection;
import java.util.Map;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MapStoreConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.core.MapLoader;
import com.hazelcast.core.MapStore;

public class Persistence implements MapLoader<Object, Object>,
		MapStore<Object, Object> {
	public static void main(String[] args) {
		Config config = new Config();
		MapConfig mapConfig = new MapConfig();
		MapStoreConfig mapStoreConfig = new MapStoreConfig();
		mapStoreConfig.setClassName(Persistence.class.getName());
		mapConfig.setMapStoreConfig(mapStoreConfig);
		config.getMapMapConfigs().put("persistent", mapConfig);
		HazelcastInstance hazelCast = Hazelcast.newHazelcastInstance(config);
		IMap<Object, Object> persistent = hazelCast.getMap("persistent");
		persistent.put("foo", "bar");
		System.out.println(persistent.get("baz"));

	}

	public Object load(Object key) {
		System.out.println("load " + key);
		return "xyz";
	}

	public Map<Object, Object> loadAll(Collection<Object> keys) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Object key) {
		System.out.println("delete " + key);

	}

	public void deleteAll(Collection<Object> keys) {
		// TODO Auto-generated method stub

	}

	public void store(Object key, Object value) {
		System.out.println("store " + key);

	}

	public void storeAll(Map<Object, Object> map) {
		// TODO Auto-generated method stub

	}
}
