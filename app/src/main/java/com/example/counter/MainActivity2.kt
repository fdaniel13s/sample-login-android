package com.example.counter

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.counter.ui.theme.CounterTheme

class MainActivity2 : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val user = intent.getStringExtra("username") ?: ""
            val password = intent.getStringExtra("password") ?: ""
            CounterTheme {
                Column {

                TopAppBar(
                    title = {
                        Text("Welcome!")
                    },
                    modifier = Modifier.padding(horizontal = 16.dp),
                    navigationIcon = {
                        Icon(Icons.Filled.Home, contentDescription = "Home")
                    }
                )
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Card(
                        modifier = Modifier
                            .padding(16.dp)
                            .background(Color.White)
                            .border(4.dp, Color.Black  , shape = RoundedCornerShape(16.dp))
                    ) {
                        Text("Hello, $user!", modifier = Modifier.padding(16.dp))
                        Text("Your password is $password", modifier = Modifier.padding(16.dp))
                        Text("Sorry to display your password here, but this is just a demo!", modifier = Modifier.padding(16.dp))
                    }
                }
                }
            }
        }
    }
}
