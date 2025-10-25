import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class StartClass extends Application {
	Button addBT = new Button("Add");
	Button modifyBT = new Button("Modify");
	Button deleteBT = new Button("Delete");
	Button stockrebortBT = new Button("Stock Rebort");
	Button filechoseBT = new Button("file choser");
	handller handller = new handller(this);

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		BorderPane bP = new BorderPane();
		Label mainL = new Label("Inventory Management System");
		mainL.setFont(new Font("Verdana", 15));
		mainL.setStyle("");
		bP.setAlignment(mainL, Pos.CENTER);
		bP.setTop(mainL);
		ImageView imageView = new ImageView(
				"C:\\Users\\ahmad\\eclipse-workspace\\Java2_phase2\\src\\inventoryManagement.jpg");
		imageView.setFitWidth(250);
		imageView.setFitHeight(250);
		addBT.setOnAction(handller);
		modifyBT.setOnAction(handller);
		deleteBT.setOnAction(handller);
		stockrebortBT.setOnAction(handller);
		filechoseBT.setOnAction(handller);
		imageView.setRotate(35);
		HBox hBox = new HBox(addBT, modifyBT, deleteBT, stockrebortBT, filechoseBT);
		bP.setCenter(imageView);
		bP.setBottom(hBox);
		hBox.setAlignment(Pos.CENTER);
		hBox.setSpacing(10);

		addBT.setStyle(" -fx-background-color: white;-fx-font-size: 12px;" + "    -fx-font-weight: bold;"
				+ "    -fx-text-fill: #333333;"
				+ "    -fx-effect: dropshadow( gaussian , rgba(255,255,255,0.5) , 0,0,0,1 );");

		modifyBT.setStyle("  -fx-background-color: white;-fx-font-size: 12px;" + "    -fx-font-weight: bold;"
				+ "    -fx-text-fill: #333333; "
				+ "    -fx-effect: dropshadow( gaussian , rgba(255,255,255,0.5) , 0,0,0,1 ); ");
		deleteBT.setStyle(" -fx-background-color: white;-fx-font-size: 12px;" + "    -fx-font-weight: bold;"
				+ "    -fx-text-fill: #333333;"
				+ "    -fx-effect: dropshadow( gaussian , rgba(255,255,255,0.5) , 0,0,0,1 );");
		stockrebortBT.setStyle(" -fx-background-color: white;-fx-font-size: 12px;" + "    -fx-font-weight: bold;"
				+ "    -fx-text-fill: #333333;"
				+ "    -fx-effect: dropshadow( gaussian , rgba(255,255,255,0.5) , 0,0,0,1 );");
		filechoseBT.setStyle(" -fx-background-color: white;-fx-font-size: 12px;" + "    -fx-font-weight: bold;"
				+ "    -fx-text-fill: #333333;"
				+ "    -fx-effect: dropshadow( gaussian , rgba(255,255,255,0.5) , 0,0,0,1 );");

		Scene scene = new Scene(bP, 450, 450);
		bP.setStyle("-fx-background-color: gray;");
		stage.setTitle("Inventory Management System");
		stage.setScene(scene);
		stage.show();

	}

}
