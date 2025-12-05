package org.firstinspires.ftc.teamcode.systems;

//import com.qualcomm.hardware.dfrobot.HuskyLens;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;
import org.firstinspires.ftc.robotcore.internal.system.Deadline;

import java.util.concurrent.TimeUnit;

public class navSystem {
    private int READ_PERIOD = 1;
    private int START_X = 1;
    private int START_Y = 1;
    private int START_HEAD = 180;
    //private HuskyLens huskyLens;
    private GoBildaPinpointDriver pinpoint;

    Deadline rateLimit = new Deadline(READ_PERIOD, TimeUnit.SECONDS);

    public void init(HardwareMap hMap){
        //huskyLens = hMap.get(HuskyLens.class,"huskylens");
        pinpoint = hMap.get(GoBildaPinpointDriver.class, "pintpoint");

        rateLimit.expire();
        //huskyLens.selectAlgorithm(HuskyLens.Algorithm.TAG_RECOGNITION);

        configurePinpoint();
    }
/*
    public boolean findTag(int tagToFind){
        HuskyLens.Block[] blocks = huskyLens.blocks();
        boolean found = false;
        for (int i = 0; i < blocks.length; i++) {
            if (blocks[i].id == tagToFind) {
                found = true;
            } else {
                found =  false;
            }
        }
        return found;
    }
*/
    public Pose2D getCurrentPose(){
        Pose2D currentPose = pinpoint.getPosition();
        return currentPose;
    }

    public void setStartPose(int x, int y, int head){
        Pose2D startingPose = new Pose2D(DistanceUnit.INCH, x, y, AngleUnit.DEGREES, head);
        pinpoint.setPosition(startingPose);
    }

    private void configurePinpoint(){
        /*
         *  Set the odometry pod positions relative to the point that you want the position to be measured from.
         *
         *  The X pod offset refers to how far sideways from the tracking point the X (forward) odometry pod is.
         *  Left of the center is a positive number, right of center is a negative number.
         *
         *  The Y pod offset refers to how far forwards from the tracking point the Y (strafe) odometry pod is.
         *  Forward of center is a positive number, backwards is a negative number.
         */
        pinpoint.setOffsets(-84.0, -168.0, DistanceUnit.MM); //these are tuned for 3110-0002-0001 Product Insight #1

        /*
         * Set the kind of pods used by your robot. If you're using goBILDA odometry pods, select either
         * the goBILDA_SWINGARM_POD, or the goBILDA_4_BAR_POD.
         * If you're using another kind of odometry pod, uncomment setEncoderResolution and input the
         * number of ticks per unit of your odometry pod.  For example:
         *     pinpoint.setEncoderResolution(13.26291192, DistanceUnit.MM);
         */
        pinpoint.setEncoderResolution(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD);

        /*
         * Set the direction that each of the two odometry pods count. The X (forward) pod should
         * increase when you move the robot forward. And the Y (strafe) pod should increase when
         * you move the robot to the left.
         */
        pinpoint.setEncoderDirections(GoBildaPinpointDriver.EncoderDirection.FORWARD,
                GoBildaPinpointDriver.EncoderDirection.FORWARD);

        /*
         * Before running the robot, recalibrate the IMU. This needs to happen when the robot is stationary
         * The IMU will automatically calibrate when first powered on, but recalibrating before running
         * the robot is a good idea to ensure that the calibration is "good".
         * resetPosAndIMU will reset the position to 0,0,0 and also recalibrate the IMU.
         * This is recommended before you run your autonomous, as a bad initial calibration can cause
         * an incorrect starting value for x, y, and heading.
         */
        pinpoint.resetPosAndIMU();
    }

}
