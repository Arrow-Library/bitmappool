package com.arrow.next.ui.glidepool

import android.graphics.Bitmap
import android.net.Uri


fun Uri.GlideBitmapDecode(width: Int = 200, height: Int = 200): Bitmap {
    if (width != 200 && height != 200) {
        return GlideBitmapFactory.decodeFile(this.path, width, height)
    }
    return GlideBitmapFactory.decodeFile(this.path)
}

fun String.GlideBitmapDecode(width: Int = 200, height: Int = 200): Bitmap {
    if (width != 200 && height != 200) {
        return GlideBitmapFactory.decodeFile(this, width, height)
    }
    return GlideBitmapFactory.decodeFile(this)
}



