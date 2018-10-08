/*
 * Copyright (C) 2008 ZXing authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.husheng.riji.husshen2.ui;

import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceView;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;


import com.husheng.riji.husshen2.R;
import com.husheng.riji.husshen2.camera.CameraManager;
import com.husheng.riji.husshen2.utils.BeepManager;
import com.husheng.riji.husshen2.utils.InactivityTimer;
import com.husheng.riji.husshen2.utils.SuitScreen;


/**
 * This activity opens the camera and does the actual scanning on a background
 * thread. It draws a viewfinder to help the user place the barcode correctly,
 * shows feedback as the image processing is happening, and then overlays the
 * results when a scan is successful.
 *
 * @author dswitkin@google.com (Daniel Switkin)
 * @author Sean Owen
 */
public final class TwoDimensionScanActivity extends AppCompatActivity {

    private static final String TAG =  TwoDimensionScanActivity.class.getSimpleName();

    private CameraManager cameraManager;

    private InactivityTimer inactivityTimer;
    private BeepManager beepManager;

    private SurfaceView scanPreview = null;
    private RelativeLayout scanContainer;
    private RelativeLayout scanCropView;
    private ImageView scanLine;

    private Rect mCropRect = null;



    public CameraManager getCameraManager() {
        return cameraManager;
    }

    private boolean isHasSurface = false;
    private Camera camera = null;
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_capture);



        SuitScreen ss=new SuitScreen();
        ss.setWindows(getWindow());




    }

    @Override
    protected void onResume() {
        super.onResume();

    }
    
}