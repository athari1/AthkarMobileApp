package com.ites.makkahleave.athkar;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 4/15/16.
 */
public class CardAdapterThekr extends RecyclerView.Adapter<CardAdapterThekr.ViewHolder> {
    private List<THekr> mModels;


    public CardAdapterThekr(List<THekr> models) {
        mModels = new ArrayList<>(models);
    }


    public void clear() {
        mModels.clear();
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_view1, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        viewHolder.login.setText( mModels.get(position).getId());
        viewHolder.tag.setText(mModels.get(position).getTitle()); //mItems[i].getTitle()
        viewHolder.im.setImageResource(mModels.get(position).getImageUrl()); //mItems[i].getImageUrl()

    }

    @Override
    public int getItemCount() {
        return mModels.size();
    }

    public void animateTo(List<THekr> models) {
        applyAndAnimateRemovals(models);
        applyAndAnimateAdditions(models);
        applyAndAnimateMovedItems(models);
    }

    private void applyAndAnimateRemovals(List<THekr> newModels) {
        for (int i = mModels.size() - 1; i >= 0; i--) {
            final THekr model = mModels.get(i);
            if (!newModels.contains(model)) {
                removeItem(i);
            }
        }
    }

    private void applyAndAnimateAdditions(List<THekr> newModels) {
        for (int i = 0, count = newModels.size(); i < count; i++) {
            final THekr model = newModels.get(i);
            if (!mModels.contains(model)) {
                addItem(i, model);
            }
        }
    }

    private void applyAndAnimateMovedItems(List<THekr> newModels) {
        for (int toPosition = newModels.size() - 1; toPosition >= 0; toPosition--) {
            final THekr model = newModels.get(toPosition);
            final int fromPosition = mModels.indexOf(model);
            if (fromPosition >= 0 && fromPosition != toPosition) {
                moveItem(fromPosition, toPosition);
            }
        }
    }

    public THekr removeItem(int position) {
        final THekr model = mModels.remove(position);
        notifyItemRemoved(position);
        return model;
    }

    public void addItem(int position, THekr model) {
        mModels.add(position, model);
        notifyItemInserted(position);
    }

    public void moveItem(int fromPosition, int toPosition) {
        final THekr model = mModels.remove(fromPosition);
        mModels.add(toPosition, model);
        notifyItemMoved(fromPosition, toPosition);
    }

    // inner class to hold a reference to each item of RecyclerView
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView login;
        public TextView tag;
        public ImageView im;

        public ViewHolder(View itemView) {
            super(itemView);
            login = (TextView) itemView.findViewById(R.id.login);
            tag = (TextView) itemView.findViewById(R.id.tag);
            im = (ImageView) itemView.findViewById(R.id.imdtag);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), Thekr_detailsActivity.class);
                    intent.putExtra("EXTRA_emp_name", login.getText().toString());
                    intent.putExtra("EXTRA_emp_position", tag.getText().toString());
                    v.getContext().startActivity(intent);

                    Toast.makeText(v.getContext(), "Your toast message.",
                            Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}


