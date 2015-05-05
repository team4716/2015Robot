package org.usfirst.frc.team4716.robot.subsystems;

import org.usfirst.frc.team4716.robot.commands.HoldSystemOff;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
*Steven Rice
*/
public class HoldSystem extends Subsystem {
    
	boolean hold = false;
	DoubleSolenoid holdpiston;
	
	public HoldSystem() {
		//objects
		holdpiston = new DoubleSolenoid(2,3);
		//holdpiston = new Solenoid(0);
		//live window
		LiveWindow.addActuator("Hold System", "Solenoid Status", holdpiston);
	}
    
    public void initDefaultCommand() {
    	setDefaultCommand(new HoldSystemOff());
    }
    
    //getters
    public boolean getHoldPosition(){
    	return hold;
    }
    
    //setters
    public void HoldOff() {
    	// Shut off both double solenoids
    	//holdpiston.set(true);
    }
    
    public void HoldLock() {
    	// Forward both solenoids to close
    	holdpiston.set(DoubleSolenoid.Value.kForward);
    	hold = true;
    }
    
    public void HoldRelease() {
    	// Reverse both solenoids to open
    	holdpiston.set(DoubleSolenoid.Value.kReverse);
    	hold = false; 	
    }
    
    //logging
    public void smartDashLog(){
    	SmartDashboard.putBoolean("Hold Status", hold);
    }
}