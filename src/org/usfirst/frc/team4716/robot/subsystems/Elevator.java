package org.usfirst.frc.team4716.robot.subsystems;

import org.usfirst.frc.team4716.robot.RobotMap;
import org.usfirst.frc.team4716.robot.commands.StopElevator;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Elevator extends Subsystem {
	   
    private SpeedController leftElevCIM, rightElevCIM;
    private Encoder elevEncoder;
    
    public Elevator(){
    	//objects
    	leftElevCIM = new Talon(4);
    	rightElevCIM = new Talon(5);    	    	  	
    	elevEncoder	= new Encoder(RobotMap.ELEVATOR_ENCODER_PORT_1, RobotMap.ELEVATOR_ENCDER_PORT_2,
    							  false, EncodingType.k4X);
    	//properties
    	elevEncoder.setDistancePerPulse(1.0);
    	
    	//live window
    	LiveWindow.addActuator("Elevator", "Elevator CIM", (Talon) leftElevCIM);
    	LiveWindow.addActuator("Elevator", "Elevator CIM", (Talon) rightElevCIM);
    	LiveWindow.addSensor("Encoder", "Elevator Encoder", elevEncoder);
    	
    }

    public void initDefaultCommand() {
        setDefaultCommand(new StopElevator());
    }
    
    //getters     
    public double getEncoderDistance(){
    	return elevEncoder.getDistance();
    }
    
    //setters
    public void moveElevCIM(double speed){
    	leftElevCIM.set(speed);
    	rightElevCIM.set(-speed);
    }
    
    public void smartMoveElevCIM(double _speed, double _distance){
    	double power;
    	double kP = 6.5;
    	if (-elevEncoder.getDistance() < _distance){
    		power = _speed - kP * (-elevEncoder.getDistance()/_distance);
    		leftElevCIM.set(power);
    		rightElevCIM.set(-power);
    	} else if (-elevEncoder.getDistance() > _distance){
    		leftElevCIM.set(0);
    		rightElevCIM.set(0);
    	}
    }

    public void encoderReset(){
    	elevEncoder.reset();
    }
    //logging
    public void smartDashLog(){
    	SmartDashboard.putNumber("Elevator Encoder", elevEncoder.getDistance());
    }
}

