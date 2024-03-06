package org.firstinspires.ftc.teamcode.utils;

import com.qualcomm.robotcore.hardware.Gamepad;

public class Controls {
// intr o zi poate fac si eu clasa de controls

    // GAMEPAD1: LEFT/RIGHT STICK, L2/R2, A
    // GAMEPAD2: X,B, DPAD UP, DOWN, LEFT
    Gamepad gamepad1, gamepad2;

    public Controls (Gamepad gamepad1, Gamepad gamepad2)
    {
        this.gamepad1 = gamepad2;
        this.gamepad2 = gamepad2;
    }
    public void update()
    {

    }
}
