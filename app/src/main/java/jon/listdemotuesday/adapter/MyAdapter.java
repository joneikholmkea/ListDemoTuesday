package jon.listdemotuesday.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import jon.listdemotuesday.R;
import jon.listdemotuesday.model.Item;

public class MyAdapter extends BaseAdapter {
    private List<Item> items;
    private LayoutInflater inflater;

    public MyAdapter(List<Item> items, Context context) {
        this.items = items;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if(view == null){
            view = inflater.inflate(R.layout.myrow, null);
        }
        TextView textView = view.findViewById(R.id.rowTextView);
        textView.setText(items.get(position).getText());
        ImageView imageView = view.findViewById(R.id.rowImageView);
        imageView.setImageResource(items.get(position).getImage());
        return view;
    }
}
