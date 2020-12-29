package com.vogella.android.android4a

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.Observer
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.vogella.android.android4a.presentation.main.LoginError
import com.vogella.android.android4a.presentation.main.LoginSuccess
import kotlinx.android.synthetic.main.activity_main.*
import com.vogella.android.android4a.presentation.main.LoginStatus
import com.vogella.android.android4a.presentation.main.SecondActivity

import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    val mainViewModel: MainViewModel by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val button = findViewById<Button>(R.id.login_button)
        button.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)

            mainViewModel.loginLiveData.observe(this, Observer {
                when (it) {
                    is LoginSuccess -> { /*TODO Navigate*/
                    }
                   // LoginError -> {
                   //     MaterialAlertDialogBuilder(this)
                   //         .setTitle("Erreur")
                   //         .setMessage("compte inconnu")
                   //         .setPositiveButton("okay") { dialog, which ->
                   //             dialog.dismiss()
                   //         }
                   //         .show()
                   // }
                }
            })
            login_button.setOnClickListener {
                mainViewModel.onClickedLogin(login_edit.text.toString().trim(),
                    password_edit.text.toString())
            }
        }
    }
}