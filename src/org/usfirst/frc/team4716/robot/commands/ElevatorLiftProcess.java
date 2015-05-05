package org.usfirst.frc.team4716.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ElevatorLiftProcess extends CommandGroup {
    
    public  ElevatorLiftProcess() {
    	addParallel(new HoldSystemRelease());
    	addSequential(new ElevatorUp(-0.9,580));
    	//addSequential(new Wait(1.0));
    	addSequential(new HoldSystemLock());
    	addSequential(new ElevatorDown(0.9,10));
    	//addSequential(new StopElevator());
    	
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
