package com.duty.pequeguia.data

import java.io.Serializable

data class Consejo(
    val id : Int,
    val tittle: String,
    val subtittle: String,
    val content:String,
    val image: Int = 0
): Serializable
