package org.firstinspires.ftc.teamcode.opmode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.drivee.DriveTrain;
import org.firstinspires.ftc.teamcode.drivee.HardwareMapA;
import org.firstinspires.ftc.teamcode.parts.OutTake;
@TeleOp(name = "tragic")
public class Main extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        final HardwareMapA hm = HardwareMapA.from(hardwareMap);
        DriveTrain dt = new DriveTrain(hm);
        OutTake outTake = new OutTake(hm);
        waitForStart();

        while (opModeIsActive() && !isStopRequested()) {
            dt.update(gamepad1);
            outTake.update(gamepad2);
        }
    }
}
