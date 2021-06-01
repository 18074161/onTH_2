package com.example.thith_lan2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.thith_lan2.api.APIService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Action extends AppCompatActivity implements  onClickListener{
    List<User> mUsers;
    RecyclerView rcv_user;
    CustomAdapter adt;

    EditText plId,plFn,plLn,plGt;
    Button btnClear, btnAdd, btnDelete, btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action);

        plId =findViewById(R.id.plId);
        plFn =findViewById(R.id.plFn);
        btnUpdate =findViewById(R.id.btnCapNhat);
        plLn =findViewById(R.id.plLn);
        plGt =findViewById(R.id.plGt);
        btnClear =findViewById(R.id.btnClear);
        btnAdd =findViewById(R.id.btnAdd);
        btnDelete =findViewById(R.id.btnXoa);

        rcv_user = findViewById(R.id.rcv_user);
        mUsers = new ArrayList<>();
//        mUsers.add(new User("A","a","a"));
        adt = new CustomAdapter(mUsers,this);

        rcv_user.setHasFixedSize(true);
        rcv_user.setAdapter(adt);
        rcv_user.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        loadUI();
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                APIService.apiService.deleteUser(plId.getText().toString()).enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        clear();
                        loadUI();
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {

                    }
                });

            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=  plId.getText().toString();
                String fl=  plFn.getText().toString();
                String ln=  plLn.getText().toString();
                String gt=  plGt.getText().toString();
                APIService.apiService.addUser(new User(fl,ln,gt)).enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        loadUI();
                        clear();
                        Toast.makeText(Action.this, "them", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {

                    }
                });
                
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=  plId.getText().toString();
                String fl=  plFn.getText().toString();
                String ln=  plLn.getText().toString();
                String gt=  plGt.getText().toString();
                APIService.apiService.updateUser(id,new User(fl,ln,gt)).enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        loadUI();
                        clear();
                        Toast.makeText(Action.this, "them", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {

                    }
                });

            }
        });



    }

    @Override
    public void ClickItem(User user) {
        plId.setText(user.getId());
        plFn.setText(user.getFirstname());
        plLn.setText(user.getLastname());
        plGt.setText(user.getGioitinh());

    }
    public void clear(){
        plId.setText("");
        plFn.setText("");
        plLn.setText("");
        plGt.setText("");
    }
    public void loadUI(){
        APIService.apiService.findAll().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                mUsers = response.body();
                adt.setList(response.body());
                Toast.makeText(Action.this, "success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });

    }
}