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
public class Arm extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Spark armSpark = new Spark(RobotMap.armTalonPort);
	TalonSRX leftWheel=new TalonSRX(RobotMap.leftIntakeTalonPort);
	TalonSRX rightWheel=new TalonSRX(RobotMap.rightIntakeTalonPort);
	Compressor robotCompressor = new Compressor();
	DoubleSolenoid ejectorSolenoid = new DoubleSolenoid(1,0);
	
	public void setArmPower(double armPower) {
		armSpark.set(armPower);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

