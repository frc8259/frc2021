// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class DriveCommand extends CommandBase {
  private final DriveSubsystem m_subsystem;
  private final DoubleSupplier m_speed;
  private final DoubleSupplier m_rotation;

  public DriveCommand(DriveSubsystem subsystem, DoubleSupplier speed, DoubleSupplier rotation) {
    m_subsystem = subsystem;
    m_speed = speed;
    m_rotation = rotation;

    addRequirements(m_subsystem);
  }

  @Override
  public void execute() {
    m_subsystem.arcadeDrive(m_speed.getAsDouble(), Math.pow(m_rotation.getAsDouble(), 3));
  }

  @Override
  public void end(boolean interrupted) {
    m_subsystem.setLeftOff();
    m_subsystem.setRightOff();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
