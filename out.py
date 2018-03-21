#!/usr/bin/env python3
from ev3dev.ev3 import *
from time import sleep
motorL = LargeMotor('outB')
motorR = LargeMotor('outC')
motorL.run_to_rel_pos(position_sp=3119, speed_sp=+300, stop_action='hold')
motorR.run_to_rel_pos(position_sp=3119, speed_sp=+300, stop_action='hold')
motorR.wait_while('running')
RotateMotor(OUT_B, 300, 357);

motorL.run_to_rel_pos(position_sp=624, speed_sp=+300, stop_action='hold')
motorR.run_to_rel_pos(position_sp=624, speed_sp=+300, stop_action='hold')
motorR.wait_while('running')
Sound.speak("Done")
