package org.firstinspires.ftc.teamcode.opmode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.drivee.HardwareMapA;
import org.firstinspires.ftc.teamcode.parts.Claw;

@TeleOp
public class IntakeTest extends LinearOpMode {

    public void runOpMode() throws InterruptedException {

        final HardwareMapA hm = HardwareMapA.from(hardwareMap);
        Claw claw = new Claw(hm);

        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive())
        {
            claw.update(gamepad2);
            telemetry.update();
        }
    }
}
