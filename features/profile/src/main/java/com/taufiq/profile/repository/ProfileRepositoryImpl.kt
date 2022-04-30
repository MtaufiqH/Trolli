package com.taufiq.profile.repository

import com.taufiq.profile.data.entity.User
import com.taufiq.core.event.MutableStateEventManager
import com.taufiq.core.event.StateEventManager
import com.taufiq.core.utils.fetchStateEventSubscriber
import com.taufiq.profile.data.source.ProfileUserDataSource
import io.reactivex.disposables.CompositeDisposable
import okhttp3.internal.closeQuietly


class ProfileRepositoryImpl(private val dataSource: ProfileUserDataSource) : ProfileRepository {

    private val disposables = CompositeDisposable()

    // backing property
    private var _userStateEventManager: MutableStateEventManager<User> = MutableStateEventManager()
    override val userStateEventManager: StateEventManager<User> = _userStateEventManager

    override fun getUser() {
        val disposable = dataSource.getUser().fetchStateEventSubscriber {
            _userStateEventManager.post(it)
        }

        disposables.add(disposable)
    }

    override fun close() {
        _userStateEventManager.closeQuietly()
        disposables.dispose()
    }

}