package org.firstinspires.ftc.teamcode.drivee;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.apache.commons.math3.geometry.euclidean.twod.Line;

@TeleOp(name = "avocado shit")
public class sasiu extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException{
        DriveTrain dt = new DriveTrain(HardwareMapping.from(hardwareMap));
        waitForStart();

        while(opModeIsActive() && !isStopRequested()){

            dt.update(gamepad1);

        }
    }
}
