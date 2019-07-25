package com.example.medicalapp.Doctors;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import com.example.medicalapp.API.DoctorsModel.DataItem;
import com.example.medicalapp.R;

public class DoctorsAdapter extends RecyclerView.Adapter<DoctorsAdapter.ViewHolder> {


    Fragment f;
    public DoctorsAdapter(List<DataItem> doctors,Fragment f) {
        this.doctors = doctors;
        this.f=f;
    }

    List<DataItem> doctors = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.doctor_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final DataItem doctor = doctors.get(position);
        if (doctor.getProfile().getFirstName() + doctor.getProfile().getLastName() != null)
            holder.name.setText(doctor.getProfile().getFirstName() + doctor.getProfile().getLastName());
        else holder.name.setText("Clara mohmed");
//        if(doctor.getSpecialties().get(0).getCategory()!=null&&doctor.getSpecialties().get(0).getName()!=null)
//        holder.cat.setText(doctor.getSpecialties().get(0).getCategory()+" , "+doctor.getSpecialties().get(0).getName());
        //holder.cat.setText("Medical, dcotor family");
        if (!doctor.getPractices().isEmpty())
            holder.country.setText(doctor.getPractices().get(0).getVisitAddress().getStateLong());
        else holder.country.setText("California");
        if (!doctor.getSpecialties().isEmpty())
            holder.actor.setText(doctor.getSpecialties().get(0).getActor());
        else holder.actor.setText("Family Practitioner");
        holder.details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                f.getFragmentManager().beginTransaction().replace(R.id.frame_container,new doctor_details(doctor)).commit();
            }
        });


    }

    @Override
    public int getItemCount() {
        return doctors.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, cat, country, actor;
        Button details;
        ImageView icon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.drname_view);
            cat = itemView.findViewById(R.id.dr_cat);
            country = itemView.findViewById(R.id.dr_state_long);
            actor = itemView.findViewById(R.id.dr_actor);
            details = itemView.findViewById(R.id.dr_details_btn);
            icon = itemView.findViewById(R.id.dr_image);


        }
    }
}
