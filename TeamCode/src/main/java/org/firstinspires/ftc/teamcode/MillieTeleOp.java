package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.systems.carouselSystem;
import org.firstinspires.ftc.teamcode.systems.intakeSystem;
import org.firstinspires.ftc.teamcode.systems.launchSystem;
import org.firstinspires.ftc.teamcode.systems.mechanumDrive;

@TeleOp
public class MillieTeleOp extends OpMode {
   private intakeSystem intake = new intakeSystem();
   private mechanumDrive drive = new mechanumDrive();
   private carouselSystem carousel = new carouselSystem();
   private launchSystem launch = new launchSystem();
    @Override
    public void init(){
        intake.init(hardwareMap);
        drive.init(hardwareMap);
        carousel.init(hardwareMap);
        launch.init(hardwareMap);
    }
    @Override
    public void loop(){
        if (gamepad1.left_trigger == 1){
            intake.runIntake();
        } else if (gamepad1.right_trigger == 1) {
            intake.reverseRunIntake();
        }
        if (gamepad2.a == true){
            carousel.advanceCarousel();
        }
        drive.driveRobot(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);
    }
}
