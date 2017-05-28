package com.tpddns.flannery.bubeidanci.adapter.holder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.tpddns.flannery.bubeidanci.R;
import com.tpddns.flannery.bubeidanci.adapter.type.TwoType;


/**
 * Created by flannery on 17-4-28.
 */

public class TwoViewHolder extends BaseViewHolder<TwoType> {

    private TextView two;

    public TwoViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void findView() {
        two = (TextView) getViewById(R.id.two);
    }

    @Override
    public void setViewData(TwoType model, Context context) {
        two.setText(model.getContent());
    }
}
