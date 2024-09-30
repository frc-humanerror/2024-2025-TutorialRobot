// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int lJoystickPort = 0;
    public static final int rJoystickPort = 1;
    public static final int xboxControllerPort = 2;
  }
  public static class DriveConstants {
    public static final double multiply = 0.5;
    public static final int LFTalonID = 2;
    public static final int LBTalonID = 1;
    public static final int RFTalonID = 4;
    public static final int RBTalonID = 3;
  }
  public static class LaunchConstants {
 public static final double launchMult = 0.85;
 public static final int lLaunchTalonID = 7;
 public static final int rLaunchTalonID = 8;
  }
  public static class ClimbConstants {
  public static final int lClimberTalon = 10;
  public static final int rClimberTalon = 9;
  public static final double climbSpeed = 0.3;
  } 
  public static class WristConstants {
    public static final double wristIntakeSetPointB = -171;
    public static final double wristIntakeSetPointA = 0;
    public static final double PscaleFactor = 425;
  }
  public static class IntakeConstants {
    public static final double intakeSpeed = 0.5;
    public static final double outtakeSpeed = -0.5;
  }
}
