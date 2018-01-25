package org.usfirst.frc.team2449.robot.commands;

import org.usfirst.frc.team2449.robot.Robot;
import org.usfirst.frc.team2449.robot.RobotMap;
import org.usfirst.frc.team2449.robot.subsystems.Sensors;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *driveTrainDistancek
 */
public class EncoderVelocityDrive extends Command {
	
	public PIDController leftPIDController = new PIDController(RobotMap.driveTrainDistancekP,RobotMap.driveTrainDistancekI,RobotMap.driveTrainDistancekD,Robot.robotSensors.left1Encoder,Robot.robotDriveTrain.leftPIDGroup);
	public PIDController rightPIDController = new PIDController(RobotMap.driveTrainDistancekP,RobotMap.driveTrainDistancekI,RobotMap.driveTrainDistancekD,Robot.robotSensors.right1Encoder,Robot.robotDriveTrain.rightPIDGroup);
	private double leftRate;
	private double rightRate;
	
	//Drives drivetrain at certain rate, in degrees per second
    public EncoderVelocityDrive() {
    	requires(Robot.robotDriveTrain);
    	requires(Robot.robotSensors);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	//Allows tolerance 	so that loop ends; never perfect
    	leftPIDController.setAbsoluteTolerance(15);
    	rightPIDController.setAbsoluteTolerance(15);
    	
    	
    	
    	//What Encoder will get;This case distance
    	Robot.robotSensors.left1Encoder.setPIDSourceType(PIDSourceType.kRate);
    	Robot.robotSensors.right1Encoder.setPIDSourceType(PIDSourceType.kRate);
    	
    	//Enables PIDController
    	leftPIDController.enable();
    	rightPIDController.enable();
    	
    }
    
    public void setRate(double leftRate,double rightRate) {
    	this.leftRate=leftRate;
    	this.rightRate=rightRate;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	leftPIDController.setSetpoint(leftRate);
    	rightPIDController.setSetpoint(rightRate);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	leftPIDController.disable();
    	rightPIDController.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.end();
    }
}
