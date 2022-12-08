// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ElectricalSubsystem extends SubsystemBase {
  public ElectricalSubsystem() {
  }

  @Override
  public void periodic() {
  }

  public String getCPU() {
    try {
      DatagramSocket recieveSocket = new DatagramSocket(1150);
      byte[] recieveData = new byte[8];
      DatagramPacket recievePacket = new DatagramPacket(recieveData, recieveData.length);

      recieveSocket.receive(recievePacket);
      String recieveString = new String(recievePacket.getData());
      recieveSocket.close();

      return recieveString;
    } catch (IOException e) {
      e.printStackTrace();
      return "Error 101 - Warning";
    }
  }

  public String getRAM() {
    try {
      DatagramSocket recieveSocket = new DatagramSocket(1150);
      byte[] recieveData = new byte[8];
      DatagramPacket recievePacket = new DatagramPacket(recieveData, recieveData.length);

      recieveSocket.receive(recievePacket);
      String recieveString = new String(recievePacket.getData());
      recieveSocket.close();

      return recieveString;
    } catch (IOException e) {
      e.printStackTrace();
      return "Error 102 - Warning";
    }
  }

  public void getTelemetry() {
    try {
      SmartDashboard.putString("CPU", getCPU());
    } catch (Exception e) {
      System.out.println("Error 101 - Error");
    }

    try {
      SmartDashboard.putString("RAM", getRAM());
    } catch (Exception e) {
      System.out.println("Error 102 - Error");
    }
  }
}
