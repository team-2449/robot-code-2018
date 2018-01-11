package org.usfirst.frc.team2449.robot.subsystems;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Vision extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void startVisionServer() {
	//start the Vision Server	
	}
	
	public void getVisionTarget() {
	//get the location of the vision target
	//NEEDS TO RETURN A VALUE AT SOME POINT
	}
	
	public void getTargetColor(Object visiontargetlocation) {
	//get the color of the switch lights surrounding the vision target	
	}
	
	public Alliance getTeamColor() {	
	//get current team Color, Red or Blue
		return DriverStation.getInstance().getAlliance();
	}
	
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

