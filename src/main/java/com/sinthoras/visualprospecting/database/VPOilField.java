package com.sinthoras.visualprospecting.database;

import com.sinthoras.visualprospecting.VP;
import net.minecraftforge.fluids.Fluid;

import java.util.Arrays;

public class VPOilField {

    public static final VPOilField NOT_PROSPECTED = new VPOilField(new Fluid("no_oil"), new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}});

    public final Fluid oil;
    public final int[][] chunks;

    public VPOilField(Fluid oil, int[][] chunks) {
        this.oil = oil;
        this.chunks = chunks;
    }

    public boolean equals(VPOilField other) {
        return oil == other.oil && Arrays.deepEquals(chunks, other.chunks);
    }

    public int getMinProduction() {
        int smallest = Integer.MAX_VALUE;
        for(int chunkX = 0; chunkX < VP.oilFieldSizeChunkX; chunkX++) {
            for (int chunkZ = 0; chunkZ < VP.oilFieldSizeChunkZ; chunkZ++) {
                if (chunks[chunkX][chunkZ] < smallest) {
                    smallest = chunks[chunkX][chunkZ];
                }
            }
        }
        return smallest;
    }

    public int getMaxProduction() {
        int largest = Integer.MIN_VALUE;
        for(int chunkX=0;chunkX < VP.oilFieldSizeChunkX;chunkX++) {
            for (int chunkZ = 0; chunkZ < VP.oilFieldSizeChunkZ; chunkZ++) {
                if (chunks[chunkX][chunkZ] > largest) {
                    largest = chunks[chunkX][chunkZ];
                }
            }
        }
        return largest;
    }
}