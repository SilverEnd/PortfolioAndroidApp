package com.erikzuo.portfolioandroidapp.data.model

import com.google.gson.annotations.SerializedName

import java.security.acl.Owner

/**
 * Created by YifanZuo on 7/02/2018.
 */

class Repo(var id: Int, @field:SerializedName("name")
var name: String?, @field:SerializedName("full_name")
           var fullName: String?, @field:SerializedName("description")
           var description: String?, @field:SerializedName("html_url")
           var link: String?)
