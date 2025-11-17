package aman.first.signupscreen

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class Signup_Activity : AppCompatActivity() {

    private lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)

        val button = findViewById<Button>(R.id.Signupbtn)
        val name = findViewById<TextInputEditText>(R.id.et_username)
        val userId = findViewById<TextInputEditText>(R.id.et_userid)
        val mail = findViewById<TextInputEditText>(R.id.et_useremail)
        val password = findViewById<TextInputEditText>(R.id.et_userpassword)

        database = FirebaseDatabase.getInstance().getReference("Users")

        button.setOnClickListener {

            val etName = name.text.toString()
            val etId = userId.text.toString()
            val etMail = mail.text.toString()
            val etPass = password.text.toString()


            val user = User(etName, etId, etMail, etPass)

                    Toast.makeText(this, "Successfully Saved", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener {
                    Toast.makeText(this, "Failed: ${it.message}", Toast.LENGTH_SHORT).show()
                }
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
