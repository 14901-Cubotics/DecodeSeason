package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class pickupSystem {
    private DcMotor pickup;
    public void Init(HardwareMap hMap){
        pickupSystem = hMap.get(DcMotor.class,"pickup");
        pickup.setDirection(DcMotorSimple.Direction.FORWARD);
    }
    public void pickupBall(Gamepad gamepad1){
        if (gamepad1 == true) {
            pickup.setPower(1.0);
        } else {
            pickup.setPower(0.0);
        }
    }
}
