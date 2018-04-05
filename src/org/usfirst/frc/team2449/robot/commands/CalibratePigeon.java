package org.usfirst.frc.team2449.robot.commands;

import org.usfirst.frc.team2449.robot.Robot;

import com.ctre.phoenix.sensors.PigeonIMU.CalibrationMode;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class CalibratePigeon extends Command {

    public CalibratePigeon() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.robotSensors);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("Starting Calibration");
    	Robot.robotSensors.robotIMU.enterCalibrationMode(CalibrationMode.Temperature, 1000);
    	System.out.println("Running Temperature Calibration");
    	Timer.delay(5000);
    	Robot.robotSensors.robotIMU.enterCalibrationMode(CalibrationMode.Magnetometer360, 1000);
    	System.out.println("Running Compass Calibration");
    	Timer.delay(20000);
    	Robot.robotSensors.robotIMU.configTemperatureCompensationEnable(true, 10);
    	System.out.println("Calibration Finished");
    	
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
