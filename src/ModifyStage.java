import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ModifyStage extends stage {

	ComboBox<String> searchCB = new ComboBox<>();
	Button updateBT = new Button("update");
	Button cancelBT = new Button("cancel");
	Button searchBT = new Button("Search");
	GridPane gp = new GridPane();

	TextField searchTF = new TextField();
	HBox buttonsHB = new HBox(10, updateBT, cancelBT);
	VBox vBox = new VBox(10, searchCB, super.gp, buttonsHB);
//	static Label warnigLabel = new Label();

	public ModifyStage() {
		stageHandler stageHandler = new stageHandler(this);

		gp.setVgap(10);
		gp.setHgap(10);
		buttonsHB.setAlignment(Pos.CENTER);
		searchCB.setEditable(true);
		searchCB.setOnAction(stageHandler);
		searchTF.setStyle("-fx-text-fill: grey;   -fx-border-color: grey;\r\n" + "   -fx-border-width: 2;\r\n"
				+ "   -fx-border-radius: 1;");
		updateBT.setOnAction(stageHandler);
		cancelBT.setOnAction(stageHandler);
		searchBT.setOnAction(stageHandler);

		gp.add(searchCB, 0, 0);
		gp.add(super.gp, 0, 1);
		gp.add(buttonsHB, 0, 2);
		gp.add(warningLabel, 0, 4);
		updateBT.setStyle("-fx-background-color: white");
		cancelBT.setStyle("-fx-background-color: white");
		gp.setBackground(new Background(new BackgroundFill(Color.DARKGREY, null, null)));
		searchCB.getItems().addAll("Brand", "No Brand");

		Scene scene = new Scene(gp, 400, 400);
		this.setTitle("Update Item");
		this.setScene(scene);
		this.show();
	}

	public void showSearchTextFiled() {
		super.gp.add(searchTF, 2, 0);

	}

	public void hideSearchTextFiled() {
		super.gp.getChildren().remove(searchTF);
	}

	public void showSearchButton() {
		super.gp.add(searchBT, 3, 0);

	}

	public void removeSearchButton() {
		super.gp.getChildren().remove(searchBT);

	}

}
