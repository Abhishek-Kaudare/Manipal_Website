package com.example.findmyhospital;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.findmyhospital.Model.BloodBank;
import com.example.findmyhospital.Model.Pharmacy;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment_Blood extends Fragment  {

    ViewGroup root;
    String url,baseURL;
    List<BloodBank> hosp;
    RequestQueue requestQueue;
    ListView listView;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        root = (ViewGroup)inflater.inflate(R.layout.activity_list_of_blood_banks,null);
        baseURL = getString(R.string.base_url);
        requestQueue = Volley.newRequestQueue(getContext());
        hosp = new ArrayList<>();
        listView = (ListView)root.findViewById(R.id.listViewOfBloodBanks);
        getBloodBankData();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                BloodBank hos = hosp.get(i);
                Intent intent = new Intent(getActivity(),Personal_Info_BloodBank.class);
                intent.putExtra("bloodbank_id", hos.getBloodbank_id());
                startActivity(intent);
            }
        });



        return root;
    }

    private void getBloodBankData() {
        url = baseURL + "api/allbloodbank";
        try{
            MyJsonArrayRequest request=new MyJsonArrayRequest(Request.Method.POST, url, null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    for(int i = 0; i < response.length(); i++)
                        try{
                            JSONObject res = response.getJSONObject(i);
                            Log.e("Volley",res.toString());
                            String name,city,state,pincode,userId;
                            name = res.getString("bloodbank_name");
                            city = res.getString("city");
                            state = res.getString("state");
                            pincode = res.getString("pincode");
                            userId = res.getString("bloodbank_id");
                            BloodBank hos = new BloodBank(name,city,state,pincode,userId);
                            hosp.add(hos);

                        }catch (Exception e){
                            Log.e("Volley",e.toString());
                        }
                    try{
                        BBCustomAdapter bbCustomAdapter = new BBCustomAdapter();
                        listView.setAdapter(bbCustomAdapter);
                    }catch (Exception e){
                        Log.e("Volley",e.toString());
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                    Log.i("onErrorResponse", "Error");
                }
            });
            request.setRetryPolicy(new DefaultRetryPolicy(500000,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            requestQueue.add(request);
        }catch (Exception e){
            Log.e("Volley",e.toString());
        }
    }

    class  BBCustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return hosp.size();
        }

        @Override
        public Object getItem(int i) {


            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.custom_list_of_blood_banks,null);

            BloodBank hos = hosp.get(i);
            ImageView imagebbView = (ImageView)view.findViewById(R.id.imageBloodBankView);
            TextView bb_name = (TextView)view.findViewById(R.id.bloodbank_name);
            TextView bb_description = (TextView)view.findViewById(R.id.bloodbank_description);
            TextView bb_address = (TextView)view.findViewById(R.id.bloodbank_address);
            TextView bb_distances = (TextView)view.findViewById(R.id.distance_of_bloodbank);
            TextView pincode = view.findViewById(R.id.pincode);
            TextView state = view.findViewById(R.id.state);


            imagebbView.setImageResource(R.drawable.medicine);
            bb_name.setText(hos.getBloodbank_name());
            bb_description.setText(hos.getCity());
            bb_address.setText(hos.getCity());
            state.setText(hos.getState());
            pincode.setText(hos.getPincode());

            return view;
        }

    }

}
