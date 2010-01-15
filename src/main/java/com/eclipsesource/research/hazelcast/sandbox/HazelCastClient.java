package com.eclipsesource.research.hazelcast.sandbox;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.core.Member;

public class HazelCastClient {
	public static void main(String[] args) throws InterruptedException {
		Config config = new Config();
		// config.setSuperClient(true);
		HazelcastInstance hazelCastB = Hazelcast.newHazelcastInstance(config);
		IMap<Object, Object> timeMap = hazelCastB.getMap("time");
		Member member = hazelCastB.getCluster().getLocalMember();
		System.out.println(member);

		while (true) {
			System.out.println("Now: " + timeMap.get("now"));
			Thread.sleep(1000);
		}
	}
}
