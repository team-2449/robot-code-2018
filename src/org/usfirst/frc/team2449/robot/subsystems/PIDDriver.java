package org.usfirst.frc.team2449.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.PIDOutput;

public class PIDDriver implements PIDOutput {
	private TalonSRX Talon1;
	private TalonSRX Talon2;
	private TalonSRX Talon3;
	public PIDDriver(TalonSRX Talon1, TalonSRX Talon2, TalonSRX Talon3) {
		// TODO Auto-generated constructor stub
		this.Talon1=Talon1;
		this.Talon2=Talon2;
		this.Talon3=Talon3;
	}
	@Override
	public void pidWrite(double output) {
		// TODO Auto-generated method stub
		Talon1.set(ControlMode.PercentOutput, output);
		Talon2.set(ControlMode.PercentOutput, output);
		Talon3.set(ControlMode.PercentOutput, output);
	}

}
