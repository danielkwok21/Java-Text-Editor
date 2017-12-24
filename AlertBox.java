package application;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class AlertBox {

	static boolean saved = false;
	
	public static boolean handle(){
		
		 //set window
		 Stage window = new Stage();
	     window.initModality(Modality.APPLICATION_MODAL);
	    
	     Label label = new Label();
	     label.setText("You've made unsaved changes. Save?");

	     //Yes save please buttons
	     Button save = new Button("Save");
	     save.setOnAction(e -> {
	            saved = true;
	            window.close();
	     });
	     
	     //go back
	     Button back = new Button("Back");
	     back.setOnAction(e -> {
	            window.close();
	     });
	     
	     VBox layout = new VBox(10);

	     //Add buttons
	     layout.getChildren().addAll(label, save, back);
	     layout.setAlignment(Pos.CENTER);
	     Scene scene = new Scene(layout);
	     window.setScene(scene);
	     window.showAndWait();
            
	     return saved;
	 }
}

