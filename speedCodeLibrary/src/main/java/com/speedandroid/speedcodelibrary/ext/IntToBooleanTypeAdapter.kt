package com.speedandroid.speedcodelibrary.ext

import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter

/**
 * Int 转 boolean 的Gson JsonAdapter
 * Int 1 为 true, 0 为 false
 *
 * 使用方法
 *
 *     @JsonAdapter(IntToBooleanTypeAdapter::class)
 *     val isFree:Boolean,
 * */
class IntToBooleanTypeAdapter : TypeAdapter<Boolean>() {
    companion object {
        private const val INT_TRUE = 1
        private const val INT_FALSE = 0
    }

    override fun write(out: JsonWriter, value: Boolean?) {
        if (value == null) {
            out.nullValue()
        } else {
            val intValue = if (value) INT_TRUE else INT_FALSE
            out.value(intValue)
        }
    }

    override fun read(reader: JsonReader): Boolean {
        val intValue = reader.nextInt()
        return intValue == INT_TRUE
    }
}