// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotConstants.OuttakeConstants;

public class OuttakeSubsystem extends SubsystemBase {
  private final PWMVictorSPX m_outtakeMotor = new PWMVictorSPX(OuttakeConstants.k_outtakeMotorPort);

  public OuttakeSubsystem() {}

  @Override
  public void periodic() {}

  public void setOn(boolean isPositive) {
    if(isPositive) {
      m_outtakeMotor.set(OuttakeConstants.k_outtakeSpeed);
    } else {
      m_outtakeMotor.set(-OuttakeConstants.k_outtakeSpeed);
    }
    
  }

  public void setOff() {
    m_outtakeMotor.set(0);
  }

  public void getTelemetry() {
    try {
      SmartDashboard.putNumber("Outtake Motor", m_outtakeMotor.get());
    } catch (Exception e) {
      System.out.println("Error 402 - Error");
    }
  }
}
