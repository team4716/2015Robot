package org.usfirst.frc.team4716.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4716.robot.commands.ElevatorDown;
import org.usfirst.frc.team4716.robot.commands.ElevatorLiftProcess;
import org.usfirst.frc.team4716.robot.commands.ElevatorUp;
import org.usfirst.frc.team4716.robot.commands.HoldSystemLock;
import org.usfirst.frc.team4716.robot.commands.HoldSystemRelease;
import org.usfirst.frc.team4716.robot.commands.LiftPull;
import org.usfirst.frc.team4716.robot.commands.LiftPush;
import org.usfirst.frc.team4716.robot.commands.PIDSetPointElevator;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	Joystick stick       = new Joystick(0);
	Joystick stick2      = new Joystick(1);
	Joystick control 	 = new Joystick(2);
	Joystick test        = new Joystick(3);
	
	JoystickButton but1  = new JoystickButton(stick, 1);
	JoystickButton but2  = new JoystickButton(stick, 2);
	JoystickButton but3  = new JoystickButton(stick, 3);
	JoystickButton but4  = new JoystickButton(stick, 4);
	JoystickButton but5  = new JoystickButton(stick, 5);
	JoystickButton but6  = new JoystickButton(stick, 6);
	JoystickButton but7  = new JoystickButton(stick, 7);
	
	JoystickButton A     = new JoystickButton(control, RobotMap.BUTTON_A);
	JoystickButton B     = new JoystickButton(control, RobotMap.BUTTON_B);
	JoystickButton X     = new JoystickButton(control, RobotMap.BUTTON_X);
	JoystickButton Y     = new JoystickButton(control, RobotMap.BUTTON_Y);
	JoystickButton START = new JoystickButton(control, RobotMap.BUTTON_START);
	JoystickButton BACK  = new JoystickButton(control, RobotMap.BUTTON_BACK);
	JoystickButton xbut7 = new JoystickButton(control, 7);
	
	JoystickButton tbut1 = new JoystickButton(test, 1);
	JoystickButton tbut2 = new JoystickButton(test, 2);
	JoystickButton tbut3 = new JoystickButton(test, 3);
	JoystickButton tbut4 = new JoystickButton(test, 4);
	JoystickButton tbut5 = new JoystickButton(test, 5);
	JoystickButton tbut6 = new JoystickButton(test, 6);
	JoystickButton tbut7 = new JoystickButton(test, 7);
	

	
	
	public OI(){
		tbut1.whenPressed(new ElevatorLiftProcess());
		tbut2.whenPressed(new HoldSystemLock());
		tbut3.whenPressed(new HoldSystemRelease());
		tbut4.whenPressed(new ElevatorUp());
		tbut5.whenPressed(new ElevatorDown());
		tbut6.whenPressed(new LiftPull());
		tbut7.whenPressed(new LiftPush());
		
		A.whenPressed(new ElevatorLiftProcess());
		B.whenPressed(new ElevatorUp());
		X.whenPressed(new ElevatorDown());
		START.whenPressed(new PIDSetPointElevator(10.0));
		BACK.whenPressed(new PIDSetPointElevator(0.0));
		
		SmartDashboard.putData("Elevator Lift Process", new ElevatorLiftProcess());
		SmartDashboard.putData("Hold System Lock", new HoldSystemLock());
		SmartDashboard.putData("Hold System Release", new HoldSystemRelease());
		SmartDashboard.putData("Elevator Up", new ElevatorUp());
		SmartDashboard.putData("Elevator Down", new ElevatorDown());
		SmartDashboard.putData("Lift Pull", new LiftPull());
		SmartDashboard.putData("Lift Pull", new LiftPush());	
		
		
	}
	
	public double getLeftSpeed(){
		return stick.getY();
	}
	
	public double getRightSpeed(){
		return stick2.getY();
	}
	
	public double getJoyX(){
		return stick.getX();
	}
	
	public double getJoyY(){
		return stick.getY();
	}
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}

