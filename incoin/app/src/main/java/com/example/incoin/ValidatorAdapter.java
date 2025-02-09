package com.example.incoin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.shimmer.ShimmerFrameLayout;
import java.util.List;

public class ValidatorAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int VIEW_TYPE_SKELETON = 0;
    private static final int VIEW_TYPE_ITEM = 1;

    private List<Validator> validatorList;
    private boolean isLoading = true;

    public ValidatorAdapter(List<Validator> validatorList) {
        this.validatorList = validatorList;
    }

    @Override
    public int getItemViewType(int position) {
        return isLoading ? VIEW_TYPE_SKELETON : VIEW_TYPE_ITEM;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        if (viewType == VIEW_TYPE_SKELETON) {
            View view = inflater.inflate(R.layout.item_skeleton, parent, false);
            return new SkeletonViewHolder(view);
        } else {
            View view = inflater.inflate(R.layout.item_validator, parent, false);
            return new ValidatorViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (!isLoading && holder instanceof ValidatorViewHolder) {
            Validator validator = validatorList.get(position);
            ((ValidatorViewHolder) holder).validatorName.setText(validator.getName());
            ((ValidatorViewHolder) holder).validatorPublicKey.setText(validator.getPublicKey());
        }
    }

    @Override
    public int getItemCount() {
        return isLoading ? 5 : (validatorList != null ? validatorList.size() : 0);
    }

    public void setData(List<Validator> newList) {
        this.validatorList = newList;
        isLoading = false;
        notifyDataSetChanged();
    }

    static class SkeletonViewHolder extends RecyclerView.ViewHolder {
        SkeletonViewHolder(View itemView) {
            super(itemView);
        }
    }

    static class ValidatorViewHolder extends RecyclerView.ViewHolder {
        TextView validatorName, validatorPublicKey;

        ValidatorViewHolder(View itemView) {
            super(itemView);
            validatorName = itemView.findViewById(R.id.validatorName);
            validatorPublicKey = itemView.findViewById(R.id.validatorPublicKey);
        }
    }
}
