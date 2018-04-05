package org.usfirst.frc.team2449.robot.commands.ClimbCommands;

import org.usfirst.frc.team2449.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DecreasePower extends Command {

    public DecreasePower() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.robotClimber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.robotClimber.climbPower -= 0.02;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
