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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidinterviewapplication.R.string.buttonString
import com.example.androidinterviewapplication.R.string.textFieldLabel
import com.example.androidinterviewapplication.ui.theme.AndroidInterviewApplicationTheme
import java.util.*

@Composable
fun StringValidatedView() {
    // TODO center column both horizontally and vertically
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        var stringToValidate by remember { mutableStateOf("") }
        var isValid by remember { mutableStateOf(false) }

        // TODO change this to an outlined text field
        // TODO add label to text field and extract string to strings.xml
        // TODO add padding of 16dp
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

        // TODO change color of button to Colors.Blue
        // TODO add padding of 16dp
        Button(
            colors = ButtonDefaults.buttonColors(Color.Blue),
            modifier = Modifier.padding(16.dp),
            onClick = { isValid = bracketValidator(stringToValidate) }
        ) {
            // TODO extract string to strings.xml
            Text(text = stringResource(buttonString))
        }

        // TODO make the text italic
        // TODO make the text bold
        // TODO add padding of 16dp
        Text(
            isValid.toString(),
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidInterviewApplicationTheme {
        StringValidatedView()
    }
}

// TODO add logic to validate brackets
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