package org.usfirst.frc.team2449.robot.subsystems;

import org.usfirst.frc.team2449.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 *
 */
public class DriveTrain extends Subsystem {

	
<<<<<<< HEAD
	CANTalon left1Talon = new CANTalon(RobotMap.left1TalonPort);
	CANTalon left2Talon = new CANTalon(RobotMap.left2TalonPort);
	CANTalon left3Talon = new CANTalon(RobotMap.left3TalonPort);
	CANTalon right1Talon = new CANTalon(RobotMap.right1TalonPort);
	CANTalon right2Talon = new CANTalon(RobotMap.right2TalonPort);
	CANTalon right3Talon = new CANTalon(RobotMap.right3TalonPort);
=======
	TalonSRX left1Talon = new TalonSRX(RobotMap.left1TalonPort);
	TalonSRX left2Talon = new TalonSRX(RobotMap.left2TalonPort);
	TalonSRX right1Talon = new TalonSRX(RobotMap.right1TalonPort);
	TalonSRX right2Talon = new TalonSRX(RobotMap.right2TalonPort);
>>>>>>> d60b95fccde3b356dc4020cb9569be2596a68799
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void basicDrive(double leftPower, double rightPower) {
		//Basic Driving using direct power mapping
<<<<<<< HEAD
		left1Talon.set(-leftPower);
		left2Talon.set(-leftPower);
		left3Talon.set(-leftPower);
		right1Talon.set(rightPower);
		right2Talon.set(rightPower);
		right3Talon.set(rightPower);
=======
		left1Talon.set(ControlMode.PercentOutput, -leftPower);
		left2Talon.set(ControlMode.PercentOutput, -leftPower);
		right1Talon.set(ControlMode.PercentOutput, rightPower);
		right2Talon.set(ControlMode.PercentOutput, rightPower);
>>>>>>> d60b95fccde3b356dc4020cb9569be2596a68799
		
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
}

