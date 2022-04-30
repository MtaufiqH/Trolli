package com.taufiq.core.utils.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.widget.doOnTextChanged
import com.google.android.material.textfield.TextInputLayout
import com.taufiq.core.R
import com.taufiq.core.databinding.UnitFieldBinding

class UnitField(context: Context, attrs: AttributeSet) : ConstraintLayout(context, attrs) {

    var binding: UnitFieldBinding =
        UnitFieldBinding.inflate(LayoutInflater.from(context), this)

    val textField: TextInputLayout = binding.tilText
    var selectedUnit: String = ""
        private set

    init {
        val styleAttrs = context.theme.obtainStyledAttributes(attrs, R.styleable.UnitField, 0, 0)
        try {
            textField.hint = styleAttrs.getString(R.styleable.UnitField_android_hint)
        } finally {
            styleAttrs.recycle()
        }
        binding.tilText.editText?.id = this.id
    }

    fun setUnit(unit: String) {
        if (unit.isNotEmpty()) {
            selectedUnit = unit ?: ""
            binding.tilUnit.editText?.setText(selectedUnit)
        }
    }

    fun getText(): String =
        textField.editText?.text.toString()


    fun trackChange(change: (String) -> Unit) {
        textField.editText?.doOnTextChanged { text, _, _, _ ->
            change(text.toString().orEmpty())
        }

    }

    fun setText(text: String?) {
        if (!text.isNullOrEmpty()) {
            textField.editText?.setText(text)
        }

    }

}