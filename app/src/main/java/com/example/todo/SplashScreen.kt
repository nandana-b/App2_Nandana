package com.example.todo
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_splash_screen.*


class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        supportActionBar?.hide()


        val backgroundImage: ImageView = findViewById(R.id.SplashScreenImg)
        val slideAnimation=AnimationUtils.loadAnimation(this,R.anim.fade)
        backgroundImage.startAnimation(slideAnimation)
        Handler().postDelayed({
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        },4000)
        GIFview()
    }
    private fun GIFview(){
        val imageView:ImageView=findViewById(R.id.SplashScreenImg)
        Glide.with(this).load(R.drawable.checklist).into(imageView)
    }
}