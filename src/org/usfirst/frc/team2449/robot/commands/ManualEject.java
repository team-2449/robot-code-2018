package org.usfirst.frc.team2449.robot.commands;

import org.usfirst.frc.team2449.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ManualEject extends Command {

    public ManualEject() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.robotManipulator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.robotManipulator.setIntakePower(-1);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (Robot.m_oi.ejectButton.get()) {
    		Robot.robotManipulator.setEjector(Value.kForward);
    	}
    	else {
    		Robot.robotManipulator.setEjector(Value.kReverse);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.robotManipulator.setIntakePower(0);
    	Robot.robotManipulator.setEjector(Value.kReverse);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.end();
    }
}
