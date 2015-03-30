package org.usfirst.frc.team4716.robot.commands;

import org.usfirst.frc.team4716.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
Steven Rice
*/
public class LiftOff extends Command {

    public LiftOff() {
    	requires(Robot.lift);
    }
    
    protected void initialize() {
    	Robot.lift.LiftOff();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}