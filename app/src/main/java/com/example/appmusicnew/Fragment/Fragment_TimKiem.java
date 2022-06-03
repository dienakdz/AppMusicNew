package com.example.appmusicnew.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.appmusicnew.Adapter.TimkiembaihatAdapter;
import com.example.appmusicnew.Model.Baihat;
import com.example.appmusicnew.R;
import com.example.appmusicnew.Service.APIService;
import com.example.appmusicnew.Service.Dataservice;
import com.example.appmusicnew.Service.PreferenceHelper;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_TimKiem extends Fragment {
    View viewtk;
    Toolbar toolbar;
    RecyclerView recyclerViewtimkiembaihat;
    TextView txtkhongcodulieu;
    TimkiembaihatAdapter timkiembaihatAdapter;
    private PreferenceHelper preferenceHelper;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewtk = inflater.inflate(R.layout.fragment_timkiem,container,false);
        preferenceHelper = new PreferenceHelper(viewtk.getContext());
        if (preferenceHelper.getIsLogin()){



        }else {
            toolbar = viewtk.findViewById(R.id.toolbartimkiembaihat);
            recyclerViewtimkiembaihat = viewtk.findViewById(R.id.recyclerviewtimkiembaihat);
            txtkhongcodulieu = viewtk.findViewById(R.id.textviewkhongcodulieu);
            ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
            toolbar.setTitle("");
            setHasOptionsMenu(true);

        }

        return viewtk;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.timkiem_view, menu);
        MenuItem menuItem = menu.findItem(R.id.menu_timkiem);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.d("QQQ", query);
                Timkiemtukhoabaihat(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }
    private  void Timkiemtukhoabaihat(String query){
        Dataservice dataservice = APIService.getService();
        Call<List<Baihat>> callback = dataservice.GetTimkiembaihat(query);
        callback.enqueue(new Callback<List<Baihat>>() {
            @Override
            public void onResponse(Call<List<Baihat>> call, Response<List<Baihat>> response) {
                ArrayList<Baihat> mangbaihat =  (ArrayList<Baihat>) response.body();
                System.out.println("mangbaihatne: "+mangbaihat.size());
                if (mangbaihat.size()>0){
                    timkiembaihatAdapter = new TimkiembaihatAdapter(getActivity(), mangbaihat);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                    recyclerViewtimkiembaihat.setLayoutManager(linearLayoutManager);
                    recyclerViewtimkiembaihat.setAdapter(timkiembaihatAdapter);
                    txtkhongcodulieu.setVisibility(View.GONE);
                    recyclerViewtimkiembaihat.setVisibility(View.VISIBLE);
                }else {
                    recyclerViewtimkiembaihat.setVisibility(View.GONE);
                    txtkhongcodulieu.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onFailure(Call<List<Baihat>> call, Throwable t) {

            }
        });

    }
}
