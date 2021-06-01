package com.example.thith_lan2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    List<User> mUsers;
    onClickListener listener;

    public CustomAdapter(List<User> users,onClickListener listener1) {
        mUsers = users;
        listener = listener1;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  CustomAdapter.ViewHolder holder, int position) {
        User user = mUsers.get(position);
        holder.muser = user;
        holder.tvFirstName.setText(user.getFirstname());
        holder.tvLastName.setText(user.getLastname());
        holder.tvGioiTinh.setText(user.getGioitinh());
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    public void setList(List<User> users) {
        mUsers = users;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvFirstName, tvLastName, tvGioiTinh;
        User muser;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvFirstName = itemView.findViewById(R.id.tvFirstName);
            tvLastName = itemView.findViewById(R.id.tvLastName);
            tvGioiTinh = itemView.findViewById(R.id.tvGioiTinh);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.ClickItem(muser);
                }
            });

        }

    }
}
