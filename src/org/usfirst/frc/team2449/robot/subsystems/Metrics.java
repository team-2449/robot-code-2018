package org.usfirst.frc.team2449.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.hal.PDPJNI;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Metrics extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void displayVoltage() {
		SmartDashboard.putNumber("Battery Voltage", PDPJNI.getPDPVoltage(0));
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

