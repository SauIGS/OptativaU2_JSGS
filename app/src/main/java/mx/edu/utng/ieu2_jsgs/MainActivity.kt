package mx.edu.utng.ieu2_jsgs

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var txtUsuario = findViewById(R.id.txtUsuario) as EditText
        var txtPassword = findViewById(R.id.txtContrasenia) as EditText
        var btnLogin = findViewById(R.id.btnLogin) as Button
        val bounceAnimation = AnimationUtils.loadAnimation(this, R.anim.bounce)

        
        btnLogin.setOnClickListener {
            val sUsuario = txtUsuario.text;
            val sPassword = txtPassword.text;

            if(!sUsuario.isNullOrEmpty() && !sPassword.isNullOrEmpty() )   {
                val intent = Intent(this, actLogeado::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Las credenciales no deben de estar vacias", Toast.LENGTH_LONG).show();
                btnLogin.setBackgroundColor(Color.RED)
                btnLogin.startAnimation(bounceAnimation)
            }
        }
    }
}