package com.example.android.recycleview;

import java.util.Collections;
import java.util.List;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.android.R;
import com.example.android.databinding.ForecastRowLayoutBinding;

import static com.brightcove.player.captioning.TTMLParser.Tags.BR;


public class ForecastItemAdaptor extends RecyclerView.Adapter<ForecastItemAdaptor.ForecastViewHolder> {

    private List<Forecast> data;

    ForecastItemAdaptor() {
        this.data = Collections.emptyList();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    static class ForecastViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        private final ForecastRowLayoutBinding binding;

        public ForecastViewHolder(ForecastRowLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Forecast forecast) {
            binding.setForecast(forecast);
            binding.executePendingBindings();
        }
    }

    @Override
    public ForecastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        ForecastRowLayoutBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.forecast_row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        return new ForecastViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ForecastViewHolder holder, int position) {
        final Forecast forecast = data.get(position);
        holder.bind(forecast);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<Forecast> data) {
        if(data == null)
            this.data = Collections.emptyList();
        this.data = data;
        notifyDataSetChanged();
    }
}
