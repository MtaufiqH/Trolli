package com.taufiq.trolli

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.taufiq.core.event.StateEventManager
import com.taufiq.profile.data.entity.User
import com.taufiq.trolli.databinding.ActivityMainBinding
import com.taufiq.trolli.home.HomePageViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber as timber

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val vm: HomePageViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {

            tvLog.setOnClickListener {
                vm.getUser()
            }

            val userManager: StateEventManager<User> = vm.userManager
            userManager.onLoading = {
                tvLog.text = "loading..."
            }

            userManager.onFailure = {
                timber.i(it.localizedMessage)
                tvLog.text = it.localizedMessage
            }

            userManager.onSuccess = {
                tvLog.text = it.fullName
            }
        }
    }
}