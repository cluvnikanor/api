package com.jb;

import java.util.Calendar;
import java.util.TreeSet;

public class OrderTask implements Runnable {

	private TreeSet<Order> orders;

	public OrderTask(TreeSet<Order> orders) {
		this.orders = orders;
	}

	@Override
	public void run() {
		while (true) {
			if (!orders.isEmpty()) {
				for (Order order : orders) {
					if (order.getReadyOn().before(Calendar.getInstance()) && !order.isPoped()) {
						pop(order);
					}
				}
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	private void pop(Order order) {
		System.out.println("Order is ready" + order);
		order.setPoped(true);
		if (order.isImportant()) {
			ImportantOrderTask importantOrderTask = new ImportantOrderTask(order);
			importantOrderTask.run();
		}
	}

}
