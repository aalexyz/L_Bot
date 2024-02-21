package org.firstinspires.ftc.teamcode.drivee;

import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

import java.util.List;

@TeleOp(name = "DTTEST")
public class DTTest extends LinearOpMode
{
    @Override
    public void runOpMode() throws InterruptedException
    {

        List<LynxModule> allHubs = hardwareMap.getAll(LynxModule.class);

        final HardwareMapA mappingA = HardwareMapA.from(hardwareMap);

        DriveTrain dt = new DriveTrain(mappingA);
        FieldCentric dtfc = new FieldCentric(mappingA, hardwareMap);

        boolean ok = true;
        Gamepad gmcur = gamepad1, gmprev;

        for (LynxModule hub : allHubs) {
            hub.setBulkCachingMode(LynxModule.BulkCachingMode.MANUAL);
        }

        waitForStart();

        while(!isStopRequested() && opModeIsActive())
        {

            gmprev = gmcur; // gmcur - gamepadcurrent gmprev - gamepadprevious
            gmcur = gamepad1;

            if(gmcur.share && !gmprev.share)
                ok=!ok;

            if(ok)
            {
                dt.update(gamepad1);
                telemetry.addLine("robot centric drivetrain, press share to switch");
            }
            else
            {
                dtfc.update(gamepad1);
                telemetry.addLine("field centric drivetrain, press share to switch");
            }

            dt.update(gamepad1);
            dtfc.update(gamepad1);
            telemetry.update();
            for (LynxModule hub : allHubs) {
                hub.clearBulkCache();
            }
        }
    }
}
