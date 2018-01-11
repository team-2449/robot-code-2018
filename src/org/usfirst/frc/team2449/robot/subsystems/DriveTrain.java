package org.usfirst.frc.team2449.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void basicDrive(double leftPower, double rightPower) {
		//Basic Driving using direct power mapping
	}
	
	public void changeControlMode(ControlMode controlMode) {
		//Change Talon SRX Control Mode
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
}

