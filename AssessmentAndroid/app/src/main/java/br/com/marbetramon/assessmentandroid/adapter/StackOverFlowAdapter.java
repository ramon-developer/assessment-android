package br.com.marbetramon.assessmentandroid.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import br.com.marbetramon.assessmentandroid.R;
import br.com.marbetramon.assessmentandroid.model.Tag;

public class StackOverFlowAdapter extends RecyclerView.Adapter<StackOverFlowAdapter.TagsViewHolder>{

    private ArrayList<Tag> list;

    public StackOverFlowAdapter(ArrayList<Tag> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public TagsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_view, parent, false);
        return new TagsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TagsViewHolder holder, int position) {
        holder.tvTitle.setText(list.get( position ).getTitle());
        holder.tvLink.setText(list.get( position ).getLink());
        holder.tvTags.setText(list.get( position ).getTag());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class TagsViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        TextView tvLink;
        TextView tvTags;
        TextView tvIsAnswered;

        TagsViewHolder(View v){
            super(v);
            tvIsAnswered = (TextView) v.findViewById( R.id.tv_answered );
            tvTitle = (TextView) v.findViewById( R.id.tv_title );
            tvLink = (TextView) v.findViewById( R.id.tv_link );
            tvTags = (TextView) v.findViewById( R.id.tv_tags );
        }
    }
}
