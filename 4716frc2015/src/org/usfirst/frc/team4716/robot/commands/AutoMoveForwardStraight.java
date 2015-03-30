package org.usfirst.frc.team4716.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoMoveForwardStraight extends CommandGroup {
    
    public  AutoMoveForwardStraight() {
    	addSequential(new Drive_Forward());
    }
}
