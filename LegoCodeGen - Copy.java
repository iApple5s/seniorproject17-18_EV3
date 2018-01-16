import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javax.swing.*;
import java.lang.String;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener.Change;
import javafx.concurrent.Worker.State;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.web.PopupFeatures;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebHistory.Entry;
import netscape.javascript.JSObject;
import javafx.scene.text.Text;
import javafx.scene.text.TextBuilder;



public class LegoCodeGen extends Application {
	
    private Scene scene;
    
    @Override
    public void start(Stage stage) {
    	/**
    	* start This is the function that initializes the UI component of the java application. This is where the scene gets it's parameters,
    	*       and this is also wher the WebView browser object is created.
    	*       The scene that hosts the UI is also defined here, along with the gridPane object that creates a grid 
    	*       to map the UI elements to so they stay lined up and proportional
    	*
    	* ---Inputs---
    	* Stage stage      This is the object that hosts all the other JavaFX objects in the UI
    	* ---Outputs---
    	* void
    	*/ 
        WebView browser = new WebView();
        WebEngine webEngine = browser.getEngine();
        webEngine.load(LegoCodeGen.class.getResource("blockly.html").toExternalForm());
        
        stage.setTitle("Lego Mindstorm Code Generator");
        
        //These JavaFX objects are the UI elements that populate the stage
        TextField txtTrackWidth, txtWheelDiameter, txtOutput;
        Label lblWheelDiameter, lblTrackWidth, lblTouchSensor, lblLeftMotor, lblRightMotor,
        lblSoundSensor, lblUltrasonicSensor, lblLightSensor, lblMotorPower, lblOutput;
        Button btnSaveSettings, btnLoadSettings, btnZoomIn, btnZoomOut, btnDownloadCode;
        ComboBox cboLeftMotor, cboRightMotor, cboTouchSensor, cboUltrasonicSensor, cboSoundSensor, cboLightSensor, cboMotorPower;
        
        //This gridPane is the grid that holds all the JavaFX objects in place when the UI is resized
        GridPane gridPane = new GridPane();
        
        ObservableList<String> motorOptions = FXCollections.observableArrayList ("A", "B", "C");
        ObservableList<String> inputPortOptions = FXCollections.observableArrayList ( "Not used", "1", "2", "3", "4");
        
        //Create JavaFX UI objects.
        lblTrackWidth = new Label("Track Width");
        txtTrackWidth = new TextField();
        txtTrackWidth.setText("4.37008");
        lblWheelDiameter = new Label("Wheel Diameter");
        txtWheelDiameter = new TextField();
        txtWheelDiameter.setText("2.20472");
        lblOutput = new Label("Output file name");
        txtOutput = new TextField();
        txtOutput.setText("out");
        
        lblLeftMotor = new Label("Left Motor");
        cboLeftMotor = new ComboBox();
        cboLeftMotor.getItems().addAll ("A", "B");
        cboLeftMotor.setValue("B");
        
        lblRightMotor = new Label("Right Motor");
        cboRightMotor = new ComboBox();
        cboRightMotor.getItems().addAll ("B", "C");
        cboRightMotor.setValue("C");
        
        lblTouchSensor = new Label("Touch Sensor");
        cboTouchSensor = new ComboBox();
        cboTouchSensor.getItems().addAll ("Not used", "1", "2", "3", "4");
        cboTouchSensor.setValue("Not used");
        
        lblUltrasonicSensor = new Label("Ultrasonic Sensor");
        cboUltrasonicSensor = new ComboBox();
        cboUltrasonicSensor.getItems().addAll ("Not used", "1", "2", "3", "4");
        cboUltrasonicSensor.setValue("Not used");
        
        lblSoundSensor = new Label("Sound Sensor");
        cboSoundSensor = new ComboBox();
        cboSoundSensor.getItems().addAll ("Not used", "1", "2", "3", "4");
        cboSoundSensor.setValue("Not used");
        
        lblLightSensor = new Label("Light Sensor");
        cboLightSensor = new ComboBox();
        cboLightSensor.getItems().addAll ("Not used", "1", "2", "3", "4");
        cboLightSensor.setValue("Not used");
        
        lblMotorPower = new Label("Motor Power");
        cboMotorPower = new ComboBox();
        cboMotorPower.getItems().addAll ("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        cboMotorPower.setValue("3");        
        
        //This button generates a nxc code based on the current state of the JavaFX ui elements and the blockly workspace
        btnDownloadCode = new Button ("Download code");
        btnDownloadCode.setOnAction((ActionEvent t) -> {
        		String code = (String) webEngine.executeScript("getCode()");
        		
        		//String code = (String) webEngine.executeScript("getCode()");
        		String touch_sen, light_sen, sound_sen, ultrasonic_sen, leftMotor, rightMotor, wheelDiam, trackWid, motorPower, output;              
        		touch_sen = cboTouchSensor.getValue().toString();
        		light_sen = cboLightSensor.getValue().toString();
        		sound_sen = cboSoundSensor.getValue().toString();
        		ultrasonic_sen = cboUltrasonicSensor.getValue().toString();
        		leftMotor = cboLeftMotor.getValue().toString();
        		rightMotor = cboRightMotor.getValue().toString();
        		motorPower = cboMotorPower.getValue().toString();
        		wheelDiam = txtWheelDiameter.getText();
        		trackWid = txtTrackWidth.getText();  
        		output = txtOutput.getText();                                                           
        		//Now we take the code string and pass it to the parser to get what we need.
        		parser(code, touch_sen, light_sen, sound_sen, ultrasonic_sen, leftMotor, rightMotor, wheelDiam, trackWid, motorPower, output);
        });
        
        //This button rescales the contents of the WebView browser by a factor of +.1
        btnZoomIn = new Button ("Zoom In");
        btnZoomIn.setOnAction((ActionEvent t) -> {
        		zoom(0.1,browser);
        });
        //This button rescales the contents of the WebView browser by a factor of -.1
        btnZoomOut = new Button ("Zoom Out");
        btnZoomOut.setOnAction((ActionEvent t) -> {
        		zoom(-0.1,browser);
        });      
        //This button saves the current state of necessary the JavaFX UI objects and saves them to a file
        btnSaveSettings = new Button ("Save Settings");
        btnSaveSettings.setOnAction((ActionEvent t) -> {
        		//save the current state of the UI elements
        		String touch_sen, light_sen, sound_sen, ultrasonic_sen, leftMotor, rightMotor, wheelDiam, trackWid, motorPower;   
        		touch_sen = cboTouchSensor.getValue().toString();
        		light_sen = cboLightSensor.getValue().toString();
        		sound_sen = cboSoundSensor.getValue().toString();
        		ultrasonic_sen = cboUltrasonicSensor.getValue().toString();
        		leftMotor = cboLeftMotor.getValue().toString();
        		rightMotor = cboRightMotor.getValue().toString();
        		motorPower = cboMotorPower.getValue().toString();
        		wheelDiam = txtWheelDiameter.getText();
        		trackWid = txtTrackWidth.getText();   
        		
        		
        		//create the String to be saved to disk sent to the function SaveFile()
        		final String save_Settings = trackWid+","+wheelDiam+","+leftMotor+","+rightMotor+","+touch_sen+","+ultrasonic_sen+","+sound_sen+","+light_sen+","+motorPower+"\n";
        		Text textSong = TextBuilder.create()
                .text(save_Settings)
                .build(); 
                
                FileChooser fileChooser = new FileChooser();
                //Set extension filter
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("SET files (*.set)", "*.set");
                fileChooser.getExtensionFilters().add(extFilter);
                //Set Class Directory as default
                fileChooser.setInitialDirectory(new File(LegoCodeGen.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
                //Show save file dialog
                File file = fileChooser.showSaveDialog(stage);
                
                if(file != null){
                	SaveFile(save_Settings, file);
                }
        });
        //This button loads the settings stored in a file to the UI objects
        btnLoadSettings = new Button ("Load Settings");
        btnLoadSettings.setOnAction((ActionEvent t) -> {
                FileChooser fileChooser = new FileChooser();
                
                //Set extension filter
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("SET files (*.set)", "*.set");
                fileChooser.getExtensionFilters().add(extFilter);
                
                //Set Class Directory as default
                fileChooser.setInitialDirectory(new File(LegoCodeGen.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
                
                //Show save file dialog
                File file = fileChooser.showOpenDialog(stage);
                if(file != null){
                    String setting_string = readFile(file);
                    try {
                        //if the file is formatted correctly this will work
                        String[] splitSettingString = setting_string.split(",");
                        txtTrackWidth.setText(splitSettingString[0]);
                        txtWheelDiameter.setText(splitSettingString[1]);
                        cboLeftMotor.setValue(splitSettingString[2]);     
                        cboRightMotor.setValue(splitSettingString[3]);     
                        cboTouchSensor.setValue(splitSettingString[4]);     
                        cboUltrasonicSensor.setValue(splitSettingString[5]);     
                        cboSoundSensor.setValue(splitSettingString[6]);     
                        cboLightSensor.setValue(splitSettingString[7]);     
                        cboMotorPower.setValue(splitSettingString[8]);
                    }
                    catch (Exception e) {
                        //something didnt work
                        JOptionPane.showMessageDialog (null, "Something is wrong with the selected settings file");
                    } 
                }
                
        });               
        
        //This is where we define the gridPane() and UI elements to have the desired constraints 
        BorderPane background = new BorderPane();
        background.setCenter(browser);         
        BorderPane spacer = new BorderPane();
        gridPane.setVgrow (spacer, Priority.ALWAYS);
        gridPane.setHgrow(spacer, Priority.ALWAYS);
        gridPane.setMaxWidth (Double.MAX_VALUE);
        gridPane.setMaxHeight (Double.MAX_VALUE);
        btnDownloadCode.setMaxWidth(Double.MAX_VALUE);
        btnZoomIn.setMaxWidth(Double.MAX_VALUE);
        btnZoomOut.setMaxWidth(Double.MAX_VALUE);
        btnSaveSettings.setMaxWidth(Double.MAX_VALUE);
        btnLoadSettings.setMaxWidth(Double.MAX_VALUE);        
        //space.setFillWidth();
        //Set the columns to have a minimum size, pref width, and max size
        ColumnConstraints col1 = new ColumnConstraints();
        ColumnConstraints col2 = new ColumnConstraints();
        ColumnConstraints col3 = new ColumnConstraints();
        col1.setPercentWidth(76);
        col2.setPercentWidth(12);
        col3.setPercentWidth(12);
        gridPane.getColumnConstraints().addAll(col1,col2,col3);
        
        
        
        gridPane.add (browser,             0, 0,  1, 14);
        gridPane.add (lblTrackWidth,       1, 0,  1, 1);
        gridPane.add (txtTrackWidth,       2, 0,  1, 1);
        gridPane.add (lblWheelDiameter,    1, 1,  1, 1);
        gridPane.add (txtWheelDiameter,    2, 1,  1, 1);
        gridPane.add (lblLeftMotor,        1, 2,  1, 1);
        gridPane.add (cboLeftMotor,        2, 2,  1, 1);
        gridPane.add (lblRightMotor,       1, 3,  1, 1);
        gridPane.add (cboRightMotor,       2, 3,  1, 1);
        gridPane.add (lblTouchSensor,      1, 4,  1, 1);
        gridPane.add (cboTouchSensor,      2, 4,  1, 1);         
        gridPane.add (lblUltrasonicSensor, 1, 5,  1, 1);
        gridPane.add (cboUltrasonicSensor, 2, 5,  1, 1);         
        gridPane.add (lblSoundSensor,      1, 6,  1, 1);
        gridPane.add (cboSoundSensor,      2, 6,  1, 1);         
        gridPane.add (lblLightSensor,      1, 7,  1, 1);
        gridPane.add (cboLightSensor,      2, 7,  1, 1);
        gridPane.add (lblMotorPower,       1, 8,  1, 1);
        gridPane.add (cboMotorPower,       2, 8,  1, 1); 
        gridPane.add (lblOutput,           1, 9,  1, 1);
        gridPane.add (txtOutput,           2, 9,  1, 1);
        gridPane.add (btnSaveSettings,     1, 10, 1, 1);
        gridPane.add (btnLoadSettings,     2, 10, 1, 1);                 
        gridPane.add (spacer,              1, 11, 2, 1);   
        gridPane.add (btnZoomIn,           1, 12, 1, 1);
        gridPane.add (btnZoomOut,          2, 12, 1, 1);                                                  
        gridPane.add (btnDownloadCode,     1, 13, 2, 1);      
        
        Scene scene = new Scene(gridPane, 1024, 600);
        stage.setScene(scene);
        stage.setMinWidth(1024);
        stage.setMinHeight(600);
        // show stage
        stage.show();
    }
    
    //This is a global variable to remember the zoomfactor by which to resize the content in the WebView browser
    double zoomFactor = 1.0;
    
    public void zoom(double zoomBy,WebView browser) {
    	/**
    	* zoom takes the zoomBy factor and the WebView broswer to allow the user to zoom in or zoom out on the content in the WebView browser object
    	*
    	* ---Inputs---
    	* double zoomBy   This is the factor by which a user wants to resize the content in the WebView browser object
    	* WebView browser This is WebView object created by the application that acts like a browser to display the blockly.html page  
    	*                 and lets us use the javascript functions necessary to make blockly work.
    	* ---Outputs---
    	* Void
    	*/     
    	zoomFactor += zoomBy;
    	browser.setZoom (zoomFactor);
    }
    
    private void SaveFile(String content, File file){
    	/**
    	* SaveFile takes the String content generated and the File pointer passed from btnSaveSettings action on click then saves to disk
    	*
    	* ---Inputs---
    	* String content This is the string generated by the btnSaveSettings action on click
    	* File file      This is the file object created by the FileChooser object when the user selected  
    	*                an existing OR created a new file to be saved
    	* ---Outputs---
    	* Void
    	*/       
        try {
            FileWriter fileWriter = null;
            
            fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(LegoCodeGen.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private String readFile(File file){
    	/**
    	* readFile takes the File pointer passed from btnLoadSettings action on click
    	*
    	* ---Inputs---
    	* File file      This is the file object created by the FileChooser object when the user selected a file to be read
    	* ---Outputs---
    	* String         This is the content of the bufferReader object filled by the read file passed in
    	*/       
        StringBuilder stringBuffer = new StringBuilder();
        BufferedReader bufferedReader = null;
        
        try {
        	
            bufferedReader = new BufferedReader(new FileReader(file));
            
            String text;
            while ((text = bufferedReader.readLine()) != null) {
                stringBuffer.append(text);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LegoCodeGen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LegoCodeGen.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException ex) {
                Logger.getLogger(LegoCodeGen.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
        return stringBuffer.toString();
    }
    
    public boolean parser(String splitMe, String touch_sen, String light_sen, String sound_sen, String distance_sen, String leftMotor, String rightMotor, String wheelDiam, String trackWid, String motorPower, String output) {
    	/**
    	* parser takes the current state of the blockly workspace and values from the UI to generate syntactically correct nxc code 
    	* for the robot to execute
    	*
    	* ---Inputs---
    	* String splitMe      This is the string generated by the blockly blocks passed from the blockly.html workspace to the java application
    	* String touch_sen    This is the string value of the touch sensor drop down
    	* String light_sen    This is the string value of the light sensor drop down
    	* String sound_sen    This is the string value of the sound sensor drop down
    	* String distance_sen This is the string value of the ultrasonic sensor drop down
    	* String leftMotor    This is the string value of the left motor drop down
    	* String rightMotor   This is the string value of the right motor drop down
    	* String wheelDiam    This is the string value of the wheel diameter text box
    	* String trackWid     This is the string value of the track width diameter text box
    	* String motorPower   This is the string value of the motor power drop down
    	* String output       This is the string value of the output file name text box
    	* ---Outputs---
    	* boolean the reason this is not a void function is because there are cases where I have to return out of the function early to avoid errors
    	*/      
        String[] splitString = splitMe.split("\\n");
        String[] result = new String[1000];
        int r=0;
        
        int motorPowerInt = Integer.parseInt(motorPower) * 10;
        
        double wheelCircum = 0.0;
        double turnCircum = 0.0;
        
        //This is some error checking to make sure the user isn't doing anything computationally illegal
        try {
        	wheelCircum = Double.parseDouble(wheelDiam) * Math.PI;
        	turnCircum= Double.parseDouble(trackWid) * 2 * Math.PI;
        } catch (Exception e) {
        	JOptionPane.showMessageDialog (null, "Please enter a valid number for wheel diameter and track width");
        	return false;
        }
        
        if (output.equals("")){
        	JOptionPane.showMessageDialog (null, "Please enter a valid name for your output file");
        	return false;
        }
        
        //This loop goes through the generated array of strings from the .split() function 
        //and then looks at each index to figure out which block of code to generate
        
        // All NEW 2017-2018 code is at the end of this if statement, will be marked.
        
        // FUTURE IDEA: Some variable that keeps track of indentation and code in all
        // 				functions that impliments this indentation.
        //				Something like: '\t'*indentLevel;
        // CONSEQUENTLY: We may have to stick to very simple things for the demo, no loops or booleans.
        //				 At the very least, nothing that requires indentation.
        for (int i = 0; i < splitString.length; i ++)
        { 
        	if (splitString[i]=="NULL" || splitString[i]=="" || splitString[i]==" "|| splitString[i]=="EOF")
        	{
                break;
            }
            else
            {
                if (splitString[i].contains("move_forward_in"))
                {      
                	String[] tempStrNum = splitString[i].split("!");
                	String trimTempStrNum = tempStrNum[1].trim();
                	double distance = 0.0;
                	try {
                		distance = Double.parseDouble(trimTempStrNum);
                	} catch (Exception e){
                		JOptionPane.showMessageDialog (null, "Please enter a valid number for the move block");
                		return false;
                	}
                	long revDeg = revolutionsDeg(wheelCircum,distance);
                	String tempStrCalculated = Long.toString(revDeg);
                	//take split string and put it as NXC code here, add it to array as a string
                	String NXC_Code="RotateMotor(OUT_"+leftMotor+rightMotor+", "+motorPowerInt+", "+tempStrCalculated+");\n";
                	result[r] = NXC_Code;
                	r++;
                }
                else if (splitString[i].contains("move_forward_ft"))
                {    
                	String[] tempStrNum = splitString[i].split("!");
                	String trimTempStrNum = tempStrNum[1].trim();
                	double distance = 0.0;
                	try {
                		distance = Double.parseDouble(trimTempStrNum) * 12; //convert feet to inches
                	} catch (Exception e){
                		JOptionPane.showMessageDialog (null, "Please enter a valid number for the move block");
                		return false;
                	}
                	long revDeg = revolutionsDeg(wheelCircum,distance);
                	String tempStrCalculated = Long.toString(revDeg);
                	//take split string and put it as NXC code here, add it to array as a string
                	String NXC_Code="RotateMotor(OUT_"+leftMotor+rightMotor+", "+motorPowerInt+", "+tempStrCalculated+");\n";
                	result[r] = NXC_Code;
                	r++;
                }       
                else if (splitString[i].contains("move_backward_in"))
                {  
                	String[] tempStrNum = splitString[i].split("!");
                	String trimTempStrNum = tempStrNum[1].trim();
                	double distance = 0.0;
                	try {
                		distance = Double.parseDouble(trimTempStrNum);
                	} catch (Exception e){
                		JOptionPane.showMessageDialog (null, "Please enter a valid number for the move block");
                		return false;
                	}
                	long revDeg = revolutionsDeg(wheelCircum,distance);
                	String tempStrCalculated = Long.toString(revDeg);
                	//take split string and put it as NXC code here, add it to array as a string
                	String NXC_Code="RotateMotor(OUT_"+leftMotor+rightMotor+", -"+motorPowerInt+", "+tempStrCalculated+");\n";
                	result[r] = NXC_Code;
                	r++;
                }
                else if (splitString[i].contains("move_backward_ft"))
                {   
                	String[] tempStrNum = splitString[i].split("!");
                	String trimTempStrNum = tempStrNum[1].trim();
                	double distance = 0.0;
                	try {
                		distance = Double.parseDouble(trimTempStrNum) * 12;//convert feet to inches
                	} catch (Exception e){
                		JOptionPane.showMessageDialog (null, "Please enter a valid number for the move block");
                		return false;
                	}
                	long revDeg = revolutionsDeg(wheelCircum,distance);
                	String tempStrCalculated = Long.toString(revDeg);
                	//take split string and put it as NXC code here, add it to array as a string
                	String NXC_Code="RotateMotor(OUT_"+leftMotor+rightMotor+", -"+motorPowerInt+", "+tempStrCalculated+");\n";
                	result[r] = NXC_Code;
                	r++;
                }      
                else if (splitString[i].contains("turn_left"))
                {    
                	String[] tempStrNum = splitString[i].split("!");
                	String trimTempStrNum = tempStrNum[1].trim();
                	double tempDegrees = 0.0;   
                	try {
                		tempDegrees = Double.parseDouble(trimTempStrNum);
                	} catch (Exception e){
                		JOptionPane.showMessageDialog (null, "Please enter a valid number for the turn block");
                		return false;
                	}             
                	double distance = (tempDegrees/360D) * turnCircum;
                	long revDeg = revolutionsDeg(wheelCircum,distance);
                	String tempStrCalculated = Long.toString(revDeg); 
                	String NXC_Code="RotateMotor(OUT_"+leftMotor+", "+motorPowerInt+", "+tempStrCalculated+");\n";
                	result[r] = NXC_Code;
                	r++;
                }
                else if (splitString[i].contains("turn_right"))
                {    
                	String[] tempStrNum = splitString[i].split("!");
                	String trimTempStrNum = tempStrNum[1].trim();   
                	double tempDegrees = 0.0;
                	try {
                		tempDegrees = Double.parseDouble(trimTempStrNum);
                	} catch (Exception e){
                		JOptionPane.showMessageDialog (null, "Please enter a valid number for the turn block");
                		return false;
                	}              
                	double distance = (tempDegrees/360D) * turnCircum;
                	long revDeg = revolutionsDeg(wheelCircum,distance);
                	String tempStrCalculated = Long.toString(revDeg); 
                	String NXC_Code="RotateMotor(OUT_"+rightMotor+", "+motorPowerInt+", "+tempStrCalculated+");\n";
                	result[r] = NXC_Code;
                	r++;
                }    
                else if (splitString[i].contains("touch_sensor_fwd"))
                {    
                	if (touch_sen.equals("Not used")) {
                		JOptionPane.showMessageDialog (null, "Please give the touch sensor a valid input number");
                		return false;                     
                	}
                	String NXC_Code="SetSensorTouch(IN_"+touch_sen+");\nOnFwd(OUT_"+leftMotor+rightMotor+", "+motorPowerInt+");\nuntil (Sensor(IN_"+touch_sen+") == 1);\nOff(OUT_"+leftMotor+rightMotor+");\n";
                	result[r] = NXC_Code;
                	r++;
                }
                else if (splitString[i].contains("distance_sensor_fwd_in"))
                {   
                	if (distance_sen.equals("Not used")) {
                		JOptionPane.showMessageDialog (null, "Please give the ultra sonic sensor a valid input number");
                		return false;                     
                	}                
                	String[] tempStrNum = splitString[i].split("!");
                	String trimTempStrNum = tempStrNum[1].trim();
                	long tempDblStrNum = 0;
                	try {
                		tempDblStrNum = Math.round(Double.parseDouble(trimTempStrNum) * 2.54);
                	} catch (Exception e){
                		JOptionPane.showMessageDialog (null, "Please enter a valid number for the ultra sonic sensor block");
                		return false;
                	}      
                	String tempStrCalculated = Long.toString(tempDblStrNum);
                	//take split string and put it as NXC code here, add it to array as a string
                	String NXC_Code="SetSensorLowspeed(IN_"+distance_sen+");\nwhile(true){\nOnFwd(OUT_"+leftMotor+rightMotor+","+motorPowerInt+");\nwhile(SensorUS(IN_"+distance_sen+")>"+tempStrCalculated+");\nOff(OUT_"+leftMotor+rightMotor+");\nbreak;}\n";
                	result[r] = NXC_Code;
                	r++;
                } 
                else if (splitString[i].contains("distance_sensor_fwd_ft"))
                {   
                	if (distance_sen.equals("Not used")) {
                		JOptionPane.showMessageDialog (null, "Please give the ultra sonic sensor a valid input number");
                		return false;                     
                	}                
                	String[] tempStrNum = splitString[i].split("!");
                	String trimTempStrNum = tempStrNum[1].trim();
                	long tempDblStrNum = 0;
                	try {
                		tempDblStrNum = Math.round(Double.parseDouble(trimTempStrNum) * 2.54 * 12); //convert to feet and cm
                	} catch (Exception e){
                		JOptionPane.showMessageDialog (null, "Please enter a valid number for the ultra sonic sensor block");
                		return false;
                	}      
                	String tempStrCalculated = Long.toString(tempDblStrNum);
                	//take split string and put it as NXC code here, add it to array as a string
                	String NXC_Code="SetSensorLowspeed(IN_"+distance_sen+");\nwhile(true){\nOnFwd(OUT_"+leftMotor+rightMotor+","+motorPowerInt+");\nwhile(SensorUS(IN_"+distance_sen+")>"+tempStrCalculated+");\nOff(OUT_"+leftMotor+rightMotor+");\nbreak;}\n";
                	result[r] = NXC_Code;
                	r++;
                }                 
                else if (splitString[i].contains("light_sensor_fwd"))
                {   
                	if (light_sen.equals("Not used")) {
                		JOptionPane.showMessageDialog (null, "Please give the light sensor a valid input number");
                		return false;                     
                	}                
                	int threshold = 0;
                	String[] tempStrNum = splitString[i].split("!");
                	String trimTempStr = tempStrNum[1].trim();
                	String NXC_Code="";
                	if (trimTempStr.equals("light")) { 
                		threshold = 50; 
                		NXC_Code="SetSensorLight(IN_"+light_sen+");\nwhile(true){\nOnFwd(OUT_"+leftMotor+rightMotor+","+motorPowerInt+");\nwhile(Sensor(IN_"+light_sen+") < "+threshold+");\nOff(OUT_"+leftMotor+rightMotor+");\nbreak;}\n";
                	}
                	else { 
                		threshold = 50;
                		NXC_Code="SetSensorLight(IN_"+light_sen+");\nwhile(true){\nOnFwd(OUT_"+leftMotor+rightMotor+","+motorPowerInt+");\nwhile(Sensor(IN_"+light_sen+") > "+threshold+");\nOff(OUT_"+leftMotor+rightMotor+");\nbreak;}\n"; 
                	}
                	//take split string and put it as NXC code here, add it to array as a string
                	
                	result[r] = NXC_Code;
                	r++;
                }      
                else if (splitString[i].contains("sound_sensor_fwd"))
                {   
                	if (sound_sen.equals("Not used")) {
                		JOptionPane.showMessageDialog (null, "Please give the sound sensor a valid input number");
                		return false;                     
                	}                
                	int threshold = 0;
                	String[] tempStrNum = splitString[i].split("!");
                	String trimTempStr = tempStrNum[1].trim();
                	if (trimTempStr.equals("quiet")) { threshold = 30; }
                	else if (trimTempStr.equals("medium")) { threshold = 60; }
                	else { threshold = 90; }
                	//take split string and put it as NXC code here, add it to array as a string
                	String NXC_Code="SetSensorSound(IN_"+sound_sen+");\nwhile(true){\nOnFwd(OUT_"+leftMotor+rightMotor+","+motorPowerInt+");\nif(Sensor(IN_"+sound_sen+") > "+threshold+"){\nOff(OUT_"+leftMotor+rightMotor+");\nbreak;}}\n";
                	result[r] = NXC_Code;
                	r++;
                } 
                else if (splitString[i].contains("touch_sensor_bwd"))
                {    
                	if (touch_sen.equals("Not used")) {
                		JOptionPane.showMessageDialog (null, "Please give the touch sensor a valid input number");
                		return false;                     
                	}
                	String NXC_Code="SetSensorTouch(IN_"+touch_sen+");\nOnFwd(OUT_"+leftMotor+rightMotor+",-"+motorPowerInt+");\nuntil (Sensor(IN_"+touch_sen+") == 1);\nOff(OUT_"+leftMotor+rightMotor+");\n";
                	result[r] = NXC_Code;
                	r++;
                }
                else if (splitString[i].contains("distance_sensor_bwd_in"))
                {   
                	if (distance_sen.equals("Not used")) {
                		JOptionPane.showMessageDialog (null, "Please give the ultra sonic sensor a valid input number");
                		return false;                     
                	}                
                	String[] tempStrNum = splitString[i].split("!");
                	String trimTempStrNum = tempStrNum[1].trim();
                	long tempDblStrNum = 0;
                	try {
                		tempDblStrNum = Math.round(Double.parseDouble(trimTempStrNum) * 2.54);
                	} catch (Exception e){
                		JOptionPane.showMessageDialog (null, "Please enter a valid number for the ultra sonic sensor block");
                		return false;
                	} 
                	String tempStrCalculated = Long.toString(tempDblStrNum);
                	//take split string and put it as NXC code here, add it to array as a string
                	String NXC_Code="SetSensorLowspeed(IN_"+distance_sen+");\nwhile(true){\nOnFwd(OUT_"+leftMotor+rightMotor+",-"+motorPowerInt+");\nwhile(SensorUS(IN_"+distance_sen+")>"+tempStrCalculated+");\nOff(OUT_"+leftMotor+rightMotor+");\nbreak;}\n";
                	result[r] = NXC_Code;
                	r++;
                } 
                else if (splitString[i].contains("distance_sensor_bwd_ft"))
                {   
                	if (distance_sen.equals("Not used")) {
                		JOptionPane.showMessageDialog (null, "Please give the ultra sonic sensor a valid input number");
                		return false;                     
                	}                
                	String[] tempStrNum = splitString[i].split("!");
                	String trimTempStrNum = tempStrNum[1].trim();
                	long tempDblStrNum = 0;
                	try {
                		tempDblStrNum = Math.round(Double.parseDouble(trimTempStrNum) * 2.54 * 12);//convert to feet and cm
                	} catch (Exception e){
                		JOptionPane.showMessageDialog (null, "Please enter a valid number for the ultra sonic sensor block");
                		return false;
                	} 
                	String tempStrCalculated = Long.toString(tempDblStrNum);
                	//take split string and put it as NXC code here, add it to array as a string
                	String NXC_Code="SetSensorLowspeed(IN_"+distance_sen+");\nwhile(true){\nOnFwd(OUT_"+leftMotor+rightMotor+",-"+motorPowerInt+");\nwhile(SensorUS(IN_"+distance_sen+")>"+tempStrCalculated+");\nOff(OUT_"+leftMotor+rightMotor+");\nbreak;}\n";
                	result[r] = NXC_Code;
                	r++;
                } 
                else if (splitString[i].contains("light_sensor_bwd"))
                {   
                	if (light_sen.equals("Not used")) {
                		JOptionPane.showMessageDialog (null, "Please give the light sensor a valid input number");
                		return false;                     
                	}                
                	int threshold = 0;
                	String[] tempStrNum = splitString[i].split("!");
                	String trimTempStr = tempStrNum[1].trim();
                	String NXC_Code="";
                	if (trimTempStr.equals("light")) { 
                		threshold = 50; 
                		NXC_Code="SetSensorLight(IN_"+light_sen+");\nwhile(true){\nOnFwd(OUT_"+leftMotor+rightMotor+",-"+motorPowerInt+");\nwhile(Sensor(IN_"+light_sen+") < "+threshold+");\nOff(OUT_"+leftMotor+rightMotor+");\nbreak;}\n";
                	}
                	else { 
                		threshold = 50;
                		NXC_Code="SetSensorLight(IN_"+light_sen+");\nwhile(true){\nOnFwd(OUT_"+leftMotor+rightMotor+",-"+motorPowerInt+");\nwhile(Sensor(IN_"+light_sen+") > "+threshold+");\nOff(OUT_"+leftMotor+rightMotor+");\nbreak;}\n"; 
                	}
                	//take split string and put it as NXC code here, add it to array as a string
                	
                	result[r] = NXC_Code;
                	r++;
                }      
                else if (splitString[i].contains("sound_sensor_bwd"))
				{	
					if (sound_sen.equals("Not used")) {
						JOptionPane.showMessageDialog (null, "Please give the sound sensor a valid input number");
						return false;					   
					}				   
					int threshold = 0;
					String[] tempStrNum = splitString[i].split("!");
					String trimTempStr = tempStrNum[1].trim();
					if (trimTempStr.equals("quiet")) { threshold = 30; }
					else if (trimTempStr.equals("medium")) { threshold = 60; }
					else { threshold = 90; }
					//take split string and put it as NXC code here, add it to array as a string
					String NXC_Code="SetSensorSound(IN_"+sound_sen+");\nwhile(true){\nOnFwd(OUT_"+leftMotor+rightMotor+",-"+motorPowerInt+");\nif(Sensor(IN_"+sound_sen+") > "+threshold+"){\nOff(OUT_"+leftMotor+rightMotor+");\nbreak;}}\n";
					result[r] = NXC_Code;
					r++;
				}			
//*************************************************************************************************************
                // Begin new 2017-2018 code
                else if (splitString[i].contains("ev3.Sound.speak"))
                {
                	// insert code here
                	
                	result[r] = NXC_Code;
                	r++;
                }
                else{}  
            }
        }
        try
        {
        	//create new output .nxc file -- add necessary elements not added in the first for loop
        	File fout = new File(output+".nxc");
        	FileOutputStream fos = new FileOutputStream(fout);
        	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        	bw.write("task main () {"); //print out the nxc header stuff to file
        	bw.newLine();
        	
        	for (int z = 0; z < r; z++)
        	{
        		bw.write(result[z]); //print out the result array to file
        		bw.newLine();
        	}
        	
        	bw.write("}");    	//print out the nxc footer stuff to file
        	
        	bw.close();
        } 
        catch (IOException e)
        {
        	JOptionPane.showMessageDialog (null, "Problem writing to the file");
        }
        //at this point everything will have been sent to the file, and it should be able to be compiled
        set_compile(output);
        return true;
    }
    
    public long revolutionsDeg(double circum, double distance) {
    	/**
    	* revolutionsDeg takes the computed circumference and desired distance, and then returns the proper number of degrees to rotate
    	*
    	* ---Inputs---
    	* double circum this is the circumference of the circle (either circum of wheels or circum of turning circle)
    	* double distance this is the desired distance you want to travel along the circumference
    	* ---Outputs---
    	* long degrees this is the number of degrees the motors are to turn to move the robot the desired distance
    	*/   
    	double revTemp = distance / circum;
    	double degrees = revTemp * 360;
    	return Math.round(degrees);
    }
    
    public void set_compile(String output) {
    	/**
    	* set_compile takes the generated .nxc output file from parser() and passes it to the Bricx Command Center for compilation
    	*
    	* ---Inputs---
    	* String output this string holds the name of the output file generated by parser()
    	* ---Outputs---
    	* Void
    	*/
    	//Create command line string
    	String CMD = "cmd.exe /c nbc -Susb -d "+output+".nxc -nbc=nbc_assembly.out -E=errors.txt > CompileStatus.out";
    	try {
    		//Runtime object to hold Runtime execution
    		Runtime rt = Runtime.getRuntime();
    		rt.exec(CMD);
    	} catch (Exception e) {
    		e.printStackTrace(System.err);
    	}
    }
    
    
    public static void main(String[] args) {
    	launch(args);
    }
}

