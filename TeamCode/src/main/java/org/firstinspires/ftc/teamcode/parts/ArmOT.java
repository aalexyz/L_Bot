package org.firstinspires.ftc.teamcode.parts;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;
import com.qualcomm.robotcore.hardware.configuration.typecontainers.MotorConfigurationType;

import org.firstinspires.ftc.teamcode.drivee.HardwareMapA;

public class ArmOT {

    private HardwareMapA mappingA;
    public static int targetposr, posr, armDown, armUp;
    boolean isDown;
    public static PIDFCoefficients pidfCoefficients = new PIDFCoefficients(0, 0, 0, 0), lastpidf;
    public ArmOT(HardwareMapA mappingA)
    {
        this.mappingA = mappingA;

        MotorConfigurationType mct = mappingA.motorRotation.getMotorType();
        mct.setAchieveableMaxRPMFraction(1.0);
        mappingA.motorRotation.setMotorType(mct);

        mappingA.motorRotation.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        mappingA.motorRotation.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        mappingA.motorRotation.setTargetPosition(0);

        mappingA.motorRotation.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        targetposr = 0;
        posr = 0;
        lastpidf = pidfCoefficients;
        mappingA.motorRotation.setPower(1);
    }
    public void update()
    {
        if (isDown)
        {
            mappingA.motorRotation.setTargetPosition(armUp);
            isDown = false;
        }
        else mappingA.motorRotation.setTargetPosition(armDown);
        if (lastpidf != pidfCoefficients)
            mappingA.motorRotation.setPIDFCoefficients(DcMotor.RunMode.RUN_TO_POSITION, pidfCoefficients);
        mappingA.motorRotation.setTargetPosition(targetposr);
        mappingA.motorRotation.setPower(1);
        posr = mappingA.motorRotation.getCurrentPosition();
    }
}
//60 rpm (2,786.2 * 120) / 360