package com.kkyoungs.medicalcare

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.core.view.isVisible
import com.kkyoungs.medicalcare.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    private lateinit var binding : ActivityEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bloodTypeSpinner.adapter = ArrayAdapter.createFromResource(
            this,
            R.array.blood_types,
            android.R.layout.simple_list_item_1
        )

        binding.birthdateLayer.setOnClickListener {
            println(">>>>>")
            val listener = OnDateSetListener{
                _, year,month, dayOfMonth ->
                binding.birthdateTextView.text = "$year-${month.inc()}-$dayOfMonth"
            }
            DatePickerDialog(this,listener, 2000,1,1).show()
        }

        binding.warningCheckBox.setOnCheckedChangeListener { buttonView, isChecked ->
            binding.cautionEditText.isVisible = isChecked
        }

        binding.cautionEditText.isVisible = binding.warningCheckBox.isChecked


    }
}