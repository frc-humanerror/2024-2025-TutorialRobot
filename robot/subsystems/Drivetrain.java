// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class Drivetrain extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  
  private WPI_TalonSRX LFTalon = new WPI_TalonSRX(DriveConstants.LFTalonID);
  private WPI_TalonSRX LBTalon = new WPI_TalonSRX(DriveConstants.LBTalonID);
  private WPI_TalonSRX RFTalon = new WPI_TalonSRX(DriveConstants.RFTalonID);
  private WPI_TalonSRX RBTalon = new WPI_TalonSRX(DriveConstants.RBTalonID);

  public Drivetrain() {
    LFTalon.follow(LBTalon);
    RFTalon.follow(RBTalon);
  }
  /**
   * Example command factory method.
   *
   * @return a command
   */
  public void RobotMove(double lInput, double rInput) {
double Correctedlinput = -lInput * DriveConstants.multiply;
double Correctedrinput = rInput * DriveConstants.multiply;
    LBTalon.set(Correctedlinput);
    RBTalon.set(Correctedrinput);
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *P
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
