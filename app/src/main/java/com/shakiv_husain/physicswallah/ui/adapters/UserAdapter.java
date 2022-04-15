package com.shakiv_husain.physicswallah.ui.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.shakiv_husain.physicswallah.R;
import com.shakiv_husain.physicswallah.databinding.ItemUserBinding;
import com.shakiv_husain.physicswallah.data.models.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserAdapterViewHolder> {

    private final List<User> userList;

    public UserAdapter(List<User> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public UserAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemUserBinding userBinding = ItemUserBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false
        );
        return new UserAdapterViewHolder(userBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapterViewHolder holder, int position) {
        holder.setUserData(userList.get(position));
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    static class UserAdapterViewHolder extends RecyclerView.ViewHolder {

        private ItemUserBinding userBinding;

        public UserAdapterViewHolder(@NonNull ItemUserBinding userBinding) {
            super(userBinding.getRoot());
            this.userBinding = userBinding;
        }

        void setUserData(User user) {
            if (user.getName() != null) {
                userBinding.tvUserName.setText(user.getName());
            }
            if (user.getSubjects().get(0) != null) {
                userBinding.tvSubject.setText(user.getSubjects().get(0));
            }
            if (user.getQualification().get(0) != null) {
                userBinding.tvQualification.setText(user.getQualification().get(0));
            }

            if (user.getProfileImage() != null) {
                Glide.with(userBinding.getRoot().getContext())
                        .load(user.getProfileImage())
                        .placeholder(R.color.light_grey)
                        .fitCenter()
                        .into(userBinding.userImage);
            }

        }
    }
}
