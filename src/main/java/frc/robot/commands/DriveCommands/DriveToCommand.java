// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.DriveCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class DriveToCommand extends CommandBase {
  private final DriveSubsystem m_subsystem;
  private final double m_distance;
  private double m_distanceError;

  public DriveToCommand(DriveSubsystem subsystem, double distance) {
    m_subsystem = subsystem;
    m_distance = m_subsystem.getDisplacement() - distance;

    addRequirements(m_subsystem);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    while(m_subsystem.getDisplacement() < m_distance) {
      m_distanceError = m_subsystem.getDisplacement();

      m_subsystem.tankDrive(m_subsystem.getError(m_distanceError, m_distance), m_subsystem.getError(m_distanceError, m_distance));
    }
  }

  @Override
  public void end(boolean interrupted) {
    m_subsystem.setLeftOff();
    m_subsystem.setRightOff();
  }

  @Override
  public boolean isFinished() {
    if(m_subsystem.getError(m_distanceError, m_distance) < 0.05){
      return true;
    } else {
      return false;
    }
  }
}
