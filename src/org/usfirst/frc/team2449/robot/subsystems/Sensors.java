package org.usfirst.frc.team2449.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Sensors extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public ADXRS450_Gyro robotGyro=new ADXRS450_Gyro();
	public Encoder left1Encoder = new Encoder(0,1, true);
	public Encoder right1Encoder = new Encoder(2,3);
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

