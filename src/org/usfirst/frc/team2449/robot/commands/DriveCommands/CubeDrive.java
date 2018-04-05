package org.usfirst.frc.team2449.robot.commands.DriveCommands;

import org.usfirst.frc.team2449.robot.Robot;
import org.usfirst.frc.team2449.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CubeDrive extends Command {

    public CubeDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.robotDriveTrain);
    	requires(Robot.robotLimelight);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(!Robot.robotLimelight.hasTargets()) {
    		this.end();
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.robotDriveTrain.basicDrive(RobotMap.limelightTurnC+RobotMap.limelightTurnkP*Robot.robotLimelight.getX(), RobotMap.limelightTurnC-RobotMap.limelightTurnkP*Robot.robotLimelight.getX());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.robotLimelight.getArea()>85;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.robotDriveTrain.basicDrive(0, 0);
    	new BasicDrive().start();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.end();
    }
}
