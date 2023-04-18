package Sena.myfirstkotlinapp

import Sena.myfirstkotlinapp.databinding.ActivityAfterLoginBinding
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton

class AfterLogin : AppCompatActivity() {

    private lateinit var usernameLogged: TextView
    private lateinit var shareButton: MaterialButton
    private  lateinit var binding: ActivityAfterLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityAfterLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragments(HomeFragment())

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> replaceFragments(HomeFragment())
                R.id.search -> replaceFragments(SearchFragment())
                R.id.profile -> replaceFragments(ProfileFragment())
                else ->{
                }
            }
            true
        }
    }

    private fun replaceFragments(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val bundle = Bundle()
        print(intent.getStringExtra("username"))
        bundle.putString("username", intent.getStringExtra("username"))
        fragment.arguments = bundle
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}