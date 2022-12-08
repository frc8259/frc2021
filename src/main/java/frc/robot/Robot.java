// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {
  private RobotContainer m_robotContainer = new RobotContainer();

  private Command m_autonomousCommand;
  private Command m_testCommand;

  @Override
  public void robotInit() {
    UsbCamera m_front = CameraServer.getInstance().startAutomaticCapture();
    
    m_front.setResolution(640, 480);
    m_front.setFPS(15);
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();

    m_robotContainer.m_electricalSubsystem.getTelemetry();
    m_robotContainer.m_driveSubsystem.getTelemetry();
    m_robotContainer.m_liftSubsystem.getTelemetry();
    m_robotContainer.m_intakeSubsystem.getTelemetry();
    m_robotContainer.m_outtakeSubsystem.getTelemetry();
  }

  @Override
  public void disabledInit() {
    SmartDashboard.putBoolean("Enabled", false);
    SmartDashboard.putString("Mode", "");
  }

  @Override
  public void disabledPeriodic() {
    SmartDashboard.putBoolean("Enabled", false);
    SmartDashboard.putString("Mode", "");
  }

  @Override
  public void autonomousInit() {
    SmartDashboard.putBoolean("Enabled", true);
    SmartDashboard.putString("Mode", "Autonomous");

    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  @Override
  public void autonomousPeriodic() {
    SmartDashboard.putBoolean("Enabled", true);
    SmartDashboard.putString("Mode", "Autonomous");
  }

  @Override
  public void teleopInit() {
    SmartDashboard.putBoolean("Enabled", true);
    SmartDashboard.putString("Mode", "Operated");

    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {
    SmartDashboard.putBoolean("Enabled", true);
    SmartDashboard.putString("Mode", "Operated");
  }

  @Override
  public void testInit() {
    SmartDashboard.putBoolean("Enabled", true);
    SmartDashboard.putString("Mode", "Test");

    m_testCommand = m_robotContainer.getTestCommand();
    
    if (m_testCommand != null) {
      m_testCommand.schedule();
    }
  }

  @Override
  public void testPeriodic() {
    SmartDashboard.putBoolean("Enabled", true);
    SmartDashboard.putString("Mode", "Test");
  }
}
