package org.usfirst.frc.team2449.robot.subsystems;

import org.usfirst.frc.team2449.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public double climbPower;
	private VictorSPX climber1Talon = new VictorSPX(RobotMap.climber1TalonPort);
	private VictorSPX climber2Talon = new VictorSPX(RobotMap.climber1TalonPort);
	public void setPower(double power) {
		climber1Talon.set(ControlMode.PercentOutput, power);
		climber2Talon.set(ControlMode.PercentOutput, power);
	}
	
	public Climber() {
		climbPower = RobotMap.climberStartPower;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

