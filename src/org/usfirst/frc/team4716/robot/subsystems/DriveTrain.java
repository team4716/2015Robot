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

    /*SpeedController declaration*/
    private SpeedController fleftcim, 
    			      		frightcim, 
    			      		bleftcim, 
    			      		brightcim;
    			      

    /*Encoder declaration*/
    private Encoder           leftDriveEncoder,
    			      rightDriveEncoder;
    /*Gyro declaration*/
    private Gyro              gyro;
    
    /*RobotDrive declaration*/
    private RobotDrive drive;
    
    	public DriveTrain(){
    		
    		
	    	//-------  motor initialization ---------- //
    		//
    		//
    		//
    		//
	    	fleftcim   = new Victor(0);  //3
    		frightcim  = new Victor(1); //1
    		bleftcim   = new Victor(2);  //2
    		brightcim  = new Victor(3); //0
    
    		/*RobotDrive Initialization*/
    		drive = new RobotDrive(fleftcim,frightcim,bleftcim,brightcim);
    		drive.setSafetyEnabled(true);
    		drive.setExpiration(.1);
    		drive.setSensitivity(1);
    		drive.setMaxOutput(1.0);
	
    		/*Encoder Initialzation*/
    		leftDriveEncoder = new Encoder(RobotMap.LEFT_DRIVE_ENCODER_PORT_1,
				       RobotMap.LEFT_DRIVE_ENCDER_PORT_2,
				       false,EncodingType.k4X);
    		rightDriveEncoder = new Encoder(RobotMap.RIGHT_DRIVE_ENCODER_PORT_1,
					RobotMap.RIGHT_DRIVE_ENCDER_PORT_2,
					false,EncodingType.k4X);
	
    		/*Gyro Initialzation*/
    		gyro = new Gyro(0);
    		gyro.setSensitivity(RobotMap.GYRO_SENSITIVITY);
	
    		/*LiveWindow Initialzation*/
    		LiveWindow.addActuator("DriveTrain", "Front Left CIM", (Victor) fleftcim);
    		LiveWindow.addActuator("DriveTrain", "Front Right CIM", (Victor) frightcim);
    		LiveWindow.addActuator("DriveTrain", "Back Left CIM", (Victor) bleftcim);
    		LiveWindow.addActuator("DriveTrain", "Back Right CIM", (Victor) brightcim);
    }

    	public void initDefaultCommand() {
    		setDefaultCommand(new DriveWithJoystick());
    }
    
    	/*Setters*/
    
    	public void reset(){
    		gyro.reset();
    		leftDriveEncoder.reset();
    		rightDriveEncoder.reset();
    }

    	public void gyroReset(){
    		gyro.reset();
    }
    
    	public void tankDrive(double x, double y) {
    		double xPow = Utils.rampSpeed(x, RobotMap.SENSITIVITY/10);
    		double yPow = Utils.rampSpeed(y, RobotMap.SENSITIVITY/10);
    		drive.tankDrive(xPow, yPow);
   	}
    
        
    	public void arcadeDrive(double x, double y){
    		drive.arcadeDrive(x*RobotMap.mFactor,y*RobotMap.mFactor);
    }

    
    	public void driveSet(double output){
    		fleftcim.set(output);
    		frightcim.set(output);
    		bleftcim.set(output);
    		brightcim.set(output);
    }
    	
//        public void driveStraight(double speed){
//        	double leftRate = getleftRate();
//        	double rightRate = getrightRate();
//        	double error = leftRate - rightRate;
//        	double leftpow = speed;
//        	double rightpow = speed;
//        	    	
//        		if (error > 0){
//        			while(error >= 3 && error < 30)
//        		{
//        				if((leftpow - 0.01) < 0 || (rightpow + 0.01) > 1)
//        					break;
//        	    	leftpow -= 0.01;
//        	    	rightpow += 0.01;
//        			error = leftRate - rightRate;
//        	   	}
//        			tankDrive(leftpow, rightpow);
//        	    }else if (error < 0){
//        	    	while(error <= -3 && error > -30)
//        		{
//        	    		if((leftpow + 0.01) > 1 || (rightpow - 0.01) < 0)
//        					break;
//        	    	leftpow += 0.01;
//        	    	rightpow -= 0.01;
//        	    	error = leftRate - rightRate;
//        	   	}
//        	    	tankDrive(leftpow, rightpow);
//        	    }else{
//        	    	tankDrive(leftpow, rightpow);
//        	    }
//        }   
//    
    
    /*Getters*/
    
    	public double getHeading(){
    		return gyro.getAngle();
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
    
    public void driveStraight(double _speed, double _distance){
    	double rightpow,leftpow;
    	boolean start = true;
    	double rightDist = -rightDriveEncoder.getRate();
    	double leftDist = leftDriveEncoder.getRate();
    	double error = rightDist - leftDist;
    	double kP = 0.009;
    	if(rightDist > leftDist){
    		rightpow =  _speed - kP * error;
    		tankDrive(rightpow, _speed);
    	}else if(rightDist < leftDist){
    		leftpow =  _speed - kP * error;
    		tankDrive(_speed, leftpow);
    	}else{
    		tankDrive(_speed,_speed);
    	}
    	
    }
    
    
    public void altDriveStraight(double _speed){
    	double rightpow, leftpow;
    	double angle = gyro.getAngle();
    	double kP = 0.02;
    	if(5 < angle){
    		rightpow =  _speed - kP * angle;
    		tankDrive(rightpow, _speed);
    	}else if(-5 > angle){
    		leftpow =  _speed + kP * angle;
    		tankDrive(_speed, leftpow);
    	}else{
    		tankDrive(_speed,_speed);
    	}
    	
    }
    
    public double gyroAngle (){
    	return gyro.getAngle();
    }
    
    public void turnAngle(double _speed, double _angle, boolean _isRight){
    	double leftpow,rightpow;
    	if (_isRight == true && Math.abs(gyro.getAngle()) < _angle){
    		rightpow = _speed - (gyro.getAngle()/_angle) * _speed;
    		tankDrive(0, rightpow);
    	}else if(_isRight == false && Math.abs(gyro.getAngle()) < _angle){
    		leftpow = _speed - (gyro.getAngle()/_angle) * _speed;
    		tankDrive(leftpow,0);
    	}
    }
    
    /*get Turning rate for auto-straight drive using gyro*/
    	public double getTurning(){
    		double	    angle;
    		double      turning;
    		angle = gyro.getAngle();
    		if(angle<0){
    			turning = -getIRate(angle);
    			
    		}else{
    			turning = getIRate(Math.abs(angle));
    		}
    		return turning;
    }
    
    /*Calculate the difference between left encoder rate and right encoder rate*/
    	public double getDelta(){
    		return getleftRate() - getrightRate();
    }

    /*Provides calculation for getTurning()*/
    	private double getIRate(double arg){
    		return ((-1)/((1/40)*arg +1))+1;
    }

    /*Log*/
    	public void smartDashLog(){
    		SmartDashboard.putNumber("Gyro Angle", gyro.getAngle());
    		SmartDashboard.putNumber("Gyro Rate", gyro.getRate());
    		SmartDashboard.putNumber("Right Drive Encoder", -leftDriveEncoder.getDistance());
    		SmartDashboard.putNumber("Left Drive Encoder", rightDriveEncoder.getDistance());
    		SmartDashboard.putNumber("Delta Encoder",getDelta());
    		SmartDashboard.putNumber("Drive Speeed", RobotMap.mFactor);
    }
}

