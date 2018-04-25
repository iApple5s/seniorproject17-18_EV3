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
	var code = text_textin;
	return code;
};

Blockly.JavaScript['number'] = function(block) {
	var number_numberin = block.getFieldValue('numberIn');
	var code = number_numberin;
	return [code, Blockly.JavaScript.ORDER_NONE];
};

Blockly.JavaScript['boolean'] = function(block) {
	var dropdown_booleandrop = block.getFieldValue('booleanDrop');
	var code = "__"+dropdown_booleandrop+"__";
	return [code, Blockly.JavaScript.ORDER_NONE];
};

Blockly.JavaScript['arithmeticop'] = function(block) {
	var value_val1 = Blockly.JavaScript.valueToCode(block, 'val1', Blockly.JavaScript.ORDER_ATOMIC);
	var dropdown_operation = block.getFieldValue('operation');
	var value_val2 = Blockly.JavaScript.valueToCode(block, 'val2', Blockly.JavaScript.ORDER_ATOMIC);
	var code = "("+value_val1+")"+dropdown_operation+"("+value_val2+")";
	return [code, Blockly.JavaScript.ORDER_NONE];
};

Blockly.JavaScript['compare'] = function(block) {
	var value_val1 = Blockly.JavaScript.valueToCode(block, 'val1', Blockly.JavaScript.ORDER_ATOMIC);
	var dropdown_comparetype = block.getFieldValue('compareType');
	var value_val2 = Blockly.JavaScript.valueToCode(block, 'val2', Blockly.JavaScript.ORDER_ATOMIC);
	var code = '('+value_val1+')'+dropdown_comparetype+'('+value_val2+')';
	return [code, Blockly.JavaScript.ORDER_NONE];
};
Blockly.JavaScript['if_statement'] = function(block) {
	var value_trigger = Blockly.JavaScript.valueToCode(block, 'trigger', Blockly.JavaScript.ORDER_ATOMIC);
	var statements_code = Blockly.JavaScript.statementToCode(block, 'code');
	var code = 'ifState __'+value_trigger+"__:State\n"+statements_code+'\n|\n'; // | is the char signifying a decrement in tab counter
	return code;
};






Blockly.JavaScript['touch_sensor'] = function(block) {
	var code = '__ts.value()__';
	return code;
};

Blockly.JavaScript['combo_logic'] = function(block) {
	var block1 = Blockly.JavaScript.valueToCode(block, 'block1', Blockly.JavaScript.ORDER_ATOMIC);
	var dropdown_logicop = block.getFieldValue('logicOp');
	var block2 = Blockly.JavaScript.valueToCode(block, 'block2', Blockly.JavaScript.ORDER_ATOMIC);
	var code = '('+block1+' '+drobdown_logicop+' '+block2+')';
	return code;
}

Blockly.JavaScript['not_logic'] = function(block) {
	var value_name = Blockly.JavaScript.valueToCode(block, 'NAME', Blockly.JavaScript.ORDER_ATOMIC);
	var code = '__not'+value_name+'__';
	return code;
};

Blockly.JavaScript['infrared_sensor'] = function(block) {
	var dropdown_unit = block.getFieldValue('unit');
	// TODO: Assemble JavaScript into code variable.
	var code = '__infrared_'+dropdown_unit+"__";
	// TODO: Change ORDER_NONE to the correct strength.
	return [code, Blockly.JavaScript.ORDER_NONE];
};


Blockly.JavaScript['color_colorbool'] = function(block) {
	var dropdown_color = block.getFieldValue('COLOR');
	// TODO: Assemble JavaScript into code variable.
	var code = '__color_bool_'+dropdown_color+"__";
	// TODO: Change ORDER_NONE to the correct strength.
	return [code, Blockly.JavaScript.ORDER_NONE];
};

Blockly.JavaScript['color_colorint'] = function(block) {
	// TODO: Assemble JavaScript into code variable.
	var code = '__color_int_'+dropdown_color+"__";
	// TODO: Change ORDER_NONE to the correct strength.
	return [code, Blockly.JavaScript.ORDER_NONE];
};

Blockly.JavaScript['color_ambient'] = function(block) {
	// TODO: Assemble JavaScript into code variable.
	var code = '__color_ambient_'+dropdown_color+"__";
	// TODO: Change ORDER_NONE to the correct strength.
	return [code, Blockly.JavaScript.ORDER_NONE];
};

Blockly.JavaScript['color_reflected'] = function(block) {
	// TODO: Assemble JavaScript into code variable.
	var code = '__color_reflected_'+dropdown_color+"__";
	// TODO: Change ORDER_NONE to the correct strength.
	return [code, Blockly.JavaScript.ORDER_NONE];
};

Blockly.JavaScript['ultrasonic_sensor'] = function(block) {
	var dropdown_unit = block.getFieldValue('unit');
	var code = '__ultrasonic_'+dropdown_unit+"__";
	return [code, Blockly.JavaScript.ORDER_NONE];
};

Blockly.JavaScript['gyro_sensor'] = function(block) {
  // TODO: Assemble JavaScript into code variable.
  var code = '__gy.value()__';
  // TODO: Change ORDER_NONE to the correct strength.
  return code;
};


// color color
// bool is color what is defined
// int output of color number
// color ambient light
// color reflected light

//If statement conditions

//What color is being seen block
//Blockly.JavaScript['color_is_seen'] = function(block) {
//	var dropdown_color = block.getFieldValue('color');
//	var code = dropdown_color;
//	return code;
//};