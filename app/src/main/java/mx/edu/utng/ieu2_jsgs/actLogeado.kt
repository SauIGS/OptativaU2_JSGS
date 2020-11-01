package mx.edu.utng.ieu2_jsgs

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Transformations.map
import com.google.android.gms.maps.MapFragment
import com.google.android.gms.maps.SupportMapFragment

class actLogeado : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_logeado)
        setSupportActionBar(findViewById(R.id.toolbar))
        var btnOp = findViewById(R.id.btnOp) as Button
        val bounceAnimation = AnimationUtils.loadAnimation(this, R.anim.bounce)

        btnOp.setOnClickListener{
            var opUtil = findViewById<RadioButton>(R.id.rbUtil)
            var opNoUtil = findViewById<RadioButton>(R.id.rbNoUtil)

           if(opUtil.isChecked()){
               Toast.makeText(this, "Gracias por tu opinión, te mostraremos más información relacionada", Toast.LENGTH_LONG).show();
           }else if(opNoUtil.isChecked()){
               Toast.makeText(this, "Gracias por tu opinión, no te mostraremos más información relacionada", Toast.LENGTH_LONG).show();
           }else{
               Toast.makeText(this, "Por favor selecciona una opinión", Toast.LENGTH_LONG).show();
               btnOp.setBackgroundColor(Color.RED)
               btnOp.startAnimation(bounceAnimation)
           }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.salir -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}