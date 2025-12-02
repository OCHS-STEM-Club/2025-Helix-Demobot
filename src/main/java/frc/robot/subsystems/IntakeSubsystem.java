// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.configs.TalonFXSConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.hardware.TalonFXS;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;

public class IntakeSubsystem extends SubsystemBase {

  public TalonFXS intakeMotor;
  public TalonFX pivotMotor;

  private TalonFXSConfiguration intakeMotorConfig;
  private TalonFXConfiguration pivotMotorConfig;

  /** Creates a new IntakeSubsystem. */
  public IntakeSubsystem() {
    intakeMotor = new TalonFXS(IntakeConstants.intakeMotorId);
    pivotMotor = new TalonFX(IntakeConstants.pivotMotorId);
  }
  public void rollersIntake(){
    intakeMotor.set(IntakeConstants.kIntakeMotorSpeed);
  }
  public void rollersOuttake(){
    intakeMotor.set(-IntakeConstants.kIntakeMotorSpeed);
  }
  public void rollersStop(){
    intakeMotor.set(0);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
