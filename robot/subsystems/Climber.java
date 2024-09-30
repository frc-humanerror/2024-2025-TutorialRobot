// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ClimbConstants;

public class Climber extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */

  private WPI_TalonSRX lClimberTalon = new WPI_TalonSRX(ClimbConstants.lClimberTalon);
  private WPI_TalonSRX rClimberTalon = new WPI_TalonSRX(ClimbConstants.rClimberTalon);
  edu.wpi.first.wpilibj.Encoder lClimberEncoder = new edu.wpi.first.wpilibj.Encoder(6,7);
  edu.wpi.first.wpilibj.Encoder rClimberEncoder = new edu.wpi.first.wpilibj.Encoder(4,5);

public void Climb(boolean getLeftBumper, boolean getRightBumper) {
  if (getRightBumper && rClimberEncoder.get() < 710) {
rClimberTalon.set(ClimbConstants.climbSpeed);
lClimberTalon.set(-ClimbConstants.climbSpeed);
  }
else if (getLeftBumper && lClimberEncoder.get() > 0) {
rClimberTalon.set(-ClimbConstants.climbSpeed);
lClimberTalon.set(ClimbConstants.climbSpeed);
  }
  else {
  rClimberTalon.stopMotor();
  lClimberTalon.stopMotor();
  }
}

  public Climber() {}

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
