// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.LiftCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LiftSubsystem;

public class LiftUpCommand extends CommandBase {
  private final LiftSubsystem m_subsystem;

  public LiftUpCommand(LiftSubsystem subsystem) {
    m_subsystem = subsystem;
    
    addRequirements(m_subsystem);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    if(!m_subsystem.getLeftTop()) {
      m_subsystem.setLeftOn(true);
    } else {
      m_subsystem.setLeftOff();
    }

    if(!m_subsystem.getRightTop()) {
      m_subsystem.setRightOn(true);
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
    if(m_subsystem.getLeftTop() & m_subsystem.getRightTop()){
      return true;
    } else {
      return false;
    }
  }
}
