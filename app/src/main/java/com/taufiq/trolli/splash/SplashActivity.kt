package com.taufiq.trolli.splash

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.taufiq.core.event.StateEventManager
import com.taufiq.profile.data.entity.User
import com.taufiq.trolli.databinding.ActivitySplashBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private val splashViewModel: SplashViewModel by viewModel()


    lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {

            val userManager: StateEventManager<User> = splashViewModel.userManager
            userManager.onLoading = {
                progressBar.isVisible = true
            }

            userManager.onFailure = {
                Timber.i(it.localizedMessage)
                progressBar.isVisible = false

            }

            userManager.onSuccess = {
                // intent to login screen
                progressBar.isVisible = false

            }
        }
    }
}