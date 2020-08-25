package com.example.study01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var requestQueue: RequestQueue = Volley.newRequestQueue(this)

        val url =
            "https://api.openweathermap.org/data/2.5/weather?q=Seoul&appid=9f3ff66235d442987dcc6f7b30c93d9b"

        val request = JsonObjectRequest(Request.Method.GET, url, null,
            Response.Listener { response ->
                try {
                    tvLocation.text="서울특별시 사근동"
                    val weatherId: Int =
                        response.getJSONArray("weather").getJSONObject(0).getInt("id")
                    if(weatherId>=801){
                        imageView.setImageResource(R.drawable.cloudy01)
                    }else if(weatherId==800){
                        imageView.setImageResource(R.drawable.sunny02)
                    }else if(weatherId>=700){
                        imageView.setImageResource(R.drawable.cloudy02)
                    }else if(weatherId>=600){
                        imageView.setImageResource(R.drawable.snowy01)
                    }else if(weatherId>=500){
                        imageView.setImageResource(R.drawable.rainy02)
                    }else if(weatherId>=300){
                        imageView.setImageResource(R.drawable.rainy01)
                    }else if(weatherId>=200){
                        imageView.setImageResource(R.drawable.stomy01)
                    }

                    val humidity:Int=response.getJSONObject("main").getInt("humidity")
                    tvHumidity.text=humidity.toString()+"%"
                    val temp:Double=response.getJSONObject("main").getDouble("temp")-273.15
                    tvTemp.text=temp.toInt().toString()+"ºC"
                    val speed:Double=response.getJSONObject("wind").getDouble("speed")
                    tvWind.text=speed.toInt().toString()+"km/h"
                    val cloud:Int=response.getJSONObject("clouds").getInt("all")
                    tvCloud.text=cloud.toString()+"%"




                } catch (e: JSONException) {
                    Toast.makeText(this, e.localizedMessage, Toast.LENGTH_SHORT).show();
                }
            }, Response.ErrorListener {
                error -> Toast.makeText(this, error.localizedMessage, Toast.LENGTH_SHORT).show();
            })
        requestQueue.add(request)
    }


}