package com.tpddns.flannery.bubeidanci.adapter.type;

import android.view.View;

import com.tpddns.flannery.bubeidanci.adapter.holder.BaseViewHolder;

/**
 * Created by flannery on 17-4-28.
 */

public interface TypeInterface {
    int getLayout();

    BaseViewHolder createViewHolder(View itemView);
}
