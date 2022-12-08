// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.AutoCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveCommands.DriveToCommand;
import frc.robot.commands.DriveCommands.RotateToCommand;
import frc.robot.subsystems.DriveSubsystem;

public class MiddleAutoCommands extends SequentialCommandGroup {
  private final DriveSubsystem m_subsystem;

  public MiddleAutoCommands(DriveSubsystem subsystem) {
    m_subsystem = subsystem;

    addCommands(new DriveToCommand(m_subsystem, 1),
    new RotateToCommand(m_subsystem, 90),
    new DriveToCommand(m_subsystem, 1),
    new RotateToCommand(m_subsystem, 0));
  }
}
