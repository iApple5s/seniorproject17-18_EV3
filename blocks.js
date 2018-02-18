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
        .appendField(new Blockly.FieldTextInput("string"), "STRING");
    this.setOutput(true, "String");
    this.setColour(230);
 this.setTooltip("String input");
 this.setHelpUrl("");
  }
};
Generator stu