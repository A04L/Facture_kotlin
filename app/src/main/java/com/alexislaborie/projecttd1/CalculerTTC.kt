package com.alexislaborie.projecttd1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.navigation.NavController

@Composable
fun Mont(qte:Int?, prix:Float?, tva:Float?, remise:Float?){
    var montantFinal by remember {
        mutableStateOf("")
    }

    val montantTTC = if (qte != null && prix != null && tva != null && remise != null){
        val montantHT = qte * prix
        val montantTVA = montantHT * tva
        val montantRemise = montantHT * remise
        montantHT + montantTVA - montantRemise
    }else{
        montantFinal = "Erreur: Vérifiez les valeurs de qte, prix, tva et remise"
    }
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()){
        Text(
            text = "Montant TTC: $montantTTC",
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(
            Modifier
                .height(30.dp)
                .fillMaxSize()
        )
        OutlinedTextField(
            value = montantFinal,
            onValueChange = { montantFinal = it },
            label = { Text("Label") }
        )
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
