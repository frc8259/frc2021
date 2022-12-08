// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotConstants.LiftConstants;

public class LiftSubsystem extends SubsystemBase {
  private final PWMVictorSPX m_leftLiftMotor = new PWMVictorSPX(LiftConstants.k_leftLiftMotorPort);
  private final PWMVictorSPX m_rightLiftMotor = new PWMVictorSPX(LiftConstants.k_rightLiftMotorPort);

  private final DigitalInput m_leftLiftTopSensor = new DigitalInput(LiftConstants.k_leftLiftTopSensorPort);
  private final DigitalInput m_leftLiftBottomSensor = new DigitalInput(LiftConstants.k_leftLiftBottomSensorPort);
  private final DigitalInput m_rightLiftTopSensor = new DigitalInput(LiftConstants.k_rightLiftTopSensorPort);
  private final DigitalInput m_rightLiftBottomSensor = new DigitalInput(LiftConstants.k_rightLiftBottomSensorPort);

  public LiftSubsystem() {}

  @Override
  public void periodic() {}

  public void setLeft(double speed) {
    m_leftLiftMotor.set(speed);
  }

  public void setRight(double speed) {
    m_rightLiftMotor.set(speed);
  }

  public void setLeftOn(boolean isPositive) {
    if(isPositive) {
      m_leftLiftMotor.set(1);
    } else {
      m_leftLiftMotor.set(-1);
    }
  }

  public void setRightOn(boolean isPositive) {
    if(isPositive) {
      m_rightLiftMotor.set(1);
    } else {
      m_rightLiftMotor.set(-1);
    }
  }

  public void setLeftOff() {
    m_leftLiftMotor.set(0);
  }

  public void setRightOff() {
    m_leftLiftMotor.set(0);
  }

  public boolean getLeftTop() {
    if(m_leftLiftTopSensor.get()) {
      return false;
    } else {
      return true;
    }
  }

  public boolean getLeftBottom() {
    if(m_leftLiftBottomSensor.get()) {
      return false;
    } else {
      return true;
    }
  }

  public boolean getRightTop() {
    if(m_rightLiftTopSensor.get()) {
      return false;
    } else {
      return true;
    }
  }

  public boolean getRightBottom() {
    if(m_rightLiftBottomSensor.get()) {
      return false;
    } else {
      return true;
    }
  }

  public void getTelemetry() {
    try {
      SmartDashboard.putNumber("Left Lift Motor", m_leftLiftMotor.get());
    } catch (Exception e) {
      System.out.println("Error 301 - Error");
    }

    try {
      SmartDashboard.putNumber("Right Lift Motor", m_rightLiftMotor.get());
    } catch (Exception e) {
      System.out.println("Error 302 - Error");
    }

    try {
      SmartDashboard.putBoolean("Left Top Lift Sensor", getLeftTop());
    } catch (Exception e) {
      System.out.println("Error 303 - Error");
    }

    try {
      SmartDashboard.putBoolean("Left Bottom Lift Sensor", getLeftBottom());
    } catch (Exception e) {
      System.out.println("Error 304 - Error");
    }

    try {
      SmartDashboard.putBoolean("Right Top Lift Sensor", getRightTop());
    } catch (Exception e) {
      System.out.println("Error 305 - Error");
    }

    try {
      SmartDashboard.putBoolean("Right Bottom Lift Sensor", getRightBottom());
    } catch (Exception e) {
      System.out.println("Error 306 - Error");
    }
  }
}
