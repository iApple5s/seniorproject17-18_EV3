1. Compiling the project

  You need java 8 installed on your machine, and make sure the nbc.exe is in your folder with your class files
  We used jGrasp to compile the project. 
  Javac LegoCodeGen.java doesn’t work because jGrasp is compiling with some flags that we didn’t do much research 
  on. We just got it to work with jGrasp and had to figure out other things along the way. 


2. How to make a block.

  I highly recommend you visit https://blockly-demo.appspot.com/static/demos/blockfactory/index.html to familiarize 
  yourself with the different input options for a Blockly block. We use JavaScript block definitions and JavaScript Generator stubs in this project.
  The block definitions go into blocks.js in the working directory of the project, and the generator stubs go into javascript.js.
  Be careful messing around with this too much because JavaScript doesn’t spit out compilation errors, it simply doesn’t 
  work. So if you miss a comma or a semi colon, you may wrack your brain for a good hour or two before you find it.


3. Notes on block/code generation.

  We cleaned up a lot of the code in javascript.js to be more scalable for future implementation. Unfortunately, the 
  logic within the LegoCodeGen parser() function is very static at the moment. One of the first things to be worked on 
  would be making the logic more generic so it is more maintainable and more scalable for future additions to the program.


4. Helpful bits of code/documentation for debugging purposes

  After the btnDownloadCode.setOnAction(
                 String code = (String) webEngine.executeScript("getCode()");
                 String msg = "";
                 msg += " Track with " + txtTrackWidth.getText() + "\n";
                 msg += " Wheel diameter "  + txtWheelDiameter.getText()+ "\n";
                 msg += " Left motor " + cboLeftMotor.getValue() + "\n";
                 msg += " Right motor " + cboRightMotor.getValue() + "\n";
                 msg += " Touch sensor " + cboTouchSensor.getValue() + "\n";
                 msg += " Ultrasonic sensor " + cboUltrasonicSensor.getValue() + "\n";
                 msg += " Sound sensor " + cboSoundSensor.getValue() + "\n";
                 msg += " Light sensor " + cboLightSensor.getValue() + "\n";
                 msg += "\n" + code;
                 JOptionPane.showMessageDialog (null, msg);
  That bit of code is super useful for seeing the state of the UI variables and what code the blocks are actually generating and sending to your application.


  Useful documentation links
  https://docs.oracle.com/javase/8/javafx/api/javafx/scene/web/WebEngine.html
  https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/GridPane.html
  http://bricxcc.sourceforge.net/nbc/nxcdoc/NXC_tutorial.pdf
  http://bricxcc.sourceforge.net/nbc/nxcdoc/nxcapi/index.html




5. General thoughts on the project
        
  There is a lot of things we did just to make it work due to our crunched time table. Ideally a lot of our logic would be easily maintained, but unfortunately we had to do case by case as they came up because we didn’t know what the next problem was going to be.  I think it would be really cool to have different blockly.html web pages that get loaded in based on the abilities of the user. So there would be a beginner, intermediate, and advanced blockly.html page that would have easier to more advanced blocks for the advanced users. I also think Dr. Marsh’s idea of controlling a virtual robot would be really cool to implement. 

  If you have any questions or need any help feel free to contact me at michael58201@gmail.com and I will do my best to help you out. Even though I have not worked on the project since May 2017.