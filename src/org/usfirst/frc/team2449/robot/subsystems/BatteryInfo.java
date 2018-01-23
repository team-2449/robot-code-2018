package org.usfirst.frc.team2449.robot.subsystems;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BatteryInfo extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	PowerDistributionPanel powerDistribution = new PowerDistributionPanel();
	

	
	public double current0 = powerDistribution.getCurrent(0);                                                                                           
	public double current1 = powerDistribution.getCurrent(1);
	public double current2 = powerDistribution.getCurrent(2);
	public double current3 = powerDistribution.getCurrent(3);
	public double current5 = powerDistribution.getCurrent(5);
	public double current6 = powerDistribution.getCurrent(6);
	public double currentAll = powerDistribution.getTotalCurrent();
		
	
	
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

