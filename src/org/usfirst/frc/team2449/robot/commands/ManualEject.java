package org.usfirst.frc.team2449.robot.commands;

import org.usfirst.frc.team2449.robot.Robot;
import org.usfirst.frc.team2449.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ManualEject extends Command {

    public ManualEject() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.robotIntake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.robotIntake.setIntakeVelocity(-RobotMap.ejectVelocity);
    	Robot.robotCompressor.enableCompressor();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	if (Robot.m_oi.ejectButton.get()) {
    		Robot.robotIntake.setEjector(Value.kForward);
    		Robot.robotIntake.setIntakePower(-1);
    	}
    	else {
    		Robot.robotIntake.setEjector(Value.kReverse);
    		Robot.robotIntake.setIntakeVelocity(-RobotMap.ejectVelocity);
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.robotIntake.setIntakePower(0);
    	Robot.robotIntake.setEjector(Value.kReverse);
    	Robot.robotCompressor.disableCompressor();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.end();
    }
}
