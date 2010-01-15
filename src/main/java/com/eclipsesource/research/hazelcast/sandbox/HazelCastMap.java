package com.eclipsesource.research.hazelcast.sandbox;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class HazelCastMap {
	public static void main(String[] args) throws InterruptedException {
		HazelcastInstance hazelCastA = Hazelcast.newHazelcastInstance(null);
		HazelcastInstance hazelCastB = Hazelcast.newHazelcastInstance(null);
		Object value = 3;
		hazelCastA.getMap("foo").put("bar", value);
		System.out.println(hazelCastB.getMap("foo").get("bar"));

	}
}
