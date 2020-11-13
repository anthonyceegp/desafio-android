package com.example.digitalhousefoods

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    private val tilEmail by lazy { findViewById<TextInputLayout>(R.id.til_email_login) }
    private val tieEmail by lazy { findViewById<TextInputEditText>(R.id.tie_email_login) }
    private val tilPassword by lazy { findViewById<TextInputLayout>(R.id.til_password_login) }
    private val tiePassword by lazy { findViewById<TextInputEditText>(R.id.tie_password_login) }
    private val btnLogin by lazy { findViewById<MaterialButton>(R.id.btn_login) }
    private val btnRegister by lazy { findViewById<MaterialButton>(R.id.btn_register_login) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener {
            clearFieldsError()
            if(validateFields()){
                intent = Intent(this, StoreListActivity::class.java)
                startActivity(intent)
            }
        }

        btnRegister.setOnClickListener {
            intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun clearFieldsError() {
        tilEmail.error = null
        tilPassword.error = null
    }

    private fun validateFields(): Boolean {
        var isValid = true

        isValid = validateField(tilEmail, tieEmail.text.toString().trim()) && isValid
        isValid = validateField(tilPassword, tiePassword.text.toString()) && isValid

        return isValid
    }

    private fun validateField(textInputLayout: TextInputLayout, text: String): Boolean {
        var isValid = true
        if (text.isEmpty()) {
            textInputLayout.error = getString(R.string.required_field)
            isValid = false
        }

        return isValid
    }
}