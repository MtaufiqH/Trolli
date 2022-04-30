package com.taufiq.core.utils.customview

import android.os.Bundle
import android.viewbinding.library.activity.viewBinding
import androidx.appcompat.app.AppCompatActivity
import com.taufiq.trolli.databinding.ActivityMain2Binding
import com.taufiq.core.utils.loading
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity2 : AppCompatActivity() {

    private val binding: ActivityMain2Binding by viewBinding()
    private val vModel by viewModel<MainPageViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        with(binding) {
            etUnit.setUnit("kg")
            etUnit2.setUnit("cm")

            etDropDown.setUnits(listOf("cm", "m", "kg","mm"))

            btnProgress.onClick {
                btnProgress.loading()
                if (etUnit.textField.editText?.text?.isEmpty() == true) {
                    etUnit.textField.error = "Please fill value first"
                } else {
                    etUnit.textField.error = null
                    val bb: String = etUnit.getText()
                    tvBerat.text = "${bb}kg"
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        binding.apply {
            etUnit.setText(vModel.textInputEditText)
        }

    }
}