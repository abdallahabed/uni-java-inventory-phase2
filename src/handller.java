import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;

public class handller implements EventHandler<ActionEvent> {
	StartClass startClass;

	public handller(StartClass StartClass) {
		this.startClass = StartClass;
	}

	@Override
	public void handle(ActionEvent e) {

		if (e.getSource() == startClass.addBT) {
			stage.warningLabel.setText("");
			new AddStage();
		}
		if (e.getSource() == startClass.modifyBT) {
			stage.warningLabel.setText("");
			new ModifyStage();
		}
		if (e.getSource() == startClass.deleteBT) {
			stage.warningLabel.setText("");
			new DeleteStage();
		}
		if (e.getSource() == startClass.stockrebortBT) {
			stage.warningLabel.setText("");
			new StockRebortStage();
		}
		if (e.getSource() == startClass.filechoseBT) {
			FileChooser fileChooser = new FileChooser();
			File load = fileChooser.showOpenDialog(null);
			load = new File(load.getAbsolutePath());

			try {
				// based on stockRebort in phase 1
				// data will be written in file
				// type - in stock : quantity , "price" : $ price

				ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(load));
				try {
					Item item = (Item) objectInputStream.readObject();
					stage.store.inventory.add(item);
					objectInputStream.close();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	}

}
