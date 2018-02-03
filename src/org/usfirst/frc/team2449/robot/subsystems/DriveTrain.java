package org.usfirst.frc.team2449.robot.subsystems;


import org.usfirst.frc.team2449.robot.Robot;
import org.usfirst.frc.team2449.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
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
	private Encoder leftEncoder;
	private Encoder rightEncoder;
	PIDController leftPIDController;
	PIDController rightPIDController;
	
	
	public DriveTrain(Encoder leftEncoder, Encoder rightEncoder) {
		right1Talon.setInverted(true);
		right2Talon.setInverted(true);
		right3Talon.setInverted(true);
		this.leftEncoder=leftEncoder;
		this.rightEncoder=rightEncoder;
		leftPIDController = new PIDController(RobotMap.driveTrainVelocitykP,RobotMap.driveTrainVelocitykI,RobotMap.driveTrainVelocitykD,RobotMap.driveTrainVelocitykF,leftEncoder,leftPIDGroup);
		rightPIDController = new PIDController(RobotMap.driveTrainVelocitykP,RobotMap.driveTrainVelocitykI,RobotMap.driveTrainVelocitykD,RobotMap.driveTrainVelocitykF,rightEncoder,rightPIDGroup);
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void setLeftPower(double leftPower) {
		//Basic Driving using direct power mapping
		left1Talon.set(ControlMode.PercentOutput, leftPower);
		left2Talon.set(ControlMode.PercentOutput, leftPower);
		left3Talon.set(ControlMode.PercentOutput, leftPower);
	}
	
	public void setRightPower(double rightPower) {
		//Basic Driving using direct power mapping
		right1Talon.set(ControlMode.PercentOutput, rightPower);
		right2Talon.set(ControlMode.PercentOutput, rightPower);
		right3Talon.set(ControlMode.PercentOutput, rightPower);
	}
	
	public void setLeftVelocity(double leftRate) {
		if(Math.abs(leftRate)>=Math.abs(leftEncoder.getRate())&&Math.abs(leftRate)>0.1) {
			this.enableLeftVelocityControl();
			leftPIDController.setSetpoint(leftRate);
		}
		else {
			this.disableLeftVelocityControl();
			this.setLeftPower(0);
		}
	}
	
	private void enableLeftVelocityControl() {
		leftEncoder.setPIDSourceType(PIDSourceType.kRate);
    	leftPIDController.enable();
	}
	
	public void disableLeftVelocityControl() {
		leftPIDController.disable();
	}
	
	public void setRightVelocity(double rightRate) {
		if(Math.abs(rightRate)>=Math.abs(rightEncoder.getRate())&&Math.abs(rightRate)>0.1) {
			this.enableRightVelocityControl();
			rightPIDController.setSetpoint(rightRate);
		}
		else {
			this.disableRightVelocityControl();
			this.setRightPower(0);
		}
	}
	
	private void enableRightVelocityControl() {
    	rightEncoder.setPIDSourceType(PIDSourceType.kRate);
    	rightPIDController.enable();
	}
	
	public void disableRightVelocityControl() {
    	rightPIDController.disable();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
}
