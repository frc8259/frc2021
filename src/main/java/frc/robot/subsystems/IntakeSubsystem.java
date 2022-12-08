// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotConstants.IntakeConstants;

public class IntakeSubsystem extends SubsystemBase {
  private final PWMVictorSPX m_intakeMotor = new PWMVictorSPX(IntakeConstants.k_intakeMotorPort);

  public IntakeSubsystem() {}

  @Override
  public void periodic() {}

  public void setOn(boolean isPositive) {
    if(isPositive) {
      m_intakeMotor.set(IntakeConstants.k_intakeSpeed);
    } else {
      m_intakeMotor.set(-IntakeConstants.k_intakeSpeed);
    }
  }

  public void setOff() {
    m_intakeMotor.set(0);
  }

  public void getTelemetry() {
    try {
      SmartDashboard.putNumber("Intake Motor", m_intakeMotor.get());
    } catch (Exception e) {
      System.out.println("Error 401 - Error");
    }
  }
}
