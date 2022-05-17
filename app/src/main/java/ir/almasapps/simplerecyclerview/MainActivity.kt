package ir.almasapps.simplerecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        fillRecyclerview(1)

        btnGrid.setOnClickListener{
            fillRecyclerview(2)
        }
        btnLinear.setOnClickListener{
            fillRecyclerview(1)
        }


    }
    private fun fillRecyclerview(recyclerviewType:Int){

        recyclerview.layoutManager = LinearLayoutManager(this)

        if(recyclerviewType==2){
            recyclerview.layoutManager = GridLayoutManager(this,2)
        }
        recyclerview.adapter = CountryAdapter(this,DataSource.countries,recyclerviewType){
            country ->  Toast.makeText(this,"Population : ${country.population}",Toast.LENGTH_SHORT).show()
        }

    }
}