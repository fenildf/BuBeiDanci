package com.tpddns.flannery.bubeidanci.adapter.holder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.tpddns.flannery.bubeidanci.R;
import com.tpddns.flannery.bubeidanci.adapter.type.ThreeType;


/**
 * Created by flannery on 17-4-28.
 */

public class ThreeViewHolder extends BaseViewHolder<ThreeType> {
    private TextView three;

    public ThreeViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void findView() {
        three = (TextView) getViewById(R.id.three);
    }

    @Override
    public void setViewData(ThreeType model, Context context) {
        three.setText(model.getContent());
    }
}
