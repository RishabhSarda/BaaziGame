package com.ProducerConsumer;

import java.util.LinkedList;
import java.util.Random;

public class ThreadexampleQ4 {
	public static void main(String[] args)
		throws InterruptedException
	{
		final ProducerConsumer pc = new ProducerConsumer();
		// Updating capacity of ProducerConsumer list size
		pc.capacity = 10;
		// Create producer thread
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run()
			{
				try {
					pc.produce();
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		// Create consumer thread
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run()
			{
				try {
					pc.consume();
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		// Start both threads
		t1.start();
		t2.start();

		// t1 finishes before t2
		t1.join();
		t2.join();
	}

	// This class has a list, producer (adds items to list
	// and consumer (removes items).
	public static class ProducerConsumer {

		// Create a list shared by producer and consumer
		// Size of list is 2.
		LinkedList<Integer> list = new LinkedList<>();
		int capacity = 2;

		// Function called by producer thread
		public void produce() throws InterruptedException
		{
			int value = 0;
			while (true) {
				synchronized (this)
				{
					// producer thread waits while list
					// is full
					while (list.size() == capacity)
						wait();
					Random rand = new Random();
					// to insert the jobs in the list
					value = rand.nextInt(1000);
					list.add(value);
					System.out.println("inserted value by producer is:" + value);
					// notifies the consumer thread that list is populated
					notify();
					// to create some delay
					Thread.sleep(1000);
				}
			}
		}

		// Function called by consumer thread
		public void consume() throws InterruptedException
		{
			while (true) {
				synchronized (this)
				{
					// consumer thread waits while list
					// is empty
					while (list.size() == 0)
						wait();

					// to retrieve the first job in the list
					int val = list.removeFirst();
					System.out.println("removed value by consumer is:" + val);
					// notify producer (in case list is full and producer is in wait state)
					notify();
					Thread.sleep(1000);
				}
			}
		}
	}
}
