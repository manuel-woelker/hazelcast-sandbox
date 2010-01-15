package com.eclipsesource.research.hazelcast.sandbox;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class HazelCastExecution {
	private static final class RunnableImplementation implements
			Callable<Integer>, Serializable {
		private static final long serialVersionUID = 1L;
		private final int i;

		public RunnableImplementation(int i) {
			this.i = i;
		}

		public Integer call() throws Exception {
			System.out.println("running " + i);
			return i * 2;
		}
	}

	public static void main(String[] args) throws InterruptedException,
			ExecutionException {
		HazelcastInstance hazelCastE = Hazelcast.newHazelcastInstance(null);
		List<Future<Integer>> results = new ArrayList<Future<Integer>>();
		for (int i = 0; i < 10; i++) {
			results.add(hazelCastE.getExecutorService().submit(
					new RunnableImplementation(i)));
		}
		for (Future<Integer> result : results) {
			System.out.println(result.get());
		}
	}
}
