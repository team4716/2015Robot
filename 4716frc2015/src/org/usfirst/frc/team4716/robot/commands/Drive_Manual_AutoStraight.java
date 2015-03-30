package org.usfirst.frc.team4716.robot.commands;

import org.usfirst.frc.team4716.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Drive_Manual_AutoStraight extends Command {

	double _L_adj, _R_adj;
	double _delta;
	double _power;
	
    public Drive_Manual_AutoStraight() {
    	requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {}

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	_power = Robot.oi.getJoyY();
    	_delta = Robot.drivetrain.getDelta();
    	if(Math.abs(_delta) > 5){
    		if(_delta > 0){
    			_L_adj = (Robot.drivetrain.getrightRate()/Robot.drivetrain.getleftRate());
    		}else if(_delta < 0){
    			_R_adj = (Robot.drivetrain.getleftRate() /Robot.drivetrain.getrightRate());
    		}
    	}else{
    		_L_adj = 1;
    		_R_adj = 1;
    	}
    	Robot.drivetrain.tankDrive(_power * _L_adj, _power * _R_adj);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
