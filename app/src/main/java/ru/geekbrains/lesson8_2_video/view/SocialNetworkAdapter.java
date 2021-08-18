package ru.geekbrains.lesson8_2_video.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.geekbrains.lesson8_2_video.R;
import ru.geekbrains.lesson8_2_video.model.CardSource;

public class SocialNetworkAdapter extends RecyclerView.Adapter<SocialNetworkAdapter.MyViewHolder> {

    private CardSource dataSource;
    private MyOnClickListener listener;

    public SocialNetworkAdapter(CardSource dataSource) {
        this.dataSource = dataSource;
    }

    public void setMyOnClickListener(MyOnClickListener listener) {
        this.listener = listener;
    }

    public void setData(CardSource dataSource) {
        this.dataSource = dataSource;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title.setText(dataSource.getCardData(position).getTitle());
        holder.description.setText(dataSource.getCardData(position).getDescription());
        holder.imageView.setImageResource(dataSource.getCardData(position).getPicture());
        holder.like.setChecked(dataSource.getCardData(position).isLike());
    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView description;
        private ImageView imageView;
        private ToggleButton like;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.title = itemView.findViewById(R.id.title);
            this.description = itemView.findViewById(R.id.description);
            this.imageView = itemView.findViewById(R.id.imageView);
            this.like = itemView.findViewById(R.id.like);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onMyClick(view, getAdapterPosition());
                }
            });
        }

        public ImageView getImageView() {
            return imageView;
        }

        public void setImageView(ImageView imageView) {
            this.imageView = imageView;
        }


        public TextView getTitle() {
            return title;
        }

        public void setTitle(TextView title) {
            this.title = title;
        }

        public TextView getDescription() {
            return description;
        }

        public void setDescription(TextView description) {
            this.description = description;
        }

        public ToggleButton getLike() {
            return like;
        }

        public void setLike(ToggleButton like) {
            this.like = like;
        }

    }
}
