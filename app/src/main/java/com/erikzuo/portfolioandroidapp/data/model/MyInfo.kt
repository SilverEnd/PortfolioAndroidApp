package com.erikzuo.portfolioandroidapp.data.model

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.Observable

/**
 * Created by Soprano on 6/02/2018.
 */

class MyInfo {
    var name: String? = null
    var email: String? = null
    var title: String? = null
    var avatarUrl: String? = null

    constructor() {}

    constructor(name: String, email: String, title: String, avatarUrl: String) {
        this.name = name
        this.email = email
        this.title = title
        this.avatarUrl = avatarUrl
    }
}
