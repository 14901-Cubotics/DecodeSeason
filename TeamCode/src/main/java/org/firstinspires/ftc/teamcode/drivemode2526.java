package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.systems.mechanumDrive;
import org.firstinspires.ftc.teamcode.systems.navSystem;

@TeleOp(name="Drivemode 25-26", group="Competition")
public class drivemode2526 extends LinearOpMode {
    //initialize systems
    navSystem nav = new navSystem();
    mechanumDrive mdrive = new mechanumDrive();


    @Override
    public void runOpMode() throws InterruptedException {
        mdrive.init(hardwareMap);
        while (opModeIsActive()){
            double drive = -gamepad1.left_stick_y;
            double strafe = gamepad1.left_stick_x;
            double turn = gamepad1.right_stick_x;

        }
    }
}
