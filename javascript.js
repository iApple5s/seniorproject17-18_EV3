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


