package com.speedandroid.speedcodelibrary.ext

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData

/**
 * 扩展MediatorLiveData
 * @作者: lishucong
 * @創建時間: 2024/5/9 10:58
 * @更新時間: 2024/5/9 10:58
 * @描述: 扩展MediatorLiveData
 */

class LiveDatas {

    companion object {
        /**
         * MediatorLiveData的便捷方法
         * */
        @JvmStatic
        fun <R, T1, T2> zip(lD1: LiveData<T1>, lD2: LiveData<T2>, block: (T1?, T2?) -> R): MediatorLiveData<R> {
            val mediatorLiveData = MediatorLiveData<R>()
            val valueUpdater = {
                val value1 = lD1.value
                val value2 = lD2.value
                mediatorLiveData.value = block(value1, value2)
            }
            mediatorLiveData.addSource(lD1) { valueUpdater() }
            mediatorLiveData.addSource(lD2) { valueUpdater() }
            return mediatorLiveData
        }

        /**
         * MediatorLiveData的便捷方法
         * */
        @JvmStatic
        fun <R, T1, T2, T3> zip(lD1: LiveData<T1>, lD2: LiveData<T2>, lD3: LiveData<T3>, block: (T1?, T2?, T3?) -> R): MediatorLiveData<R> {
            val mediatorLiveData = MediatorLiveData<R>()
            val valueUpdater = {
                val value1 = lD1.value
                val value2 = lD2.value
                val value3 = lD3.value
                mediatorLiveData.value = block(value1, value2, value3)
            }
            mediatorLiveData.addSource(lD1) { valueUpdater() }
            mediatorLiveData.addSource(lD2) { valueUpdater() }
            mediatorLiveData.addSource(lD3) { valueUpdater() }
            return mediatorLiveData
        }
        /**
         * MediatorLiveData的便捷方法
         * */
        @JvmStatic
        fun <R, T1, T2, T3,T4> zip(lD1: LiveData<T1>, lD2: LiveData<T2>, lD3: LiveData<T3>, lD4: LiveData<T4>, block: (T1?, T2?, T3?,T4?) -> R): MediatorLiveData<R> {
            val mediatorLiveData = MediatorLiveData<R>()
            val valueUpdater = {
                val value1 = lD1.value
                val value2 = lD2.value
                val value3 = lD3.value
                val value4 = lD4.value
                mediatorLiveData.value = block(value1, value2, value3,value4)
            }
            mediatorLiveData.addSource(lD1) { valueUpdater() }
            mediatorLiveData.addSource(lD2) { valueUpdater() }
            mediatorLiveData.addSource(lD3) { valueUpdater() }
            mediatorLiveData.addSource(lD4) { valueUpdater() }
            return mediatorLiveData
        }
    }


}

