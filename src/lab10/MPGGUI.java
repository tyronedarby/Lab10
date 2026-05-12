package lab10;

/**
 * File: ch15/MilesPerGallonGUI.java
 * Class: CSCI 1302
 * Description: JavaFX GUI miles per gallon calculator
 */

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MPGGUI extends Application {
	private TextField tfMiles = new TextField();
	private TextField tfGallons = new TextField();
	private TextField tfMilesPerGallon = new TextField();
	private Button btCalculate = new Button("Calculate");
	private Button btReset = new Button("Reset");
	private RadioButton rb1 = new RadioButton("MPG");
	private RadioButton rb2 = new RadioButton("L/100KM");
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create UI with Labels, TextFields, and a Button
		GridPane gridPane = new GridPane();
		gridPane.setHgap(5);
		gridPane.setVgap(5);
		btReset.setOnAction(e ->{
			tfGallons.setText("0");
			tfMiles.setText("0");
			tfMilesPerGallon.setText("0");
		});
		
		Label lbl1 = new Label("Miles:");
		gridPane.add(rb1, 0, 0);
		gridPane.add(rb2, 1, 0);
		gridPane.add(lbl1, 0, 1);
		gridPane.add(tfMiles, 1, 1);
		Label lbl2 = new Label("Gallons:");
		gridPane.add(lbl2, 0, 2);
		gridPane.add(tfGallons, 1, 2);
		Label lbl3 = new Label("Miles Per Gallon:");
		gridPane.add(lbl3, 0, 3);
		gridPane.add(tfMilesPerGallon, 1, 3);
		gridPane.add(btCalculate, 1, 4);
		gridPane.add(btReset, 0, 4);
		 
		ToggleGroup tg = new ToggleGroup();
	
		rb1.setToggleGroup(tg);
		rb2.setToggleGroup(tg);
		
		rb2.setOnAction(e -> {
			if(rb2.isSelected()) {
				lbl1.setText("Kilomerters"); 
				lbl2.setText("Liters"); 
				lbl3.setText("Liters Per 100KM"); 
			}
		});
		
		rb1.setOnAction(e -> {
			if(rb1.isSelected()) {
				lbl1.setText("Miles"); 
				lbl2.setText("Gallons"); 
				lbl3.setText("Miles Per Gallons"); 
			}
		});
		// Set properties for UI
		gridPane.setAlignment(Pos.CENTER);
		tfMiles.setAlignment(Pos.BOTTOM_RIGHT);
		tfGallons.setAlignment(Pos.BOTTOM_RIGHT);
		tfMilesPerGallon.setAlignment(Pos.BOTTOM_RIGHT);
		tfMilesPerGallon.setEditable(false);
		GridPane.setHalignment(btCalculate, HPos.RIGHT);

		// Process events with a lambda expression to call calculate MPG
		btCalculate.setOnAction(e -> calculateMPG());
		tfMiles.setOnAction(e -> calculateMPG());
		tfGallons.setOnAction(e -> calculateMPG());

		// Create a scene and place it in the stage
		Scene scene = new Scene(gridPane, 400, 250);
		primaryStage.setTitle("MPG Calculator"); // Set title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	private void calculateMPG() {
		// make sure there are no blank or un-entered values
		if (tfMiles.getText() != null && !tfMiles.getText().isEmpty() &&
				tfGallons.getText() != null && !tfGallons.getText().isEmpty()) {
		
			
				if(rb1.isSelected()) {
			// pull text from TextField(s) and convert to double to do numeric operations
			double miles = Double.parseDouble(tfMiles.getText());
			double gallons = Double.parseDouble(tfGallons.getText());
			double result = miles/gallons;

			// Display miles per gallon in result TextField with 4 decimal places by converting back to string
			tfMilesPerGallon.setText(String.format("%.2f", result));
				}}
			
			
			
			if(rb2.isSelected()) {
				
				double km = Double.parseDouble(tfMiles.getText());
				double l = Double.parseDouble(tfGallons.getText());
				
				double result2 = l/(km/100);

				// Display miles per gallon in result TextField with 4 decimal places by converting back to string
				tfMilesPerGallon.setText(String.format("%.2f", result2));
			}
			
		}
		
	
	
	
	
	/**
	 * The main method is only needed for the IDE with limited
	 * JavaFX support. Not needed for running from the command line.
	 */
	public static void main(String[] args) {
		launch(args);
	}
}

