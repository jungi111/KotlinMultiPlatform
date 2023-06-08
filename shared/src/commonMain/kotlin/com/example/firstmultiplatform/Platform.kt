package com.example.firstmultiplatform

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform