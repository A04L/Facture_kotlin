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
        composable(route = "CalculerTTC"){
            Mont(navController)
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
        composable("total/{qte}/{prix}/{montant}/{tva}/{remise}/",
            arguments = listOf(
                navArgument(name="qte"){
                    type= NavType.IntType
                },
                navArgument(name="prix"){
                    type= NavType.FloatType
                },
                navArgument(name="montant"){
                    type= NavType.FloatType
                },
                navArgument(name="tva"){
                    type= NavType.IntType
                },
                navArgument(name="remise"){
                    type= NavType.IntType
                },
            )
        )
        {
            backstraEntry -> //envois les données type int ou float vers la page choisis
                Mont(
                    quantité = backstraEntry.arguments?.getInt("qte"),
                    prix = backstraEntry.arguments?.getInt("prix"),
                )
        }
    }
}


