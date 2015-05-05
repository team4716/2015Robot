package org.usfirst.frc.team4716.robot.commands;

import org.usfirst.frc.team4716.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorUp extends Command {
	double dist;
	double speed;
	
    public ElevatorUp(double _speed,double _distance) {
    	this.dist = _distance;
    	this.speed = _speed;
    	requires(Robot.elevator);
    }
    
    protected void initialize() {
    	Robot.elevator.moveElevCIM(speed);
    	System.out.println("Elevator Going Up");
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        if (Robot.elevator.getEncoderDistance() >= dist){
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
