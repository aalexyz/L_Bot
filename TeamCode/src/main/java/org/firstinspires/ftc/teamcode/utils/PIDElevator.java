package org.firstinspires.ftc.teamcode.utils;

import com.arcrobotics.ftclib.controller.PIDController;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.drivee.HardwareMapA;
import org.firstinspires.ftc.teamcode.drivee.HardwareMapping;

public class PIDElevator {

    private final HardwareMapA mappingA;

    private PID PID;
    public static double p = 0, i = 0, d = 0, f = 0;

    public static int target = 0; // ticks
    private final double ticksid = 0; // ticks in degree
    private final double ZERO_OFFSET = 0; /*To determine ZERO_OFFSET, put the arm at its resting position, use a level
    tool app on your phone and put your phone against the arm to measure its angle from VERTICAL
    (IMPORTANT: vertical down is zero degree). */

    public PIDElevator(HardwareMapA mappingA)
    {
        this.mappingA = mappingA;
        PID = new PID(PID.kp, PID.ki, PID.kd);
    }

    public double pidev(DcMotor motor, double power)
    {
        int pos = motor.getCurrentPosition();
        double pide = PID.pid(target, pos);
        double ff = Math.sin(Math.toRadians(pos / ticksid + ZERO_OFFSET)) * f;

        power = pide + ff;

        return power;

    }

}
