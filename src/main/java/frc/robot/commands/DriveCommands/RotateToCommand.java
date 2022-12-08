// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.DriveCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class RotateToCommand extends CommandBase {
  private final DriveSubsystem m_subsystem;
  private final double m_angle;
  private double m_angleError;

  public RotateToCommand(DriveSubsystem subsystem, double angle) {
    m_subsystem = subsystem;
    m_angle = m_subsystem.getAngle() -angle;

    addRequirements(m_subsystem);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    while(m_subsystem.getAngle() < m_angle) {
      m_angleError = m_subsystem.getAngle();

      m_subsystem.tankDrive(m_subsystem.getError(m_angleError, m_angle), -m_subsystem.getError(m_angleError, m_angle));
    }
  }

  @Override
  public void end(boolean interrupted) {
    m_subsystem.setLeftOff();
    m_subsystem.setRightOff();
  }

  @Override
  public boolean isFinished() {
    if(m_subsystem.getError(m_angleError, m_angle) < 0.05){
      return true;
    } else {
      return false;
    }
  }
}
