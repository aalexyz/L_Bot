package org.firstinspires.ftc.teamcode.parts;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.drivee.HardwareMapA;

public class Elevator { // nu se stie ce e asta e fucked up cel mai probabil

    private HardwareMapA mapping;
    private Claw claw;

    enum EvState
    {
        START, // poz de start
        EXTEND, // extend obvs
        DOWN, // 2
        WAIT_FOR_ARM,
        WAIT_FOR_PIXELS

    }
    public static double kp,ki,kd,f;
    public static ElapsedTime timer = new ElapsedTime();
    PIDFCoefficients pidf = new PIDFCoefficients(kp, ki, kd, f);
    EvState liftState = EvState.START;

    public Elevator(HardwareMapA mappingA)
    {
        this.mapping = mappingA;
        mappingA.motorSlider.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        mappingA.motorSlider.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void update(Gamepad gamepad)
    {

        switch (liftState)
        {
            case EXTEND:
                mapping.motorSlider.setPower(1);
                claw.isRotated = false;
                break;
            case DOWN:
                mapping.motorSlider.setPower(-1);
                claw.isRotated = true;
                break;
            case START:
                mapping.motorSlider.setPower(0);
                claw.isRotated = false;
                break;
        }
    }
}
