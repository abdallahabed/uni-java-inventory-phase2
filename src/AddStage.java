import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class AddStage extends stage {

	RadioButton yesRB = new RadioButton("yes");
	RadioButton noRB = new RadioButton("No");
	Label brandL = new Label("Brand :");
	Button saveBT = new Button("save");
	Button cancelBT = new Button("cancel");
	GridPane gp = new GridPane();
	HBox buttonshB = new HBox(10, saveBT, cancelBT);
	HBox radioHB = new HBox(10, brandL, yesRB, noRB);
	Label brandNameL = new Label("Brand name:");
	TextField brandNameTF = new TextField();

	public AddStage() {
		stageHandler stageHandler = new stageHandler(this);
		brandL.setStyle(
				"-fx-font-size: 12px;\r\n" + "    -fx-font-weight: bold;\r\n" + "    -fx-text-fill: #333333;\r\n"
						+ "    -fx-effect: dropshadow( gaussian , rgba(255,255,255,0.5) , 0,0,0,1 );");
		brandNameL.setStyle(
				"-fx-font-size: 12px;\r\n" + "    -fx-font-weight: bold;\r\n" + "    -fx-text-fill: #333333;\r\n"
						+ "    -fx-effect: dropshadow( gaussian , rgba(255,255,255,0.5) , 0,0,0,1 );");
		brandNameTF.setStyle("-fx-text-fill: grey;-fx-border-color: grey;\r\n" + "   -fx-border-width: 2;\r\n"
				+ "   -fx-border-radius: 1;");
		ToggleGroup tG = new ToggleGroup();
		yesRB.setToggleGroup(tG);
		noRB.setToggleGroup(tG);
		super.gp.setAlignment(Pos.CENTER_LEFT);
		gp.setVgap(10);
		gp.setHgap(10);
		gp.add(radioHB, 0, 0);
		gp.add(super.gp, 0, 1);
		buttonshB.setAlignment(Pos.CENTER);
		yesRB.setOnAction(stageHandler);
		noRB.setOnAction(stageHandler);
		saveBT.setStyle("-fx-background-color: white");
		cancelBT.setStyle("-fx-background-color: white");
		saveBT.setOnAction(stageHandler);
		cancelBT.setOnAction(stageHandler);

		/*
		 * to use if no radio button is clicked then when save button cliked give a red
		 * label say that you have to chose one show a warning dialog of the user press
		 * cancel button ask him, if he sure want to exit
		 * 
		 */
		gp.add(buttonshB, 0, 4);
		gp.add(warningLabel, 0, 5);
//		gp.setBackground(new Background(new BackgroundFill(Color.DARKGREY, null, null)));

		Scene scene = new Scene(gp, 400, 400);
		this.setTitle("Add New Item");
		this.setScene(scene);
		this.show();

	}

	public void showBrandFiled() {
		super.gp.add(brandNameL, 0, 3);
		super.gp.add(brandNameTF, 1, 3);

	}

	public void hideBrandFiled() {
		super.gp.getChildren().remove(brandNameL);
		super.gp.getChildren().remove(brandNameTF);

	}

}
