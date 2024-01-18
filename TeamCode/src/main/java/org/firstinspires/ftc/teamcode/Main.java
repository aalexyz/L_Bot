package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

@TeleOp(name="Main")
public class Main extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        final HardwareMapping mapping = HardwareMapping.from(hardwareMap);
        DriveTrain dt = new DriveTrain(mapping);
        FieldCentric dtfc = new FieldCentric(mapping);
        boolean ok = true;
        Gamepad gmcur = gamepad1, gmprev;


        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive())
        {
            gmprev = gmcur; // gmcur - gamepadcurrent gmprev - gamepadprevious
            gmcur = gamepad1;

            if(gmcur.share && !gmprev.share)
                ok=!ok;

            if(ok)
                dt.update(gamepad1);
            else
                dtfc.update(gamepad1);

            dt.update(gamepad1);
            dtfc.update(gamepad1);
            telemetry.update();
            // gamepad1 - drivetrain
            // gamepad2 - intake
            // share - schimba de la robot centric la field centric
            // a - acceleraza sper..........
            //
        }
    }
}
