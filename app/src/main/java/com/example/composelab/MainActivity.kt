package com.example.composelab

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composelab.ui.theme.ComposeLabTheme
import kotlin.reflect.typeOf

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLabTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TipScreen()
                }
            }
        }
    }
}

@Composable
fun TipScreen()
{

    var amount by remember { mutableStateOf( "")}
    var tip by remember { mutableStateOf( "")}



    fun Calc(num:Double) {
         tip = "KES" + num.times(0.15).toString()
//        Toast.makeText( tip, Toast.LENGTH_LONG)
//            .show()



    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )

    {
        Text(text = "Tip Calculator")
        TextField(value = amount , onValueChange = {input -> amount = input})
//        TODO
//        keyboardOptions = KeyboardOptions(keyboardType = keyBoard.number)

        Button(onClick = { Calc(amount.toDouble()) })
        {
            Text(text = "Generate")

        }
        Text(text = tip)
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeLabTheme {
        TipScreen()
    }
}