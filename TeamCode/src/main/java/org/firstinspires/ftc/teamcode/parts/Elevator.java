package org.firstinspires.ftc.teamcode.parts;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;
import com.qualcomm.robotcore.hardware.configuration.typecontainers.MotorConfigurationType;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.drivee.HardwareMapA;
import org.firstinspires.ftc.teamcode.drivee.HardwareMapping;
import org.firstinspires.ftc.teamcode.utils.PID;
import org.firstinspires.ftc.teamcode.utils.PIDElevator;

import java.io.PipedOutputStream;

@Config
public class Elevator {
    
    private HardwareMapA hm;

    enum LiftState
    {
        RETRACT,
        EXTENDED,
        RETRACTED,
        EXTEND,
        NULL;

        public static int position = 0;
        public static final int resolution = 10;

    }
    public LiftState liftState;

    public static ElapsedTime timer = new ElapsedTime();
    public static PIDFCoefficients pidfCoefficients = new PIDFCoefficients(0, 0, 0, 0);
    public static int maxUp = 200;
    public Elevator(HardwareMapA hm)
    {
        this.hm = hm;
        
        MotorConfigurationType mct = hm.motorSlider.getMotorType().clone();
        mct.setAchieveableMaxRPMFraction(1.0);
        hm.motorSlider.setMotorType(mct);

        liftState = LiftState.RETRACT;
    }

    public void update(Gamepad gamepad)
    {

        switch (liftState)
        {
            case RETRACT:
                hm.motorSlider.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                hm.motorSlider.setPower(-1);
                liftState = LiftState.RETRACTED;
                break;
            case RETRACTED:
                if(hm.motorSlider.getVelocity(AngleUnit.DEGREES) <= 10){ // to be tuned
                    hm.motorSlider.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    hm.motorSlider.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                    hm.motorSlider.setTargetPosition(0);
                    hm.motorSlider.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    hm.motorSlider.setPower(1);
                    liftState = LiftState.NULL;
                }

                break;
            case EXTENDED:
                LiftState.position += gamepad.left_stick_y * LiftState.resolution;
                if(LiftState.position > maxUp) LiftState.position = maxUp;
                if(LiftState.position < 0) LiftState.position = 0;
                break;
            case EXTEND:
                hm.motorSlider.setTargetPosition(LiftState.position);
                liftState = LiftState.EXTENDED;
                break;
        }

    }
}
