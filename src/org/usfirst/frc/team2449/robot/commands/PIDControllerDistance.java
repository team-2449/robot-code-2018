package org.usfirst.frc.team2449.robot.commands;

import org.usfirst.frc.team2449.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PIDControllerDistance extends Command {

    public PIDControllerDistance() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize(double setPoint) {
    	Robot.robotDriveTrain.left1PIDController.enable();
    	Robot.robotDriveTrain.left2PIDController.enable();
    	Robot.robotDriveTrain.left3PIDController.enable();
    	Robot.robotDriveTrain.right1PIDController.enable();
    	Robot.robotDriveTrain.right2PIDController.enable();
    	Robot.robotDriveTrain.right3PIDController.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return Robot.robotDriveTrain.right1PIDController.onTarget() && Robot.robotDriveTrain.left1PIDController.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.robotDriveTrain.left1PIDController.disable();
    	Robot.robotDriveTrain.left2PIDController.disable();
    	Robot.robotDriveTrain.left3PIDController.disable();
    	Robot.robotDriveTrain.right1PIDController.disable();
    	Robot.robotDriveTrain.right2PIDController.disable();
    	Robot.robotDriveTrain.right3PIDController.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
