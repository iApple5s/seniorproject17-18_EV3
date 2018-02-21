//These javascript definitions define the blocks in the workspace 
//and return a generic string value that the parser in the java application will then convert to real NXC code. 
//The newline characters are delimiters between the generic commands the blocks will generate.

Blockly.JavaScript['turn'] = function(block) {
	var dir = block.getFieldValue('dir');
	var deg = block.getFieldValue('deg');
	
	var code = 'turn_'+dir+'!'+deg+'\n'; 
	
	return code;
};


Blockly.JavaScript['move'] = function(block) {
	var dir  = block.getFieldValue('dir');
	var dist = block.getFieldValue('dist');
	var type = block.getFieldValue('type');  
	
	var code = 'move_'+dir+'_'+type+'!'+dist+'\n';
	
	return code;
};


Blockly.JavaScript['touch_sensor'] = function(block) {
	var dir = block.getFieldValue('dir');
	
	var code = 'touch_sensor_'+dir+'\n';
	
	return code;
};

Blockly.JavaScript['distance_sensor'] = function(block) {
	var dir  = block.getFieldValue('dir');
	var dist = block.getFieldValue('dist');
	var type = block.getFieldValue('type');  
	
	var code = 'distance_sensor_'+dir+'_'+type+'!'+dist+'\n'; 
	
	return code;
	
};

Blockly.JavaScript['light_sensor'] = function(block) {
	var dir = block.getFieldValue('dir');
	var light = block.getFieldValue('light');
	
	var code = 'light_sensor_'+dir+'!'+light+'\n';
    
	return code;
};

Blockly.JavaScript['sound_sensor'] = function(block) {
	var dir = block.getFieldValue('dir');
	var sound = block.getFieldValue('sound');
	
	var code = 'sound_sensor_'+dir+'!'+sound+'\n';
	
	return code;
};

Blockly.JavaScript['led'] = function(block) {
	var dropdown_side = block.getFieldValue('side');
	var dropdown_color = block.getFieldValue('color');
	
	var code = 'led_'+dropdown_side+'!'+dropdown_color+'\n';
	return code;
};

Blockly.JavaScript['speech'] = function(block) {
	var text_speech = block.getFieldValue('speech');
	var code = 'Sound.speak_'+text_speech+'\n';
	return code;
};

Blockly.JavaScript['string'] = function(block) {
	var text_textin = block.getFieldValue('textIn');
	// TODO: Assemble JavaScript into code variable.
	var code = text_textin;
	// TODO: Change ORDER_NONE to the correct strength.
	return [code, Blockly.JavaScript.ORDER_NONE];
};

Blockly.JavaScript['number'] = function(block) {
	var number_numberin = block.getFieldValue('numberIn');
	// TODO: Assemble JavaScript into code variable.
	var code = number_numberin;
	// TODO: Change ORDER_NONE to the correct strength.
	return [code, Blockly.JavaScript.ORDER_NONE];
};

Blockly.JavaScript['boolean'] = function(block) {
	var dropdown_booleandrop = block.getFieldValue('booleanDrop');
	// TODO: Assemble JavaScript into code variable.
	var code = dropdown_booleandrop;
	// TODO: Change ORDER_NONE to the correct strength.
	return code;
};

Blockly.JavaScript['arithmeticop'] = function(block) {
  var value_val1 = Blockly.JavaScript.valueToCode(block, 'val1', Blockly.JavaScript.ORDER_ATOMIC);
  var dropdown_operation = block.getFieldValue('operation');
  var value_val2 = Blockly.JavaScript.valueToCode(block, 'val2', Blockly.JavaScript.ORDER_ATOMIC);
  // TODO: Assemble JavaScript into code variable.
  var code = value_val1+dropdown_operatio+value_val2;
  // TODO: Change ORDER_NONE to the correct strength.
  return code;
};

Blockly.JavaScript['compare'] = function(block) {
  var value_val1 = Blockly.JavaScript.valueToCode(block, 'val1', Blockly.JavaScript.ORDER_ATOMIC);
  var dropdown_comparetype = block.getFieldValue('compareType');
  var value_val2 = Blockly.JavaScript.valueToCode(block, 'val2', Blockly.JavaScript.ORDER_ATOMIC);
  // TODO: Assemble JavaScript into code variable.
  var code = '('+value_val1+dropdown_comparetype+value_val2+')';
  // TODO: Change ORDER_NONE to the correct strength.
  return code;
};
Blockly.JavaScript['if_statement'] = function(block) {
  var value_trigger = Blockly.JavaScript.valueToCode(block, 'trigger', Blockly.JavaScript.ORDER_ATOMIC);
  var statements_code = Blockly.JavaScript.statementToCode(block, 'code');
  // TODO: Assemble JavaScript into code variable.
  var code = 'ifStatement_'+statements_code+'|'; // | is the char signifying a decrement in tab counter
  return code;
};