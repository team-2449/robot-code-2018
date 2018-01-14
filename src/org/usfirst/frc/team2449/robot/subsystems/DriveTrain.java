package org.usfirst.frc.team2449.robot.subsystems;

import org.usfirst.frc.team2449.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
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
	public PIDController left1PIDController = new PIDController(RobotMap.driveTrainkP,RobotMap.driveTrainkI,RobotMap.driveTrainkD,RobotMap.left1Encoder,(PIDOutput) left1Talon);
	public PIDController left2PIDController = new PIDController(RobotMap.driveTrainkP,RobotMap.driveTrainkI,RobotMap.driveTrainkD,RobotMap.left1Encoder,(PIDOutput) left2Talon);
	public PIDController left3PIDController = new PIDController(RobotMap.driveTrainkP,RobotMap.driveTrainkI,RobotMap.driveTrainkD,RobotMap.left1Encoder,(PIDOutput) left3Talon);
	public PIDController right1PIDController = new PIDController(RobotMap.driveTrainkP,RobotMap.driveTrainkI,RobotMap.driveTrainkD,RobotMap.right1Encoder,(PIDOutput) right1Talon);
	public PIDController right2PIDController = new PIDController(RobotMap.driveTrainkP,RobotMap.driveTrainkI,RobotMap.driveTrainkD,RobotMap.right1Encoder,(PIDOutput) right2Talon);
	public PIDController right3PIDController = new PIDController(RobotMap.driveTrainkP,RobotMap.driveTrainkI,RobotMap.driveTrainkD,RobotMap.right1Encoder,(PIDOutput) right3Talon);

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void basicDrive(double leftPower, double rightPower) {
		//Basic Driving using direct power mapping

		left1Talon.set(ControlMode.PercentOutput, -leftPower);
		left2Talon.set(ControlMode.PercentOutput, -leftPower);
		right1Talon.set(ControlMode.PercentOutput, rightPower);
		right2Talon.set(ControlMode.PercentOutput, rightPower);

		
	}


	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
}

