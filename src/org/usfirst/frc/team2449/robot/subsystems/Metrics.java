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

	public void displayDriveTrainDistance() {
		SmartDashboard.putNumber("Left Drivetrain Distance", Robot.robotSensors.left1Encoder.getDistance());
		SmartDashboard.putNumber("Right Drivetrain Distance", Robot.robotSensors.right1Encoder.getDistance());
		
	}
	
	public void displayCurrent() {
		SmartDashboard.putNumber("Port 0", Robot.robotBattery.current0);
		SmartDashboard.putNumber("Port 1", Robot.robotBattery.current1);
		SmartDashboard.putNumber("Port 2", Robot.robotBattery.current2);
		SmartDashboard.putNumber("Port 3", Robot.robotBattery.current3);
		SmartDashboard.putNumber("Port 5", Robot.robotBattery.current6);
		SmartDashboard.putNumber("Total Current", Robot.robotBattery.currentAll);
	}
	
	public void displayPotentiometer() {
		SmartDashboard.putNumber("Potentiometer Degrees", Robot.robotSensors.mastPotentiometer.get());
	}
	
	public void displayDriveTrainVelocity() {
		SmartDashboard.putNumber("Left Drivetrain Velocity", Robot.robotSensors.left1Encoder.getRate());
		SmartDashboard.putNumber("Right Drivetrain Velocity", Robot.robotSensors.right1Encoder.getRate());
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

