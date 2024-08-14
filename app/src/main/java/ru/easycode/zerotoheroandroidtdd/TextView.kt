package ru.easycode.zerotoheroandroidtdd

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

class TextView {
    
    @Composable
    fun setTexView(text: String) {
        Row {
            Text(text = text)
        }
    }
}