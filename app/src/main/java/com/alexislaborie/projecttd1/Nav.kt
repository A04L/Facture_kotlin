package com.alexislaborie.projecttd1

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Nav(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Login"){
        composable(route = "Login"){
            Login(navController)
        }
        composable(route = "Facture"){
            Fact(navController)
        }
        composable(route = "Layout1"){
            layoutOne(navController)
        }
        composable(route = "Layout2"){
            layoutTwo(navController)
        }
        composable(route = "Layout3"){
            layoutThree(navController)
        }
        composable("RCalculerTTC/{qte1}/{prix1}/{tva1}/{remise1}",
            arguments = listOf(
                navArgument(name="qte1"){
                    type= NavType.IntType
                },
                navArgument(name="prix1"){
                    type= NavType.FloatType
                },
                navArgument(name="tva1"){
                    type= NavType.FloatType
                },
                navArgument(name="remise1"){
                    type= NavType.FloatType
                }
            )
        )
        {backstraEntry -> //envois les données type int ou float vers la page choisis
                Mont(
                    qte = backstraEntry.arguments?.getInt("qte1"),
                    prix = backstraEntry.arguments?.getFloat("prix1"),
                    tva = backstraEntry.arguments?.getFloat("tva1"),
                    remise = backstraEntry.arguments?.getFloat("remise1"),
                )
        }
    }
}


