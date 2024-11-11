package com.example.iot;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class DataCuacaAdapter extends RecyclerView.Adapter<DataCuacaAdapter.ViewHolder> {
    private List<DataCuaca> dataCuacaList;

    public DataCuacaAdapter(List<DataCuaca> dataCuacaList) {
        this.dataCuacaList = dataCuacaList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data_cuaca, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DataCuaca dataCuaca = dataCuacaList.get(position);
        holder.tvSuhu.setText("Suhu: " + dataCuaca.getSuhu());
        holder.tvHumid.setText("Humid: " + dataCuaca.getHumid());
        holder.tvLux.setText("Lux: " + dataCuaca.getLux());
        holder.tvTs.setText("Timestamp: " + dataCuaca.getTs());
    }

    @Override
    public int getItemCount() {
        return dataCuacaList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvSuhu, tvHumid, tvLux, tvTs;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSuhu = itemView.findViewById(R.id.tvSuhu);
            tvHumid = itemView.findViewById(R.id.tvHumid);
            tvLux = itemView.findViewById(R.id.tvLux);
            tvTs = itemView.findViewById(R.id.tvTs);
        }
    }
}
