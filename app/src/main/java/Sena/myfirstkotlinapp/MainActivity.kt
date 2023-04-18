package Sena.myfirstkotlinapp

import Sena.myfirstkotlinapp.databinding.ActvityNameBinding
import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var editable: EditText
    private lateinit var button: Button
    private lateinit var loginButton: MaterialButton
    private lateinit var usernameInput: TextInputEditText
    private lateinit var passwordInput: TextInputEditText
    private lateinit var usernameInputLayout: TextInputLayout
    private lateinit var passwordInputLayout: TextInputLayout
    private lateinit var afterLoginAct: Intent
    private lateinit var alertDialog: AlertDialog
    private lateinit var binding: ActvityNameBinding
    private fun initComponents() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActvityNameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initComponents()

        binding.button1.setOnClickListener {
            showDialog()
        }

    }

    override fun onRestart() {
        alertDialog.dismiss()
        super.onRestart()
    }

    private fun showDialog() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.login_dialog, null)
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setView(dialogView)
        alertDialog = dialogBuilder.create()
        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        alertDialog.show()
        usernameInput = dialogView.findViewById<TextInputEditText>(R.id.usernameInput)
        passwordInput = dialogView.findViewById<TextInputEditText>(R.id.passwordInput)
        loginButton = dialogView.findViewById<MaterialButton>(R.id.loginButton)
        usernameInputLayout = dialogView.findViewById<TextInputLayout>(R.id.usernameInputLayout)
        passwordInputLayout = dialogView.findViewById<TextInputLayout>(R.id.passwordInputLayout)

        usernameInputLayout.isHelperTextEnabled = false
        passwordInputLayout.isHelperTextEnabled = false
        loginButton.setOnClickListener {
            login()
        }
    }

    //Explicit Intent
    private fun login() {

        if (usernameInput.text!!.isEmpty() || passwordInput.text!!.isEmpty()) {
            usernameInputLayout.isHelperTextEnabled = true
            usernameInputLayout.helperText = "Required"
            usernameInputLayout.setHelperTextColor(getColorStateList(R.color.red))
            usernameInputLayout.boxStrokeColor = getColor(R.color.red)
            usernameInputLayout.hintTextColor = getColorStateList(R.color.red)
            if (usernameInput.text!!.isEmpty()) {
                passwordInputLayout.isHelperTextEnabled = true
                passwordInputLayout.helperText = "Required"
                passwordInputLayout.setHelperTextColor(getColorStateList(R.color.red))
                passwordInputLayout.boxStrokeColor = getColor(R.color.red)
                passwordInputLayout.hintTextColor = getColorStateList(R.color.red)
            }
        } else {
            //Explicit Intent
            afterLoginAct = Intent(this@MainActivity, AfterLogin::class.java)
            afterLoginAct.putExtra("username", usernameInput.text.toString())
            startActivity(afterLoginAct)

            //Toast
            Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show()
        }

    }
}