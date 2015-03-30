package org.usfirst.frc.team4716.robot.commands;

import org.usfirst.frc.team4716.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
Steven Rice
*/
public class HoldSystemOff extends Command {

    public HoldSystemOff() {
    	requires(Robot.holdsystem);
    }

    protected void initialize() {
    	Robot.holdsystem.HoldOff();
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