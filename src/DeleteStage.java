
public class DeleteStage extends ModifyStage {

	public DeleteStage() {
		stageHandler stageHandler = new stageHandler(this);
		super.updateBT.setText("delete");
		
		super.updateBT.setOnAction(stageHandler);
		this.setTitle("Delete Item" );
	}

}
