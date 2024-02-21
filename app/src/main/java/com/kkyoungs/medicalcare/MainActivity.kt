package com.kkyoungs.medicalcare

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.kkyoungs.medicalcare.databinding.ActivityEditBinding
import com.kkyoungs.medicalcare.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.goActivityInput.setOnClickListener {
            val intent = Intent(this, EditActivity::class.java)
             startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        getDataUIUpdate()

    }
    private fun getDataUIUpdate(){
        with(getSharedPreferences(USER_INFORMATION, Context.MODE_PRIVATE)){
            binding.nameValueTextView.text = getString(NAME, "미정")
            binding.birthdateValueTextView.text = getString(BIRTHDATE, "미정")
            binding.bloodValueTextView.text = getString(BLOOD_TYPE, "미정")
            binding.contactValueTextView.text = getString(EMERGENCY_CONTACT, "미정")
            val warning = getString(WARNING, "미정")

            binding.cautionTextView.isVisible = warning.isNullOrEmpty().not()
            binding.cautionValueTextView.isVisible = warning.isNullOrEmpty().not()

            if (!warning.isNullOrEmpty()){
                binding.cautionValueTextView.text = getString(WARNING, "미정")
            }

        }

    }
}