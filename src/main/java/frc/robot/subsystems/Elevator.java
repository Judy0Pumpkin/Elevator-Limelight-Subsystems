// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.sql.Time;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.RemoteFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.fasterxml.jackson.databind.AnnotationIntrospector.ReferenceProperty.Type;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.Constants.ElevatorConstant;;


public class Elevator extends SubsystemBase {
  // WPI_TalonFX m_elevatorTalon = new WPI_TalonFX(3);
  // WPI_TalonFX m_slaveTalon = new WPI_TalonFX(0);
  Timer m_Timer = new Timer();


  DoubleSolenoid grabberdoubleSolenoid =new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 1, 0);
  Compressor grabbercompressor = new Compressor(0, PneumaticsModuleType.CTREPCM);
  CANSparkMax m_grabberMotor1 = new CANSparkMax(1, MotorType.kBrushless);
 // CANSparkMax m_grabberMotor2 = new CANSparkMax(1, MotorType.kBrushless);
  

  /** Creates a new Elevator. */
  public Elevator() {
    
  // m_elevatorTalon.configFactoryDefault();  
  // m_slaveTalon.configFactoryDefault();
  // m_elevatorTalon.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, 0, 1);
  // m_elevatorTalon.setInverted(true);
  // m_elevatorTalon.setSensorPhase(true); // flip encoder direction
  // m_slaveTalon.setInverted(true);

  
  // m_slaveTalon.follow(m_elevatorTalon);
  
  // m_elevatorTalon.config_kF(0, 0.5, 10);
  // m_elevatorTalon.config_kP(0, 0.5, 10);
	// m_elevatorTalon.config_kI(0, 0.0, 10);
	// m_elevatorTalon.config_kD(0, 0.0, 10);
	// m_elevatorTalon.config_IntegralZone(0, 0, 0);
  
  // m_elevatorTalon.enableVoltageCompensation(true);
  // m_elevatorTalon.configVoltageCompSaturation(9, 1);
  // m_elevatorTalon.configMotionCruiseVelocity(2048*2);   // start testing with half the value of maximum sensor velocity
  // m_elevatorTalon.configMotionAcceleration(2048);
  // m_elevatorTalon.configMotionSCurveStrength(0);  

  //m_grabberMotor2.follow(m_grabberMotor1);
  m_grabberMotor1.setInverted(true);
  //m_grabberMotor2.setInverted(false);
  m_Timer.reset();
  grabbercompressor.enableDigital();
  
  grabberdoubleSolenoid.set(DoubleSolenoid.Value.kReverse);
  }

public void motormode1(){
  m_grabberMotor1.set(0.1);
}




boolean y=false; 
public void motormode2(){
  m_grabberMotor1.set(0);
}

 

  public void hi(){
    
    if (y== false){
      m_Timer.start();

      // m_elevatorTalon.set(ControlMode.MotionMagic, -100000);

      grabberdoubleSolenoid.set(DoubleSolenoid.Value.kForward);

    
        m_grabberMotor1.set(0.1);
     
    }else{
      // m_elevatorTalon.set(ControlMode.MotionMagic, 100000);
      grabberdoubleSolenoid.set(DoubleSolenoid.Value.kReverse);
      m_Timer.stop();
      m_Timer.reset();
      m_grabberMotor1.set(0);
    }
   y = !y; 

   
     
  }

  /* m_Timer.start();
    m_elevatorTalon.set(0.3);
  
    if (m_Timer.get() > 1.0) {
        m_elevatorTalon.set(0.0);
        m_Timer.stop();
        m_Timer.reset();
     } */

  public void bye(){

      m_Timer.start();

      if (m_Timer.get()>4 && m_Timer.get() < 6 ){
        m_grabberMotor1.set(0.4);
      }
      else
        m_grabberMotor1.set(0);
      


  }

  




  // public void stage1(){
    
  //   if (y== false){

  //     m_elevatorTalon.set(ControlMode.MotionMagic, -10000);
      
      
  //   }else{
  //     m_elevatorTalon.set(ControlMode.MotionMagic, 10000);
  //   }
  //  y = !y; 
  // }


  // public void stage2(){  
    
  //   if (y== false){

  //     m_elevatorTalon.set(ControlMode.MotionMagic, -20000);
      
      
  //   }else{
  //     m_elevatorTalon.set(ControlMode.MotionMagic, 20000);
  //   }
  //  y = !y; 
  // }


  // public void stage3(){
  //   if (y== false){

  //     m_elevatorTalon.set(ControlMode.MotionMagic, -30000);
      
      
  //   }else{
  //     m_elevatorTalon.set(ControlMode.MotionMagic, 30000);
  //   }
  //  y = !y; 
  // }






  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  

}
