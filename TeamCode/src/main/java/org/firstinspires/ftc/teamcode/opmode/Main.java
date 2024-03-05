package org.firstinspires.ftc.teamcode.drivee;

import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.apache.commons.math3.geometry.euclidean.twod.Line;

import java.util.List;

@TeleOp(name = "kms")
public class sasiu extends LinearOpMode
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

        if (isStopRequested()) return;

        while(opModeIsActive())
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
