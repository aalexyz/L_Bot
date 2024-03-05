package org.firstinspires.ftc.teamcode.opmode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.drivee.HardwareMapA;
import org.firstinspires.ftc.teamcode.parts.BratAngle;
import org.firstinspires.ftc.teamcode.parts.Elevator;
import org.firstinspires.ftc.teamcode.parts.OutTake;

public class testBrat extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        final HardwareMapA hm = HardwareMapA.from(hardwareMap);
        OutTake outTake = new OutTake(hm);
        waitForStart();

        while (opModeIsActive() && !isStopRequested()){
            outTake.update(gamepad1);
        }

    }
}
