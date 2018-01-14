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

	
	TalonSRX left1Talon = new TalonSRX(RobotMap.left1TalonPort);
	TalonSRX left2Talon = new TalonSRX(RobotMap.left2TalonPort);
	TalonSRX left3Talon = new TalonSRX(RobotMap.left3TalonPort);
	TalonSRX right1Talon = new TalonSRX(RobotMap.right1TalonPort);
	TalonSRX right2Talon = new TalonSRX(RobotMap.right2TalonPort);
	TalonSRX right3Talon = new TalonSRX(RobotMap.right3TalonPort);
	public PIDDriver leftPIDGroup = new PIDDriver(left1Talon,left2Talon,left3Talon);
	public PIDDriver rightPIDGroup = new PIDDriver(right1Talon,right2Talon,right3Talon);

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void basicDrive(double leftPower, double rightPower) {
		//Basic Driving using direct power mapping
		left1Talon.set(ControlMode.PercentOutput, -leftPower);
		left2Talon.set(ControlMode.PercentOutput, -leftPower);
		left3Talon.set(ControlMode.PercentOutput, -leftPower);
		right1Talon.set(ControlMode.PercentOutput, rightPower);
		right2Talon.set(ControlMode.PercentOutput, rightPower);
		right3Talon.set(ControlMode.PercentOutput, rightPower);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
}
