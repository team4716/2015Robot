package org.usfirst.frc.team4716.robot.commands;

import org.usfirst.frc.team4716.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveWithJoystick extends Command {

    public DriveWithJoystick() {
    	requires(Robot.drivetrain);
    }

    protected void initialize() {}

    protected void execute() {
    	Robot.drivetrain.arcadeDrive(Robot.oi.getJoyY(), -Robot.oi.getJoyX());
    	
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
