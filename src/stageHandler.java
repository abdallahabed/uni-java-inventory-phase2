import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ToggleGroup;

public class stageHandler implements EventHandler<ActionEvent> {
	AddStage addStage;
	ModifyStage modifyStage;
	DeleteStage deleteStage;
	StockRebortStage stockReportStage;
	ToggleGroup tG = new ToggleGroup();
	Object object;

	/*
	 * the handler constructer takes a class of type object and since object is the
	 * father of all classes it can take any class type then in the handle method
	 * chick the type of class using instanceof to see the type of class then cast
	 * the object and handle it as required
	 */
	public stageHandler(Object object) {
		this.object = object;
	}

	@Override
	public void handle(ActionEvent e) {

		if (object instanceof AddStage) {
			addStage = (AddStage) object;
			if (e.getSource() == addStage.noRB) {
				addStage.hideBrandFiled();

			}
			if (e.getSource() == addStage.yesRB) {
				addStage.showBrandFiled();
			}

			if (e.getSource() == addStage.saveBT) {
				// check if all data exist....else give warning to enter all data
				if (addStage.priceTF.getText().isEmpty() || addStage.typeTF.getText().isEmpty()
						|| addStage.quantityTF.getText().isEmpty()) {
					AddStage.warningLabel.setText("you have to fill all boxes.");
				} else {
					/*
					 * check if its brand or not ...if yes radio button selected then its a brand
					 * else its not a brand
					 */
					if (addStage.yesRB.isSelected()) {
						// add the brand to store by getting values from text filed.
						AddStage.store.newItem(addStage.brandNameTF.getText(), addStage.typeTF.getText(),
								Integer.parseInt(addStage.quantityTF.getText()),
								Double.parseDouble(addStage.priceTF.getText()), addStage.experationTF.getText());
						// here to hide the stage after clicking save button....return to main site.
						// but you have to check if there is a warning then there is some thing wrong
						// in data and don't hide the stage
						if (AddStage.warningLabel.getText().isEmpty()) {

							addStage.hide();
						}
					} else if (addStage.noRB.isSelected()) {
						AddStage.store.newItem(addStage.typeTF.getText(),
								Integer.parseInt(addStage.quantityTF.getText()),
								Double.parseDouble(addStage.priceTF.getText()), addStage.experationTF.getText());
						// here to hide the stage after clicking save button....return to main site.
						if (AddStage.warningLabel.getText().isEmpty()) {

							addStage.hide();
						}

					}

					else {
						/*
						 * if you did not select with or without a brand no radio button selected it
						 * will give you this warning.
						 */
						AddStage.warningLabel.setText("you have to select a rdion button to save");
					}

				}
			}
			/*
			 * if cancel button is clicked it will give you a confirm massage to make sure
			 * you want to exit if you click yes it will exit else it will keep you in the
			 * stage
			 * 
			 */
			if (e.getSource() == addStage.cancelBT) {
				canelMethod();
			}
		}

		if (object instanceof ModifyStage) {
			modifyStage = (ModifyStage) object;
			if (e.getSource() == modifyStage.updateBT) {
				if (modifyStage.priceTF.getText().isEmpty() || modifyStage.typeTF.getText().isEmpty()
						|| modifyStage.quantityTF.getText().isEmpty()) {
					ModifyStage.warningMethod("you have to fill all boxes");

				} else {
					if (modifyStage.searchCB.getValue().equals("Brand")) {
						ModifyStage.store.update(modifyStage.searchTF.getText(), modifyStage.typeTF.getText(),
								Integer.parseInt(modifyStage.quantityTF.getText()));
						ModifyStage.store.update(modifyStage.searchTF.getText(), modifyStage.typeTF.getText(),
								Double.parseDouble(modifyStage.priceTF.getText()));
						ModifyStage.store.update(modifyStage.searchTF.getText(), modifyStage.typeTF.getText(),
								modifyStage.experationTF.getText());

						if (ModifyStage.warningLabel.getText().isEmpty())
							modifyStage.hide();

					} else if (modifyStage.searchCB.getValue().equals("No Brand")) {
						ModifyStage.store.update(modifyStage.typeTF.getText(),
								Integer.parseInt(modifyStage.quantityTF.getText()));
						ModifyStage.store.update(modifyStage.typeTF.getText(),
								Double.parseDouble(modifyStage.priceTF.getText()));
						ModifyStage.store.update(modifyStage.typeTF.getText(), modifyStage.experationTF.getText());
						if (ModifyStage.warningLabel.getText().isEmpty())
							modifyStage.hide();
					}

				}

			}
			modifyStage.removeSearchButton();
			modifyStage.hideSearchTextFiled();

			if (modifyStage.searchCB.getValue().equals("Brand")) {
				modifyStage.showSearchTextFiled();
				modifyStage.showSearchButton();
				if (e.getSource() == modifyStage.searchBT) {
					// use method find item if it return -1 thats mean the brand does not exist
					// tell the user that he entered invalid input.
					if (ModifyStage.store.warningFindItem(modifyStage.typeTF.getText(), true,
							modifyStage.searchTF.getText()) == -1) {
						ModifyStage.warningMethod("the item does not exist.");
					}

				}

			} else if (modifyStage.searchCB.getValue().equals("No Brand")) {
				modifyStage.hideSearchTextFiled();
				modifyStage.showSearchButton();
				if (e.getSource() == modifyStage.searchBT) {
					if (ModifyStage.store.warningFindItem(modifyStage.typeTF.getText(), true) == -1) {

						ModifyStage.warningMethod("the item  " + modifyStage.typeTF.getText() + " does not exist.");
					}
				}
			}
			if (e.getSource() == modifyStage.cancelBT) {
				canelMethod();
			}
		}

		if (object instanceof DeleteStage) {
			deleteStage = (DeleteStage) object;
			if (e.getSource() == deleteStage.updateBT) {
				DeleteStage.store.remove(deleteStage);
			}
		}
		if (object instanceof StockRebortStage) {
			stockReportStage = (StockRebortStage) object;
			if (stockReportStage.textareaCb.isSelected()) {
				// if the chick box is selected make the text area visible
				StockRebortStage.textArea.setVisible(true);
				StockRebortStage.store.stockReport();
			}
			if (!(stockReportStage.textareaCb.isSelected())) {
				// if the chick box is not selected hide the text area
				StockRebortStage.textArea.setVisible(false);
			}
			if (stockReportStage.fileCB.isSelected()) {
				// if the chick box is selected make the file text filed and button visible
				stockReportStage.exportBT.setVisible(true);
				stockReportStage.fileTX.setVisible(true);
			}
			if (!(stockReportStage.fileCB.isSelected())) {
				// if the chick box is not selected hide the file text filed and button
				stockReportStage.exportBT.setVisible(false);
				stockReportStage.fileTX.setVisible(false);
			}
			if (e.getSource() == stockReportStage.exportBT) {
				File load;
				// if file text filed does not have name show file chose open dialog
				// make the user chose file to save
				// else take the name of the file that the user entered and write in it.

				if (stockReportStage.fileTX.getText().equals("enter file name")) {
					FileChooser fileChooser = new FileChooser();
					load = fileChooser.showOpenDialog(null);
				} else {
					load = new File(stockReportStage.fileTX.getText());
				}
				try {
					ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(load));

					for (int i = 0; i < Inventory.inventory.size(); i++) {
						Item item = Inventory.inventory.get(i);

						objectOutputStream.writeObject(item);

					}
					objectOutputStream.close();
					stockReportStage.hide();

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}

		}

	}

	public void canelMethod() {

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("confirmation");
		alert.setContentText("are your sure you want exit");
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {

			if (object instanceof AddStage)
				addStage.hide();
			if (object instanceof ModifyStage)
				modifyStage.hide();
			if (object instanceof DeleteStage)
				deleteStage.hide();

		}

	}

}
