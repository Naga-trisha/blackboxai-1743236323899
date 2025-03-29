package com.example.myapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.myapp.ui.theme.MyAppTheme

@Composable
fun DetailScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text("Detail Screen")
        Button(onClick = { navController.popBackStack() }) {
            Text("Go Back")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    MyAppTheme {
        // Preview won't show NavController
        Column(modifier = Modifier.fillMaxSize()) {
            Text("Detail Screen Preview")
        }
    }
}