package com.example.agricultural_products_store

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = FirebaseAuth.getInstance()

        val register_email = findViewById<EditText>(R.id.dangkitk)
        val register_pass = findViewById<EditText>(R.id.dkimk)
        val confirm_pass = findViewById<EditText>(R.id.nhaplaimkdki)
        val button_Register = findViewById<Button>(R.id.button_Register)

        button_Register.setOnClickListener {
            if (register_email.text.toString().isNotEmpty() && register_pass.text.toString().isNotEmpty() && confirm_pass.text.toString().isNotEmpty()){
                if (register_pass.text.toString().equals(confirm_pass.text.toString())){
                        createUser(register_email.text.toString(),register_pass.text.toString())
                }else{
                    Toast.makeText(this,"Vui lòng nhập lại đúng mật khẩu ",Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(this,"Nhập đầy đủ các ô",Toast.LENGTH_LONG).show()
            }
        }
    }
    private fun createUser(email : String, password: String){
        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener (this){ task ->
                if(task.isSuccessful){
                    Log.d("Task Message", "createUserWithEmail:success")
                    //val user = auth.currentUser
                    var intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }else{
                    Log.w("Task Message", "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Đăng kí thất bại",
                        Toast.LENGTH_SHORT).show()
                }
            }

    }
}