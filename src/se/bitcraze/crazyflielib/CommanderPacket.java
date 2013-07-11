/**
 *    ||          ____  _ __                           
 * +------+      / __ )(_) /_______________ _____  ___ 
 * | 0xBC |     / __  / / __/ ___/ ___/ __ `/_  / / _ \
 * +------+    / /_/ / / /_/ /__/ /  / /_/ / / /_/  __/
 *  ||  ||    /_____/_/\__/\___/_/   \__,_/ /___/\___/
 *
 * Copyright (C) 2013 Bitcraze AB
 *
 * Crazyflie Nano Quadcopter Client
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 *
 */

package se.bitcraze.crazyflielib;

import struct.StructClass;
import struct.StructField;

@StructClass 
public class CommanderPacket implements Packet {
    @StructField(order = 0)
    public byte port;
    @StructField(order = 1)
    public float roll;
    @StructField(order = 2)
    public float pitch;
    @StructField(order = 3)
    public float yaw;
    @StructField(order = 4)
    public char thrust;

    public CommanderPacket(float roll, float pitch, float yaw, char thrust, boolean xmode) {
        this.port = (byte) 0x30;
        if (xmode) {
            this.pitch = 0.707f * (roll + pitch);
            this.roll = 0.707f * (roll - pitch);
        } else {
            this.pitch = pitch;
            this.roll = roll;
        }
        this.yaw = yaw;
        this.thrust = thrust;
    }
}