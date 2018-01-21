package com.example.shivaji.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Data> numList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*for (int i=0; i<10; i++){
            Model modObj = new Model();
            modObj.setNum(i+1);
            numList.add(modObj);
        }*/

        recyclerView = (RecyclerView)findViewById(R.id.main_recycler_view);
        final CustomAdapter adapter = new CustomAdapter(this, numList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        APIClient client = new APIClient();
        APIClient.APIInterface apiInterface = client.getAPIInterface();

        Call<DataList> call = apiInterface.getData();
        call.enqueue(new Callback<DataList>() {
            @Override
            public void onResponse(Call<DataList> call, Response<DataList> response) {
                DataList dataList = response.body();
                List<Data> tempList = dataList.getDataList();
                numList.addAll(tempList);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<DataList> call, Throwable t) {
            }
        });


    }
}
