package com.eclipsesource.research.hazelcast.sandbox;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IdGenerator;

public class IdGeneration {
	public static void main(String[] args) throws InterruptedException {
		HazelcastInstance hazelCast = Hazelcast.newHazelcastInstance(null);
		IdGenerator idGenerator = hazelCast.getIdGenerator("foo");
		while (true) {
			System.out.println(idGenerator.newId());
			Thread.sleep(1000);
		}

	}
}
