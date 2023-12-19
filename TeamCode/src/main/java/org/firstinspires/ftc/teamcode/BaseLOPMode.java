package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public abstract class BaseLOPMode extends LinearOpMode {
    @Override
    public void runOpMode() {
        setup();

        waitForStart();

        while (opModeIsActive() && !isStopRequested()) {
            run();
        }
    }

    public abstract void setup();
    public abstract void run();
}
