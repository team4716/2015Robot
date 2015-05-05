package org.usfirst.frc.team4716.robot.commands;

import org.usfirst.frc.team4716.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorDown extends Command {
	
	double dist;
	double speed;

    public ElevatorDown(double _speed,double _distance) {
    	this.dist = _distance;
    	this.speed = _speed;
    	requires(Robot.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(Robot.elevator.limitGet() == false){
    	Robot.elevator.moveElevCIM(speed);
    	System.out.println("Elevator Going Up");
    	}

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	 if (Robot.elevator.getEncoderDistance() >= dist){
         	return false;
         } else if(Robot.elevator.getEncoderDistance() <= dist || Robot.elevator.limitGet() == true) {
         	return true;
         } else {
        	 return true;
         }
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.elevator.moveElevCIM(0);
    	

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
