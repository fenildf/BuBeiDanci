package com.tpddns.flannery.bubeidanci.adapter.type;

import android.view.View;

import com.tpddns.flannery.bubeidanci.R;
import com.tpddns.flannery.bubeidanci.adapter.holder.BaseViewHolder;
import com.tpddns.flannery.bubeidanci.adapter.holder.ThreeViewHolder;


/**
 * Created by flannery on 17-4-28.
 */

public class ThreeType implements TypeInterface {
    private String text;

    public ThreeType(String text) {
        this.text = text;
    }

    public String getContent() {
        return text;
    }

    @Override
    public int getLayout() {
        return R.layout.multiple_item_three;
    }

    @Override
    public BaseViewHolder createViewHolder(View itemView) {
        return new ThreeViewHolder(itemView);
    }
}
