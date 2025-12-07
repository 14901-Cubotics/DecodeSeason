package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.systems.mechanumDrive;

@TeleOp(name = "Drivemode 25-26", group = "Competition")
public class drivemode2526 extends LinearOpMode {

    // Create any systems here, name and assign like the mechanuDrive
    mechanumDrive mdrive = new mechanumDrive();
    // intakeSystem
    // carouselSystem
    // launchSystem

    @Override
    public void runOpMode() throws InterruptedException {
        // TODO: Essentially your main method

       // Init any hardware here.
        mdrive.init(hardwareMap);

        waitForStart();

        while (opModeIsActive()) {
            // Your loop, repeats as long as the game is active.

            // variables for the drive numbers.
            double drive = -gamepad1.left_stick_y;
            double strafe = gamepad1.left_stick_x;
            double turn = gamepad1.right_stick_x;

            //calling the mechanumDrive's drive method with our numbers.
            mdrive.driveRobot(drive, strafe, turn);
        }
    }
}
