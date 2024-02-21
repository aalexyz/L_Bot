package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.parts.BratAngle;

public class testBrat extends LinearOpMode {
    public static BratAngle bratAngle;
    @Override
    public void runOpMode() throws InterruptedException {
        bratAngle = new BratAngle(hardwareMap);
        waitForStart();

        while (opModeIsActive() && !isStopRequested()){
            bratAngle.update();
        }

    }
}
