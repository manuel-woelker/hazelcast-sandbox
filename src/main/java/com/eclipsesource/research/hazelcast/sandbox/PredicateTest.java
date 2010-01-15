package com.eclipsesource.research.hazelcast.sandbox;

import java.util.Collection;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.core.MapEntry;
import com.hazelcast.query.Predicate;

public class PredicateTest {
	public static void main(String[] args) {
		HazelcastInstance hazelCastB = Hazelcast.newHazelcastInstance(null);
		IMap<Object, Object> set = hazelCastB.getMap("a");
		for (int i = 0; i < 100; i++) {
			set.put(Integer.valueOf(i), Integer.valueOf(i));
		}
		Collection<Object> values = set.values(new Predicate() {

			private static final long serialVersionUID = 1L;

			@SuppressWarnings("unchecked")
			public boolean apply(MapEntry mapEntry) {
				System.out.println("checking " + mapEntry.getKey());
				return 5 > (Integer) mapEntry.getKey();
			}
		});
		System.out.println(values.size());
	}
}
