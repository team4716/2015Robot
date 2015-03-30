package org.usfirst.frc.team4716.robot.commands;

import org.usfirst.frc.team4716.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ResetElevatorEncoder extends Command {

    public ResetElevatorEncoder() {
    	requires(Robot.elevator);
    	setTimeout(0.1);
    }


    protected void initialize() {
    	Robot.elevator.encoderReset();
    }
    
    protected void execute() {
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
