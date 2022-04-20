package com.example.uts_mochagungmaulana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

    public static ArrayList<Shape> shapeList = new ArrayList<Shape>();

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupData();
        setUpList();
        setUpOnclickListener();
    }

    private void setupData()
    {
        Shape jennie = new Shape("0", "Jennie        BlackPink", R.drawable.jennie);
        shapeList.add(jennie);

        Shape rose = new Shape("1","Rose         BlackPink", R.drawable.rose);
        shapeList.add(rose);

        Shape lisa = new Shape("2","Lisa        BlackPink", R.drawable.lisa);
        shapeList.add(lisa);

        Shape jisoo = new Shape("3","Jisoo          BlackPink", R.drawable.jisoo);
        shapeList.add(jisoo);

        Shape wendy = new Shape("4","Wendy              Red Velvet", R.drawable.wendy);
        shapeList.add(wendy);

        Shape yeri = new Shape("5", "Yeri              Red Velvet", R.drawable.yeri);
        shapeList.add(yeri);

        Shape irene = new Shape("6","Irene      Red Velvet", R.drawable.irene);
        shapeList.add(irene);

        Shape joy = new Shape("7","Joy            Red Velvet", R.drawable.joy);
        shapeList.add(joy);

        Shape seulgi1 = new Shape("8","Seulgi            Red Velvet", R.drawable.seulgi1);
        shapeList.add(seulgi1);

        Shape sieun = new Shape("9","Sieun           StayC", R.drawable.sieun);
        shapeList.add(sieun);

        Shape j = new Shape("10","J            StayC", R.drawable.j);
        shapeList.add(j);
    }

    private void setUpList()
    {
        listView = (ListView) findViewById(R.id.shapesListView);

        ShapeAdapter adapter = new ShapeAdapter(getApplicationContext(), 0, shapeList);
        listView.setAdapter(adapter);
    }

    private void setUpOnclickListener()
    {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l)
            {
                Shape selectShape = (Shape) (listView.getItemAtPosition(position));
                Intent showDetail = new Intent(getApplicationContext(), DetailActivity.class);
                showDetail.putExtra("id",selectShape.getId());
                startActivity(showDetail);
            }
        });

    }

}