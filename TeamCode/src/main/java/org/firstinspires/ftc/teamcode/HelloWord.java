package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class HelloWord extends OpMode {

    @Override
    public void init() {
        telemetry.addData("Hello", "World");
        telemetry.addLine("_________________");
        telemetry.addLine("Hello Emily 67");
    }

    @Override
    public void loop() {}

    // Single Line Comment

}
