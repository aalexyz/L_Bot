package org.firstinspires.ftc.teamcode.parts;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.drivee.HardwareMapA;
@Config
public class Claw {
    private final HardwareMapA hm;
    Gamepad currentgm, prevgm;
    public enum ClawState
    {
        OPENED_LEFT,
        OPENED_RIGHT,
        BOTH_OPENED,
        CLOSED_LEFT,
        CLOSED_RIGHT,
        BOTH_CLOSED
    }
    public ClawState clawState = ClawState.BOTH_OPENED;
    public static boolean isRotated = false, c1isOpened = true, c2isOpened = true;
    public static double closed = 0.4, opened = 0.7, intakePos, backdropPos;
    public Claw(HardwareMapA hm)
    {
        this.hm = hm;
    }
    public void update (Gamepad gamepad)
    {
        prevgm = currentgm;
        currentgm = gamepad;


        if (gamepad.dpad_up)
        {
            hm.servoC1.setPosition(backdropPos);
            isRotated = true;
        }
        else if (gamepad.dpad_down)
        {
            hm.servoC1.setPosition(intakePos);
            isRotated = false;
        }


        switch (clawState)
        {
            case OPENED_LEFT:
                if (currentgm.dpad_left && !prevgm.dpad_left)
                {
                    if (c1isOpened)
                    {
                        hm.miniC1.setPosition(closed);
                        c1isOpened = false;
                    }
                }
                break;
            case OPENED_RIGHT:
                if (currentgm.dpad_right && !prevgm.dpad_right)
                {
                    if (c2isOpened)
                    {
                        hm.miniC2.setPosition(closed);
                        c2isOpened = false;
                    }
                }
                break;
            case CLOSED_LEFT:
                if (currentgm.dpad_left && !prevgm.dpad_left)
                {
                    if (!c1isOpened)
                    {
                        hm.miniC1.setPosition(opened);
                        c1isOpened = true;
                    }
                }
                break;
            case CLOSED_RIGHT:
                if (currentgm.dpad_right && !prevgm.dpad_right)
                {
                    if (!c2isOpened)
                    {
                        hm.miniC2.setPosition(opened);
                        c2isOpened = true;
                    }
                }
                break;
            case BOTH_OPENED:
                if (c1isOpened && c2isOpened)
                {
                    hm.miniC1.setPosition(closed);
                    hm.miniC2.setPosition(closed);
                    c1isOpened = c2isOpened = false;
                }
                break;
            case BOTH_CLOSED:
                hm.miniC1.setPosition(opened);
                hm.miniC2.setPosition(opened);
                c1isOpened = c2isOpened = true;
        }

    }
}
