// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.Climb;
import frc.robot.commands.Drive;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.Launch;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Launcher;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final static CommandJoystick  m_lJoystick  =
  new CommandJoystick(OperatorConstants.lJoystickPort);

  private final static CommandJoystick m_rJoystick =
  new CommandJoystick(OperatorConstants.rJoystickPort);

  private final static XboxController m_XboxController = new XboxController(OperatorConstants.xboxControllerPort);

   private final Drivetrain mDrivetrain = new Drivetrain();
   private final Drive DriveCommand = new Drive(mDrivetrain);

   private final Launcher mLauncher = new Launcher();
   private final Launch LaunchCommand = new Launch(mLauncher);

   private final Climber mClimber = new Climber();
   private final Climb ClimbCommand = new Climb(mClimber);


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings

    configureBindings();
    mDrivetrain.setDefaultCommand(DriveCommand);
    mLauncher.setDefaultCommand(LaunchCommand);
    mClimber.setDefaultCommand(ClimbCommand);
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
  }
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`

public static double getljoystick() {
  return m_lJoystick.getY();
}

public static double getrjoystick() {
  return m_rJoystick.getY();
}

public static double getLeftXboxJoystickY() {
  return m_XboxController.getLeftY();
}

public static boolean getLeftXboxBumper() {
  return m_XboxController.getLeftBumper();
}

public static boolean getRightXboxBumper() {
  return m_XboxController.getRightBumper();
}

public static boolean getXboxAButton() {
  return m_XboxController.getAButton();
}

public static boolean getXboxBButton() {
  return m_XboxController.getBButton();
}

public static boolean getXboxXButton() {
  return m_XboxController.getXButton();
}

public static boolean getXboxYButton() {
  return m_XboxController.getYButton();
}
    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(m_exampleSubsystem);
  }
}
