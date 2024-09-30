// Copyright (c) FIRST and other WPILib contributors.
// Copyright (c) FIRST and other WPILib contributors.
// Copyright (c) FIRST and other WPILib contributors.
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.WristIntake;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class WristMove extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final WristIntake m_WristIntake;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public WristMove(WristIntake subsystem) {
    m_WristIntake = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_WristIntake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_WristIntake.wrist(RobotContainer.getXboxBButton(), RobotContainer.getXboxAButton());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
