package org.usfirst.frc.team4716.robot.commands;

import org.usfirst.frc.team4716.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Drive_Turn extends Command {
	double speed,angle;
	boolean isRight;

    public Drive_Turn(double _speed, double _angle, boolean _isRight) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.speed = _speed;
    	this.angle = _angle;
    	this.isRight = _isRight;
    	requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.gyroReset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.turnAngle(speed, angle, isRight);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (Math.abs(this.angle) >= Robot.drivetrain.gyroAngle()){
        	return false;
        }else{
        	return true;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
