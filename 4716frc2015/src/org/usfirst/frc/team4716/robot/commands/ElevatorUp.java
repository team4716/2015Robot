package org.usfirst.frc.team4716.robot.commands;

import org.usfirst.frc.team4716.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorUp extends Command {
	
    public ElevatorUp() {
    	requires(Robot.elevator);
    }
    
    protected void initialize() {
    	Robot.elevator.moveElevCIM(0.7);
    	System.out.println("Elevator Going Up");
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        if (Robot.elevator.getEncoderDistance() >= 100.0){
        	return true;
        } else {
        	return false;
        }
    }

    protected void end() {
    	Robot.elevator.moveElevCIM(0);
    }

    protected void interrupted() {
    	Robot.elevator.moveElevCIM(0);
    }
}
