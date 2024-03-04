package org.firstinspires.ftc.teamcode.opmode;
import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.drivee.HardwareMapping;
import org.firstinspires.ftc.teamcode.parts.Elevator;
import org.firstinspires.ftc.teamcode.parts.Intake;
import org.firstinspires.ftc.teamcode.parts.OutTake;

import java.util.List;

@TeleOp(name="Main")
public class Main extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        List<LynxModule> allHubs = hardwareMap.getAll(LynxModule.class);

        final HardwareMapping mapping = HardwareMapping.from(hardwareMap);
        //DriveTrain dt = new DriveTrain(mapping);
        //FieldCentric dtfc = new FieldCentric(mapping);
        Intake intake = new Intake(mapping);
        Elevator elevator = null;
        boolean ok = true;
        Gamepad gmcur = gamepad1, gmprev;

        for (LynxModule hub : allHubs) {
            hub.setBulkCachingMode(LynxModule.BulkCachingMode.MANUAL);
        }

        waitForStart();

        while (!isStopRequested() && opModeIsActive())
        {
           /* gmprev = gmcur; // gmcur - gamepadcurrent gmprev - gamepadprevious
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
            intake.update(gamepad1); // circle, square
            outtake.update(gamepad2);
            //elevator.update(gamepad2);
            */
            telemetry.update();
            for (LynxModule hub : allHubs) {
                hub.clearBulkCache();
            }
        }
    }
}
