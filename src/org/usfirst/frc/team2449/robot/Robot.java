/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2449.robot;

import org.usfirst.frc.team2449.robot.commands.CalibratePigeon;
import org.usfirst.frc.team2449.robot.commands.DisplayMetrics;
import org.usfirst.frc.team2449.robot.commands.AutonCommands.AutonChooser;
import org.usfirst.frc.team2449.robot.commands.DriveCommands.BasicDrive;
import org.usfirst.frc.team2449.robot.subsystems.Arm;
<<<<<<< HEAD
import org.usfirst.frc.team2449.robot.subsystems.CompressorSystem;
=======
import org.usfirst.frc.team2449.robot.subsystems.Climber;
>>>>>>> AutonFramework
import org.usfirst.frc.team2449.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2449.robot.subsystems.Intake;
import org.usfirst.frc.team2449.robot.subsystems.Limelight;
import org.usfirst.frc.team2449.robot.subsystems.Metrics;
import org.usfirst.frc.team2449.robot.subsystems.Sensors;
import org.usfirst.frc.team2449.robot.subsystems.Vision;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	
	//SubSystems
	public static final DriveTrain robotDriveTrain = new DriveTrain();
	public static final Vision robotVision = new Vision();
	public static final Metrics robotMetrics = new Metrics();
	public static final Sensors robotSensors = new Sensors();
	public static final Arm robotArm= new Arm();
	public static final Intake robotIntake = new Intake();
	public static final CompressorSystem robotCompressor = new CompressorSystem();
	public static final Limelight robotLimelight = new Limelight();
	public static final Climber robotClimber = new Climber();
	
	public static OI m_oi;

	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();
	public static final SendableChooser<Boolean> sideChooser = new SendableChooser<>();
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		m_oi = new OI();
		
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", m_chooser);
		sideChooser.addDefault("Left", false);
		sideChooser.addObject("right", true);
		SmartDashboard.putData("Starting Side",sideChooser);
		robotLimelight.setLight(2);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	public void disabledInit() {
		
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	
	public void autonomousInit() {
		m_autonomousCommand = m_chooser.getSelected();
		new DisplayMetrics().start();
		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
		new AutonChooser().start();
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
		new DisplayMetrics().start();
		new BasicDrive().start();
	}

	/**
	 * This function is called periodically during operator control.
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	public void testPeriodic() {
		
	}
	
	public void testInit() {
		new CalibratePigeon().start();
	}
}
