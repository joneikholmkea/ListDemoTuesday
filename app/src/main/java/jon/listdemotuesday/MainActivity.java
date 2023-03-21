package jon.listdemotuesday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import jon.listdemotuesday.adapter.MyAdapter;
import jon.listdemotuesday.model.Item;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private MyAdapter myAdapter;
    private List<Item> values = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addValues();
        listView = findViewById(R.id.listView);
       // adapter = new ArrayAdapter<>(this, R.layout.myrow, R.id.rowTextView, values);
        myAdapter = new MyAdapter(values, this);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener((listView, linearLayout, pos, id) ->{
            TextView tv = linearLayout.findViewById(R.id.rowTextView);
            System.out.println("you pressed " + tv.getText());
            Intent intent = new Intent(this, DetailActivity.class);
            startActivity(intent);
        });
    }

    public void addPressed(View view){
        System.out.println("Add pressed");
        values.add(new Item("New item", R.drawable.car0));
        myAdapter.notifyDataSetChanged(); // should update the layout
    }

    private void addValues(){
        values.add(new Item("Car 1", R.drawable.car1));
        values.add(new Item("Car 2", R.drawable.car2));
    }

}