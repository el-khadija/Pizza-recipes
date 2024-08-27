package android.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.example.listview.databinding.ActivityMainBinding;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    ListAdapter listAdapter;
    ArrayList<ListData> dataArrayList=new ArrayList<>();
    ListData listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        int[] imageList={R.drawable.pastas,R.drawable.pasta_bolonaise,R.drawable.pasta_carbonara,R.drawable.pasta_dinde_fum_e,R.drawable.pasta_fuit_de_mer,R.drawable.pasta_saumon,R.drawable.pasta_with_tuna};
        int[] ingredientsList={R.string.tofuIngredients,R.string.bolonaiseIngredients,R.string.carbonaraIngredients,R.string.dindeIngredients,R.string.seafruitsIngredients,R.string.saumonIngredients,R.string.tunaIngredients,};
        int[] descList={R.string.tofoDesc,R.string.bolonaiseDesc,R.string.carbonaraDesc,R.string.dindeDesc,R.string.seafoodDesc,R.string.saumonDesc,R.string.tunaDesc};
        String[] timeList={"15-20 min","30-35 min","35-40 min","20-25 min","25-30 min","40-45 min","15-20 min"};
        String[] nameList={"Tofu Pasta","Pasta Bolonaise","Pasta Carbonara","Pasta dinde fumée","Seafood Pasta","Salmon Pasta","Tuna Pasta"};
        int[] storeList={1,2,4,3,7,5,6};
        for(int i=0; i<imageList.length;i++){
            listData=new ListData(nameList[i],timeList[i],ingredientsList[i],descList[i],imageList[i],storeList[i]);
            dataArrayList.add(listData);
        }
        listAdapter=new ListAdapter(MainActivity.this, dataArrayList);
        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,DetailsActivity.class);
                intent.putExtra("name",nameList[i]);
                intent.putExtra("time",timeList[i]);
                intent.putExtra("ingredients",ingredientsList[i]);
                intent.putExtra("desc",descList[i]);
                intent.putExtra("image",imageList[i]);
                intent.putExtra("store",storeList[i]);
                startActivity(intent);


            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Check out these cool recipes!!!");
        intent.putExtra(Intent.EXTRA_TEXT, "The app's link is here....");
        startActivity(Intent.createChooser(intent, "Share via"));
        return super.onOptionsItemSelected(item);
    }

}