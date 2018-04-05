package org.usfirst.frc.team2449.robot.commands.DriveCommands;

import org.usfirst.frc.team2449.robot.Robot;
import org.usfirst.frc.team2449.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class StraightDrive extends Command {

	private double distance;
    public StraightDrive(double distance) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.distance = distance*RobotMap.distanceMult;
    	requires(Robot.robotDriveTrain);
    	requires(Robot.robotSensors);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.robotSensors.tarePigeon();
    	Robot.robotDriveTrain.left1Talon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
    	Robot.robotDriveTrain.left2Talon.follow(Robot.robotDriveTrain.left1Talon);
    	Robot.robotDriveTrain.left3Talon.follow(Robot.robotDriveTrain.left1Talon);
    	Robot.robotDriveTrain.right1Talon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
    	Robot.robotDriveTrain.right2Talon.follow(Robot.robotDriveTrain.right1Talon);
    	Robot.robotDriveTrain.right3Talon.follow(Robot.robotDriveTrain.right1Talon);
    	Robot.robotDriveTrain.left1Talon.selectProfileSlot(0, 0);
		Robot.robotDriveTrain.left1Talon.config_kF(0, RobotMap.distancekF, 10);
		Robot.robotDriveTrain.left1Talon.config_kP(0, RobotMap.distancekP, 10);
		Robot.robotDriveTrain.left1Talon.config_kI(0, RobotMap.distancekI, 10);
		Robot.robotDriveTrain.left1Talon.config_kD(0, RobotMap.distancekD, 10);
		Robot.robotDriveTrain.left1Talon.configMotionCruiseVelocity(RobotMap.cruiseVelocity, 10);
		Robot.robotDriveTrain.left1Talon.configMotionAcceleration(RobotMap.rampRate, 10);
		Robot.robotDriveTrain.left1Talon.setSelectedSensorPosition(0, 0, 10);
		Robot.robotDriveTrain.left1Talon.set(ControlMode.MotionMagic, distance);
		Robot.robotDriveTrain.right1Talon.selectProfileSlot(0, 0);
		Robot.robotDriveTrain.right1Talon.config_kF(0, RobotMap.distancekF, 10);
		Robot.robotDriveTrain.right1Talon.config_kP(0, RobotMap.distancekP, 10);
		Robot.robotDriveTrain.right1Talon.config_kI(0, RobotMap.distancekI, 10);
		Robot.robotDriveTrain.right1Talon.config_kD(0, RobotMap.distancekD, 10);
		Robot.robotDriveTrain.right1Talon.configMotionCruiseVelocity(RobotMap.cruiseVelocity, 10);
		Robot.robotDriveTrain.right1Talon.configMotionAcceleration(RobotMap.rampRate, 10);
		Robot.robotDriveTrain.right1Talon.setSelectedSensorPosition(0, 0, 10);
		Robot.robotDriveTrain.right1Talon.set(ControlMode.MotionMagic, distance);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Math.abs(Robot.robotDriveTrain.left1Talon.getSelectedSensorVelocity(0))<5)&&Math.abs(Robot.robotDriveTrain.left1Talon.getSelectedSensorPosition(0)-distance)<10000;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.robotDriveTrain.basicDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.end();
    }
}
