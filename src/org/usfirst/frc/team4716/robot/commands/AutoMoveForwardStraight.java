package org.usfirst.frc.team4716.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoMoveForwardStraight extends CommandGroup {
    
    public  AutoMoveForwardStraight() {
    	addSequential(new Drive_Forward_Manul(2.0,-0.7));
    	//addSequential(new Drive_Turn(0.7,120,true));
    	addSequential(new Drive_Forward_Manul(0.1,0));
    }
}
