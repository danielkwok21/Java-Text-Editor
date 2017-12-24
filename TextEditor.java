package application;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TextEditor extends Application {
	
	//variables for window size
	public static final int WIDTH = 128;
	public static final int HEIGHT = 128;
	public static final int HEIGHT2 = HEIGHT + 16;
	public static final int SCALE = 3;
	static boolean saved = false;
		
    Stage window;

    public static void main(String[] args) {
    	
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
    	
    	//variables for changes
    	final String fileName = "src/application/sample.txt";
    	//final String fileName = "sample.txt";
    	    	
    	//open map file
    	FileIO w = new FileIO(fileName);
    	
    	//set window
        window = primaryStage;
        window.setTitle("Text Editor");
        
        //text input field
        TextField text = new TextField();
        
        //save button
        //gets input from textfield and writes to sample.txt	
        Button save = new Button("Save");
        save.setTranslateY(30);
        save.setOnAction(e->{
            w.save(text.getText());
            try {
        		String dir = "C:\\Users\\danie\\eclipse-workspace\\GitSWMCW2\\JAR_MapViewer";
        		File path = new File(dir);
        		Runtime r = Runtime.getRuntime();
        		Process p = r.exec("java -jar MapViewer.jar", null, path);
        		p.waitFor(20, TimeUnit.SECONDS);
        		p.destroy();
        	}catch(Exception e1) {
        		e1.printStackTrace();
        	}
        });
        
        //close button
        //also checks if file is saved
        //pops up alert box if isn't
        Button close = new Button("Close");
        close.setTranslateY(60);
        close.setOnAction(
        	e->{
        		if(saved) {
                    window.close();           		
            	}else {
            		saved = AlertBox.handle();
            	}
        	}
        );

        
        TextField content = new TextField();
        content.setTranslateY(120);
        content.setEditable(false);
        
        //read button
        //reads from sample.txt and writes to here	
        Button read = new Button("read");
        read.setTranslateY(90);
        read.setOnAction(e->{
            content.setText(w.read());
        });
	   
        StackPane layout = new StackPane();
        layout.getChildren().addAll(text, save, close, read, content);
        Scene scene = new Scene(layout, WIDTH*SCALE, HEIGHT*SCALE);
        window.setScene(scene);
        window.show();
    }
}