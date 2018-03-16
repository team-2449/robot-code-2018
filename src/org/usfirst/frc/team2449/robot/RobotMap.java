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
	public static double pigeonTurnkP=.01;
	public static double pigeonTurnkI=0;
	public static double pigeonTurnkD=0.0001;
	public static double limelightTurnkP=0.02;
	public static double limelightTurnC=0.3;
	
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
	
	//Sensing Variables
}
