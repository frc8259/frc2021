// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.OuttakeCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.OuttakeSubsystem;

public class OuttakeDownCommand extends CommandBase {
  private final OuttakeSubsystem m_subsystem;

  public OuttakeDownCommand(OuttakeSubsystem subsystem) {
    m_subsystem = subsystem;

    addRequirements(m_subsystem);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    m_subsystem.setOn(false);
  }

  @Override
  public void end(boolean interrupted) {
    m_subsystem.setOff();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
