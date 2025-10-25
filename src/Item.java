import java.io.Serializable;

public class Item implements Comparable<Item>, Serializable {

	private String type = null;
	private int quantity = -1;
	private double price = -1;
	private String experationDate = null;

	public Item() {

		setPrice(price);
		setQuantity(quantity);
		setExperationDate(experationDate);

	}

	public String getExperationDate() {
		return experationDate;
	}

	public Item setExperationDate(String experationDate) {
		this.experationDate = experationDate;
		return this;
	}

	public Item(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public int getQuantity() {
		return quantity;
	}

	public Item setQuantity(int quantity) {
		this.quantity = quantity;
		return this;
	}

	public double getPrice() {
		return price;
	}

	public Item setPrice(double price) {
		this.price = price;
		return this;
	}

	public Item update(int qtyIncrease) {
		// update quantity by adding the increase to it.
		setQuantity(qtyIncrease + quantity);
		return this;
	}

	public Item update(double adjustmentFactor) {
		// update price by adding one to the factor and then multiply it by price
		setPrice(price * (1 + adjustmentFactor));
		return this;
	}

	public Item update(String experationDate) {
		setExperationDate(experationDate);
		return this;
	}

	@Override
	public int compareTo(Item o) {
		/*
		 * here in the compare method you have to compare using the price in case the
		 * price greater than the price its compared to return positive number in case
		 * the price less than the price it compared to return negative number in equal
		 * case return zero
		 *
		 */

		if (o != null && this.price > o.price) {
			return (int) (this.price - o.price);
		}

		else if (o != null && o.price > this.price) {
			return (int) (this.price - o.price);
		}

		return 0;
	}

}
