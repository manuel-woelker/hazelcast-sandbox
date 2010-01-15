package com.eclipsesource.research.hazelcast.sandbox;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ISet;
import com.hazelcast.core.Transaction;

public class Watcher {
	public static void main(String[] args) throws InterruptedException {
		HazelcastInstance hazelCastB = Hazelcast.newHazelcastInstance(null);
		int lastSize = Integer.MIN_VALUE;
		ISet<Object> listA = hazelCastB.getSet("a");
		ISet<Object> listB = hazelCastB.getSet("b");
		while (true) {
			Transaction transaction = hazelCastB.getTransaction();
			transaction.begin();

			int asize = listA.size();
			Thread.sleep(1);
			int bsize = listB.size();
			int size = asize + bsize;
			if (size != lastSize) {
				System.out.println(size);
				lastSize = size;
			}
			transaction.commit();
			Thread.sleep(1);
		}

	}
}
