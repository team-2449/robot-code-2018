package org.usfirst.frc.team2449.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Compressor extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Compressor robotCompressor = new Compressor();
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void enableCompressor() {
    	robotCompressor.enableCompressor();
    }
    
    public void disableCompressor() {
    	robotCompressor.disableCompressor();
    }
}

