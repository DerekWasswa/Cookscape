package com.rosen.cookscape.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rosen.cookscape.ui.theme.CookscapeTheme
import com.rosen.cookscape.ui.theme.PaleWhite
import com.rosen.cookscape.ui.theme.TransparentPurple

@Composable
fun SearchTextField(
    modifier: Modifier,
    value: String,
    hint : String = "Search",
    onValueChange: (String) -> Unit
) {
    var isHintDisplayed by remember { mutableStateOf(value.isEmpty()) }

    TextField(
        value = value,
        onValueChange = {
            onValueChange(it)
            isHintDisplayed = it.isEmpty()
        },
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp)
            .clip(RoundedCornerShape(25.dp))
            .background(TransparentPurple),
        textStyle = LocalTextStyle.current.copy(color = PaleWhite),
        placeholder = {
            if (isHintDisplayed) {
                Text(
                    text = hint,
                    color = PaleWhite,
                    fontWeight = FontWeight.Normal
                )
            }
        },
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = null, modifier = Modifier.size(24.dp), tint = PaleWhite)
        },
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedContainerColor = TransparentPurple,
            unfocusedContainerColor = TransparentPurple
        )
    )
}

@Preview
@Composable
fun SearchTextFieldPreview() {
    CookscapeTheme {
        var textValue by remember { mutableStateOf("") }
        SearchTextField(modifier = Modifier, value = textValue, onValueChange = { textValue = it })
    }
}