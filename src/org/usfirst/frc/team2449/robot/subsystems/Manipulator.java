package org.usfirst.frc.team2449.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Manipulator extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Talon armTalon = new Talon(2);
	Spark leftWheel=new Spark(0);
	Spark rightWheel=new Spark(1);
	Compressor robotCompressor = new Compressor();
	DoubleSolenoid ejectorSolenoid = new DoubleSolenoid(0,1);
	
	public void setArmPower(double armPower) {
		armTalon.set(armPower);
	}
	
	public void setIntakePower(double intakePower) {
		leftWheel.set(intakePower);
		rightWheel.set(-intakePower);
	}
	
	public void setEjector(DoubleSolenoid.Value value) {
		ejectorSolenoid.set(value);
	}
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

