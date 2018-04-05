/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2449.robot;

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
	public static double pigeonTurnkP=.005;
	public static double pigeonTurnkI=0;
	public static double pigeonTurnkD=0.005;
	public static double pigeonTurnMin=0.20;
	public static double limelightTurnkP=0.00;
	public static double limelightTurnC=0.45;
	public static double distancekF = 0.2;
	public static double distancekP = 0.22;
	public static double distancekI = 0;
	public static double distancekD = 0.4;
	public static int cruiseVelocity = 4000;
	public static int rampRate = 1500;
	public static int distanceMult = 3571;
	
	//Manipulator Variables
	public static int armTalonPort=0;
	public static int leftIntakeTalonPort=6;
	public static int rightIntakeTalonPort=7;
	public static double armUpPower=.5;
	public static double armDownPower=.5;
	public static double intakeVelocity = 1000;
	public static double intakeP = 0.1;
	public static double intakeI = 0.0005;
	public static double intakeD = 5;
	public static double intakeF = 0.066;
	public static double ejectVelocity = 2800;
			
	//Climber Variables
	public static int climber1TalonPort = 8;
	public static int climber2TalonPort = 9;
	public static double climberStartPower = 0.8;
	
	//Sensing Variables
	//##IMPORTANT## I can't easily set the talon for the pigeon or mag encoder, they will be left here as comments
	//and can be changed in the Sensors class  --Alex
}
