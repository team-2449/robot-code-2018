package org.usfirst.frc.team2449.robot.commands;

import org.usfirst.frc.team2449.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ClosedLoopDrive extends Command {

    public ClosedLoopDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.robotDriveTrain);
    	requires(Robot.robotSensors);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.robotDriveTrain.setVelocity(Robot.m_oi.driverJoystick.getRawAxis(1)*2000,Robot.m_oi.driverJoystick.getRawAxis(3)*2000 );
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.robotDriveTrain.disableVelocityControl();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.end();
    }
}
