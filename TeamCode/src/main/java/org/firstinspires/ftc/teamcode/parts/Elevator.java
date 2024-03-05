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
import org.firstinspires.ftc.teamcode.drivee.HardwareMapping;
import org.firstinspires.ftc.teamcode.utils.PID;
import org.firstinspires.ftc.teamcode.utils.PIDElevator;

import java.io.PipedOutputStream;

@Config
public class Elevator {

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
    public static DcMotorEx motor;
    public static PIDFCoefficients pidfCoefficients = new PIDFCoefficients(0, 0, 0, 0);
    public static int maxUp = 200;
    public Elevator(HardwareMap hm)
    {
        motor = hm.get(DcMotorEx.class, "motor");

        MotorConfigurationType mct = motor.getMotorType().clone();
        mct.setAchieveableMaxRPMFraction(1.0);
        motor.setMotorType(mct);

        liftState = LiftState.RETRACT;
    }

    public void update(Gamepad gamepad)
    {

        switch (liftState)
        {
            case RETRACT:
                motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                motor.setPower(-1);
                liftState = LiftState.RETRACTED;
                break;
            case RETRACTED:
                if(motor.getVelocity(AngleUnit.DEGREES) <= 10){ // to be tuned
                    motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                    motor.setTargetPosition(0);
                    motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    motor.setPower(1);
                    liftState = LiftState.NULL;
                }

                break;
            case EXTENDED:
                LiftState.position += gamepad.left_stick_y * LiftState.resolution;
                if(LiftState.position > maxUp) LiftState.position = maxUp;
                if(LiftState.position < 0) LiftState.position = 0;
                break;
            case EXTEND:
                motor.setTargetPosition(LiftState.position);
                liftState = LiftState.EXTENDED;
                break;
        }

    }
}
