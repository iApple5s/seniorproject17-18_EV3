// basic movements
Blockly.Blocks['turn'] = {
	init: function() {
		this.appendDummyInput()
        .appendField("Turn")
        .appendField(new Blockly.FieldDropdown([["left","left"], ["right","right"],]), "dir")
        .appendField(new Blockly.FieldTextInput(""), "deg")
        .appendField(" degrees")
        this.setPreviousStatement(true, null);
        this.setNextStatement(true, null);
        this.setColour(45);
        this.setTooltip('');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['move'] = {
	init: function() {
		this.appendDummyInput()
        .appendField("Move ")
        .appendField(new Blockly.FieldDropdown([["forward","forward"], ["backward","backward"], ]), "dir")
        .appendField(new Blockly.FieldTextInput(""), "dist")
        .appendField(new Blockly.FieldDropdown([["feet","ft"], ["inches","in"], ]), "type")
        .appendField("")
        this.setPreviousStatement(true, null);
        this.setNextStatement(true, null);
        this.setColour(135);
        this.setTooltip('');
        this.setHelpUrl('');
    }
};

// "drive until" blocks
Blockly.Blocks['touch_sensor'] = {
	init: function() {
		this.appendDummyInput()
        .appendField("Drive ")
        .appendField(new Blockly.FieldDropdown([["forward","fwd"], ["backward","bwd"], ]), "dir")
        .appendField(" until it touches something")
        this.setInputsInline(true);
        this.setPreviousStatement(true, null);
        this.setNextStatement(true, null);
        this.setColour(135);
        this.setTooltip('This will drive the robot forward or backward until it touches something');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['distance_sensor'] = {
	init: function() {
		this.appendDummyInput()
        .appendField("Drive the robot ")
        .appendField(new Blockly.FieldDropdown([["forward","fwd"], ["backward","bwd"], ]), "dir")
        .appendField("until it is ")  
        .appendField(new Blockly.FieldTextInput(""), "dist")
        .appendField(new Blockly.FieldDropdown([["feet","ft"], ["inches","in"], ]), "type")
        .appendField(" away from object");  
        this.setInputsInline(true);
        this.setPreviousStatement(true, null);
        this.setNextStatement(true, null);
        this.setColour(135);
        this.setTooltip('This block will move your robot until you are a specified inches distance from an object');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['light_sensor'] = {
	init: function() {
		this.appendDummyInput()
        .appendField("Drive the robot ")
        .appendField(new Blockly.FieldDropdown([["forward","fwd"], ["backward","bwd"], ]), "dir")
        .appendField("until it sees a ")
        .appendField(new Blockly.FieldDropdown([["light area","light"],["dark area","dark"]]), "light")
        this.setInputsInline(true);
        this.setPreviousStatement(true, null);
        this.setNextStatement(true, null);
        this.setColour(135);
        this.setTooltip('This block will move your robot forward until you run into a white or dark light');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['sound_sensor'] = {
	init: function() {
		this.appendDummyInput()
        .appendField("Drive the robot ")
        .appendField(new Blockly.FieldDropdown([["forward","fwd"], ["backward","bwd"], ]), "dir")   
        .appendField(" until it hears a ")        
        .appendField(new Blockly.FieldDropdown([["quiet sound","quiet"],["medium sound","medium"],["loud sound","loud"]]), "sound")
        this.setInputsInline(true);
        this.setPreviousStatement(true, null);
        this.setNextStatement(true, null);
        this.setColour(135);
        this.setTooltip('This block will move your robot until it hears a sound');
        this.setHelpUrl('');
    }
};

// experimental, single trick blocks
Blockly.Blocks['speech'] = {
	init: function() {
		this.appendDummyInput()
        .appendField("Robot says:")
        .appendField(new Blockly.FieldTextInput(""), "speech");
        this.setPreviousStatement(true, null);
        this.setNextStatement(true, null);
        this.setColour(230);
        this.setTooltip("");
        this.setHelpUrl("");
    }
};

Blockly.Blocks['led'] = {
	init: function() {
		this.appendDummyInput()
        .appendField("LED  Turn")
        .appendField(new Blockly.FieldDropdown([["left","LEFT"], ["right","RIGHT"], ["both","BOTH"]]), "side")
        .appendField("LED")
        .appendField(new Blockly.FieldDropdown([["Red","RED"], ["Green","GREEN"], ["Yellow","YELLOW"], ["Orange","ORANGE"], ["Amber","AMBER"], ["Off","OFF"]]), "color");
        this.setPreviousStatement(true, null);
        this.setNextStatement(true, null);
        this.setColour(230);
        this.setTooltip("");
        this.setHelpUrl("");
    }
};

// Variables, data declarations, and data structures

Blockly.Blocks['global_declare'] = {
	init: function() {
		this.appendValueInput("NAME")
        .setCheck(null)
        .appendField("Create global variable:")
        .appendField(new Blockly.FieldTextInput("name"), "NAME")
        .appendField("Value:");
        this.setColour(230);
        this.setTooltip("Declare a variable");
        this.setHelpUrl("");
    }
};

Blockly.Blocks['string'] = {
	init: function() {
		this.appendDummyInput()
        .appendField(new Blockly.FieldTextInput("Text"), "textIn");
        this.setOutput(true, "String");
        this.setColour(230);
        this.setTooltip("Text input");
        this.setHelpUrl("");
    }
};

Blockly.Blocks['number'] = {
	init: function() {
		this.appendDummyInput()
        .appendField(new Blockly.FieldNumber(0), "numberIn");
        this.setOutput(true, null);
        this.setColour(230);
        this.setTooltip("");
        this.setHelpUrl("");
    }
};

Blockly.Blocks['boolean'] = {
	init: function() {
		this.appendDummyInput()
        .appendField(new Blockly.FieldDropdown([["True","TRUE"], ["False","FALSE"]]), "booleanDrop");
        this.setOutput(true, "Boolean");
        this.setColour(230);
        this.setTooltip("Text input");
        this.setHelpUrl("");
    }
};

Blockly.Blocks['arithmeticop'] = {
	init: function() {
		this.appendValueInput("val1")
        .setCheck(null);
        this.appendDummyInput()
        .appendField(new Blockly.FieldDropdown([["+","add"], ["-","subtract"], ["*","multiply"], ["/","divide"]]), "operation");
        this.appendValueInput("val2")
        .setCheck(null);
        this.setOutput(true, null);
        this.setColour(230);
        this.setTooltip("Arithmetic operations");
        this.setHelpUrl("");
    }
};
Blockly.Blocks['compare'] = {
	init: function() {
		this.appendValueInput("val1")
        .setCheck(null);
        this.appendDummyInput()
        .appendField(new Blockly.FieldDropdown([["==","equal"], ["!=","notEqual"], ["<","lessThan"], [">","greaterThan"], ["<=","lessOrEqual"], [">=","greaterOrEqual"]]), "compareType");
        this.appendValueInput("val2")
        .setCheck(null);
        this.appendDummyInput();
        this.setOutput(true, "Boolean");
        this.setColour(230);
        this.setTooltip("Compare, outputs true/false value");
        this.setHelpUrl("");
    }
};
Blockly.Blocks['if_statement'] = {
	init: function() {
		this.appendValueInput("trigger")
        .setCheck("Boolean")
        .appendField("If:");
        this.appendStatementInput("code")
        .setCheck(null);
        this.setPreviousStatement(true, null);
        this.setNextStatement(true, null);
        this.setColour(230);
        this.setTooltip("If statement, code runs if statement is true");
        this.setHelpUrl("");
    }
};

Blockly.Blocks['touch_sensor'] = {
	init: function() {
		this.appendDummyInput()
        .appendField("Touch Sensor");
        this.setOutput(true, "Boolean");
        this.setColour(230);
        this.setTooltip("Returns true when pressed, false when not.");
        this.setHelpUrl("");
    }
};

Blockly.Blocks['combo_logic'] = {
	init: function() {
		this.appendValueInput("block1")
        .setCheck("Boolean");
        this.appendDummyInput()
        .appendField(new Blockly.FieldDropdown([["and","AND"], ["or","OR"]]), "logicOp");
        this.appendValueInput("block2")
        .setCheck("Boolean");
        this.setOutput(true, "Boolean");
        this.setColour(230);
        this.setTooltip("Boolean logic block");
        this.setHelpUrl("");
    }
};

Blockly.Blocks['not_logic'] = {
	init: function() {
		this.appendValueInput("NAME")
        .setCheck("Boolean")
        .appendField("Not:");
        this.appendDummyInput();
        this.setOutput(true, "Boolean");
        this.setColour(230);
        this.setTooltip("");
        this.setHelpUrl("");
    }
};

Blockly.Blocks['infrared_sensor'] = {
	init: function() {
		this.appendDummyInput()
        .appendField("Infrared Distance in:")
        .appendField(new Blockly.FieldDropdown([["cm","CM"], ["in","IN"], ["mm","MM"]]), "unit");
        this.setOutput(true, "Number");
        this.setColour(230);
        this.setTooltip("Gets current infrared distance in inches, max distance of ~27 inches");
        this.setHelpUrl("");
    }
};

Blockly.Blocks['ultrasonic_sensor'] = {
	init: function() {
		this.appendDummyInput()
        .appendField("Ultrasonic Sensor distance in:")
        .appendField(new Blockly.FieldDropdown([["cm","CM"], ["mm","MM"], ["in","IN"]]), "unit");
        this.setOutput(true, "Number");
        this.setColour(230);
        this.setTooltip("");
        this.setHelpUrl("");
    }
};



Blockly.Blocks['gyro_sensor'] = {
	init: function() {
		this.appendDummyInput()
        .appendField("Gyro sensor angle");
        this.setOutput(true, null);
        this.setColour(230);
        this.setTooltip("Difference from current to start angle, in degrees");
        this.setHelpUrl("");
    }
};



Blockly.Blocks['color_colorbool'] = {
	init: function() {
		this.appendDummyInput()
        .appendField("Is sensor seeing:")
        .appendField(new Blockly.FieldDropdown([["Blue","BLUE"], ["Black","BLACK"], ["Brown","BROWN"], ["Green","GREEN"], ["Red","RED"], ["White","WHITE"], ["Yellow","YELLOW"], ["NoColor","NOCOLOR"]]), "COLOR")
        .appendField("?");
        this.setOutput(true, "Boolean");
        this.setColour(230);
        this.setTooltip("True/false output, if sensor sees defined color");
        this.setHelpUrl("");
    }
};

Blockly.Blocks['color_colorint'] = {
	init: function() {
		this.appendDummyInput()
        .appendField("Color int value");
        this.setOutput(true, "Number");
        this.setColour(230);
        this.setTooltip("Outputs current color as an int value");
        this.setHelpUrl("");
    }
};

Blockly.Blocks['color_ambient'] = {
	init: function() {
		this.appendDummyInput()
        .appendField("Ambient Light Level");
        this.setOutput(true, "Number");
        this.setColour(230);
        this.setTooltip("Ambient light intensity, 0-100");
        this.setHelpUrl("");
    }
};

Blockly.Blocks['color_reflected'] = {
	init: function() {
		this.appendDummyInput()
        .appendField("Reflected Light Level");
        this.setOutput(true, "Number");
        this.setColour(230);
        this.setTooltip("Reflected light level, 0-100");
        this.setHelpUrl("");
    }
};
//If conditions 
