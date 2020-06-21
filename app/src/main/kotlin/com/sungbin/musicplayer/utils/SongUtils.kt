package com.sungbin.musicplayer.utils

import android.content.ContentUris
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.ParcelFileDescriptor
import android.provider.MediaStore
import com.sungbin.musicplayer.dto.SongItem
import java.io.FileNotFoundException
import java.io.IOException

object SongUtils {
    fun getAllAudioData(context: Context): ArrayList<SongItem> {
        val list = ArrayList<SongItem>()
        val contentResolver = context.contentResolver
        val uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
        val selection = "${MediaStore.Audio.Media.IS_MUSIC} != 0"
        val sortOrder = "${MediaStore.Audio.Media.TITLE} ASC"
        val cursor = contentResolver.query(uri, null, selection, null, sortOrder)
        cursor!!.moveToFirst()
        if (cursor.count > 0) {
            while (cursor.moveToNext()) {
                val trackId =
                    cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media._ID))
                val albumId =
                    cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID))
                val title =
                    cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE))
                val album =
                    cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM))
                val artist =
                    cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST))
                /*val duration =
                    cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION)) //이게 api 29 부터 추가됬네;;*/
                /*val path =
                    cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA)) //DEPRECATED 됬네?*/
                list.add(SongItem(title, artist, null, trackId, albumId))
            }
        }
        cursor.close()
        return list
    }

    fun getAlbumCoverBitmap(
        context: Context,
        albumId: Long,
        weight: Int,
        height: Int
    ): Bitmap? {
        val bitmapOptionsCache = BitmapFactory.Options()
        val artworkUri =
            Uri.parse("content://media/external/audio/albumart")
        val res = context.contentResolver
        val uri = ContentUris.withAppendedId(artworkUri, albumId)
        var fd: ParcelFileDescriptor? = null
        try {
            fd = res.openFileDescriptor(uri, "r")
            var sampleSize = 1
            bitmapOptionsCache.inJustDecodeBounds = true
            BitmapFactory.decodeFileDescriptor(
                fd!!.fileDescriptor, null, bitmapOptionsCache
            )
            var nextWidth = bitmapOptionsCache.outWidth shr 1
            var nextHeight = bitmapOptionsCache.outHeight shr 1
            while (nextWidth > weight && nextHeight > height) {
                sampleSize = sampleSize shl 1
                nextWidth = nextWidth shr 1
                nextHeight = nextHeight shr 1
            }
            bitmapOptionsCache.inSampleSize = sampleSize
            bitmapOptionsCache.inJustDecodeBounds = false
            var bitmap = BitmapFactory.decodeFileDescriptor(
                fd.fileDescriptor, null, bitmapOptionsCache
            )
            if (bitmap != null) {
                if (bitmapOptionsCache.outWidth != weight || bitmapOptionsCache.outHeight != height) {
                    val tmp = Bitmap.createScaledBitmap(bitmap, weight, height, true)
                    bitmap.recycle()
                    bitmap = tmp
                }
            }
            return bitmap
        } catch (ignored: FileNotFoundException) {
        } finally {
            try {
                fd?.close()
            } catch (ignored: IOException) {
            }
        }
        return null
    }
}