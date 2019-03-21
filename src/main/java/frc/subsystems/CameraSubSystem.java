/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.subsystems;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.commands.GetBlocksCommand;
import frc.vision.PixyCamera2;
import frc.vision.PixyPacket;

/**
 * Add your docs here.
 */
public class CameraSubSystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private PixyCamera2 pixy;
  PixyPacket[] packet = new PixyPacket[2];

  public CameraSubSystem() {
    pixy = new PixyCamera2(Port.kOnboard, 0x54);
  }

  public void getVersion() {
    pixy.getVersion();
  }

  public void getBlocks() {
    pixy.getBlocks(packet, (byte) 0x1, 2);
  }
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    // setDefaultCommand(new GetBlocksCommand());
  }
}
