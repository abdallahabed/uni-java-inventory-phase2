import java.util.ArrayList;

public class Inventory {

	public static ArrayList<Item> inventory = new ArrayList<>();
	private String catagory = null;

	public Inventory(String catagory) {
		this.catagory = catagory;
	}

	public void newItem(String type, int quantity, double price, String experationDate) {
		if (findItem(type, true) == -1) {
			inventory.add(new Item(type).setQuantity(quantity).setPrice(price).setExperationDate(experationDate));
		}

	}

	public void newItem(String brand, String type, int quantity, double price, String experationDate) {
		if (findItem(type, true, brand) == -1) {
			inventory.add(
					new Brand(brand, type).setQuantity(quantity).setPrice(price).setExperationDate(experationDate));
		}

	}

	public void setQuantity(String type, int quantity) {
		int index = findItem(type, false);
		if (index != -1) {
			inventory.get(index).setQuantity(quantity);
		}

	}

	public void setQuantity(String brand, String type, int quantity) {
		int index = findItem(type, false, brand);
		if (index != -1) {
			inventory.get(index).setQuantity(quantity);
		}
	}

	public void setPrice(String type, double price) {
		int index = findItem(type, false);
		if (index != -1) {
			inventory.get(index).setPrice(price);
		}
	}

	public void setPrice(String brand, String type, double price) {
		int index = findItem(type, false, brand);
		if (index != -1) {
			inventory.get(index).setPrice(price);
		}
	}

	public int getQuantity(String type) {
		int index = findItem(type, false);
		if (index != -1) {
			return inventory.get(index).getQuantity();
		}
		return -1;
	}

	public int getQuantity(String brand, String type) {
		int index = findItem(type, false, brand);
		if (index != -1) {
			return inventory.get(index).getQuantity();
		}
		return 0;

	}

	public String getExperation(String type) {
		int index = findItem(type, false);
		if (index != -1) {
			return inventory.get(index).getExperationDate();

		}
		return null;
	}

	public String getExperation(String brand, String type) {
		int index = findItem(type, false, brand);
		if (index != -1) {
			return inventory.get(index).getExperationDate();

		}
		return null;
	}

	public double getPrice(String type) {
		int index = findItem(type, false);
		if (index != -1) {
			return inventory.get(index).getPrice();

		}
		return Double.NaN;
	}

	public double getPrice(String brand, String type) {
		int index = findItem(type, false, brand);
		if (index != -1) {
			return inventory.get(index).getQuantity();
		}

		return Double.NaN;
	}

	public void update(String type, int qtyIncrease) {

		int index = findItem(type, false);
		if (index != -1) {
			inventory.get(index).update(qtyIncrease);
		}
	}

	public void update(String brand, String type, int qtyIncrease) {
		int index = findItem(type, false, brand);
		if (index != -1) {
			inventory.get(index).update(qtyIncrease);
		}
	}

	public void update(String type, double adjesmentFactor) {
		int index = findItem(type, false);
		if (index != -1) {
			inventory.get(index).update(adjesmentFactor);
		}
	}

	public void update(String brand, String type, String experationDate) {
		int index = findItem(type, false, brand);
		if (index != -1) {
			inventory.get(index).update(experationDate);
		}
	}

	public void update(String type, String experationDate) {
		int index = findItem(type, false);
		if (index != -1) {
			inventory.get(index).update(experationDate);
		}
	}

	public void update(String brand, String type, double adjesmentFactor) {
		int index = findItem(type, false, brand);
		if (index != -1) {
			inventory.get(index).update(adjesmentFactor);
		}

	}

	public int warningFindItem(String type, boolean warningIfFound) {
		int index = -1;
		int itemFound = 0;
		for (int i = 0; i < inventory.size(); i++) {
			if (type.equals(inventory.get(i).getType())) {
				itemFound++;
				index = i;
			}
		}
		if (itemFound == 0 && !warningIfFound) {
			ModifyStage.warningMethod("cannot find item :" + type);
		}
		if (itemFound > 1) {
			ModifyStage.warningMethod("more than one brand found of : " + type);

		}
		if (itemFound != 0 && warningIfFound == true) {

			ModifyStage.warningMethod(type + " - in stock : " + getQuantity(type) + ", price : $" + getPrice(type));
		}
		if (itemFound == 1) {
			return index;
		}
		return -1;
	}

	public int findItem(String type, boolean warningIfFound) {
		int index = -1;
		int itemFound = 0;
		for (int i = 0; i < inventory.size(); i++) {
			if (type.equals(inventory.get(i).getType())) {
				itemFound++;
				index = i;
			}
		}
		if (itemFound == 0 && !warningIfFound) {
			AddStage.warningLabel.setText("cannot find item :" + type);
		}
		if (itemFound > 1) {
			AddStage.warningLabel.setText("more than one brand found of : " + type);
		}
		if (itemFound != 0 && warningIfFound == true) {
			ModifyStage.warningLabel
					.setText(type + " - in stock : " + getQuantity(type) + ", price : $" + getPrice(type));
		}
		if (itemFound == 1) {
			return index;
		}
		return -1;
	}

	public int findItem(String type, boolean warningIfFound, String brand) {

		int index = -1;
		int itemFound = 0;

		for (int i = 0; i < inventory.size(); i++) {
			Item item = inventory.get(i);
			if (type.equals(item.getType()) && item instanceof Brand && brand.equals(((Brand) item).getBrand())) {
				itemFound++;
				index = i;
			}
		}
		if (itemFound == 0 && !warningIfFound) {
			AddStage.warningLabel.setText("cannot find item :" + brand + " " + type);
		}
		if (itemFound != 0 && warningIfFound == true) {
			// printing stock report is the same as telling the user the brand already
			// exist.
			AddStage.warningLabel.setText(
					brand + " " + type + " - in stock : " + getQuantity(type) + ", price : $" + getPrice(type));
		}
		if (itemFound == 1) {
			return index;
		}
		return -1;
	}

	public int warningFindItem(String type, boolean warningIfFound, String brand) {
		int index = -1;
		int itemFound = 0;

		for (int i = 0; i < inventory.size(); i++) {
			Item item = inventory.get(i);
			if (type.equals(item.getType()) && item instanceof Brand && brand.equals(((Brand) item).getBrand())) {
				itemFound++;
				index = i;
			}
		}
		if (itemFound == 0 && !warningIfFound) {
			ModifyStage.warningMethod(("cannot find item :" + brand + " " + type));
			;
		}
		if (itemFound != 0 && warningIfFound == true) {
			// printing stock report is the same as telling the user the brand already
			// exist.
			ModifyStage.warningMethod(
					brand + " " + type + " - in stock : " + getQuantity(type) + ", price : $" + getPrice(type));

		}
		if (itemFound == 1) {
			return index;
		}
		return -1;
	}

	public void stockReport() {
		double totalvalue = 0;

		String string = "";
		for (int i = 0; i < inventory.size(); i++) {
			Item item = inventory.get(i);
			if (item instanceof Brand) {
				StockRebortStage.textArea.setText(
						((Brand) item).getBrand() + " " + item.getType() + " - in stock : " + item.getQuantity()
								+ ", price : $" + item.getPrice() + "experation date: " + item.getExperationDate());
				string += StockRebortStage.textArea.getText() + "\n";

			} else {
				StockRebortStage.textArea.setText(item.getType() + " - in stock : " + item.getQuantity() + ", price : $"
						+ item.getPrice() + "experation date: " + item.getExperationDate());
				string += StockRebortStage.textArea.getText() + "\n";
			}
			totalvalue += item.getPrice() * item.getQuantity();
		}
		StockRebortStage.textArea.setText(string + " " + totalvalue + " ");
	}

	public void remove(DeleteStage deleteStage) {

		for (int i = 0; i < inventory.size(); i++) {
			if (deleteStage.searchCB.getValue().equals("Brand")) {
				// if quantity become zero or less that mean it does not exist so delete it.
				if ((inventory.get(i).getType().equals(deleteStage.typeTF.getText())
						&& ((Brand) inventory.get(i)).getBrand().equals(deleteStage.searchTF.getText()))
						|| inventory.get(i).getQuantity() <= 0) {
					inventory.remove(i);
					DeleteStage.warningLabel.setText(
							deleteStage.searchTF.getText() + "  " + deleteStage.typeTF.getText() + " is deleted.");

				}

			} else if (deleteStage.searchCB.getValue().equals("No Brand")) {
				if (inventory.get(i).getType().equals(deleteStage.typeTF.getText())
						|| inventory.get(i).getQuantity() <= 0) {
					inventory.remove(i);
					DeleteStage.warningLabel.setText(deleteStage.typeTF.getText() + " is deleted.");

				}
			} else {
				DeleteStage.warningLabel.setText("Cannot find the item you want to delete.");
			}

		}

	}

}