// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import frc.robot.RobotConstants.OIConstants;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ElectricalSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.LiftSubsystem;
import frc.robot.subsystems.OuttakeSubsystem;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.LiftCommand;
import frc.robot.commands.IntakeCommands.IntakeDownCommand;
import frc.robot.commands.IntakeCommands.IntakeUpCommand;
import frc.robot.commands.LiftCommands.LiftDownCommand;
import frc.robot.commands.LiftCommands.LiftUpCommand;
import frc.robot.commands.OuttakeCommands.OuttakeDownCommand;
import frc.robot.commands.OuttakeCommands.OuttakeUpCommand;
import frc.robot.commands.AutoCommands.LeftAutoCommands;
import frc.robot.commands.AutoCommands.MiddleAutoCommands;
import frc.robot.commands.AutoCommands.NoneAutoCommands;
import frc.robot.commands.AutoCommands.RightAutoCommands;
import frc.robot.commands.ElectricalCommands.TestCommand;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;

public class RobotContainer {
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  public final ElectricalSubsystem m_electricalSubsystem = new ElectricalSubsystem();
  public final DriveSubsystem m_driveSubsystem = new DriveSubsystem();
  public final IntakeSubsystem m_intakeSubsystem = new IntakeSubsystem();
  public final OuttakeSubsystem m_outtakeSubsystem = new OuttakeSubsystem();
  public final LiftSubsystem m_liftSubsystem = new LiftSubsystem();

  private final NoneAutoCommands m_noneAutoCommands = new NoneAutoCommands();
  private final LeftAutoCommands m_leftAutoCommands = new LeftAutoCommands(m_driveSubsystem);
  private final MiddleAutoCommands m_middleAutoCommands = new MiddleAutoCommands(m_driveSubsystem);
  private final RightAutoCommands m_rightAutoCommands = new RightAutoCommands(m_driveSubsystem);

  private final TestCommand m_testCommand = new TestCommand(m_driveSubsystem, m_liftSubsystem, m_intakeSubsystem, m_outtakeSubsystem);

  public final Joystick m_driverController = new Joystick(OIConstants.k_driverControllerPort);
  public final Joystick m_operatorController = new Joystick(OIConstants.k_operatorControllerPort);
  
  public RobotContainer() {
    configureButtonBindings();

    m_driveSubsystem.setDefaultCommand(new DriveCommand(m_driveSubsystem, () -> m_driverController.getY(), () -> m_driverController.getZ()));
    m_liftSubsystem.setDefaultCommand(new LiftCommand(m_liftSubsystem, () -> m_operatorController.getRawAxis(1), () -> m_operatorController.getRawAxis(5)));

    m_chooser.setDefaultOption("None", m_noneAutoCommands);
    m_chooser.addOption("Left", m_leftAutoCommands);
    m_chooser.addOption("Middle", m_middleAutoCommands);
    m_chooser.addOption("Right", m_rightAutoCommands);
  }

  private void configureButtonBindings() {
    new JoystickButton(m_operatorController, OIConstants.k_aButton).whileHeld(new IntakeUpCommand(m_intakeSubsystem));
    new JoystickButton(m_operatorController, OIConstants.k_bButton).whileHeld(new IntakeDownCommand(m_intakeSubsystem));

    new JoystickButton(m_operatorController, OIConstants.k_xButton).whileHeld(new OuttakeUpCommand(m_outtakeSubsystem));
    new JoystickButton(m_operatorController, OIConstants.k_yButton).whileHeld(new OuttakeDownCommand(m_outtakeSubsystem));

    new POVButton(m_operatorController, OIConstants.k_downButton).whenPressed(new LiftUpCommand(m_liftSubsystem));
    new POVButton(m_operatorController, OIConstants.k_upButton).whenPressed(new LiftDownCommand(m_liftSubsystem));
  }

  public Command getAutonomousCommand() {
    return m_chooser.getSelected();
  }

  public Command getTestCommand() {
    return m_testCommand;
  }
}
