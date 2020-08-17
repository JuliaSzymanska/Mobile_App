package com.game.a2048_app.boardActivity.Sensors;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

import com.game.a2048_app.R;
import com.game.a2048_app.boardActivity.BoardActivityListener;
import com.game.module.Game;

/**
 * Pauses or unpauses game depending on proximity level.
 */
public class StopGameProximity implements Runnable, SensorEventListener {

    private final static int PROXIMITY_DISTANCE = 5;

    public StopGameProximity(Context context, float mProximityData, Game game) {
        this.mProximityData = mProximityData;
        this.context = context;
        this.game = game;
        this.boardActivityListener = (BoardActivityListener) context;
    }

    private float mProximityData;
    private Game game;
    private Context context;
    private BoardActivityListener boardActivityListener;

    @Override
    public void run() {
        // Proximity sensor - zatrzymuje sie czas po zblizeniu
        if (mProximityData < PROXIMITY_DISTANCE) {
            if (!game.isSuspended()) {
                boardActivityListener.callback(context.getString(R.string.SetPauseOn));
            }
        } else if (game.isSuspended()) {
            boardActivityListener.callback(context.getString(R.string.SetPauseOff));
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}