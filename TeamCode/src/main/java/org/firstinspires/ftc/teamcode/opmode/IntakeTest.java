package org.firstinspires.ftc.teamcode.opmode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.drivee.HardwareMapA;
import org.firstinspires.ftc.teamcode.parts.Claw;
import org.firstinspires.ftc.teamcode.parts.OutTakeB;

@TeleOp
public class IntakeTest extends LinearOpMode {

    public void runOpMode() throws InterruptedException {

        final HardwareMapA hm = HardwareMapA.from(hardwareMap);
        OutTakeB ot = new OutTakeB(hm);

        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive())
        {
            ot.update(gamepad1);
            telemetry.update();
        }
    }
}
