package org.usfirst.frc.team4716.robot;



/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
		
	// ***** PWN ***** //
	
	public static final int 	FRONT_LEFT_DRIVE_CIM = 0,
			  			FRONT_RIGHT_DRIVE_CIM = 1,
			  			BACK_LEFT_DRIVE_CIM = 2,
					  	BACK_RIGHT_DRIVE_CIM = 3,
			  			ELEVATOR_CIM = 4;
	
	// ***** DIO ***** //
	
	public static int 	ELEVATOR_ENCODER_PORT_1 = 4,
						ELEVATOR_ENCDER_PORT_2 = 5,
						LEFT_DRIVE_ENCODER_PORT_1 = 0,
						LEFT_DRIVE_ENCDER_PORT_2 = 1,
						RIGHT_DRIVE_ENCODER_PORT_1 = 2,
						RIGHT_DRIVE_ENCDER_PORT_2 = 3;
	
	// ***** PNC ***** //
	
	public static int	LEFT_PISTON_ON_ELEVATOR_PORT_1 = 0, 
						LEFT_PISTON_ON_ELEVATOR_PORT_2 = 1,
						RIGHT_PISTON_ON_ELEVATOR_PORT_1 = 2, 
						RIGHT_PISTON_ON_ELEVATOR_PORT_2 = 3,
						LEFT_PISTON_ELEVATOR_PORT_1 = 4, 
						LEFT_PISTON_ELEVATOR_PORT_2 = 5,
						RIGHT_PISTON_ELEVATOR_PORT_1 = 6, 
						RIGHT_PISTON_ELEVATOR_PORT_2 = 7;
	
	// ***** ANALOG ***** //
	
	public static int	MAIN_GYRO = 0;
	
	// *****
	
	// ***** CONSTANTS ***** //
	
	public static final double GYRO_SENSITIVITY = 0.007;
	
	//Elevator
	public static final double ELEV_DISTANCE = 100.0;
	public static double ELEV_ENCODER_TRAVEL = 0;
	
	// PID
    public static final double DRIVETRAIN_KP = 10.0;
    public static final double DRIVETRAIN_KI = 0.01;
    public static final double DRIVETRAIN_KD = 0.00;
    
    //Drive Constants
    public static double SENSITIVITY = 0.80;
    public static double leftPower = Utils.rampSpeed(SENSITIVITY / 1.0);
    public static double rightPower = Utils.rampSpeed(SENSITIVITY / 1.0);
    
    
    // Camera Stuff
    public static final String CAMERA_ADDRESS = "axis-camera";
    public static final int CAMERA_BRIGHTNESS = 15;
    public static final int CAMERA_COMPRESSION = 0;
    public static final int CAMERA_COLOR_LEVEL = 100;
    public static final int TARGETING_LIGHT_RELAY_CHANNEL = 5;
    
    
    // Targeting and Camera Thingamajigs
    public static final int Y_IMAGE_RES = 480;
    public static final double VIEW_ANGLE = 49.0;
    public static final double PI = 3.141592653;
    public static final int RECTANGULARITY_LIMIT = 40;
    public static final int ASPECT_RATIO_LIMIT = 55;
    public static final int TAPE_WIDTH_LIMIT = 50;
    public static final int VERTICAL_SCORE_LIMIT = 50;
    public static final int LR_SCORE_LIMIT = 50;
    public static final int AREA_MINIMUM = 150;
    public static final int MAX_PARTICLES = 8;
    
    //Autonomous Constants
    
    public static final double WHEEL_DIAMETER = 6;
    public static final double INCHES_PER_REV = (PI * WHEEL_DIAMETER);//18.849555918 
    
    public static double DISTANCE_FEET = 10;
    public static double DISTANCE_INCHES = 18.84;
    
    //Compressor
    public static final int COMPRESSOR_RELAY_CHANNEL = 1;
    public static final int PRESSURE_SWITCH_DIO_CHANNEL = 1;
	
	/* Motors */
    
    public static int DRIVE_STICK = 1,
    				  COMMAND_STICK = 2;
    
    /* Sensors */
   
    
    
 // Axis indexes:
    public static final int
            LEFT_X_AXIS = 1,
            LEFT_Y_AXIS = 2,
            TRIGGERS = 3,
            RIGHT_X_AXIS = 4,
            RIGHT_Y_AXIS = 5,
            DPAD_LR = 6;
    
    // Button mappings:
    public static final int
            BUTTON_A = 1,
            BUTTON_B = 2,
            BUTTON_X = 3,
            BUTTON_Y = 4,
            BUMPER_L = 5,
            BUMPER_R = 6,
            BUTTON_BACK = 7,
            BUTTON_START = 8,
            LEFT_STICK_PRESS = 9,
            RIGHT_STICK_PRESS = 10;
    
    
    
}
