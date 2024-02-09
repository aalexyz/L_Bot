package org.firstinspires.ftc.teamcode.parts;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.drivee.HardwareMapping;

public class Intake {

    private final HardwareMapping mapping;
    public static boolean intakeON = false;

    public Intake(HardwareMapping mapping)
    {
        this.mapping = mapping;
    }

    public void update(Gamepad gamepad)
    {

        if (gamepad.circle)
        {
            mapping.intakeMotor.setPower(1);
            intakeON = true;
        }
        else if (gamepad.square)
        {
            mapping.intakeMotor.setPower(-1);
            intakeON = true;
        }
        else
        {
            mapping.intakeMotor.setPower(0);
            intakeON = false;
        }

    }

}
