package org.firstinspires.ftc.teamcode.parts;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.drivee.HardwareMapping;
import org.firstinspires.ftc.teamcode.utils.PID;
import org.firstinspires.ftc.teamcode.utils.PIDElevator;

public class Elevator {

    private final HardwareMapping mapping;


    enum LiftState
    {
        START, // poz de start adica nu e extended inca
        EXTEND, // extend obvs ca sa get pixels
        GOT_PIXELS, // extend inapoi oare pot ssa il fac se depkinda de intake sper ca da sigur da e o pb pt eu din viitor
        PLACE_PIXELS, // extend outtake
        WAIT_FOR_PIXELS  // asteapta sa fie pusi pixelii si merge inapoi la start crd
        //imi mai trb un state la care nu ajunge? idk? help?????? oare imi mai trb un go back to start?

    }
    public static double kp,ki,kd;
    public static ElapsedTime timer = new ElapsedTime();
    PID pid = new PID(kp , ki , kd);
    LiftState liftState = LiftState.START;

    public Elevator(HardwareMapping mapping)
    {
        this.mapping = mapping;
        mapping.liftEncoder.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER); // nu cred ca trb sa fac asta aici dar wtv
        mapping.liftEncoder.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void update(Gamepad gamepad)
    {

        switch (liftState)
        {
            case EXTEND:

        }
       // double power=pid(100, mapping.liftEncoder.getCurrentPosition());
       // mapping.liftMotor.setPower(power);
    }
}
