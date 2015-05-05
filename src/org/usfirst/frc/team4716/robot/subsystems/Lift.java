package org.usfirst.frc.team4716.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4716.robot.commands.LiftOff;

/**
*Steven Rice
*/
public class Lift extends Subsystem {
	
	boolean pulled = true;
	DoubleSolenoid lift;
	
	public Lift() {
		//objects
		lift = new DoubleSolenoid(0,1);
		
		//live window
		LiveWindow.addActuator("DriveTrain", "Back Right CIM", lift);
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new LiftOff());
    }
    
    //getters
    public boolean getPulledPosition(){
    	return pulled;
    }
    
    //setters
    public void LiftOff() {
    	// Shut off both double solenoids
    	lift.set(DoubleSolenoid.Value.kOff);
    }
    
    public void LiftPush() {
    	// Pushes lift to 90 Degrees
    	lift.set(DoubleSolenoid.Value.kForward);
    	pulled = false;
    }
    
    public void LiftPull() {
    	// Pulls back lift to 22 degrees
    	lift.set(DoubleSolenoid.Value.kReverse);
    	pulled = true; 
    }
    
    //logging
    public void smartDashLog(){
    	SmartDashboard.putBoolean("Lift Status", pulled);
    }
}