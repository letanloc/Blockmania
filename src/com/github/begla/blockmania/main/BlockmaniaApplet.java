/*
 * Copyright 2011 Benjamin Glatzel <benjamin.glatzel@me.com>.
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
package com.github.begla.blockmania.main;


import org.lwjgl.opengl.Display;

import java.applet.Applet;

/**
 * @author Benjamin Glatzel <benjamin.glatzel@me.com>
 */
public final class BlockmaniaApplet extends Applet {
    private Blockmania _blockmania;
    private Thread _gameThread;

    @Override
    public void init() {
        startGame();
        super.init();
    }

    private void startGame() {
        _gameThread = new Thread() {
            @Override
            public void run() {
                try {
                    Configuration.loadSandboxed();

                    Display.setParent(null);
                    Display.setDisplayMode(new org.lwjgl.opengl.DisplayMode(1280, 720));
                    Display.setTitle(Configuration.GAME_TITLE);
                    Display.create();

                    _blockmania = Blockmania.getInstance();
                    _blockmania.initControls();

                    _blockmania.initGame();
                    _blockmania.startGame();
                } catch (Exception e) {
                    System.err.println(e);
                }
            }
        };

        _gameThread.start();
    }

    @Override
    public void start() {
        _blockmania.unpauseGame();
        super.start();
    }

    @Override
    public void stop() {
        _blockmania.pauseGame();
        super.stop();
    }

    @Override
    public void destroy() {
        if (_blockmania != null)
            _blockmania.stopGame();

        super.destroy();
    }
}
