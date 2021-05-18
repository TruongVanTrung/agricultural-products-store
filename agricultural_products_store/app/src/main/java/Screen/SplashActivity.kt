package Screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.agricultural_products_store.LoginActivity
import com.example.agricultural_products_store.MainActivity
import com.example.agricultural_products_store.R
import android.os.Handler as Handler

class SplashActivity : AppCompatActivity() {

    private val splash_time : Long = 300
    lateinit var handler : Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        handler = Handler()
        handler.postDelayed({
            startActivity(Intent(this,LoginActivity::class.java))
            finish()
        },
        splash_time)
    }
}