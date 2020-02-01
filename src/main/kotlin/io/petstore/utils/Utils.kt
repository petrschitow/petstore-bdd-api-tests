package io.swagger.petstore.utils

import java.lang.Math.random

open class Utils {

    fun getRandom(from: Int = 0, to: Int = 1_000_000): Int{
        return (from..to).random()
    }
}