package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.parts.BratAngle;
import org.firstinspires.ftc.teamcode.parts.OutTake;

public class testBrat extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        OutTake outTake = new OutTake(hardwareMap, telemetry);

        waitForStart();

        while (opModeIsActive() && !isStopRequested()){
            outTake.update(gamepad1);
        }

    }
}
