// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import org.littletonrobotics.junction.AutoLogOutput;

import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.math.filter.MedianFilter;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;

public class IntakeSubsystem extends SubsystemBase {

  public TalonFX rollerMotor;
  public TalonFX pivotMotor;

  private TalonFXConfiguration rollerMotorConfig;
  private TalonFXConfiguration pivotMotorConfig;

  private MedianFilter intakeFilter;

  /** Creates a new IntakeSubsystem. */
  public IntakeSubsystem() {
    rollerMotor = new TalonFX(IntakeConstants.kRollerMotorId);
    pivotMotor = new TalonFX(IntakeConstants.kPivotMotorId);

    intakeFilter = new MedianFilter(10);

    rollerMotorConfig = new TalonFXConfiguration()
                            .withMotorOutput(new MotorOutputConfigs()
                                                  .withInverted(InvertedValue.Clockwise_Positive)
                                                  .withNeutralMode(NeutralModeValue.Brake))
                            .withCurrentLimits(new CurrentLimitsConfigs()
                                                  .withSupplyCurrentLimit(IntakeConstants.kRollerCurrentLimit));

    rollerMotor.getConfigurator().apply(rollerMotorConfig);

    pivotMotorConfig = new TalonFXConfiguration()
                            .withMotorOutput(new MotorOutputConfigs()
                                                  .withInverted(InvertedValue.Clockwise_Positive)
                                                  .withNeutralMode(NeutralModeValue.Brake))
                            .withCurrentLimits(new CurrentLimitsConfigs()
                                                  .withSupplyCurrentLimit(IntakeConstants.kPivotCurrentLimit));
    pivotMotor.getConfigurator().apply(pivotMotorConfig);
  }

  public void intakeIn(){
    rollerMotor.set(IntakeConstants.kRollerMotorSpeed);
  }

  public void intakeOut(){
    rollerMotor.set(-IntakeConstants.kRollerMotorSpeed);
  }

  public void intakeStop(){
    rollerMotor.set(0);
  }


  


  @AutoLogOutput
  public double getIntakeVelocity(){
    return rollerMotor.getVelocity().getValueAsDouble();
  }

  @AutoLogOutput
  public double getIntakeSupplyCurrent(){
    return rollerMotor.getSupplyCurrent().getValueAsDouble();
  }

  @AutoLogOutput
  public double getIntakeStatorCurrent(){
    return rollerMotor.getStatorCurrent().getValueAsDouble();
  }



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
