package com.alexislaborie.projecttd1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun Login(navController: NavController){
    var loginValue by remember {
        mutableStateOf("")
    }
    var mdpValue by remember {
        mutableStateOf("")
    }


    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Connectez-vous", color = Color.Red)
        Spacer(
            modifier = Modifier.height(50.dp)
        )
        OutlinedTextField(
            value = loginValue,
            onValueChange = { loginValue = it },
            label = { Label("Identifiant") }
        )
        Spacer(
            Modifier
                .height(15.dp)
                .fillMaxSize()
        )
        OutlinedTextField(
            value = mdpValue,
            onValueChange = { mdpValue = it },
            label = { Label("Mot de passe") }
        )
        Spacer(
            Modifier
                .height(15.dp)
                .fillMaxSize()
        )
        Button(onClick = {
            if (loginValue == "etudiant" && mdpValue == "azerty") {
                navController.navigate("Facture")
            }

        }) {
            Text(text = "Se connecter", fontSize = 20.sp)
        }
    }
}

@Composable
fun Label(label: String){
    Text(
        text = label,
        modifier = Modifier
    )
}