package org.usfirst.frc.team4716.robot.subsystems;

import org.usfirst.frc.team4716.robot.commands.HoldSystemOff;


import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
Steven Rice
*/
public class HoldSystem extends Subsystem {
    
	boolean hold = false;
	DoubleSolenoid Double1;
	DoubleSolenoid Double2;
	
	public HoldSystem() {
		// Two double solenoids to open and close
		Double1 = new DoubleSolenoid(4,5);
		Double2 = new DoubleSolenoid(6,7);
	}
    
    public void initDefaultCommand() {
    	setDefaultCommand(new HoldSystemOff());
    }
    
    public void HoldOff() {
    	// Shut off both double solenoids
    	Double1.set(DoubleSolenoid.Value.kOff);
    	Double2.set(DoubleSolenoid.Value.kOff);
    }
    
    public void HoldLock() {
    	// Forward both solenoids to close
    	Double1.set(DoubleSolenoid.Value.kForward);
    	Double2.set(DoubleSolenoid.Value.kForward);
    	hold = true;
    }
    
    public void HoldRelease() {
    	// Reverse both solenoids to open
    	Double1.set(DoubleSolenoid.Value.kReverse);
    	Double2.set(DoubleSolenoid.Value.kReverse);
    	hold = false;
    	
    	
    }
    
    public void smartDashLog(){
    	SmartDashboard.putBoolean("Hold Status", hold);
    }
}