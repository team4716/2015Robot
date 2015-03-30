package org.usfirst.frc.team4716.robot.commands;

import org.usfirst.frc.team4716.robot.Robot;


import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PIDSetPointElevator extends Command {
	private double setpoint;

    public PIDSetPointElevator(double setpoint) {
    	this.setpoint = setpoint;
    	requires(Robot.elevator);
    }

    protected void initialize() {
    	Robot.elevator.enable();
    	Robot.elevator.setSetpoint(setpoint);
    	System.out.println("PID Elevator Moving... Wow, never thought this would work");
    }

    protected void execute() {
    }

    protected boolean isFinished() {
    	return Math.abs(Robot.elevator.getPosition() - setpoint) < 5;
    }

    protected void end() {
    	Robot.elevator.moveElevCIM(0.0);
    }

    protected void interrupted() {
    	Robot.elevator.moveElevCIM(0.0);
    }
}
