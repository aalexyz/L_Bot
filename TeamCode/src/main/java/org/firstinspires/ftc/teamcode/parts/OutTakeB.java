package org.firstinspires.ftc.teamcode.parts;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.drivee.HardwareMapA;
import org.firstinspires.ftc.teamcode.utils.PIDElevator;

public class OutTakeB {
    private final HardwareMapA mappingA;
    private PIDElevator pidElevator;
    public OutTakeB (HardwareMapA mappingA)
    {
        this.mappingA = mappingA;

        mappingA.motorRotation.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        mappingA.motorSlider.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        mappingA.motorRotation.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        mappingA.motorSlider.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void update (Gamepad gamepad)
    {
        if (gamepad.x) {
            mappingA.motorRotation.setPower(pidElevator.pidev(mappingA.motorRotation, 1));
        }
        else mappingA.motorRotation.setPower(0);
    }
}
