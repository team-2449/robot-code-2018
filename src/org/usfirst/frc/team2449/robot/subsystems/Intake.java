package org.usfirst.frc.team2449.robot.subsystems;

import org.usfirst.frc.team2449.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	TalonSRX leftWheel=new TalonSRX(RobotMap.leftIntakeTalonPort);
	TalonSRX rightWheel=new TalonSRX(RobotMap.rightIntakeTalonPort);
	Compressor robotCompressor = new Compressor();
	DoubleSolenoid ejectorSolenoid = new DoubleSolenoid(1,0);
	
	public void setIntakePower(double intakePower) {
		leftWheel.set(ControlMode.PercentOutput,intakePower);
		rightWheel.set(ControlMode.PercentOutput,-intakePower);
	}
	
	public void setIntakeVelocity(double RPMs) {
		leftWheel.set(ControlMode.Velocity, RPMs*4096/600);
		rightWheel.set(ControlMode.Velocity, -RPMs*4096/600);
	}
	
	public void setEjector(DoubleSolenoid.Value value) {
		ejectorSolenoid.set(value);
	}
	
	public Intake() {
		//PID Config Setup
		leftWheel.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
		rightWheel.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
		leftWheel.configNominalOutputForward(0, 0);
		leftWheel.configNominalOutputReverse(-0, 0);
		leftWheel.configPeakOutputForward(1, 0);
		leftWheel.configPeakOutputReverse(-1, 0);
		rightWheel.configNominalOutputForward(0, 0);
		rightWheel.configNominalOutputReverse(-0, 0);
		rightWheel.configPeakOutputForward(1, 0);
		rightWheel.configPeakOutputReverse(-1, 0);
		leftWheel.config_kP(0, RobotMap.intakeP, 10);
		leftWheel.config_kI(0, RobotMap.intakeI, 10);
		leftWheel.config_kD(0, RobotMap.intakeD, 10);
		leftWheel.config_kF(0, RobotMap.intakeF, 10);
		rightWheel.config_kP(0, RobotMap.intakeP, 10);
		rightWheel.config_kI(0, RobotMap.intakeI, 10);
		rightWheel.config_kD(0, RobotMap.intakeD, 10);
		rightWheel.config_kF(0, RobotMap.intakeF, 10);
		leftWheel.setInverted(true);
		rightWheel.setInverted(true);
		}
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

