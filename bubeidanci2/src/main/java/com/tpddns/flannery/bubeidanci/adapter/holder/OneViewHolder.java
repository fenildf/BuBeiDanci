package com.tpddns.flannery.bubeidanci.adapter.holder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.tpddns.flannery.bubeidanci.R;
import com.tpddns.flannery.bubeidanci.adapter.type.OneType;


/**
 * Created by flannery on 17-4-28.
 */

public class OneViewHolder extends BaseViewHolder<OneType> {
    private TextView one;

    public OneViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void findView() {
        one = (TextView) getViewById(R.id.one);
    }

    @Override
    public void setViewData(OneType model, Context context) {
        one.setText(model.getContent());
    }
}
