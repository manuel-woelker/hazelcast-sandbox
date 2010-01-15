package com.eclipsesource.research.hazelcast.sandbox;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ISet;
import com.hazelcast.core.Transaction;

public class Pusher {
	public static void main(String[] args) throws InterruptedException {
		HazelcastInstance hazelCastB = Hazelcast.newHazelcastInstance(null);
		ISet<Object> set = hazelCastB.getSet("a");
		for (int i = 0; i < 1000; i++) {
			set.add(Integer.valueOf(i));
		}
		System.out.println("A: " + hazelCastB.getSet("a").size());
		System.out.println("B: " + hazelCastB.getSet("b").size());
		ISet<Object> listA = hazelCastB.getSet("a");
		ISet<Object> listB = hazelCastB.getSet("b");
		for (int i = 0; i < 1000; i++) {
			Transaction transaction = hazelCastB.getTransaction();
			transaction.begin();
			System.out.println(i);
			listA.remove(Integer.valueOf(i));
			listB.add(Integer.valueOf(i));
			transaction.commit();

		}
		System.out.println("A: " + hazelCastB.getSet("a").size());
		System.out.println("B: " + hazelCastB.getSet("b").size());
	}
}
