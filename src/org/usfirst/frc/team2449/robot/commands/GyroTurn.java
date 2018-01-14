package org.usfirst.frc.team2449.robot.commands;

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
    PIDController leftGyroController=new PIDController(RobotMap.gyrokP, RobotMap.gyrokI, RobotMap.gyrokD, Robot.robotSensors.robotGyro,Robot.robotDriveTrain.leftPIDGroup);
    PIDController rightGyroController=new PIDController(RobotMap.gyrokP, RobotMap.gyrokI, RobotMap.gyrokD, Robot.robotSensors.robotGyro,Robot.robotDriveTrain.rightPIDGroup);
    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.robotSensors.robotGyro.reset();
    	Robot.robotSensors.robotGyro.setPIDSourceType(PIDSourceType.kDisplacement);
    	leftGyroController.setAbsoluteTolerance(5);
    	rightGyroController.setAbsoluteTolerance(5);
		leftGyroController.setSetpoint(turnAngle);
    	rightGyroController.setSetpoint(turnAngle);
    	leftGyroController.enable();
    	rightGyroController.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return leftGyroController.onTarget()&&rightGyroController.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	leftGyroController.disable();
    	rightGyroController.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
