package com.example.vardan.musicplayer;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.List;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MusicViewHolder> {
    private ImageView image;
    private Context context;
    private List<Model> list;

    public MusicAdapter(Context context, List<Model> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MusicAdapter.MusicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        final View view = inflater.inflate(R.layout.item_list,parent,false);
        return new MusicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MusicAdapter.MusicViewHolder holder, final int position) {
        Model model = list.get(position);
        holder.name.setText(model.getName());
        holder.image.setImageResource(model.getImage());
        holder.button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (holder.button.isChecked()){
                    Intent intent = new Intent(context,MyService.class);
                    intent.putExtra("key",position);
                    context.startService(intent);
                }else {
                    Intent intent = new Intent(context,MyService.class);
                    context.startService(intent);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MusicViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private ToggleButton button;
        private ImageView image;

        public MusicViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.music_name);
            button = itemView.findViewById(R.id.play_music);
            image = itemView.findViewById(R.id.image_id);

//            button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//
//                    if (!list.get(getAdapterPosition()).isPause()) {
//                        button.setImageResource(R.drawable.ic_play_arrow_24dp);
//                        MusicProvider.list.get(getAdapterPosition()).setPause(true);
//
//                    } else {
//                        button.setImageResource(R.drawable.ic_pause_24dp);
//                        MusicProvider.list.get(getAdapterPosition()).setPause(false);
//                    }
//                }
//            });
        }
    }

}
