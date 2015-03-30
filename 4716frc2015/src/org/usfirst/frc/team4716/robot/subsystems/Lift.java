package org.usfirst.frc.team4716.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4716.robot.commands.LiftOff;

/**
Steven Rice
*/
public class Lift extends Subsystem {
	
	boolean pulled = false;
	DoubleSolenoid Double1;
	DoubleSolenoid Double2;
	
	public Lift() {
		Double1 = new DoubleSolenoid(0,1);
		Double2 = new DoubleSolenoid(2,3);
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new LiftOff());
    }
    
    public void LiftOff() {
    	// Shut off both double solenoids
    	Double1.set(DoubleSolenoid.Value.kOff);
    	Double2.set(DoubleSolenoid.Value.kOff);
    }
    
    public void LiftPush() {
    	// Pushes lift to 90 Degrees
    	Double1.set(DoubleSolenoid.Value.kForward);
    	Double2.set(DoubleSolenoid.Value.kForward);
    	pulled = false;
    }
    
    public void LiftPull() {
    	// Pulls back lift to 22 degrees
    	Double1.set(DoubleSolenoid.Value.kReverse);
    	Double2.set(DoubleSolenoid.Value.kReverse);
    	pulled = true; 
    }
    
    public void smartDashLog(){
    	SmartDashboard.putBoolean("Lift Status", pulled);
    }
}