package com.erikzuo.portfolioandroidapp.data.model

/**
 * Created by Soprano on 9/02/2018.
 */

class Education {
    var name: String? = null
    var degree: String? = null
    var major: String? = null
    var from: Long = 0
    var to: Long = 0

    constructor() {}

    constructor(name: String, degree: String, major: String, from: Long, to: Long) {
        this.name = name
        this.degree = degree
        this.major = major
        this.from = from
        this.to = to
    }
}
