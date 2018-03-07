package org.usfirst.frc.team2449.robot.subsystems;

import org.usfirst.frc.team2449.robot.Robot;

import com.ctre.phoenix.sensors.PigeonIMU;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Sensors extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public ADXRS450_Gyro robotGyro=new ADXRS450_Gyro();
	
	public PigeonIMU robotPigeon=new PigeonIMU(Robot.robotDriveTrain.right2Talon);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

