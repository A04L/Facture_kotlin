package com.alexislaborie.projecttd1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun layoutTwo(navController: NavController){
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Bienvenue sur LAYOUT Two", color = Color.Red)
        Spacer(
            modifier = Modifier.height(50.dp)
        )
        Button(onClick = {
            navController.navigate("Layout3")
        }) {
            Text(text = "Aller à LAYOUT 3", fontSize = 25.sp)
        }
    }
}