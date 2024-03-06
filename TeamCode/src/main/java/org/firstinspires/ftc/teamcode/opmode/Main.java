package org.firstinspires.ftc.teamcode.opmode;

import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.drivee.DriveTrain;
import org.firstinspires.ftc.teamcode.drivee.HardwareMapA;
import org.firstinspires.ftc.teamcode.parts.OutTake;
import org.firstinspires.ftc.teamcode.parts.OutTakeB;

import java.util.List;

@TeleOp(name = "tragic")
public class Main extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        List<LynxModule> allHubs = hardwareMap.getAll(LynxModule.class);

        final HardwareMapA hm = HardwareMapA.from(hardwareMap);
        DriveTrain dt = new DriveTrain(hm);
        OutTakeB outTake = new OutTakeB(hm);

        for (LynxModule hub : allHubs) {
            hub.setBulkCachingMode(LynxModule.BulkCachingMode.MANUAL);
        }

        waitForStart();

        while (opModeIsActive() && !isStopRequested()) {
            dt.update(gamepad1);
            outTake.update(gamepad2);

            for (LynxModule hub : allHubs) {
                hub.clearBulkCache();
            }
        }
    }
}
