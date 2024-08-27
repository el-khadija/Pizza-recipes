package android.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.example.listview.databinding.ActivityDetailsBinding;
import android.os.Bundle;

public class DetailsActivity extends AppCompatActivity {
    ActivityDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent=this.getIntent();
        if(intent !=null){
            String name=intent.getStringExtra("name");
            String time=intent.getStringExtra("time");
            int ingredients=intent.getIntExtra("ingredients",R.string.tofuIngredients);
            int desc=intent.getIntExtra("Description",R.string.tofoDesc);
            int image=intent.getIntExtra("image",R.drawable.pastas);
            binding.detailName.setText(name);
            binding.detailTime.setText(time);
            binding.detailIngredients.setText(ingredients);
            binding.detailDesc.setText(desc);
            binding.detailImage.setImageResource(image);

        }
    }
}