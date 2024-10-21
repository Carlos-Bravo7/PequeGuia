package com.duty.pequeguia.data

data class Usuario(
    val email : String,
    val name: String,
    val password: String,
    val image: String,
    val kids:List<Kid>
)
