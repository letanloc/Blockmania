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
package com.github.begla.blockmania.generators;

import com.github.begla.blockmania.blocks.BlockManager;
import com.github.begla.blockmania.main.Configuration;
import com.github.begla.blockmania.world.LocalWorldProvider;
import com.github.begla.blockmania.world.chunk.Chunk;

/**
 * Generates some basic resources.
 *
 * @author Benjamin Glatzel <benjamin.glatzel@me.com>
 */
public class ChunkGeneratorResources extends ChunkGeneratorTerrain {

    public ChunkGeneratorResources(LocalWorldProvider worldProvider) {
        super(worldProvider);
    }

    /**
     * @param c
     */
    @Override
    public void generate(Chunk c) {
        for (int x = 0; x < Configuration.CHUNK_DIMENSIONS.x; x++) {
            for (int z = 0; z < Configuration.CHUNK_DIMENSIONS.z; z++) {
                for (int y = 0; y < Configuration.CHUNK_DIMENSIONS.y; y++) {
                    if (BlockManager.getInstance().getBlock(c.getBlock(x, y, z)).getTitle().equals("Stone")) {
                        if (_worldProvider.getRandom().standNormalDistrDouble() < Configuration.PROB_COAL) {
                            c.setBlock(x, y, z, BlockManager.getInstance().getBlock("Coal").getId());
                        }

                        if (_worldProvider.getRandom().standNormalDistrDouble() < Configuration.PROB_GOLD) {
                            c.setBlock(x, y, z, BlockManager.getInstance().getBlock("Gold").getId());
                        }

                        if (_worldProvider.getRandom().standNormalDistrDouble() < Configuration.PROB_DIAMOND) {
                            c.setBlock(x, y, z, BlockManager.getInstance().getBlock("Diamond").getId());
                        }
                        if (_worldProvider.getRandom().standNormalDistrDouble() < Configuration.PROB_REDSTONE) {
                            c.setBlock(x, y, z, BlockManager.getInstance().getBlock("Red stone").getId());
                        }

                        if (_worldProvider.getRandom().standNormalDistrDouble() < Configuration.PROB_SILVER) {
                            c.setBlock(x, y, z, BlockManager.getInstance().getBlock("Silver").getId());
                        }
                    }
                }
            }
        }
    }
}
