package com.example.pemmobkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import com.example.pemmobkotlin.databinding.ActivityMainBinding
import com.example.pemmobkotlin.databinding.LoginBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: LoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener {
            val username = binding.usernameEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            if (username.equals("user",false) &&
                    password.equals("1234", false)
            )
                makeToast("Username dan Password Benar")
            else if (username.equals("user",false))
                makeToast("Password Salah")
            else if (password.equals("1234",false))
                makeToast("Username Salah")
            else
                makeToast("Username dan Password Salah")
        }
    }

    fun makeToast(message: String) {
        Toast.makeText(
            this@MainActivity,
            message,
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        savedInstanceState.putString("USERNAME", binding.usernameEditText.text.
            toString())
        savedInstanceState.putString("PASSWORD", binding.passwordEditText.text
            .toString())
        super.onSaveInstanceState(savedInstanceState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        binding.usernameEditText.setText(savedInstanceState.getString
            ("USERNAME"))
        binding.passwordEditText.setText(savedInstanceState.getString
            ("PASSWORD"))
    }
}