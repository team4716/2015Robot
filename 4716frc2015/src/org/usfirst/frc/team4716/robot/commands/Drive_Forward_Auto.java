package org.usfirst.frc.team4716.robot.commands;

import org.usfirst.frc.team4716.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Drive_Forward_Auto extends Command {

	private double setpoint;
	private double speed;
	
    public Drive_Forward_Auto(double setpoint,double speed) {
    	requires(Robot.drivetrain);
    	if(speed > 1.0||speed < 0.0)
    		System.out.println("Invalid speed value");
    	else
    		this.speed = speed;
    	
    	if(setpoint < 0.0)
    		System.out.println("Invalid setpoint value");
    	else
    		this.setpoint = setpoint;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.arcadeDrive(speed, Robot.drivetrain.getTurning());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if((Math.abs(setpoint - Robot.drivetrain.getDistance())) < 3)
        	return true;
        else
        	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.driveSet(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.drivetrain.driveSet(0);
    }
}
