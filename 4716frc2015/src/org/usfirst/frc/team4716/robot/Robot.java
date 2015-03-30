
package org.usfirst.frc.team4716.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4716.robot.commands.AutoDoNothing;
import org.usfirst.frc.team4716.robot.commands.AutoMoveForwardStraight;
import org.usfirst.frc.team4716.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4716.robot.subsystems.Elevator;
import org.usfirst.frc.team4716.robot.subsystems.HoldSystem;
import org.usfirst.frc.team4716.robot.subsystems.Lift;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final DriveTrain drivetrain = new DriveTrain();
	public static final Elevator elevator = new Elevator();
	public static final Lift lift = new Lift();
	public static final HoldSystem holdsystem = new HoldSystem();
	public static GlobalSensors globalsensors;
	public static OI oi;
	public NIVision.Rect rect;

    Command autonomousCommand;
    SendableChooser autoChooser2;
    
    CameraServer server1;
    SerialPort serial;
    
    int session;
    Image frame;
    
    Timer gameTimer;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
        //the camera name (ex "cam0") can be found through the roborio web interface
		
		server1 = CameraServer.getInstance();		
		server1.setQuality(25);
		server1.startAutomaticCapture("cam0");
		gameTimer = new Timer();
        gameTimer.start();
			
		//frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
        //session = NIVision.IMAQdxOpenCamera("cam0",
          //      NIVision.IMAQdxCameraControlMode.CameraControlModeController);
        //NIVision.IMAQdxConfigureGrab(session);
		elevator.encoderReset();
		drivetrain.reset();
        // instantiate the command used for the autonomous period
		autoChooser2 = new SendableChooser();
        autoChooser2.addDefault("Auto Nothing", new AutoDoNothing());
        autoChooser2.addObject("Auto Move Straight", new AutoMoveForwardStraight());
        SmartDashboard.putData(Scheduler.getInstance());
        SmartDashboard.putData("AutoMode Chooser", autoChooser2);
        
        autonomousCommand = new AutoDoNothing();

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
    	drivetrain.gyroReset();
    	gameTimer.reset();
        // schedule the autonomous command (example)
    	autonomousCommand = (Command) autoChooser2.getSelected();
        if (autonomousCommand != null) autonomousCommand.start();
        
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        elevator.encoderReset();
        gameTimer.reset();
        //NIVision.IMAQdxStartAcquisition(session);
        drivetrain.reset();
        
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){
    	//NIVision.IMAQdxStopAcquisition(session);
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	drivetrain.smartDashLog();
    	elevator.smartDashLog();
    	holdsystem.smartDashLog();
    	lift.smartDashLog();

    	SmartDashboard.putData(drivetrain);
        SmartDashboard.putData(elevator);
        SmartDashboard.putData(holdsystem);
        SmartDashboard.putData(lift);
        SmartDashboard.putNumber("Elapsed Time", gameTimer.get());
        
        SmartDashboard.putNumber("Drive Stick X", Robot.oi.getJoyX());
        SmartDashboard.putNumber("Drive Stick Y", Robot.oi.getJoyY());
        SmartDashboard.putNumber("Robot Speed", Math.abs(Robot.oi.getJoyY()));
        
        Scheduler.getInstance().run();
        
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
