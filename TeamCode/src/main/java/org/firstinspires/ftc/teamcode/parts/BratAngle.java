package org.firstinspires.ftc.teamcode.parts;

import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.controller.PIDController;
import com.arcrobotics.ftclib.controller.PIDFController;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;
import com.qualcomm.robotcore.hardware.configuration.typecontainers.MotorConfigurationType;

import org.firstinspires.ftc.teamcode.drivee.HardwareMapA;

@Config
public class BratAngle {
    private HardwareMapA hm;
    public static int targetPositoin, position;

    public static PIDFCoefficients pidfCoefficients = new PIDFCoefficients(0, 0, 0, 0), lastPIDF;
    public BratAngle(HardwareMapA hm){
        this.hm = hm;
        MotorConfigurationType mct = hm.motorRotation.getMotorType();
        mct.setAchieveableMaxRPMFraction(1.0);
        hm.motorRotation.setMotorType(mct);

        hm.motorRotation.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        hm.motorRotation.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        hm.motorRotation.setTargetPosition(0);

        hm.motorRotation.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        targetPositoin = 0;
        position = 0;
        lastPIDF = pidfCoefficients;
        hm.motorRotation.setPower(1);
    }
    public void setPosition(int pos){
        targetPositoin = pos;
        hm.motorRotation.setTargetPosition(targetPositoin);
    }
    public void update(){
        if(lastPIDF != pidfCoefficients){
            hm.motorRotation.setPIDFCoefficients(DcMotor.RunMode.RUN_TO_POSITION, pidfCoefficients);
            lastPIDF = pidfCoefficients;
        }
        hm.motorRotation.setTargetPosition(targetPositoin);
        position = hm.motorRotation.getCurrentPosition();
    }

}
