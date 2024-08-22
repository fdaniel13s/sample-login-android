package com.example.counter

import android.content.Intent
import android.graphics.drawable.Icon
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.counter.ui.theme.CounterTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CounterTheme {
                var txtUsu by remember { mutableStateOf("") }
                var txtPas by remember { mutableStateOf("") }
                var passwordVisibility by remember { mutableStateOf(false) }
                var showDialog by remember { mutableStateOf(false) }

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TopAppBar(title = { Text(text = "   Login UPC - Challenge Week 2") },
                        navigationIcon = {
                            Icon(
                                imageVector = Icons.Default.Home,
                                contentDescription = "Home"
                            )
                        })


                    val imageModifier: Modifier = Modifier
                        .padding(16.dp)
                        .size(100.dp)
                        .align(Alignment.CenterHorizontally)

                    //Image from Drawable
                    Image(
                        painter = painterResource(id = R.drawable.icon),
                        contentDescription = "Logo",
                        modifier = imageModifier
                    )





                    Card(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = "Welcome to the login",
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                    OutlinedTextField(
                        value = txtUsu,
                        onValueChange = { txtUsu = it },
                        label = { Text("Username") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )
                    OutlinedTextField(
                        value = txtPas,
                        onValueChange = { txtPas = it },
                        label = { Text("Password") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        trailingIcon = {
                            IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                                Icon(
                                    painter = if (passwordVisibility) painterResource(id = R.drawable.eye)
                                    else painterResource(id = R.drawable.visibility_off),
                                    modifier = Modifier.size(24.dp),
                                    contentDescription = "Visibility"
                                )
                            }
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password
                        ),
                        visualTransformation = if (passwordVisibility) VisualTransformation.None
                        else PasswordVisualTransformation()
                    )

                    fun validateUser(): Boolean {
                        return txtUsu == "Jose Perez" && txtPas == "UPC123"
                    }


                    fun onClick() {
                        if (validateUser()) {
                            val navigate = Intent(this@MainActivity,
                                MainActivity2::class.java).apply {
                                    putExtra("username", txtUsu)
                                    putExtra("password", txtPas)
                            }
                            startActivity(navigate)
                        } else {
                            showDialog = true
                        }

                    }

                    Button(onClick = { onClick() }) {
                        Text("Login")
                    }

                    if (showDialog) {
                        AlertDialog(
                            onDismissRequest = { showDialog = true },
                            title = { Text("Error") },
                            text = { Text("Invalid username or password") },
                            confirmButton = {
                                Button(
                                    onClick = { showDialog = false }
                                ) {
                                    Text("Try Again")
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}