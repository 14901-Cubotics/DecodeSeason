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
        carousel.init(this);
        launch.init(hardwareMap);
    }

    @Override
    public void loop(){
        
        if (gamepad1.left_bumper){
            intake.runIntake();
        } else if (gamepad1.right_bumper) {
            intake.reverseRunIntake();
        }

        if (gamepad1.a == true){
            carousel.advanceCarousel();
        }
        if (gamepad1.dpad_up){
            launch.activateLongFlywheel();
        }
        if (gamepad1.dpad_down){
            launch.stopFlywheel();
        }

        drive.driveRobot(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);
    }
}
