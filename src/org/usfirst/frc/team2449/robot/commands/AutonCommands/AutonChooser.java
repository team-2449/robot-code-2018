package org.usfirst.frc.team2449.robot.commands.AutonCommands;

import org.usfirst.frc.team2449.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutonChooser extends CommandGroup {

    public AutonChooser() {
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
    	
    	if(!Robot.sideChooser.getSelected()) {
    		if(!Robot.robotSensors.getScaleSide()) {
    			new AutonScaleLTL().start();
    		}else {
    			new AutonScaleLTR().start();
    		}
    	}else {
    		if(!Robot.robotSensors.getScaleSide()) {
    			new AutonScaleRTL().start();
    		}else {
    			new AutonScaleRTR().start();
    		}
    	}
    }
}
