package org.usfirst.frc.team2449.robot.subsystems;

import org.usfirst.frc.team2449.robot.Robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.sensors.PigeonIMU;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Sensors extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	double[] robotYPR=new double[3];
	public PigeonIMU robotIMU=new PigeonIMU(Robot.robotDriveTrain.right2Talon);
	
	
	public void tarePigeon() {
		robotIMU.setFusedHeading(0, 10);
	}
	
	public double getHeading() {
		return robotIMU.getFusedHeading();  		//Returns Heading
	}
	
	public double getTurnRate() {
		robotIMU.getYawPitchRoll(robotYPR);
		return robotYPR[2];
	}
	
	public boolean getCloseSwitchSide() { //False for L, True for R
		return DriverStation.getInstance().getGameSpecificMessage().toCharArray()[0]=='R';
	}
	
	public boolean getScaleSide() { //False for L, True for R
		return DriverStation.getInstance().getGameSpecificMessage().toCharArray()[1]=='R';
	}
	
	public boolean getFarSwitchSide() { //False for L, True for R
		return DriverStation.getInstance().getGameSpecificMessage().toCharArray()[2]=='R';
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

