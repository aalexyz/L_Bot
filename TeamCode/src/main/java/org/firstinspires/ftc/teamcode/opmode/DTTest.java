package org.firstinspires.ftc.teamcode.opmode;

import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.drivee.DriveTrain;
import org.firstinspires.ftc.teamcode.drivee.HardwareMapA;
import org.firstinspires.ftc.teamcode.parts.ArmOT;
import org.firstinspires.ftc.teamcode.parts.Elevator;

import java.util.List;

@TeleOp(name = "DTTEST") // tragic
public class DTTest extends LinearOpMode
{
    @Override
    public void runOpMode() throws InterruptedException
    {

        List<LynxModule> allHubs = hardwareMap.getAll(LynxModule.class);

        final HardwareMapA mappingA = HardwareMapA.from(hardwareMap);

        DriveTrain dt = new DriveTrain(mappingA);
        Elevator ev = new Elevator(mappingA);

        for (LynxModule hub : allHubs) {
            hub.setBulkCachingMode(LynxModule.BulkCachingMode.MANUAL);
        }

        waitForStart();

        while(!isStopRequested() && opModeIsActive())
        {

            dt.update(gamepad1);
            ev.update(gamepad1);

            telemetry.update();
            for (LynxModule hub : allHubs) {
                hub.clearBulkCache();
            }
        }
    }
}
