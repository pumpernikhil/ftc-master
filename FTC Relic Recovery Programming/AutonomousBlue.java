package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.vuforia.HINT;
import com.vuforia.Vuforia;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.Axis;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;


  //Created by ftcte on 992017.
@TeleOp(name="vuforia max demo")
public class AutonomousBlue extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        VuforiaLocalizer.Parameters params = new VuforiaLocalizer.Parameters(R.id.cameraMonitorViewId);
        params.vuforiaLicenseKey = "AVvsNWX/////AAAAGYCdn+QzAUoloS0oMxvc0+0bqxyVeOTHMde94Naqu46gIjtbGb0VEWfqeuSFJdVTvICMDl8PpyBHO5L/pj+DAVote913lHbKzcWhXCpZdC/WTknZRxYQj98FXOPq3ZeCoOSQarfcIxCkyx8LPvhm1fCYUAbEUmWiOEg4naRfv0qocTAecnyOEuyQJ0tG8zc0ZCT3EVTFU2oPsf47NAs24xXNjqMTqiHfbgY+hxU92zZB4I7DvfqSA3QLrZDCkACmNn+EZsnmtEZ7o0PISgQjxzBXZmY3yv4gO/VfU2x3Qc+fVwNETAhZN/g6juFXWAycm4f20D5sQPs4d0NoUBn5h5uwvUGrC01lsxrrTp8kGIOK";

                params.cameraMonitorFeedback = VuforiaLocalizer.Parameters.CameraMonitorFeedback.AXES;

        VuforiaLocalizer vuforia = ClassFactory.createVuforiaLocalizer(params);
        Vuforia.setHint(HINT.HINT_MAX_SIMULTANEOUS_IMAGE_TARGETS, 1);

        VuforiaTrackables vumark_relic = vuforia.loadTrackablesFromAsset("RelicVuMark");

        vumark_relic.get(0).setName("cypher");

        waitForStart();

        vumark_relic.activate();

        while(opModeIsActive()) {

            for(VuforiaTrackable cry : vumark_relic) {
                OpenGLMatrix pose = ((VuforiaTrackableDefaultListener) cry.getListener()).getPose();
                if(pose != null) {
                    VectorF translation = pose.getTranslation();

                    telemetry.addData(cry.getName() + "Translation", translation);

                }
                telemetry.update();
            }




        }


    }
}
