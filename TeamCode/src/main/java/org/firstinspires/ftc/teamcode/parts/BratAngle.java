package org.firstinspires.ftc.teamcode.parts;

import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.controller.PIDController;
import com.arcrobotics.ftclib.controller.PIDFController;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;
import com.qualcomm.robotcore.hardware.configuration.typecontainers.MotorConfigurationType;

@Config
public class BratAngle {
    public DcMotorEx motor;
    public static int targetPositoin, position;
    public static PIDFCoefficients pidfCoefficients = new PIDFCoefficients(0, 0, 0, 0), lastPIDF;
    public BratAngle(HardwareMap hm){
        motor = hm.get(DcMotorEx.class, "brat motor");
        MotorConfigurationType mct = motor.getMotorType();
        mct.setAchieveableMaxRPMFraction(1.0);
        motor.setMotorType(mct);

        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        motor.setTargetPosition(0);

        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        targetPositoin = 0;
        position = 0;
        lastPIDF = pidfCoefficients;
        motor.setPower(1);
    }
    public void setPosition(int pos){
        targetPositoin = pos;
        motor.setTargetPosition(targetPositoin);
    }
    public void update(){
        if(lastPIDF != pidfCoefficients){
            motor.setPIDFCoefficients(DcMotor.RunMode.RUN_TO_POSITION, pidfCoefficients);
        }
        motor.setTargetPosition(targetPositoin);
        motor.setPower(1);
        position = motor.getCurrentPosition();
    }

}
