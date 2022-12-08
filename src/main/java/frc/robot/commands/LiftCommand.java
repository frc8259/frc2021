// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LiftSubsystem;

public class LiftCommand extends CommandBase {
  private final LiftSubsystem m_subsystem;
  private final DoubleSupplier m_left;
  private final DoubleSupplier m_right;

  public LiftCommand(LiftSubsystem subsystem, DoubleSupplier left, DoubleSupplier right) {
    m_subsystem = subsystem;
    m_left = left;
    m_right = right;

    addRequirements(m_subsystem);
  }

  @Override
  public void execute() {
    if (m_left.getAsDouble() < 0) {
      if (!m_subsystem.getLeftBottom()) {
        m_subsystem.setLeft(m_left.getAsDouble());
      } else {
        m_subsystem.setLeftOff();
      }
    } else if (m_left.getAsDouble() > 0) {
      if (!m_subsystem.getLeftTop()) {
        m_subsystem.setLeft(m_left.getAsDouble());
      } else {
        m_subsystem.setLeftOff();
      }
    } else {
      m_subsystem.setLeftOff();
    }

    if (m_right.getAsDouble() < 0) {
      if (!m_subsystem.getRightBottom()) {
        m_subsystem.setRight(m_right.getAsDouble());
      } else {
        m_subsystem.setRightOff();
      }
    } else if (m_right.getAsDouble() > 0) {
      if (!m_subsystem.getRightTop()) {
        m_subsystem.setRight(m_right.getAsDouble());
      } else {
        m_subsystem.setRightOff();
      }
    } else {
      m_subsystem.setRightOff();
    }
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
