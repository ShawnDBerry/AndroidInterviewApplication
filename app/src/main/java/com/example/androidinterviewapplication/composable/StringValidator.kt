package com.example.androidinterviewapplication.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.androidinterviewapplication.R.string.buttonString
import com.example.androidinterviewapplication.R.string.textFieldLabel
import java.util.*

@Composable
fun StringValidatedView() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        var stringToValidate by remember { mutableStateOf("") }
        var isValid by remember { mutableStateOf(false) }

        TextField(
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Blue,
                unfocusedBorderColor = Color.Black
            ),
            label = { Text(stringResource(textFieldLabel)) },
            modifier = Modifier.padding(16.dp),
            value = stringToValidate,
            onValueChange = { stringToValidate = it }
        )

        Button(
            colors = ButtonDefaults.buttonColors(Color.Blue),
            modifier = Modifier.padding(16.dp),
            onClick = { isValid = bracketValidator(stringToValidate) }
        ) {
            Text(text = stringResource(buttonString))
        }

        Text(
            isValid.toString(),
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )
    }
}

fun bracketValidator(vString: String): Boolean {
    val map = HashMap<Char, Char>()
    map['('] = ')'
    map['['] = ']'
    map['{'] = '}'
    val brackets = ArrayDeque<Char>()
    for (b in vString.toCharArray()) {
        if (map.containsKey(b))
            brackets.push(b)
        else if (!brackets.isEmpty() && map[brackets.peek()] == b)
            brackets.pop()
        else
            return false
    }
    return brackets.isEmpty()
}