package com.taufiq.core.utils.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.taufiq.trolli.R
import com.taufiq.trolli.databinding.ProgressButtonBinding
import androidx.core.content.ContextCompat as ctx

class ProgressButton(
    context: Context,
    attrSet: AttributeSet
) : ConstraintLayout(context, attrSet) {

    var binding: ProgressButtonBinding =
        ProgressButtonBinding.inflate(LayoutInflater.from(context), this, true)

    var allCaps = true
    var option = Type.ENABLED.value

    init {
        attrSet.let {
            val attributeStyle = context.theme.obtainStyledAttributes(it, R.styleable.Button, 0, 0)

            try {
                val textButton = attributeStyle.getString(R.styleable.Button_text)
                allCaps = attributeStyle.getBoolean(R.styleable.Button_allCaps, true)
                val stateOption = attributeStyle.getInt(R.styleable.Button_type, Type.ENABLED.value)
                selectedState(stateOption)
                isTextAllCaps(allCaps)
                buttonText(textButton)
            } finally {
                attributeStyle.recycle()
            }
        }
    }

    fun selectedState(stateOption: Int) {
        when (stateOption) {
            Type.LOADING.value -> {
                binding.btnProgress.background =
                    ctx.getDrawable(context, R.drawable.bg_progress_button)
                binding.btnProgressText.visibility = View.GONE
                binding.pbButton.visibility = View.VISIBLE
                binding.btnProgress.isEnabled = false
            }

            Type.DISABLED.value -> {
                binding.btnProgress.background =
                    ctx.getDrawable(context, R.drawable.bg_button_disable)
                binding.btnProgressText.visibility = View.VISIBLE
                binding.pbButton.visibility = View.GONE
                binding.btnProgress.isEnabled = false
            }

            Type.ENABLED.value -> {
                binding.btnProgress.background =
                    ctx.getDrawable(context, R.drawable.bg_progress_button)

                binding.btnProgressText.visibility = View.VISIBLE
                binding.pbButton.visibility = View.GONE
                binding.btnProgress.isEnabled = true
            }

        }

    }

    fun buttonText(textButton: String?) {
        if (textButton != null) binding.btnProgressText.text = textButton

    }

    fun isTextAllCaps(allCapsOption: Boolean) {
        binding.btnProgressText.isAllCaps = allCapsOption
    }

    fun onClick(listenerBtn: () -> Unit) {
        binding.btnProgress.setOnClickListener {
            if (option == Type.ENABLED.value) {
                listenerBtn.invoke()
            }
        }
    }
}

enum class Type(val value: Int) {
    ENABLED(0),
    DISABLED(1),
    LOADING(2)
}