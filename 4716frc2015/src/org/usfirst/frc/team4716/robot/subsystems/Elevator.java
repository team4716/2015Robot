package org.usfirst.frc.team4716.robot.subsystems;

import org.usfirst.frc.team4716.robot.RobotMap;
import org.usfirst.frc.team4716.robot.commands.StopElevator;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Elevator extends PIDSubsystem {
	
	private static final double Kp = 1.0;
    private static final double Ki = 0.0;
    private static final double Kd = 0.0;
    
    private SpeedController elevCIM;
    private Encoder elevEncoder;
    
    //private double encodeCount;
    
    public Elevator(){
    	super("Elevator", Kp, Ki, Kd);
    	elevCIM = new Victor(4);
    	LiveWindow.addActuator("Elevator", "Elevator CIM", (Victor) elevCIM);
    	
    	
    	elevEncoder = new Encoder(RobotMap.ELEVATOR_ENCODER_PORT_1, RobotMap.ELEVATOR_ENCDER_PORT_2,
    							  false, EncodingType.k4X);
    	elevEncoder.setDistancePerPulse(1.0);
    	LiveWindow.addSensor("Encoder", "Elevator Encoder", elevEncoder);
    
        LiveWindow.addActuator("Elevator", "PID", getPIDController());
        
        setInputRange(0, 50);
        setAbsoluteTolerance(0.5);
        setOutputRange(-0.5,0.5);
    	setSetpoint(RobotMap.ELEV_DISTANCE);
    	enable();
    	
    	
    }

    public void initDefaultCommand() {
        setDefaultCommand(new StopElevator());
    }
    
    protected double returnPIDInput() {
        return elevEncoder.pidGet();
    }
    
    protected void usePIDOutput(double output) {
        elevCIM.pidWrite(output);
    }
    
    
    public void moveElevCIMUpInInches(double speed){
    	if (elevEncoder.getDistance() <= RobotMap.ELEV_DISTANCE){
    		elevCIM.set(0.0);
    	}else{
    		elevCIM.set(speed);
    	}
    	
    }
    
    
    public double getEncoderDistance(){
    	return elevEncoder.getDistance();
    }
    public void moveElevCIM(double speed){
    	elevCIM.set(speed);
    }

    public void encoderReset(){
    	elevEncoder.reset();
    }
    public void smartDashLog(){
    	SmartDashboard.putNumber("Elevator Encoder", elevEncoder.getDistance());
    }
}

