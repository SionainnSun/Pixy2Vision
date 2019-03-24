/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.commands;

import frc.robot.Robot;
import frc.vision.PixyPacket;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveToTargetPIDCommand extends PIDCommand {

  private double magicConstant = 0.2;

  public DriveToTargetPIDCommand(double setpoint, double p, double i, double d) {
    super(p, i, d);
    requires(Robot.driveTrain);
    setSetpoint(setpoint);
    getPIDController().setAbsoluteTolerance(5);
  }

  private int lastError = 6;

  @Override
  protected double returnPIDInput() {
    PixyPacket[] blocks = new PixyPacket[1];
    Robot.pixyCamera2.getBlocks(blocks, (byte) 0x01, 0x01);
    int error = blocks[0].getXError();
    if(Math.abs(error) < 500) {
      lastError = error;
      SmartDashboard.putNumber("Error", error);
      return error;
    } else {
      SmartDashboard.putNumber("Last Error", lastError);
      return lastError;
    }
  }

  @Override
  protected void usePIDOutput(double output) {
    double speed = deadzone(Robot.oi.getJoystick().getRawAxis(5)); //right joystick y axis
    SmartDashboard.putNumber("Joystick output", speed);
    SmartDashboard.putNumber("PID Output", output);
    SmartDashboard.putNumber("Left side speed", speed);
    SmartDashboard.putNumber("Right side speed", speed + magicConstant * output);
    Robot.driveTrain.drive(speed, speed + magicConstant * output);
  }

  private double deadzone(double val) {
    return Math.abs(val) > 0.05 ? val : 0;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    getPIDController().setSetpoint(0);
    getPIDController().enable();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return getPIDController().onTarget();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    getPIDController().disable();
    Robot.driveTrain.drive(0, 0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
