package sdim.example.cats.model

import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.IntegerRes
import androidx.annotation.StringRes

interface ResourcesManager {
    fun getString(@StringRes stringId: Int): String?
    fun getInt(@IntegerRes intId: Int): Int

    @ColorInt
    fun getColor(@ColorRes color: Int): Int
}