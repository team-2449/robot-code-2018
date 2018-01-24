package org.usfirst.frc.team2449.robot.commands;

import org.usfirst.frc.team2449.robot.Robot;
import org.usfirst.frc.team2449.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ManualArm extends Command {

    public ManualArm() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.robotManipulator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.m_oi.armUpButton.get()&&!Robot.m_oi.armDownButton.get()) {
    		Robot.robotManipulator.setArmPower(RobotMap.armUpPower);
    		
    	}
    	else if(Robot.m_oi.armDownButton.get()&&!Robot.m_oi.armUpButton.get()) {
    		Robot.robotManipulator.setArmPower(RobotMap.armDownPower);
    	}
    	else {
    		Robot.robotManipulator.setArmPower(0);
    	}
    	if(Robot.m_oi.armUpButton.get()&&Robot.m_oi.armDownButton.get()) {
    		Robot.robotManipulator.setIntakePower(.6);
    	}
    	else {
    		Robot.robotManipulator.setIntakePower(0);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.robotManipulator.setArmPower(0);
    	//Robot.robotManipulator.setIntakePower(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.end();
    }
}