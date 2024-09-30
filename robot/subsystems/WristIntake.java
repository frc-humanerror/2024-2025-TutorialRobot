// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CansparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.WristConstants;

public class WristIntake extends SubsystemBase {
  private CANSparkMax spark1 = new CANSparkMax(6, MotorType.kBrushless);
  private final RelativeEncoder m_intakeEncoder = spark1.getEncoder();
  private double intakeError;
  public boolean reversed = false;
  private State currentState = State.ShootPos;
enum State {
  ShootPos,
  IntakePos,
  NoMovePos
}

public double getAnglePosition() {
  return m_intakeEncoder.getPosition()*3.4;
}
public double getRotationsMaybe() {
  return m_intakeEncoder.getPosition()/42;
}

public void wrist(boolean Bpressed, boolean Apressed) {

  if(Apressed) {
    currentState = State.ShootPos;
  }
  else if (Bpressed) {
    currentState = State.IntakePos;
  }

  if (currentState == State.IntakePos) {
    intakeError = getAnglePosition() - WristConstants.wristIntakeSetPointB;
    spark1.set(-intakeError/WristConstants.PscaleFactor);
    if(intakeError < 5 && intakeError > -5) {
      reversed = true;
    } else {
      reversed = false;
    }
  } else if (currentState == State.ShootPos) {
   intakeError = getAnglePosition() - WristConstants.wristIntakeSetPointA;
   spark1.set(-intakeError/WristConstants.PscaleFactor);
   if (intakeError < 5 && intakeError > -5) {
    reversed = true;
   } else {
    reversed = false;
   }
  } else if (currentState == State.NoMovePos) {
    spark1.stopMotor();
  }

}
  public WristIntake() {
    m_intakeEncoder.setPosition(0);
    spark1.setIdleMode(IdleMode.kBrake);
    spark1.setSmartCurrentLimit(40);
  }

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
