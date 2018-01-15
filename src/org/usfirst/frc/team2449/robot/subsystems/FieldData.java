package org.usfirst.frc.team2449.robot.subsystems;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class FieldData extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public char getScaleSide() {
		return DriverStation.getInstance().getGameSpecificMessage().charAt(1);
	}
	
	public char getOwnSwitchSide() {
		return DriverStation.getInstance().getGameSpecificMessage().charAt(0);
	}
	
	public char getOpponentSwitchSide() {
		return DriverStation.getInstance().getGameSpecificMessage().charAt(2);
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

