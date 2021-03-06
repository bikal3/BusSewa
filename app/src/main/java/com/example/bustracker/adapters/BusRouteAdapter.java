package com.example.bustracker.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bustracker.R;
import com.example.bustracker.detialui.BusRouteDetial;
import com.example.bustracker.detialui.NewsDetials;
import com.example.bustracker.models.BusRouteModel;
import com.example.bustracker.models.JobVacancyModel;

import java.util.List;

public class BusRouteAdapter extends RecyclerView.Adapter<BusRouteAdapter.ViewHolder> {
    private Context context;
    private List<BusRouteModel> busRouteModelList;

    public BusRouteAdapter(Context context, List<BusRouteModel> busRouteModelList) {
        this.context = context;
        this.busRouteModelList = busRouteModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View busrouteView = LayoutInflater.from(context).inflate(R.layout.recyclerview_bus_route, parent, false);
        return new ViewHolder(busrouteView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BusRouteModel busRouteModel = busRouteModelList.get(position);
        holder.bindHolder(busRouteModel);

    }

    @Override
    public int getItemCount() {
        return busRouteModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView routeNumber, routeStartEnd, busNumber;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            routeNumber = itemView.findViewById(R.id.txt_route_bus);
            routeStartEnd = itemView.findViewById(R.id.txt_startend_bus);
            busNumber = itemView.findViewById(R.id.txt_busno_bus);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent busrouteDetial=new Intent(context, BusRouteDetial.class);
                    busrouteDetial.putExtra("id",busRouteModelList.get(getAdapterPosition()).getId());
                    context.startActivity(busrouteDetial);
                }
            });
        }

        public void bindHolder(BusRouteModel busRouteModel) {
            routeNumber.setText(busRouteModel.getRoute());
            routeStartEnd.setText(busRouteModel.getStart_location() + "-" + busRouteModel.getEnd_location());
//            busNumber.setText(busRouteModel.get);

        }
    }
}
