package com.eclipsesource.research.hazelcast.sandbox;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

public class HazelCastServer {
	public static void main(String[] args) throws InterruptedException {
		HazelcastInstance hazelCastA = Hazelcast.newHazelcastInstance(null);
		IMap<Object, Object> timeMap = hazelCastA.getMap("time");
		while (true) {
			timeMap.put("now", System.currentTimeMillis());
			Thread.sleep(1000);
		}
	}
}
