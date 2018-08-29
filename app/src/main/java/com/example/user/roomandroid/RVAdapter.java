package com.example.user.roomandroid;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.roomandroid.model.WallItem;

import java.util.List;

/**
 * Created by User on 27.08.2018.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ItemWallTextHolder> {

    public static final int TYPE_TEXT=1;
    public static final int TYPE_PHOTO=2;
    public static final int TYPE_PHOTO_TEXT=3;
    List<WallItem>items;

    public RVAdapter(List<WallItem> items) {
        this.items = items;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public RVAdapter.ItemWallTextHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_with_text, parent, false);
        ItemWallTextHolder pvh = new ItemWallTextHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(RVAdapter.ItemWallTextHolder holder, int position) {
        holder.textViewCountLikes.setText(String.valueOf(items.get(position).getCountLikes()));
        holder.textViewCountReposts.setText(String.valueOf(items.get(position).getCountReposts()));
        holder.textViewCountComments.setText(String.valueOf(items.get(position).getCountComments()));
        holder.imageViewComments.setImageResource(R.drawable.ic_action_comments);
        holder.imageViewReposts.setImageResource(R.drawable.ic_action_repost);
        holder.imageViewLikes.setImageResource(R.drawable.ic_action_grade);
        MainActivity.imageLoader.displayImage(items.get(position).getURLPhoto(),holder.imageViewPerson);
        holder.textViewName.setText(items.get(position).getName());
        holder.textViewSurname.setText(items.get(position).getSurname());
        holder.textViewContext.setText(items.get(position).getText());
        //Log.i("dadada", String.valueOf(items.get(position).getCountLikes()));

        //
        //holder.textViewCountComments.setText(items.get(position).getCountComments());
        //MainActivity.imageLoader.displayImage(items.get(position).getURLPhoto(),holder.imageView);
        //if(items.get(position).getURLContext()!="")
        //MainActivity.imageLoader.displayImage(items.get(position).getURLContext(),holder.imageViewUrlContext);
    }

    @Override
    public int getItemCount() {
        return  items.size();
    }

    public class ItemWallTextHolder extends RecyclerView.ViewHolder {
        public ImageView imageViewPerson;
        public TextView textViewCountLikes;
        public TextView textViewCountComments;
        public TextView textViewCountReposts;
        public ImageView imageViewLikes;
        public ImageView imageViewComments;
        public ImageView imageViewReposts;
        public TextView textViewName;
        public TextView textViewSurname;
        public TextView textViewContext;


        public ItemWallTextHolder(View itemView) {
            super(itemView);
            //imageView = itemView.findViewById(R.id.person_photo);
            //imageViewUrlContext=itemView.findViewById(R.id.imageViewUrlContext);
            imageViewPerson = itemView.findViewById(R.id.imageForPhotoUser);
            textViewCountComments = itemView.findViewById(R.id.textCountComments);
            textViewCountLikes = itemView.findViewById(R.id.textCountLikes);
            textViewCountReposts = itemView.findViewById(R.id.textCountReposts);
            imageViewLikes = itemView.findViewById(R.id.imageLikes);
            imageViewComments =itemView.findViewById(R.id.imageComments);
            imageViewReposts = itemView.findViewById(R.id.imageReposts);
            textViewName = itemView.findViewById(R.id.textForName);
            textViewSurname=itemView.findViewById(R.id.textForSurname);
            textViewContext=itemView.findViewById(R.id.textContext);
        }
    }

    private class PersonViewHolderPhoto extends RecyclerView.ViewHolder{

        public PersonViewHolderPhoto(View itemView) {
            super(itemView);
        }
    }
}
