package com.arrow.next.ui.glidepool

import android.graphics.Bitmap
import android.net.Uri


fun Uri.GlideBitmapDecode(): Bitmap {
    return GlideBitmapFactory.decodeFile(this.path)
}

fun String.GlideBitmapDecode(): Bitmap {
    return GlideBitmapFactory.decodeFile(this)
}


fun Uri.GlideBitmapDecode(width: Int, height: Int): Bitmap {
    return if (width == 0 || height == 0) {
        GlideBitmapFactory.decodeFile(this.path, 200, 200)
    } else {
        GlideBitmapFactory.decodeFile(this.path, width, height)
    }

}

fun String.GlideBitmapDecode(width: Int, height: Int): Bitmap {
    return if (width == 0 || height == 0) {
        GlideBitmapFactory.decodeFile(this, 200, 200)
    } else {
        GlideBitmapFactory.decodeFile(this, width, height)
    }
}



