package com.alan.framework.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * @author Alan
 * 时 间：2020-03-13
 * 简 述：常用 Adapter
 */
public class BaseRecycleAdapter<T> extends RecyclerView.Adapter {

    protected List<T> list;
    protected Context context;

    public BaseRecycleAdapter(Context context, List<T> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return null == list ? 0 : list.size();
    }

    public static class CommonViewHolder extends RecyclerView.ViewHolder {
        public CommonViewHolder(View itemView) {
            super(itemView);
        }
    }

    public List<T> getList() {
        return list;
    }

    public Context getContext() {
        return context;
    }
}
