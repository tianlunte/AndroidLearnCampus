package com.wangqingyun.learncampus.learnrxjava

import android.util.Log
import io.reactivex.Observable

/**
 * Created by wangqingyun on 24/01/2018.
 */

fun tryErrorCondition() {
    Observable.just(3, 2, 1, 0, 4, 5)
            .map { 100 / it }
            .subscribe({
                Log.d("WQY", "received : $it")
            }, {
                Log.d("WQY", "error : ${it.message}")
            })
}

fun tryCatchTheError() {
    Observable.just(5, 4, 0, 101, 99)
            .map {
                try {
                    return@map 1000 / it
                } catch (e : Throwable) {
                    return@map -1000
                }
            }
            .subscribe({
                Log.d("WQY", "catch received : $it")
            }, {
                Log.d("WQY", "error received : ${it.message}")
            })
}

fun tryOnErrorReturnItem() {
    Observable.just(3, 0, 1)
            .map { 10 / it }
            .onErrorReturnItem(-22)
            .subscribe {
                Log.d("WQY", "on-error-return-item received : $it")
            }
}

fun tryOnErrorReturn() {
    Observable.just(3, 2, 1, 0, 5, 4)
            .map { 10 / it }
            .onErrorReturn {
                it.hashCode()
            }
            .subscribe {
                Log.d("WQY", "on-error-return : $it")
            }
}

fun tryErrorRecoverOperators() {
    tryErrorCondition()
    tryCatchTheError()

    tryOnErrorReturnItem()
    tryOnErrorReturn()
}