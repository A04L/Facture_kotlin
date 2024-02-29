package com.alexislaborie.projecttd1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
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
fun Fact(navController: NavController) {
    var quantite by remember {
        mutableStateOf("")
    }
    var prix by remember {
        mutableStateOf("")
    }
    var montant by remember{
    mutableStateOf("")
        }
    var tva by remember {
        mutableStateOf("")
    }
    var remise by remember {
        mutableStateOf("")
    }

    val montantHT = derivedStateOf {
        val quantiteValue = quantite.toFloatOrNull() ?: 0f
        val prixValue = prix.toFloatOrNull() ?: 0f
        quantiteValue * prixValue
    }
    montant = montantHT.value.toString()

    val tvaValue = derivedStateOf {
        montantHT.value * 0.20f // Calcul de la TVA à partir du montant HT (20%)
    }

    tva = tvaValue.value.toString()

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    )
    {
        Text(
            text = "Facture", color = Color.Red,
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(
            Modifier
                .height(30.dp)
                .fillMaxSize()
        )
        OutlinedTextField(
            value = quantite,
            onValueChange = { quantite = it },
            label = { Label("Quantité") }
        )
        Spacer(
            Modifier
                .height(15.dp)
                .fillMaxSize()
        )
        OutlinedTextField(
            value = prix,
            onValueChange = { prix = it },
            label = { Label("Prix unitaire") }
        )
        Spacer(
            Modifier
                .height(15.dp)
                .fillMaxSize()
        )
        OutlinedTextField(
            value = montant,
            onValueChange = { montant = it },
            label = { Label("Montant HT :") }
        )
        Spacer(
            Modifier
                .height(15.dp)
                .fillMaxSize()
        )
        OutlinedTextField(
            value = tva,
            onValueChange = { tva = it },
            label = { Label("Taux TVA") }
        )
        Spacer(
            Modifier
                .height(15.dp)
                .fillMaxSize()
        )
        OutlinedTextField(
            value = remise,
            onValueChange = { remise = it },
            label = { Label("remise") }
        )
        Spacer(
            Modifier
                .height(15.dp)
                .fillMaxSize()
        )
        Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()){
            ElevatedButton(onClick = {

            }) {
                Text(text = "Fidèle", fontSize = 20.sp)
            }
            Spacer(
                Modifier
                    .width(15.dp)
            )
            Spacer(
                Modifier
                    .height(105.dp)
            )
            ElevatedButton(onClick = {

            }) {
                Text(text = "Non Fidèle", fontSize = 20.sp)
            }
        }
        ElevatedButton(onClick = {
            navController.navigate("RCalculerTTC/$quantite/$prix/$tva/$remise")
        }) {
            Text(text = "Calculer TTC", fontSize = 20.sp)
        }
        Spacer(
            Modifier
                .height(15.dp)
                .fillMaxSize()
        )
        ElevatedButton(onClick = {

        }) {
            Text(text = "Remise A Zéro", fontSize = 20.sp)
        }
    }



}