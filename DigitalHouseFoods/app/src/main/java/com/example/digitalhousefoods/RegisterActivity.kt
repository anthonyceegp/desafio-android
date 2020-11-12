package com.example.digitalhousefoods

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class RegisterActivity : AppCompatActivity() {
    private val toolbar by lazy { findViewById<Toolbar>(R.id.default_appbar) }
    private val tilName by lazy { findViewById<TextInputLayout>(R.id.til_name_register) }
    private val tieName by lazy { findViewById<TextInputEditText>(R.id.tie_name_register) }
    private val tilEmail by lazy { findViewById<TextInputLayout>(R.id.til_email_register) }
    private val tieEmail by lazy { findViewById<TextInputEditText>(R.id.tie_email_register) }
    private val tilPassword by lazy { findViewById<TextInputLayout>(R.id.til_password_register) }
    private val tiePassword by lazy { findViewById<TextInputEditText>(R.id.tie_password_register) }
    private val tilRepeatPassword by lazy { findViewById<TextInputLayout>(R.id.til_repeat_password_register) }
    private val tieRepeatPassword by lazy { findViewById<TextInputEditText>(R.id.tie_repeat_password_register) }
    private val btnRegister by lazy { findViewById<MaterialButton>(R.id.btn_register) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        setSupportActionBar(toolbar)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = getString(R.string.register)
        }

        btnRegister.setOnClickListener {
            clearFieldsError()
            if (validateFields()) {
                intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun clearFieldsError() {
        tilName.error = null
        tilEmail.error = null
        tilPassword.error = null
        tilRepeatPassword.error = null
    }

    private fun validateFields(): Boolean {
        var isValid = true

        isValid = validateField(tilName, tieName.text.toString().trim()) && isValid
        isValid = validateField(tilEmail, tieEmail.text.toString().trim()) && isValid
        isValid = validateField(tilPassword, tiePassword.text.toString()) && isValid

        if (validateField(tilRepeatPassword, tieRepeatPassword.text.toString())) {
            val isMatch = tiePassword.text.toString() == tieRepeatPassword.text.toString()
            if (!isMatch) {
                tilRepeatPassword.error = getString(R.string.password_match)
            }
            isValid = isValid && isMatch
        }

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