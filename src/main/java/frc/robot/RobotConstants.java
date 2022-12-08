// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


public final class RobotConstants {
        public static final double k_P = 0.1;
        public static final double k_I = 0.1;
        public static final double k_D = 0.1;

        public static final class AutoConstants {
            public static final double k_autoSpeed = 1;
            public static final double k_autoRotation = 0.75;

            public static final double k_intakeAutoSpeed = 1;

            public static final double k_outtakeAutoSpeed = 1;
        }

        public static final class DriveConstants {
            public static final int k_leftMotorPort = 0;
            public static final int k_rightMotorPort = 1;

            public static final double k_speed = 1;
            public static final double k_rotation = 1;

            public static final double k_rotationRate = 1;
            public static final double k_rotationSuperRate = 0.7;
            public static final double k_rotationExpo = 0.5;
        }

        public static final class IntakeConstants {
            public static final int k_intakeMotorPort = 2;

            public static final double k_intakeSpeed = 1;
        }

        public static final class OuttakeConstants {
            public static final int k_outtakeMotorPort = 3;

            public static final double k_outtakeSpeed = 1;
        }

        public static final class LiftConstants {
            public static final int k_leftLiftMotorPort = 4;
            public static final int k_rightLiftMotorPort = 5;

            public static final int k_leftLiftTopSensorPort = 1;
            public static final int k_leftLiftBottomSensorPort = 0;
            public static final int k_rightLiftTopSensorPort = 3;
            public static final int k_rightLiftBottomSensorPort = 2;
        }

        public static final class OIConstants {
            public static final int k_driverControllerPort = 0;
            public static final int k_operatorControllerPort = 1;

            public static final int k_aButton = 1;
            public static final int k_bButton = 2;
            public static final int k_xButton = 3;
            public static final int k_yButton = 4;

            public static final int k_upButton = 0;
            public static final int k_rightButton = 90;
            public static final int k_downButton = 180;
            public static final int k_leftButton = 270;
        }
    }
