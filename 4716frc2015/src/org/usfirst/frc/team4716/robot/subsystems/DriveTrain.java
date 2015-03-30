package org.usfirst.frc.team4716.robot.subsystems;

import org.usfirst.frc.team4716.robot.RobotMap;
import org.usfirst.frc.team4716.robot.Utils;
import org.usfirst.frc.team4716.robot.commands.DriveWithJoystick;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrain extends Subsystem {
    
    private SpeedController    fleftcim, 
    						   frightcim, 
    						   bleftcim, 
    						   brightcim;
    
    private Encoder 		   leftDriveEncoder,
    						   rightDriveEncoder;
    
    private Gyro               gyro;
    
    private RobotDrive drive;
    
    public DriveTrain(){
    	//motor = new Victor(RobotMap.LEFT_DRIVE_CIM);
    	fleftcim    = new Victor(0);  //3
    	frightcim   = new Victor(1); //1
    	bleftcim    = new Victor(2);  //2
    	brightcim   = new Victor(3); //0
    
    	
    	drive = new RobotDrive(fleftcim,frightcim,bleftcim,brightcim);
    	//drive = new RobotDrive(fleftcim, frightcim);
    	drive.setSafetyEnabled(true);
		drive.setExpiration(.1);
		drive.setSensitivity(1);
		drive.setMaxOutput(1.0);
		
    	LiveWindow.addActuator("DriveTrain", "Front Left CIM", (Victor) fleftcim);
    	LiveWindow.addActuator("DriveTrain", "Front Right CIM", (Victor) frightcim);
    	LiveWindow.addActuator("DriveTrain", "Back Left CIM", (Victor) bleftcim);
    	LiveWindow.addActuator("DriveTrain", "Back Right CIM", (Victor) brightcim);

		
		leftDriveEncoder = new Encoder(RobotMap.LEFT_DRIVE_ENCODER_PORT_1,RobotMap.LEFT_DRIVE_ENCDER_PORT_2,
								false,EncodingType.k4X);
		rightDriveEncoder = new Encoder(RobotMap.RIGHT_DRIVE_ENCODER_PORT_1,RobotMap.RIGHT_DRIVE_ENCDER_PORT_2,
								false,EncodingType.k4X);
		
		gyro = new Gyro(0);
		gyro.setSensitivity(RobotMap.GYRO_SENSITIVITY);
    }

    public void initDefaultCommand() {
    	setDefaultCommand(new DriveWithJoystick());
    }
    
    public void tankDrive(double x, double y) {
        double xPow = Utils.rampSpeed(x, RobotMap.SENSITIVITY/10);
        double yPow = Utils.rampSpeed(y, RobotMap.SENSITIVITY/10);
        drive.tankDrive(xPow, yPow);
    }
    
    public void reset(){
    	gyro.reset();
    	leftDriveEncoder.reset();
    	rightDriveEncoder.reset();
    }
    
    public double getHeading(){
    	return gyro.getAngle();
    }
    
    private double getIRate(double arg){
    	return ((-1)/((1/40)*arg +1))+1;
    }
    
    public double getTurning(){
    	double		angle;
    	double      turning;
    	angle = gyro.getAngle();
    	if(angle>5)
    		turning = -getIRate(angle);
    	else if(angle < -5)
    		turning = getIRate(Math.abs(angle));
    	else
    		turning = 0.0;
    	
    	return turning;
    }
    
    public double getDistance(){
    	return (-leftDriveEncoder.getDistance() + rightDriveEncoder.getDistance())/2;
    }
    
    public double getleftRate(){
    	return -leftDriveEncoder.getRate();
    }
    
    public double getrightRate(){
    	return rightDriveEncoder.getRate();
    }

    public void arcadeDrive(double x, double y){
    	drive.arcadeDrive(x,y);
    }
    
    public void gyroReset(){
    	gyro.reset();
    }
    
    public void driveSet(double output){
    	fleftcim.set(output);
    	frightcim.set(output);
    	bleftcim.set(output);
    	brightcim.set(output);
    }
    
    public double getDelta(){
    	return getleftRate() - getrightRate();
    }
    
    public void smartDashLog(){
    	SmartDashboard.putNumber("Gyro Angle", gyro.getAngle());
    	SmartDashboard.putNumber("Gyro Rate", gyro.getRate());
    	SmartDashboard.putNumber("Left Drive Encoder", -leftDriveEncoder.getDistance());
    	SmartDashboard.putNumber("Right Drive Encoder", rightDriveEncoder.getDistance());
    	
    	
    }
    
}

