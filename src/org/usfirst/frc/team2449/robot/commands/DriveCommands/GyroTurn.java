package org.usfirst.frc.team2449.robot.commands.DriveCommands;

import org.usfirst.frc.team2449.robot.Robot;
import org.usfirst.frc.team2449.robot.RobotMap;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GyroTurn extends Command {
//Turns to a desired angle, positive for clockwise, negative for counterclockwise
	private double turnAngle;
	public GyroTurn(double turnAngle) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
		this.turnAngle=turnAngle;
    	requires(Robot.robotDriveTrain);
    	requires(Robot.robotSensors);
    }
    protected void initialize() {
    	Robot.robotSensors.tarePigeon();
    	currentOffset=turnAngle-Robot.robotSensors.getHeading();
    	currentPower=1;
    }
    private double currentOffset;
    private double currentRate;
    private double currentPower;
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	currentOffset=turnAngle-Robot.robotSensors.getHeading();
    	currentRate=Robot.robotSensors.getTurnRate();
    	currentPower=currentOffset*RobotMap.pigeonTurnkP-currentRate*RobotMap.pigeonTurnkD;
    	if (Math.abs(currentPower)<RobotMap.pigeonTurnMin) {
    		currentPower=RobotMap.pigeonTurnMin*Math.signum(currentPower);
    	}
    	Robot.robotDriveTrain.basicDrive(-currentPower, currentPower);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return (Math.abs(currentOffset)<1);
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
