import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class stage extends Stage {
	static Inventory store = new Inventory("graceory");
	GridPane gp = new GridPane();

	Label typeL = new Label("type:");
	Label quantityL = new Label("quantity:");
	Label priceL = new Label("price:");
	TextField typeTF = new TextField();
	TextField quantityTF = new TextField();
	TextField priceTF = new TextField();
	Label eXlLabel = new Label("Experation date");
	TextField experationTF = new TextField();

	static Label warningLabel = new Label();

	public stage() {

		// This style increases the font size and weight and applies a drop shadow of a
		// gray color (#333333)
		typeL.setStyle("-fx-font-size: 12px;\r\n" + "    -fx-font-weight: bold;\r\n" + "    -fx-text-fill: #333333;\r\n"
				+ "    -fx-effect: dropshadow( gaussian , rgba(255,255,255,0.5) , 0,0,0,1 );");
		quantityL.setStyle(
				"-fx-font-size: 12px;\r\n" + "    -fx-font-weight: bold;\r\n" + "    -fx-text-fill: #333333;\r\n"
						+ "    -fx-effect: dropshadow( gaussian , rgba(255,255,255,0.5) , 0,0,0,1 );");
		priceL.setStyle(
				"-fx-font-size: 12px;\r\n" + "    -fx-font-weight: bold;\r\n" + "    -fx-text-fill: #333333;\r\n"
						+ "    -fx-effect: dropshadow( gaussian , rgba(255,255,255,0.5) , 0,0,0,1 );");
		typeTF.setStyle("-fx-text-fill: grey;   -fx-border-color: grey;\r\n" + "   -fx-border-width: 2;\r\n"
				+ "   -fx-border-radius: 1;");
		quantityTF.setStyle("-fx-text-fill: grey;   -fx-border-color: grey;\r\n" + "   -fx-border-width: 2;\r\n"
				+ "   -fx-border-radius: 1;");
		priceTF.setStyle("-fx-text-fill: grey;   -fx-border-color: grey;\r\n" + "   -fx-border-width: 2;\r\n"
				+ "   -fx-border-radius: 1;");
		warningLabel.setStyle(" -fx-text-fill: red;   -fx-font-size: 20px;\r\n" + "    -fx-font-weight: bold;\r\n"
				+ "    -fx-effect: dropshadow( gaussian , rgba(255,255,255,0.5) , 0,0,0,1 );");
		eXlLabel.setStyle(
				"-fx-font-size: 12px;\r\n" + "    -fx-font-weight: bold;\r\n" + "    -fx-text-fill: #333333;\r\n"
						+ "    -fx-effect: dropshadow( gaussian , rgba(255,255,255,0.5) , 0,0,0,1 );");
		experationTF.setStyle("-fx-text-fill: grey;   -fx-border-color: grey;\r\n" + "   -fx-border-width: 2;\r\n"
				+ "   -fx-border-radius: 1;");

		gp.setVgap(10);
		gp.setHgap(10);

		gp.add(typeL, 0, 0);
		gp.add(typeTF, 1, 0);
		gp.add(quantityL, 0, 1);
		gp.add(quantityTF, 1, 1);
		gp.add(priceL, 0, 2);
		gp.add(priceTF, 1, 2);
		gp.add(eXlLabel, 0, 4);
		gp.add(experationTF, 1, 4);
	}

	public static void warningMethod(String warning) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("warning Dialog");
		alert.setContentText(warning);
		alert.showAndWait();
	}

}
