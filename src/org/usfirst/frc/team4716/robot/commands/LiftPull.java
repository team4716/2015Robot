package org.usfirst.frc.team4716.robot.commands;

import org.usfirst.frc.team4716.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
Steven Rice
*/
public class LiftPull extends Command {

    public LiftPull() {
    	requires (Robot.lift);
    }

    protected void initialize() {
    	//Robot.lift.LiftOff();
    	Robot.lift.LiftPull();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
    	if(Robot.lift.getPulledPosition() == false){
            return true;
        	}else{
        		return false;
        	}
    }

    protected void end() {
    	Robot.lift.LiftOff();
    }

    protected void interrupted() {
    	end();
    }
}