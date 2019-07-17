package com.example.medicalapp.Diagnoses;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicalapp.API.DiagnosesModel.DiagnosesResponse;
import com.example.medicalapp.R;

import java.util.List;

public class DiagnosesAdapter  extends RecyclerView.Adapter<DiagnosesAdapter.ViewHolder> {


    List<DiagnosesResponse> diagnoses;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.diagnoses_item_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DiagnosesResponse item=diagnoses.get(position);
        holder.textView.setText(item.getIssue().getName());

    }
    public void changeData(List<DiagnosesResponse>diagnoses){
        this.diagnoses=diagnoses;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(diagnoses==null)
        return 0;
        else return diagnoses.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
           textView=itemView.findViewById(R.id.name);
        }
    }
}
