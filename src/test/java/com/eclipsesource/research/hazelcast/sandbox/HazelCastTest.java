package com.eclipsesource.research.hazelcast.sandbox;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class HazelCastTest {
	
	@Test
	public void testMap() throws Exception {
		HazelcastInstance hazelCastA = Hazelcast.newHazelcastInstance(null);
		HazelcastInstance hazelCastB = Hazelcast.newHazelcastInstance(null);
		Object value = 3;
		hazelCastA.getMap("foo").put("bar", value);
		assertEquals(value, hazelCastB.getMap("foo").get("bar"));
	}

}
