import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class StockRebortStage extends stage {

	CheckBox fileCB = new CheckBox("export a file copy");
	CheckBox textareaCb = new CheckBox("Text area");
	Button exportBT = new Button("export");
	TextField fileTX = new TextField("enter file name");
	static TextArea textArea = new TextArea();
	GridPane gp = new GridPane();

	public StockRebortStage() {
		stageHandler stageHandler = new stageHandler(this);
		textArea.setMaxSize(250, 250);
		textArea.setPrefSize(400, 200);
		textArea.setVisible(false);
		fileTX.setVisible(false);
		exportBT.setVisible(false);
		fileCB.setOnAction(stageHandler);
		textareaCb.setOnAction(stageHandler);
		exportBT.setOnAction(stageHandler);
		VBox fileVBox = new VBox(10, fileCB, fileTX, exportBT);
		VBox textVBox = new VBox(10, textareaCb, textArea);

		gp.add(fileVBox, 0, 0);
		gp.add(textVBox, 1, 0);
		gp.setVgap(20);
		gp.setHgap(20);

		Scene scene = new Scene(gp, 500, 400);
		this.setTitle("Stock Report");
		this.setScene(scene);
		this.show();
	}

}
