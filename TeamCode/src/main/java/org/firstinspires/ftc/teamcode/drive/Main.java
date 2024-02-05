<<<<<<<< HEAD:TeamCode/src/main/java/org/firstinspires/ftc/teamcode/drivee/Main.java
package org.firstinspires.ftc.teamcode.drivee;
========
package org.firstinspires.ftc.teamcode.drive;
>>>>>>>> origin/master:TeamCode/src/main/java/org/firstinspires/ftc/teamcode/drive/Main.java

import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

<<<<<<<< HEAD:TeamCode/src/main/java/org/firstinspires/ftc/teamcode/drivee/Main.java
import org.firstinspires.ftc.teamcode.parts.Elevator;
import org.firstinspires.ftc.teamcode.parts.Intake;
import org.firstinspires.ftc.teamcode.parts.OutTake;

import java.util.List;
========
import org.firstinspires.ftc.teamcode.OutTakeq;
import org.firstinspires.ftc.teamcode.components.Elevator;
import org.firstinspires.ftc.teamcode.Intake;
import org.firstinspires.ftc.teamcode.ptautocosmin.Controls;
>>>>>>>> origin/master:TeamCode/src/main/java/org/firstinspires/ftc/teamcode/drive/Main.java

@TeleOp(name="Main")
public class Main extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        List<LynxModule> allHubs = hardwareMap.getAll(LynxModule.class);

        final HardwareMapping mapping = HardwareMapping.from(hardwareMap);
        DriveTrain dt = new DriveTrain(mapping);
        FieldCentric dtfc = new FieldCentric(mapping);
<<<<<<<< HEAD:TeamCode/src/main/java/org/firstinspires/ftc/teamcode/drivee/Main.java
        Intake intake = new Intake(mapping);
        OutTake outtake = new OutTake(hardwareMap, telemetry);
        Elevator elevator = null;
========
        Controls controls = new Controls(gamepad1, gamepad2);
        Intake intake = new Intake(mapping);
        OutTakeq outtake = new OutTakeq(hardwareMap);
        Elevator elevator = new Elevator(hardwareMap, telemetry);
>>>>>>>> origin/master:TeamCode/src/main/java/org/firstinspires/ftc/teamcode/drive/Main.java
        boolean ok = true;
        Gamepad gmcur = gamepad1, gmprev;

        for (LynxModule hub : allHubs) {
            hub.setBulkCachingMode(LynxModule.BulkCachingMode.MANUAL);
        }

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

            controls.update();
            dt.update(gamepad1);
            dtfc.update(gamepad1);
<<<<<<<< HEAD:TeamCode/src/main/java/org/firstinspires/ftc/teamcode/drivee/Main.java
            intake.update(gamepad1);
            outtake.update(gamepad2);
            elevator.update(gamepad2);
========
            intake.update(gamepad2);
            outtake.update(gamepad2);
>>>>>>>> origin/master:TeamCode/src/main/java/org/firstinspires/ftc/teamcode/drive/Main.java
            telemetry.update();
            for (LynxModule hub : allHubs) {
                hub.clearBulkCache();
            }
            // gamepad1 - drivetrain
            // gamepad2 - intake, outtake, restul
            // share - schimba de la robot centric la field centric
            // a / x - acceleraza sper.......... gm1 (hold)
            // circle / square - intake gm2 (hold)
        }
    }
}
