package com.baazi.q5;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueueQ5 {
	
	public static void main(String[] args) {
		final QueueStack queue = new QueueStack();
		queue.push(100);
		queue.push(200);
		queue.push(300);
		queue.printAllElement();
		queue.pop();
		queue.push(3100);
		queue.printAllElement();
	}
	
	public static class QueueStack{
		Queue<Integer> q = new LinkedList<>();
		
		public Queue<Integer> push(Integer val) {
			q.add(val);
			return q;
		}
		
		public Queue<Integer> pop() {
			Queue<Integer> temp = new LinkedList<>();
			while(q.size() > 1) {
				temp.add(q.peek());
				q.remove();
			}
			q.remove();
			while(temp.size() > 0) {
				q.add(temp.peek());
				temp.remove();
			}
			return q;
		}

		public void printAllElement() {
			System.out.println("Elements of queue are:");
			q.forEach(System.out::println);
		}
		
	}

}