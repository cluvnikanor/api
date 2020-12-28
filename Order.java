package com.jb;

import java.util.Calendar;

public class Order implements Comparable<Order> {
	private Calendar readyOn;
	private String text;
	private boolean important = false;
	private boolean poped = false;

	public Order(Calendar readyOn, String text, boolean important) {
		this.readyOn = readyOn;
		this.text = text;
		this.important = important;
	}

	public Calendar getReadyOn() {
		return readyOn;
	}

	public void setReadyOn(Calendar readyOn) {
		this.readyOn = readyOn;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isImportant() {
		return important;
	}

	public void setImportant(boolean important) {
		this.important = important;
	}

	public boolean isPoped() {
		return poped;
	}

	public void setPoped(boolean poped) {
		this.poped = poped;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (important ? 1231 : 1237);
		result = prime * result + (poped ? 1231 : 1237);
		result = prime * result + ((readyOn == null) ? 0 : readyOn.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
//		if (important != other.important)
//			return false;
//		if (poped != other.poped)
//			return false;
		if (readyOn == null) {
			if (other.readyOn != null)
				return false;
		} else if (readyOn.equals(other.readyOn)) {
			return true;
		}
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (text.equals(other.text))
			return true;
		return true;
	}

	@Override
	public int compareTo(Order O) {
		return this.readyOn.compareTo(O.readyOn);
	}

	@Override
	public String toString() {
		return "Order [readyOn=" + readyOn.getTime() + ", text=" + text + ", important=" + important + ", poped="
				+ poped + "]";
	}

}
