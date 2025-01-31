package android.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<ListData> {
    public ListAdapter(@NonNull Context context, ArrayList<ListData> dataArrayList) {
        super(context, R.layout.list_item,dataArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        ListData listData=getItem(position);
        if(view==null){
            view= LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }
        ImageView listImage=view.findViewById(R.id.listImage);
        TextView listName=view.findViewById(R.id.listName);
        TextView listStore=view.findViewById(R.id.store);
        TextView listTime=view.findViewById(R.id.time);
        listImage.setImageResource(listData.image);
        listName.setText(listData.name);
        listStore.setText(listData.time);
        listTime.setText(listData.time);
        return view;
    }
}
