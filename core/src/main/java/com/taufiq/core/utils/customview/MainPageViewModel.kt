package com.taufiq.core.utils.customview

import androidx.lifecycle.ViewModel
import com.taufiq.trolli.data.entity.User
import com.taufiq.core.event.StateEventManager
import com.taufiq.trolli.data.remote.WebService
import com.taufiq.trolli.features.repository.user.UserDataSource
import com.taufiq.trolli.features.repository.user.UserRepository
import com.taufiq.trolli.features.repository.user.UserRepositoryImpl
import okhttp3.internal.closeQuietly

class MainPageViewModel(): ViewModel() {

    var textInputEditText: String = ""



}