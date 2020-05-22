package com.lroap.prettyseattle.model

import java.io.Serializable
import java.util.*


class Event : Serializable {
    lateinit var activityname: String
    lateinit var placename:String
    lateinit var description:String
    lateinit var tag: String
    lateinit var datetime: Date

}