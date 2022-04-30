package com.taufiq.core.utils.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.widget.doOnTextChanged
import com.google.android.material.textfield.TextInputLayout
import com.taufiq.trolli.R
import com.taufiq.trolli.databinding.UnitFieldDropdownBinding

class UnitFieldDropDown(context: Context, attrs: AttributeSet) : ConstraintLayout(context, attrs) {

    private var binding: UnitFieldDropdownBinding =
        UnitFieldDropdownBinding.inflate(LayoutInflater.from(context), this)

    private val textField: TextInputLayout = binding.etDropDownText

    init {
        val styleAttrs = context.theme.obtainStyledAttributes(attrs, R.styleable.UnitField, 0, 0)
        try {
            textField.hint = styleAttrs.getString(R.styleable.UnitField_android_hint)
        } finally {
            styleAttrs.recycle()
        }
        binding.etDropDownText.editText?.id = this.id
    }

    fun setUnits(units: List<String>) {
        with(binding) {
            setupDropDownUnit(context, etDropDownUnit, units.toTypedArray())
        }

    }

    private fun setupDropDownUnit(
        context: Context,
        view: AutoCompleteTextView,
        units: Array<String>
    ) {
        val adapter = ArrayAdapter(context, android.R.layout.simple_spinner_item, units)
        view.setAdapter(adapter)
        view.threshold = 100

    }

    fun getText(): String =
        textField.editText?.text.toString()


    fun trackChange(change: (String) -> Unit) {
        textField.editText?.doOnTextChanged { text, _, _, _ ->
            change(text.toString().orEmpty())
        }

    }

}