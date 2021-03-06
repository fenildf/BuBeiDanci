package com.tpddns.flannery.bubeidanci.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tpddns.flannery.bubeidanci.adapter.holder.BaseViewHolder;
import com.tpddns.flannery.bubeidanci.adapter.type.TypeInterface;

import java.util.List;

/**
 * Created by flannery on 17-4-28.
 */

public class MyAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private List<TypeInterface> models;
    private Context context;
    private int currentPosition = -1;

    public MyAdapter(List<TypeInterface> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View itemView = LayoutInflater.from(context).inflate(viewType, parent, false);
        if (currentPosition != -1) {
            return models.get(currentPosition).createViewHolder(itemView);
        } else {
            return null;
        }
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.begin(models.get(position), context);
    }

    @Override
    public int getItemCount() {
        if (models == null || models.size() == 0) {
            return 0;
        } else {
            return models.size();
        }
    }

    @Override
    public int getItemViewType(int position) {
        currentPosition = position;
        return models.get(position).getLayout();
    }
}
