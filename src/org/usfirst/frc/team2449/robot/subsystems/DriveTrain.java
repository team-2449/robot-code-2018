package org.usfirst.frc.team2449.robot.subsystems;

import org.usfirst.frc.team2449.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 *
 */
public class DriveTrain extends Subsystem {

	
	CANTalon left1Talon = new CANTalon(RobotMap.left1TalonPort);
	CANTalon left2Talon = new CANTalon(RobotMap.left2TalonPort);
	CANTalon right1Talon = new CANTalon(RobotMap.right1TalonPort);
	CANTalon right2Talon = new CANTalon(RobotMap.right2TalonPort);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void basicDrive(double leftPower, double rightPower) {
		//Basic Driving using direct power mapping
		left1Talon.set(-leftPower);
		left2Talon.set(-leftPower);
		right1Talon.set(rightPower);
		right2Talon.set(rightPower);
		
	}
	
	
	public void changeControlMode(TalonControlMode controlMode) {
		//Change Talon SRX Control Mode
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
}

