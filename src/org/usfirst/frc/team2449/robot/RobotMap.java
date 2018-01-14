/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2449.robot;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap { 
	//DriveTrain Variables
	public static int left1TalonPort=0;
	public static int left2TalonPort=1;
	public static int left3TalonPort=2;
	public static int right1TalonPort=3;
	public static int right2TalonPort=4;
	public static int right3TalonPort=5;
	public static Encoder left1Encoder = new Encoder(0,1);
	public static Encoder right1Encoder = new Encoder(2,3);
	public static Potentiometer mastPotentiometer = new AnalogPotentiometer(0,360,0);
	public static double driveTrainkP;
	public static double driveTrainkI;
	public static double driveTrainkD;
	
	//Control Variables
	public static int driverJoystickPort=0;

	
	//Manipulator Variables
	
	//Climber Variables
	
	//Sensing Variables
}
