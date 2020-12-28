package com.jb;

import java.util.Calendar;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class OrderSystem {
	private TreeSet<Order> orders = new TreeSet<Order>();
//	private OrderTask orderTask = new OrderTask(orders);

	public OrderSystem() {
	}

	public boolean addOrder(Order order) {
		if (order.getReadyOn().before(Calendar.getInstance())) {
			System.out.println("Order's time precede current time");
			return false;
		}
		return orders.add(order);
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void orderMenu() {
		Thread t1 = new Thread(new OrderTask(orders));
		t1.start();
//		orderTask.run();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println();
			System.out.println("1. Add order");
			System.out.println("2. View orders");
			System.out.println("3. Exit");
			int op = 0;
			op = scanner.nextInt();
			switch (op) {
			case 1:
				Order order = new Order(scanCalendar(), scanText(), scanIsImportant());
				if (addOrder(order) == false) {
					System.out.println("Order can't be added");
				} else {
					System.out.println("Order added");
				}
				break;
			case 2:
				System.out.println(getOrders());
				break;
			case 3:
				System.out.println("Bye!");
				return;

			default:
				break;
			}
		}
	}

	private Calendar scanCalendar() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.print("Year:");
		int year = scanner.nextInt();
		System.out.print("Month:");
		int month = scanner.nextInt() - 1;
		System.out.print("Date:");
		int date = scanner.nextInt();
		System.out.print("Hour:");
		int hourOfDay = scanner.nextInt();
		System.out.print("Minute:");
		int minute = scanner.nextInt();
		System.out.print("Second:");
		int second = scanner.nextInt();
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, date, hourOfDay, minute, second);
		calendar.clear(Calendar.MILLISECOND);
		return calendar;
	}

	@SuppressWarnings("resource")
	private String scanText() {
		System.out.print("Text: ");
		return new Scanner(System.in).next();
	}

	@SuppressWarnings("resource")
	private boolean scanIsImportant() {
		System.out.print("Is important? (y/n): ");
		if (new Scanner(System.in).next().equalsIgnoreCase("y")) {
			return true;
		}
		return false;
	}

}
