package org.usfirst.frc.team4716.robot.commands;

import org.usfirst.frc.team4716.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class HoldSystemRelease extends Command {

    public HoldSystemRelease() {
    	requires(Robot.holdsystem);
    }

    protected void initialize() {
    	Robot.holdsystem.HoldRelease();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
    	if(Robot.holdsystem.getHoldPosition() == false){
        return true;
    	}else{
    		return false;
    	}
    }

    protected void end() {
    	Robot.holdsystem.HoldOff();
    }

    protected void interrupted() {

    }
}
