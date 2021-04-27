package com.example.agricultural_products_store

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import org.w3c.dom.Text

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        getSupportActionBar()?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()

        val login_email = findViewById<EditText>(R.id.edit_text1)
        val login_pass = findViewById<EditText>(R.id.edit_text2)
        val button_login = findViewById<Button>(R.id.button_login)
        val register = findViewById<TextView>(R.id.register)

        button_login.setOnClickListener {
            if (login_email.text.toString().isNotEmpty() &&  login_pass.text.toString().isNotEmpty()){
                registerUser(login_email.text.toString(),  login_pass.text.toString())
            }else{
                Toast.makeText(this,"Nhập đầy đủ các ô",Toast.LENGTH_LONG).show()
            }
        }

        register.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
    private fun registerUser(email : String, password: String){
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(baseContext, "Đăng nhập thất bại.",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }
}