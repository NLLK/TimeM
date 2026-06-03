package com.nllk.timem

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform