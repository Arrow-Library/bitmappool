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

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.BitmapFactory.Options
import android.graphics.Rect
import android.os.Build
import android.util.TypedValue
import java.io.FileDescriptor
import java.io.InputStream

/**
 * Created by amitshekhar on 18/06/16.
 */
object GlideBitmapFactory {
    fun decodeFile(pathName: String?): Bitmap {
        val options = Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeFile(pathName, options)
        options.inSampleSize = 1
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
            options.inMutable = true
            val inBitmap: Bitmap = GlideBitmapPool.Companion.getBitmap(
                options.outWidth,
                options.outHeight,
                options.inPreferredConfig
            )
            if (inBitmap != null && Util.canUseForInBitmap(inBitmap, options)) {
                options.inBitmap = inBitmap
            }
        }
        options.inJustDecodeBounds = false
        return try {
            BitmapFactory.decodeFile(pathName, options)
        } catch (e: Exception) {
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
                options.inBitmap = null
            }
            BitmapFactory.decodeFile(pathName, options)
        }
    }

    fun decodeFile(pathName: String?, reqWidth: Int, reqHeight: Int): Bitmap {
        val options = Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeFile(pathName, options)
        options.inSampleSize = Util.calculateInSampleSize(options, reqWidth, reqHeight)
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
            options.inMutable = true
            val inBitmap: Bitmap = GlideBitmapPool.Companion.getBitmap(
                options.outWidth,
                options.outHeight,
                options.inPreferredConfig
            )
            if (inBitmap != null && Util.canUseForInBitmap(inBitmap, options)) {
                options.inBitmap = inBitmap
            }
        }
        options.inJustDecodeBounds = false
        return try {
            BitmapFactory.decodeFile(pathName, options)
        } catch (e: Exception) {
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
                options.inBitmap = null
            }
            BitmapFactory.decodeFile(pathName, options)
        }
    }

    fun decodeResource(res: Resources?, id: Int): Bitmap {
        val options = Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeResource(res, id, options)
        options.inSampleSize = 1
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
            options.inMutable = true
            val inBitmap: Bitmap = GlideBitmapPool.Companion.getBitmap(
                options.outWidth,
                options.outHeight,
                options.inPreferredConfig
            )
            if (inBitmap != null && Util.canUseForInBitmap(inBitmap, options)) {
                options.inBitmap = inBitmap
            }
        }
        options.inJustDecodeBounds = false
        return try {
            BitmapFactory.decodeResource(res, id, options)
        } catch (e: Exception) {
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
                options.inBitmap = null
            }
            BitmapFactory.decodeResource(res, id, options)
        }
    }

    fun decodeResource(res: Resources?, id: Int, reqWidth: Int, reqHeight: Int): Bitmap {
        val options = Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeResource(res, id, options)
        options.inSampleSize = Util.calculateInSampleSize(options, reqWidth, reqHeight)
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
            options.inMutable = true
            val inBitmap: Bitmap = GlideBitmapPool.Companion.getBitmap(
                options.outWidth,
                options.outHeight,
                options.inPreferredConfig
            )
            if (inBitmap != null && Util.canUseForInBitmap(inBitmap, options)) {
                options.inBitmap = inBitmap
            }
        }
        options.inJustDecodeBounds = false
        return try {
            BitmapFactory.decodeResource(res, id, options)
        } catch (e: Exception) {
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
                options.inBitmap = null
            }
            BitmapFactory.decodeResource(res, id, options)
        }
    }

    fun decodeByteArray(data: ByteArray?, offset: Int, length: Int): Bitmap {
        val options = Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeByteArray(data, offset, length, options)
        options.inSampleSize = 1
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
            options.inMutable = true
            val inBitmap: Bitmap = GlideBitmapPool.Companion.getBitmap(
                options.outWidth,
                options.outHeight,
                options.inPreferredConfig
            )
            if (inBitmap != null && Util.canUseForInBitmap(inBitmap, options)) {
                options.inBitmap = inBitmap
            }
        }
        options.inJustDecodeBounds = false
        return try {
            BitmapFactory.decodeByteArray(data, offset, length, options)
        } catch (e: Exception) {
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
                options.inBitmap = null
            }
            BitmapFactory.decodeByteArray(data, offset, length, options)
        }
    }

    fun decodeByteArray(
        data: ByteArray?,
        offset: Int,
        length: Int,
        reqWidth: Int,
        reqHeight: Int
    ): Bitmap {
        val options = Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeByteArray(data, offset, length, options)
        options.inSampleSize = Util.calculateInSampleSize(options, reqWidth, reqHeight)
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
            options.inMutable = true
            val inBitmap: Bitmap = GlideBitmapPool.Companion.getBitmap(
                options.outWidth,
                options.outHeight,
                options.inPreferredConfig
            )
            if (inBitmap != null && Util.canUseForInBitmap(inBitmap, options)) {
                options.inBitmap = inBitmap
            }
        }
        options.inJustDecodeBounds = false
        return try {
            BitmapFactory.decodeByteArray(data, offset, length, options)
        } catch (e: Exception) {
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
                options.inBitmap = null
            }
            BitmapFactory.decodeByteArray(data, offset, length, options)
        }
    }

    fun decodeResourceStream(
        res: Resources?,
        value: TypedValue?,
        `is`: InputStream?,
        pad: Rect?
    ): Bitmap? {
        val options = Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeResourceStream(res, value, `is`, pad, options)
        options.inSampleSize = 1
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
            options.inMutable = true
            val inBitmap: Bitmap = GlideBitmapPool.Companion.getBitmap(
                options.outWidth,
                options.outHeight,
                options.inPreferredConfig
            )
            if (inBitmap != null && Util.canUseForInBitmap(inBitmap, options)) {
                options.inBitmap = inBitmap
            }
        }
        options.inJustDecodeBounds = false
        return try {
            BitmapFactory.decodeResourceStream(res, value, `is`, pad, options)
        } catch (e: Exception) {
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
                options.inBitmap = null
            }
            BitmapFactory.decodeResourceStream(res, value, `is`, pad, options)
        }
    }

    fun decodeResourceStream(
        res: Resources?,
        value: TypedValue?,
        `is`: InputStream?,
        pad: Rect?,
        reqWidth: Int,
        reqHeight: Int
    ): Bitmap? {
        val options = Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeResourceStream(res, value, `is`, pad, options)
        options.inSampleSize = Util.calculateInSampleSize(options, reqWidth, reqHeight)
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
            options.inMutable = true
            val inBitmap: Bitmap = GlideBitmapPool.Companion.getBitmap(
                options.outWidth,
                options.outHeight,
                options.inPreferredConfig
            )
            if (inBitmap != null && Util.canUseForInBitmap(inBitmap, options)) {
                options.inBitmap = inBitmap
            }
        }
        options.inJustDecodeBounds = false
        return try {
            BitmapFactory.decodeResourceStream(res, value, `is`, pad, options)
        } catch (e: Exception) {
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
                options.inBitmap = null
            }
            BitmapFactory.decodeResourceStream(res, value, `is`, pad, options)
        }
    }

    fun decodeStream(`is`: InputStream?): Bitmap? {
        val options = Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeStream(`is`, null, options)
        options.inSampleSize = 1
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
            options.inMutable = true
            val inBitmap: Bitmap = GlideBitmapPool.Companion.getBitmap(
                options.outWidth,
                options.outHeight,
                options.inPreferredConfig
            )
            if (inBitmap != null && Util.canUseForInBitmap(inBitmap, options)) {
                options.inBitmap = inBitmap
            }
        }
        options.inJustDecodeBounds = false
        return try {
            BitmapFactory.decodeStream(`is`, null, options)
        } catch (e: Exception) {
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
                options.inBitmap = null
            }
            BitmapFactory.decodeStream(`is`, null, options)
        }
    }

    fun decodeStream(`is`: InputStream?, reqWidth: Int, reqHeight: Int): Bitmap? {
        val options = Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeStream(`is`, null, options)
        options.inSampleSize = Util.calculateInSampleSize(options, reqWidth, reqHeight)
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
            options.inMutable = true
            val inBitmap: Bitmap = GlideBitmapPool.Companion.getBitmap(
                options.outWidth,
                options.outHeight,
                options.inPreferredConfig
            )
            if (inBitmap != null && Util.canUseForInBitmap(inBitmap, options)) {
                options.inBitmap = inBitmap
            }
        }
        options.inJustDecodeBounds = false
        return try {
            BitmapFactory.decodeStream(`is`, null, options)
        } catch (e: Exception) {
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
                options.inBitmap = null
            }
            BitmapFactory.decodeStream(`is`, null, options)
        }
    }

    fun decodeStream(`is`: InputStream?, outPadding: Rect?): Bitmap? {
        val options = Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeStream(`is`, outPadding, options)
        options.inSampleSize = 1
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
            options.inMutable = true
            val inBitmap: Bitmap = GlideBitmapPool.Companion.getBitmap(
                options.outWidth,
                options.outHeight,
                options.inPreferredConfig
            )
            if (inBitmap != null && Util.canUseForInBitmap(inBitmap, options)) {
                options.inBitmap = inBitmap
            }
        }
        options.inJustDecodeBounds = false
        return try {
            BitmapFactory.decodeStream(`is`, outPadding, options)
        } catch (e: Exception) {
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
                options.inBitmap = null
            }
            BitmapFactory.decodeStream(`is`, outPadding, options)
        }
    }

    fun decodeStream(
        `is`: InputStream?,
        outPadding: Rect?,
        reqWidth: Int,
        reqHeight: Int
    ): Bitmap? {
        val options = Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeStream(`is`, outPadding, options)
        options.inSampleSize = Util.calculateInSampleSize(options, reqWidth, reqHeight)
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
            options.inMutable = true
            val inBitmap: Bitmap = GlideBitmapPool.Companion.getBitmap(
                options.outWidth,
                options.outHeight,
                options.inPreferredConfig
            )
            if (inBitmap != null && Util.canUseForInBitmap(inBitmap, options)) {
                options.inBitmap = inBitmap
            }
        }
        options.inJustDecodeBounds = false
        return try {
            BitmapFactory.decodeStream(`is`, outPadding, options)
        } catch (e: Exception) {
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
                options.inBitmap = null
            }
            BitmapFactory.decodeStream(`is`, outPadding, options)
        }
    }

    fun decodeFileDescriptor(fd: FileDescriptor?): Bitmap {
        val options = Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeFileDescriptor(fd, null, options)
        options.inSampleSize = 1
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
            options.inMutable = true
            val inBitmap: Bitmap = GlideBitmapPool.Companion.getBitmap(
                options.outWidth,
                options.outHeight,
                options.inPreferredConfig
            )
            if (inBitmap != null && Util.canUseForInBitmap(inBitmap, options)) {
                options.inBitmap = inBitmap
            }
        }
        options.inJustDecodeBounds = false
        return try {
            BitmapFactory.decodeFileDescriptor(fd, null, options)
        } catch (e: Exception) {
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
                options.inBitmap = null
            }
            BitmapFactory.decodeFileDescriptor(fd, null, options)
        }
    }

    fun decodeFileDescriptor(fd: FileDescriptor?, reqWidth: Int, reqHeight: Int): Bitmap {
        val options = Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeFileDescriptor(fd, null, options)
        options.inSampleSize = Util.calculateInSampleSize(options, reqWidth, reqHeight)
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
            options.inMutable = true
            val inBitmap: Bitmap = GlideBitmapPool.Companion.getBitmap(
                options.outWidth,
                options.outHeight,
                options.inPreferredConfig
            )
            if (inBitmap != null && Util.canUseForInBitmap(inBitmap, options)) {
                options.inBitmap = inBitmap
            }
        }
        options.inJustDecodeBounds = false
        return try {
            BitmapFactory.decodeFileDescriptor(fd, null, options)
        } catch (e: Exception) {
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
                options.inBitmap = null
            }
            BitmapFactory.decodeFileDescriptor(fd, null, options)
        }
    }

    fun decodeFileDescriptor(fd: FileDescriptor?, outPadding: Rect?): Bitmap {
        val options = Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeFileDescriptor(fd, outPadding, options)
        options.inSampleSize = 1
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
            options.inMutable = true
            val inBitmap: Bitmap = GlideBitmapPool.Companion.getBitmap(
                options.outWidth,
                options.outHeight,
                options.inPreferredConfig
            )
            if (inBitmap != null && Util.canUseForInBitmap(inBitmap, options)) {
                options.inBitmap = inBitmap
            }
        }
        options.inJustDecodeBounds = false
        return try {
            BitmapFactory.decodeFileDescriptor(fd, outPadding, options)
        } catch (e: Exception) {
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
                options.inBitmap = null
            }
            BitmapFactory.decodeFileDescriptor(fd, outPadding, options)
        }
    }

    fun decodeFileDescriptor(
        fd: FileDescriptor?,
        outPadding: Rect?,
        reqWidth: Int,
        reqHeight: Int
    ): Bitmap {
        val options = Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeFileDescriptor(fd, outPadding, options)
        options.inSampleSize = Util.calculateInSampleSize(options, reqWidth, reqHeight)
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
            options.inMutable = true
            val inBitmap: Bitmap = GlideBitmapPool.Companion.getBitmap(
                options.outWidth,
                options.outHeight,
                options.inPreferredConfig
            )
            if (inBitmap != null && Util.canUseForInBitmap(inBitmap, options)) {
                options.inBitmap = inBitmap
            }
        }
        options.inJustDecodeBounds = false
        return try {
            BitmapFactory.decodeFileDescriptor(fd, outPadding, options)
        } catch (e: Exception) {
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
                options.inBitmap = null
            }
            BitmapFactory.decodeFileDescriptor(fd, outPadding, options)
        }
    }
}