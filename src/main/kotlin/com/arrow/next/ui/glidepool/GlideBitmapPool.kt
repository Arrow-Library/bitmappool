/*
 *    Copyright (C) 2016 Amit Shekhar
 *    Copyright (C) 2011 Android Open Source Project
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.arrow.next.ui.glidepool

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Build
import com.arrow.next.ui.glidepool.internal.BitmapPool
import com.arrow.next.ui.glidepool.internal.BitmapPoolAdapter
import com.arrow.next.ui.glidepool.internal.LruBitmapPool

/**
 * Created by amitshekhar on 17/06/16.
 */
class GlideBitmapPool {
    private var bitmapPool: BitmapPool? = null

    @SuppressLint("ObsoleteSdkInt")
    private constructor(maxSize: Int) {
        bitmapPool = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            LruBitmapPool(maxSize)
        } else {
            BitmapPoolAdapter()
        }
    }

    @SuppressLint("ObsoleteSdkInt")
    private constructor(maxSize: Int, allowedConfigs: Set<Bitmap.Config>) {
        bitmapPool = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            LruBitmapPool(maxSize, allowedConfigs)
        } else {
            BitmapPoolAdapter()
        }
    }

    companion object {
        private const val DEFAULT_MAX_SIZE = 6 * 1024 * 1024
        private var sInstance: GlideBitmapPool? = null
        private val instance: GlideBitmapPool?
            private get() {
                if (sInstance == null) {
                    sInstance = GlideBitmapPool(DEFAULT_MAX_SIZE)
                }
                return sInstance
            }

        fun initialize(maxSize: Int) {
            sInstance = GlideBitmapPool(maxSize)
        }

        fun initialize(maxSize: Int, allowedConfigs: Set<Bitmap.Config>) {
            sInstance = GlideBitmapPool(maxSize, allowedConfigs)
        }

        fun putBitmap(bitmap: Bitmap?) {
            instance!!.bitmapPool!!.put(bitmap)
        }

        fun getBitmap(width: Int, height: Int, config: Bitmap.Config?): Bitmap {
            return instance!!.bitmapPool!![width, height, config]
        }

        fun getDirtyBitmap(width: Int, height: Int, config: Bitmap.Config?): Bitmap {
            return instance!!.bitmapPool!!.getDirty(width, height, config)
        }

        fun clearMemory() {
            instance!!.bitmapPool!!.clearMemory()
        }

        fun trimMemory(level: Int) {
            instance!!.bitmapPool!!.trimMemory(level)
        }

        fun shutDown() {
            if (sInstance != null) {
                sInstance!!.bitmapPool!!.clearMemory()
                sInstance = null
            }
        }
    }
}