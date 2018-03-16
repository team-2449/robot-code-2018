package org.usfirst.frc.team2449.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Limelight extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	NetworkTable limelightTable;
	public void setLight(int lightState) {
		limelightTable.getEntry("ledMode").setNumber(lightState);
		//0 for off
		//1 for on
		//2 for flash
	}
	
	public void setMode(int cameraMode) {
		limelightTable.getEntry("camMode").setNumber(cameraMode);
		//0 for processor
		//1 for driver cam
	}
	
	public void setPipeline(int visionPipeline) {
		limelightTable.getEntry("pipeline").setNumber(visionPipeline);
	}
	
	public boolean hasTargets() {
		if (limelightTable.getEntry("tv").getDouble(0)==1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public double getX() {
		return limelightTable.getEntry("tx").getDouble(0);
	}
	
	public double getY() {
		return limelightTable.getEntry("ty").getDouble(0);
	}
	
	public double getArea() {
		return limelightTable.getEntry("ta").getDouble(0);
	}
	
	public Limelight() {
		limelightTable = NetworkTableInstance.getDefault().getTable("limelight");
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

