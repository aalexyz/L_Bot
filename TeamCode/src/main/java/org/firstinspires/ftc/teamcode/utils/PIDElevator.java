package org.firstinspires.ftc.teamcode.utils;

import com.arcrobotics.ftclib.controller.PIDController;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.drivee.HardwareMapping;

public class PIDElevator {

    private final HardwareMapping mapping;

    private PIDController controller;
    public static double p = 0, i = 0, d = 0, f = 0;

    public static int targetpos = 0; // ticks
    private final double ticksid = 0; // ticks in degree
    private final double ZERO_OFFSET = 0; // measured val

    public PIDElevator(HardwareMapping mapping)
    {
        this.mapping = mapping;
        controller = new PIDController(p, i, d);
    }

    public double pidev(DcMotor motor, double power)
    {
        controller.setPID(p, i, d);
        int pos = motor.getCurrentPosition();
        double pid = controller.calculate(pos, targetpos);
        double ff = Math.sin(Math.toRadians(pos / ticksid + ZERO_OFFSET)) * f;

        power = pid + ff;

        return power;

    }

}
