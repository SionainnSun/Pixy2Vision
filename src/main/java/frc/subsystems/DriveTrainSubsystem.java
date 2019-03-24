/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.commands.DriveToTargetPIDCommand;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Relay;

/**
 * Add your docs here.
 */
public class DriveTrainSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private SpeedController leftFront, leftBack, rightFront, rightBack;
  private DifferentialDrive driveTrain;

  private Relay led;

  public DriveTrainSubsystem() {
    leftFront = new Talon(1);
    leftBack = new Talon(2);
    rightFront = new Talon(3);
    rightBack = new Talon(4);

    SpeedControllerGroup left = new SpeedControllerGroup(leftFront, leftBack);
    SpeedControllerGroup right = new SpeedControllerGroup(rightFront, rightBack);

    driveTrain = new DifferentialDrive(left, right);
    driveTrain.setSafetyEnabled(false);

    led = new Relay(0);
  }

  @Override
  public void initDefaultCommand() {
    
  }

  public void setLED(Relay.Value val) {
    led.set(val);
  }

  public void drive(double left, double right) {
    driveTrain.tankDrive(left, right);
  }
}
