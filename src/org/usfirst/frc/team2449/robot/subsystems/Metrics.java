package org.usfirst.frc.team2449.robot.subsystems;

import org.usfirst.frc.team2449.robot.Robot;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Metrics extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void displayTeamColor() {
		SmartDashboard.putString("Team Color", Robot.robotVision.getTeamColor().toString());
	}
	
	public void displayGyroHeading() {
		SmartDashboard.putNumber("Gyro Heading", Robot.robotSensors.robotGyro.getAngle());
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

