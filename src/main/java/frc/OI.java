/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.commands.DriveToTargetPIDCommand;
import frc.commands.SetLEDCommand;
import edu.wpi.first.wpilibj.Relay;

/**
 * Add your docs here.
 */
public class OI {
    Joystick joystick = null;

    public OI(int joystickChannel) {
        joystick = new Joystick(joystickChannel);

        JoystickButton a = new JoystickButton(joystick, 1);
        a.whenPressed(new DriveToTargetPIDCommand(0, 0.001, 0, 0));

        JoystickButton b = new JoystickButton(joystick, 2);
        JoystickButton y = new JoystickButton(joystick, 4);
        b.whenPressed(new SetLEDCommand(Relay.Value.kOn));
        y.whenPressed(new SetLEDCommand(Relay.Value.kOff));
    }

    public Joystick getJoystick() {
        return joystick;
    }
}
