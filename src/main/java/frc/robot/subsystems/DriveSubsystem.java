// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotConstants;
import frc.robot.RobotConstants.DriveConstants;

public class DriveSubsystem extends SubsystemBase {
  private final PWMVictorSPX m_leftMotor = new PWMVictorSPX(DriveConstants.k_leftMotorPort);
  private final PWMVictorSPX m_rightMotor = new PWMVictorSPX(DriveConstants.k_rightMotorPort);
  private final DifferentialDrive m_drive = new DifferentialDrive(m_leftMotor, m_rightMotor);
  
  private final PIDController m_pid = new PIDController(RobotConstants.k_P, RobotConstants.k_I, RobotConstants.k_D);

  private final AHRS m_ahrsController = new AHRS(SPI.Port.kMXP);

  public DriveSubsystem() {
  }

  @Override
  public void periodic() {
  }

  public void arcadeDrive(double speed, double rotation) {
    m_drive.arcadeDrive(speed, rotation);
  }

  public void tankDrive(double speed, double speed2) {
    m_drive.tankDrive(speed, speed2);
  }

  public void setLeft(double speed) {
    m_leftMotor.set(speed);
  }

  public void setRight(double speed) {
    m_rightMotor.set(speed);
  }

  public void setLeftOff() {
    m_leftMotor.set(0);
  }

  public void setRightOff() {
    m_rightMotor.set(0);
  }

  public double getError(double error, double set) {
    return m_pid.calculate(error, set);
  }

  public double getAngle() {
    return m_ahrsController.getAngle();
  }

  public double getRate() {
    return m_ahrsController.getRate();
  }

  public double getDisplacement() {
    return m_ahrsController.getVelocityX() * DriverStation.getInstance().getMatchTime();
  }

  public double getVelocity() {
    return m_ahrsController.getVelocityX();
  }

  public double getAcceleration() {
    return m_ahrsController.getVelocityX() / DriverStation.getInstance().getMatchTime();
  }

  public void getTelemetry() {
    try {
      SmartDashboard.putNumber("Left Motor", m_leftMotor.get());
    } catch (Exception e) {
      System.out.println("Error 201 - Error");
    }
    
    try {
      SmartDashboard.putNumber("Right Motor", m_rightMotor.get());
    } catch (Exception e) {
      System.out.println("Error 202 - Error");
    }

    try {
      SmartDashboard.putNumber("Angle", getAngle());
    } catch (Exception e) {
      System.out.println("Error 203 - Error");
    }

    try {
      SmartDashboard.putNumber("Rate", getRate());
    } catch (Exception e) {
      System.out.println("Error 204 - Error");
    }

    try {
      SmartDashboard.putNumber("Displacement", getDisplacement());
    } catch (Exception e) {
      System.out.println("Error 205 - Error");
    }

    try {
      SmartDashboard.putNumber("Velocity", getVelocity());
    } catch (Exception e) {
      System.out.println("Error 206 - Error");
    }

    try {
      SmartDashboard.putNumber("Acceleration", getAcceleration());
    } catch (Exception e) {
      System.out.println("Error 207 - Error");
    }
  }
}
