package org.usfirst.frc.team4716.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4716.robot.commands.Drive_Forward_Manul;
import org.usfirst.frc.team4716.robot.commands.ElevatorLiftProcess;
import org.usfirst.frc.team4716.robot.commands.ElevatorUnloadProcess;
import org.usfirst.frc.team4716.robot.commands.ElevatorUp;
import org.usfirst.frc.team4716.robot.commands.HoldSystemLock;
import org.usfirst.frc.team4716.robot.commands.HoldSystemRelease;
import org.usfirst.frc.team4716.robot.commands.LiftPull;
import org.usfirst.frc.team4716.robot.commands.LiftPush;
import org.usfirst.frc.team4716.robot.commands.ManualElevDown;
import org.usfirst.frc.team4716.robot.commands.ManualElevUp;
import org.usfirst.frc.team4716.robot.commands.ResetRobot;

/**
 * 
 */
public class OI {
	
	Joystick stick = new Joystick(0);
	Joystick stick2 = new Joystick(1);
	Joystick control = new Joystick(2);
	Joystick test = new Joystick(3);
	
	JoystickButton but1 = new JoystickButton(stick, 1);
	JoystickButton but2 = new JoystickButton(stick, 2);
	JoystickButton but3 = new JoystickButton(stick, 3);
	JoystickButton but4 = new JoystickButton(stick, 4);
	JoystickButton but5 = new JoystickButton(stick, 5);
	JoystickButton but6 = new JoystickButton(stick, 6);
	JoystickButton but7 = new JoystickButton(stick, 7);
	
	JoystickButton sbut1 = new JoystickButton(stick2, 1);
	JoystickButton sbut2 = new JoystickButton(stick2, 2);
	JoystickButton sbut3 = new JoystickButton(stick2, 3);
	JoystickButton sbut4 = new JoystickButton(stick2, 4);
	JoystickButton sbut5 = new JoystickButton(stick2, 5);
	JoystickButton sbut6 = new JoystickButton(stick2, 6);
	JoystickButton sbut7 = new JoystickButton(stick2, 7);
	
	JoystickButton A = new JoystickButton(control, RobotMap.BUTTON_A);
	JoystickButton B = new JoystickButton(control, RobotMap.BUTTON_B);
	JoystickButton X = new JoystickButton(control, RobotMap.BUTTON_X);
	JoystickButton Y = new JoystickButton(control, RobotMap.BUTTON_Y);
	JoystickButton START = new JoystickButton(control, RobotMap.BUTTON_START);
	JoystickButton BACK = new JoystickButton(control, RobotMap.BUTTON_BACK);
	JoystickButton RIGHT_TRIGGER = new JoystickButton(control, RobotMap.BUMPER_R);
	JoystickButton LEFT_TRIGGER = new JoystickButton(control, RobotMap.BUMPER_L);
	JoystickButton xbut7 = new JoystickButton(control, 7);
	
	JoystickButton tbut1 = new JoystickButton(test, 1);
	JoystickButton tbut2 = new JoystickButton(test, 2);
	JoystickButton tbut3 = new JoystickButton(test, 3);
	JoystickButton tbut4 = new JoystickButton(test, 4);
	JoystickButton tbut5 = new JoystickButton(test, 5);
	JoystickButton tbut6 = new JoystickButton(test, 6);
	JoystickButton tbut7 = new JoystickButton(test, 7);
	JoystickButton tbut8 = new JoystickButton(test, 8);
	JoystickButton tbut9 = new JoystickButton(test, 9);
	

	
	
	public OI(){
		
	
		but3.whileHeld(new Drive_Forward_Manul(2.0, stick.getY()));
		
		sbut1.whenPressed(new ElevatorLiftProcess());
		sbut2.whenPressed(new ElevatorUnloadProcess());
		sbut3.whenPressed(new ResetRobot());
		sbut4.whenPressed(new ElevatorUp(0.6,-200));
		sbut5.whenPressed(new ElevatorUp(-0.6, -200));
		
		
		tbut1.whenPressed(new ElevatorLiftProcess());
		tbut2.whenPressed(new HoldSystemLock());
		tbut3.whenPressed(new HoldSystemRelease());
		//tbut4.whenPressed(new ElevatorUp());

		tbut6.whenPressed(new LiftPull());
		tbut7.whenPressed(new LiftPush());
		tbut8.whileHeld(new ManualElevUp());
		tbut9.whileHeld(new ManualElevDown());
		
		A.whenPressed(new ElevatorLiftProcess());
//		B.whenPressed(new ElevatorUp());
//		X.whenPressed(new ElevatorDown());
		//Y.whenPressed(0);
		RIGHT_TRIGGER.whenPressed(new LiftPush());
		LEFT_TRIGGER.whenPressed(new LiftPull());
//		START.whenPressed(new PIDSetPointElevator(10.0));
//		BACK.whenPressed(new PIDSetPointElevator(0.0));
		
		SmartDashboard.putData("Elevator Lift Process", new ElevatorLiftProcess());
		SmartDashboard.putData("Hold System Lock", new HoldSystemLock());
		SmartDashboard.putData("Hold System Release", new HoldSystemRelease());
//		SmartDashboard.putData("Elevator Up", new ElevatorUp());
//		SmartDashboard.putData("Elevator Down", new ElevatorDown());
		SmartDashboard.putData("Lift Pull", new LiftPull());
		SmartDashboard.putData("Lift Push", new LiftPush());	
		
		
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

}

