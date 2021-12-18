package com.example.taskofjsonparsing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView idRecyclerView;
    private AdapterProfile myAdapter;

    String strJson = new String("{\n" + "\"contacts\":[\n" + "{\n" + "\"id\":\"c200\",\n" + "\"name\":\"ASaton\",\n" + "\"email\":\"Saton@gmail.com\",\n" + "\"userimage\":\"https://images.unsplash.com/photo-1535713875002-d1d0cf377fde?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=800&q=80\",\n" + "\"address\":\"Sample1 Address1\",\n" + "\"gender\":\"male\",\n" + "\"phone\":{\n" + "\"mobile\":\"+91 8754857845\",\n" + "\"home\":\"0261 1254785\"\n" + "}\n" + "},\n" +
            "{\n" + "\"id\":\"c201\",\n" + "\"name\":\"BJohnny Depp\",\n" + "\"email\":\"johnny_depp@gmail.com\",\n" + "\"userimage\":\"https://images.unsplash.com/photo-1528763380143-65b3ac89a3ff?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=635&q=80\",\n" + "\"address\":\"althan\",\n" + "\"gender\":\"female\",\n" + "\"phone\":{\n" + "\"mobile\":\"\",\n" + "\"home\":\"0261 1554799\"\n" + "}\n" + "},\n" +
            "{\n" + "\"id\":\"c202\",\n" + "\"name\":\"CMaster\",\n" + "\"email\":\"master@gmail.com\",\n" + "\"userimage\":\"https://images.unsplash.com/photo-1506794778202-cad84cf45f1d?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=634&q=80\",\n" + "\"address\":\"Sample1 Address3\",\n" + "\"gender\":\"male\",\n" + "\"phone\":{\n" + "\"mobile\":\"+91 8785448775\",\n" + "\"home\":\"\"\n" + "}\n" + "},\n" +
            "{\n" + "\"id\":\"c203\",\n" + "\"name\":\"Ydou\",\n" + "\"email\":\"youg@gmail.com\",\n" + "\"userimage\":\"https://images.unsplash.com/photo-1535713875002-d1d0cf377fde?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=800&q=80\",\n" + "\"address\":\"Sample1 Address4\",\n" + "\"gender\":\"male\",\n" + "\"phone\":{\n" + "\"mobile\":\"\",\n" + "\"home\":\"0261 12224785\"\n" + "}\n" + "},\n" +
            "{\n" + "\"id\":\"c204\",\n" + "\"name\":\"Saton\",\n" + "\"email\":\"Saton@gmail.com\",\n" + "\"userimage\":\"https://images.unsplash.com/photo-1506794778202-cad84cf45f1d?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=634&q=80\",\n" + "\"address\":\"Sample1 Address1\",\n" + "\"gender\":\"male\",\n" + "\"phone\":{\n" + "\"mobile\":\"+91 8754857845\",\n" + "\"home\":\"0261 1254785\"\n" + "}\n" + "},\n" +
            "{\n" + "\"id\":\"c205\",\n" + "\"name\":\"DJohnny Depp\",\n" + "\"email\":\"johnny_depp@gmail.com\",\n" + "\"userimage\":\"https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=634&q=80\",\n" + "\"address\":\"althan\",\n" + "\"gender\":\"female\",\n" + "\"phone\":{\n" + "\"mobile\":\"+91 5525458457\",\n" + "\"home\":\"\"\n" + "}\n" + "},\n" +
            "{\n" + "\"id\":\"c206\",\n" + "\"name\":\"EMaster\",\n" + "\"email\":\"master@gmail.com\",\n" + "\"userimage\":\"https://images.unsplash.com/photo-1528763380143-65b3ac89a3ff?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=635&q=80\",\n" + "\"address\":\"Sample1 Address3\",\n" + "\"gender\":\"female\",\n" + "\"phone\":{\n" + "\"mobile\":\"+91 8785448775\",\n" + "\"home\":\"0261 1212585\"\n" + "}\n" + "},\n" +
            "{\n" + "\"id\":\"c207\",\n" + "\"name\":\"VBN\",\n" + "\"email\":\"youg@gmail.com\",\n" + "\"userimage\":\"https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=634&q=80\",\n" + "\"address\":\"Sample1 Address4\",\n" + "\"gender\":\"male\",\n" + "\"phone\":{\n" + "\"mobile\":\"\",\n" + "\"home\":\"0261 12224785\"\n" + "}\n" + "},\n" +
            "{\n" + "\"id\":\"c208\",\n" + "\"name\":\"QWE\",\n" + "\"email\":\"youg@gmail.com\",\n" + "\"userimage\":\"https://images.unsplash.com/photo-1535713875002-d1d0cf377fde?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=800&q=80\",\n" + "\"address\":\"Sample1 Address4\",\n" + "\"gender\":\"female\",\n" + "\"phone\":{\n" + "\"mobile\":\"+91 5525458457\",\n" + "\"home\":\"0261 12224785\"\n" + "}\n" + "},\n" +
            "{\n" + "\"id\":\"c209\",\n" + "\"name\":\"ASD\",\n" + "\"email\":\"youg@gmail.com\",\n" + "\"userimage\":\"https://images.unsplash.com/photo-1535713875002-d1d0cf377fde?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=800&q=80\",\n" + "\"address\":\"Sample1 Address4\",\n" + "\"gender\":\"male\",\n" + "\"phone\":{\n" + "\"mobile\":\"\",\n" + "\"home\":\"0261 12224785\"\n" + "}\n" + "},\n" +
            "{\n" + "\"id\":\"c210\",\n" + "\"name\":\"RRRR\",\n" + "\"email\":\"youg@gmail.com\",\n" + "\"userimage\":\"https://images.unsplash.com/photo-1535713875002-d1d0cf377fde?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=800&q=80\",\n" + "\"address\":\"Sample1 Address4\",\n" + "\"gender\":\"female\",\n" + "\"phone\":{\n" + "\"mobile\":\"+91 5525458457\",\n" + "\"home\":\"0261 12224785\"\n" + "}\n" + "}\n" + "]\n" + "}");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<ProfileList> contactData = new ArrayList<>();
        try {
            JSONObject jsonRootObject = new JSONObject(strJson);
            JSONArray jsonArray = jsonRootObject.optJSONArray("contacts");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                ProfileList contactList = new ProfileList();
                contactList.id = jsonObject.getString("id");
                contactList.name = jsonObject.getString("name");
                contactList.email = jsonObject.getString("email");
                contactList.userimage = jsonObject.getString("userimage");
                contactList.address = jsonObject.getString("address");
                contactList.gender = jsonObject.getString("gender");

                JSONObject phone = jsonObject.getJSONObject("phone");
                contactList.mobile = phone.getString("mobile");
                contactList.home = phone.getString("home");
                contactData.add(contactList);
            }
            idRecyclerView = (RecyclerView) findViewById(R.id.idRecyclerView);
            myAdapter = new AdapterProfile(MainActivity.this, contactData);
            idRecyclerView.setAdapter(myAdapter);
            idRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        } catch (JSONException e) {
            Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_LONG).show();
        }

    }
}