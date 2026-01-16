package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.systems.intakeSystem;
import org.firstinspires.ftc.teamcode.systems.mechanumDrive;

@TeleOp
public class MillieTeleOp extends OpMode {
   private intakeSystem intake = new intakeSystem();
   private mechanumDrive drive = new mechanumDrive();
    @Override
    public void init(){
        intake.init(hardwareMap);
        drive.init(hardwareMap);
    }
    @Override
    public void loop(){
        if (gamepad1.left_trigger == 1){
            intake.runIntake();
        } else if (gamepad1.right_trigger == 1) {
            intake.reverseRunIntake();
        }
        drive.driveRobot(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);
    }
}
