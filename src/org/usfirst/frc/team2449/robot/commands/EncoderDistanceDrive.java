package org.usfirst.frc.team2449.robot.commands;

import org.usfirst.frc.team2449.robot.Robot;
import org.usfirst.frc.team2449.robot.RobotMap;
import org.usfirst.frc.team2449.robot.subsystems.Sensors;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class EncoderDistanceDrive extends Command {
	
	public PIDController leftPIDController = new PIDController(RobotMap.driveTrainkP,RobotMap.driveTrainkI,RobotMap.driveTrainkD,Robot.robotSensors.left1Encoder,Robot.robotDriveTrain.leftPIDGroup);
	public PIDController rightPIDController = new PIDController(RobotMap.driveTrainkP,RobotMap.driveTrainkI,RobotMap.driveTrainkD,Robot.robotSensors.right1Encoder,Robot.robotDriveTrain.rightPIDGroup);
	private double distance;
    public EncoderDistanceDrive(double distance) {
    	this.distance = distance;
    	requires(Robot.robotDriveTrain);
    	requires(Robot.robotSensors);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//Resets if we already went a distance
    	Robot.robotSensors.right1Encoder.reset();
    	Robot.robotSensors.left1Encoder.reset();
    	
    	//Allows tolerance 	so that loop ends; never perfect
    	leftPIDController.setAbsoluteTolerance(5);
    	rightPIDController.setAbsoluteTolerance(5);
    	
    	//Setting how far the robot will go
    	leftPIDController.setSetpoint(distance);
    	rightPIDController.setSetpoint(distance);
    	
    	//Not in rotations but inches
    	
    	
    	
    	//What Encoder will get;This case distance
    	Robot.robotSensors.left1Encoder.setPIDSourceType(PIDSourceType.kDisplacement);
    	Robot.robotSensors.right1Encoder.setPIDSourceType(PIDSourceType.kDisplacement);
    	
    	//Enables PIDController
    	leftPIDController.enable();
    	rightPIDController.enable();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return leftPIDController.onTarget() && rightPIDController.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	leftPIDController.disable();
    	rightPIDController.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
