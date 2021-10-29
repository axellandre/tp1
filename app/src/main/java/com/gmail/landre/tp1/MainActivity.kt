package com.gmail.landre.tp1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var imageView: ImageView
    private lateinit var button: Button
    private lateinit var button_calcul: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageView = findViewById(R.id.image_view)
        button = findViewById(R.id.my_button)
        button_calcul = findViewById(R.id.btn_calculer)
        button.setOnClickListener(this)
        loadImage()
    }

    fun loadImage(url: String){
        Picasso.get()
            .load("https://helpx.adobe.com/content/dam/help/en/stock/how-to/visual-reverse-image-search/jcr_content/main-pars/image/visual-reverse-image-search-v2_intro.jpg")
            .resize(900, 900)
            .centerCrop()
            .into(imageView)
    }

    override fun onClick(view: View?) {
        val link = "https://www.presse-citron.net/app/uploads/2018/11/meilleure-banque-image.jpg"
        loadImage(link)
        Toast.makeText(this, "You click me", Toast.LENGTH_LONG).show()
    }
}
