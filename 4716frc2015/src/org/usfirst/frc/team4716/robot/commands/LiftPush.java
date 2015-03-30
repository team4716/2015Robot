package org.usfirst.frc.team4716.robot.commands;

import org.usfirst.frc.team4716.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
Steven Rice
*/
public class LiftPush extends Command {

    public LiftPush() {
    	requires (Robot.lift);
    }

    protected void initialize() {
    	Robot.lift.LiftPush();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.lift.LiftOff();
    }

    protected void interrupted() {
    	end();
    }
}