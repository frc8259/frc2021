// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.ElectricalCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveCommands.DriveToCommand;
import frc.robot.commands.DriveCommands.RotateToCommand;
import frc.robot.commands.LiftCommands.LiftDownCommand;
import frc.robot.commands.LiftCommands.LiftUpCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.LiftSubsystem;
import frc.robot.subsystems.OuttakeSubsystem;

public class TestCommand extends SequentialCommandGroup {
  DriveSubsystem m_driveSubsystem;
  LiftSubsystem m_liftSubsystem;
  IntakeSubsystem m_intakeSubsystem;
  OuttakeSubsystem m_outtakeSubsystem;

  public TestCommand(DriveSubsystem driveSubsystem, LiftSubsystem lifSubsystem, IntakeSubsystem intakeSubsystem, OuttakeSubsystem outtakeSubsystem) {
    m_driveSubsystem = driveSubsystem;
    m_liftSubsystem = lifSubsystem;
    m_intakeSubsystem = intakeSubsystem;
    m_outtakeSubsystem = outtakeSubsystem;


    addCommands(new DriveToCommand(m_driveSubsystem, 1),
    new DriveToCommand(m_driveSubsystem, -1),
    new RotateToCommand(m_driveSubsystem, 90),
    new RotateToCommand(m_driveSubsystem, -90),
    new LiftUpCommand(m_liftSubsystem),
    new LiftDownCommand(m_liftSubsystem));
  }
}
