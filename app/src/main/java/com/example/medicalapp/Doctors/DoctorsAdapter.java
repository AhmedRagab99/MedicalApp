package com.example.medicalapp.Doctors;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.Random;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.medicalapp.API.DoctorsModel.DataItem;
import com.example.medicalapp.API.DoctorsModel.LanguagesItem;
import com.example.medicalapp.API.DoctorsModel.PhonesItem;
import com.example.medicalapp.API.DoctorsModel.PracticesItem;
import com.example.medicalapp.API.DoctorsModel.SpecialtiesItem;
import com.example.medicalapp.API.DoctorsModel.VisitAddress;
import com.example.medicalapp.R;

public class DoctorsAdapter extends RecyclerView.Adapter<DoctorsAdapter.ViewHolder> {

    List<DataItem> doctors;
    static List<DataItem> sesrcDoctors;
    static int c=-1;
    List<String> temp;
    Fragment f;

    public DoctorsAdapter(List<DataItem> doctors, Fragment f) {
        c++;
        this.doctors = new ArrayList<>(doctors);
        if(c==0) {
            sesrcDoctors = new ArrayList<>();
            this.sesrcDoctors.addAll(this.doctors);
        }
        System.out.println(this.sesrcDoctors.size()+"/0 construc"+c);
        this.f = f;
        loadTemp();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.doctor_view, parent, false);
        return new ViewHolder(view);
    }

    public List<DataItem> getDoctors() {

        return doctors;
    }

    public void setDoctors(List<DataItem> doctors) {
        System.out.println(this.sesrcDoctors.size()+"/1");

        this.doctors=new ArrayList<>(doctors);
        System.out.println(this.sesrcDoctors.size()+"/2");

        notifyDataSetChanged();
        System.out.println(this.doctors.size()+"---");
    }




    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final DataItem doctor = doctors.get(position);

        check(doctor, holder);
        System.out.println(temp);
        holder.name.setText("Dr."+doctor.getProfile().getFirstName());
        holder.cat.setText(doctor.getSpecialties().get(0).getCategory() + " , " + doctor.getSpecialties().get(0).getName());
        holder.country.setText(doctor.getPractices().get(0).getVisitAddress().getCity());
        holder.actor.setText(doctor.getSpecialties().get(0).getActor());
        holder.rate.setText(doctor.getRatings().get(0).toString());

        holder.details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                f.getFragmentManager().beginTransaction().replace(R.id.frame_container, new doctor_details(doctor)).addToBackStack(null).commit();
            }
        });


    }

    private void loadTemp() {
        temp = new ArrayList<>();
        //cities 0
        temp.add("Seoul");
        temp.add("Tokyo");
        temp.add("Istanbul");
        temp.add("Singapore");
        temp.add("New York");
        temp.add("Dubai");
        temp.add("Paris");
        temp.add("London");
        temp.add("Bangkok");
        //countries 9
        temp.add("South Korea");
        temp.add("Japan");
        temp.add("Turkey");
        temp.add("Malaysia");
        temp.add("U.S.A.");
        temp.add("UAE");
        temp.add("France");
        temp.add("England");
        temp.add("Thailand");
        //phones 18
        temp.add("7146394018");
        temp.add("7556394113");
        temp.add("7146394329");
        temp.add("9816394075");
        temp.add("2146394002");
        //languages 23
        temp.add("English");
        temp.add("French");
        temp.add("Spanish");
        temp.add("Russian");
        temp.add("Arabic");
        //education 28
        temp.add("Harvard University");
        temp.add("University of Oxford");
        temp.add("University of Cambridge");
        temp.add("Stanford University");
        temp.add("University of California, Los Angeles (UCLA)");
        temp.add("UCL (University College London)");
        temp.add("Karolinska Institute");
        temp.add("Johns Hopkins University");
        temp.add("Massachusetts Institute of Technology (MIT)");
        //rating 37
        temp.add("118");
        temp.add("201");
        temp.add("80");
        temp.add("350");
        temp.add("461");
        temp.add("98");
        temp.add("854");
        temp.add("57");
        temp.add("2001");
        temp.add("3854");
        //lat 47
        temp.add("13.736717");
        temp.add("51.509865");
        temp.add("48.864716");
        temp.add("25.276987");
        temp.add("40.730610");

        temp.add("35.652832");
        temp.add("45.464211");
        temp.add("41.390205");
        temp.add("41.015137");
        temp.add("-8.409518");
        //long 47
        temp.add("100.523186");
        temp.add("-0.118092");
        temp.add("2.349014");
        temp.add("55.296249");
        temp.add("-73.935242");

        temp.add("139.839478");
        temp.add("9.191383");
        temp.add("2.154007");
        temp.add("28.979530");
        temp.add("115.188919");

    }

    void check(DataItem dataItem, ViewHolder holder) {

        int city = new Random().nextInt(8 - 0 + 1) + 0;
        int country = new Random().nextInt(17 - 9 + 1) + 9;
        int phone = new Random().nextInt(22 - 18 + 1) + 18;
        int language = new Random().nextInt(27 - 23 + 1) + 23;
        int education = new Random().nextInt(36 - 28 + 1) + 28;
        int rate = new Random().nextInt(46 - 37 + 1) + 37;
        int lat=new Random().nextInt(56 - 47 + 1) + 47;
        int lng=new Random().nextInt(66 - 57 + 1) + 57;

        //language
        List<LanguagesItem> languagesItem = new ArrayList<>();
        languagesItem.add(new LanguagesItem(temp.get(language)));

        List<PhonesItem> phonesItem = new ArrayList<>();
        phonesItem.add(new PhonesItem(temp.get(phone)));

        VisitAddress visitAddress = new VisitAddress(temp.get(country), temp.get(city));//,2.5,2.5);

        List<SpecialtiesItem> specialtiesItem = new ArrayList<>();
        specialtiesItem.add(new SpecialtiesItem("Family Practitioner", "Specializes in your and your family's total health.", "medical", "Family Medicine"));


        List<PracticesItem> practicesItem = new ArrayList<>();
        practicesItem.add(new PracticesItem(languagesItem, visitAddress, phonesItem,Double.valueOf(temp.get(lng)),Double.valueOf(temp.get(lat))));

        List<Object> educations = new ArrayList<>();
        List<Object> rates = new ArrayList<>();
        Object o;
        String s;
        s = temp.get(education);
        o = (Object)s;
        educations.add(o);
        s = temp.get(rate);
        o = (Object)s;
        rates.add(o);


        if (dataItem.getPractices().isEmpty()) {
            dataItem.setPractices(practicesItem);
        } else {
            if (dataItem.getPractices().get(0).getVisitAddress() == null)
                dataItem.getPractices().get(0).setVisitAddress(visitAddress);
            if (dataItem.getPractices().get(0).getLanguages() == null)
                dataItem.getPractices().get(0).setLanguages(languagesItem);
            if (dataItem.getPractices().get(0).getPhones() == null)
                dataItem.getPractices().get(0).setPhones(phonesItem);
            if (dataItem.getPractices().get(0).getLat() == 0)
                dataItem.getPractices().get(0).setLat(Double.valueOf(temp.get(lat)));
            if (dataItem.getPractices().get(0).getLon() == 0)
                dataItem.getPractices().get(0).setLon(Double.valueOf(temp.get(lng)));

        }
        if (dataItem.getSpecialties().isEmpty()) {
            dataItem.setSpecialties(specialtiesItem);
        } else {
            if (dataItem.getSpecialties().get(0).getCategory() == null)
                dataItem.getSpecialties().get(0).setCategory("medical");

            if (dataItem.getSpecialties().get(0).getActor() == null)
                dataItem.getSpecialties().get(0).setActor("Doactor");
            if (dataItem.getSpecialties().get(0).getDescription() == null)
                dataItem.getSpecialties().get(0).setDescription("very cliver");
            if (dataItem.getSpecialties().get(0).getName() == null)
                dataItem.getSpecialties().get(0).setName("Family Medicine");
        }

        if (dataItem.getEducations().isEmpty())
            dataItem.setEducations(educations);
        //if (dataItem.getRatings().isEmpty())
            dataItem.setRatings(rates);


    }

    @Override
    public int getItemCount() {
        return doctors.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, rate, cat, country, actor;
        Button details;
        ImageView icon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.dr_prof_slug);
            cat = itemView.findViewById(R.id.dr_special_cat_name);
            country = itemView.findViewById(R.id.dr_practic_visited_state_long);
            actor = itemView.findViewById(R.id.dr_special_actor);
            details = itemView.findViewById(R.id.dr_details_btn);
            icon = itemView.findViewById(R.id.dr_prof_image);
            rate = itemView.findViewById(R.id.dr_rate);


        }
    }
}
