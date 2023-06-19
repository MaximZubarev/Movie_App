package com.mldz.feature_main_impl.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mldz.core_design.R
import com.mldz.core_design.theme.White05


@Composable
fun TopBar() {
    Column(
        modifier = Modifier.padding(
            start = paddingHorizontal,
            end = paddingHorizontal,
        )
    ) {
        Row {
            Greeting(
                modifier = Modifier.weight(1f)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .width(24.dp)
                    .height(24.dp)
            )
        }
//        Search(modifier = Modifier.padding(top = 21.dp))
    }
}

@Preview
@Composable
fun TopBarPreview() {
    TopBar()
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(id = R.string.greeting_title),
        fontSize = 18.sp,
        color = Color.White,
        fontWeight = FontWeight.Medium,
        modifier = modifier
    )
}

@Composable
fun Search(modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text(text = stringResource(id = R.string.search)) },
        modifier = modifier.fillMaxWidth(),
        leadingIcon = {
            Image(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = ""
            )
        },
        textStyle = TextStyle(color = White05, fontWeight = FontWeight.Normal),
        singleLine = true,
        maxLines = 1,
        shape = RoundedCornerShape(15.dp),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.White,
            cursorColor = Color.White,
            focusedIndicatorColor = Color.White.copy(alpha = 0.2f),
            focusedLabelColor = White05,
        )
    )
}