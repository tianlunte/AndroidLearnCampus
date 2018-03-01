package com.wangqingyun.recyclerviewanalysis.view_info;

import android.support.v4.util.Pools;

/**
 * Created by qingyun.wang on 28/02/2018.
 */

/**
 * contains information about pre and post
 * */
public class InfoRecord {
    static final int FLAG_DISAPPEARED = 1;
    // appear in pre layout list
    static final int FLAG_APPEAR = 1 << 1;
    // pre layout, this is necessary to distinguish null item info
    static final int FLAG_PRE = 1 << 2;
    // post layout, this is necessary to distinguish null item info
    static final int FLAG_POST = 1 << 3;
    static final int FLAG_APPEAR_AND_DISAPPEAR = FLAG_APPEAR | FLAG_DISAPPEARED;
    static final int FLAG_PRE_AND_POST = FLAG_PRE | FLAG_POST;
    static final int FLAG_APPEAR_PRE_AND_POST = FLAG_APPEAR | FLAG_PRE | FLAG_POST;

    int flags;
    ItemHolderInfo preInfo;
    ItemHolderInfo postInfo;

    static Pools.Pool<InfoRecord> sPool = new Pools.SimplePool<>(20);

    static InfoRecord obtain() {
        InfoRecord record = sPool.acquire();
        return record == null ? new InfoRecord() : record;
    }

    static void recycle(InfoRecord record) {
        record.flags = 0;
        record.preInfo = null;
        record.postInfo = null;
        sPool.release(record);
    }

    static void drainCache() {
        //noinspection StatementWithEmptyBody
        while (sPool.acquire() != null);
    }
}