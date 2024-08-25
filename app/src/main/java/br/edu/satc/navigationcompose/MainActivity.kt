package br.edu.satc.navigationcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.edu.satc.navigationcompose.ui.theme.NavigationComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationComposeTheme {
                val navigationController = rememberNavController()
                NavHost(navController = navigationController, startDestination = "tela01") {
                    composable("tela01") {
                        Tela01(
                            { navigationController.navigate("tela02") },
                            { navigationController.navigate("tela03") })
                    }
                    composable("tela02") {
                        Tela02(
                            { navigationController.navigate("tela01") },
                            { navigationController.navigate("tela03") })
                    }

                    composable("tela03") {
                        Tela03(
                            { navigationController.navigate("tela01") },
                            { navigationController.navigate("tela02") })
                    }
                }
            }
        }
    }
}

@Composable
fun Tela01(onNavigateToScreen02: () -> Unit, onNavigateToScreen03: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(text = "Tela 01", fontSize = 36.sp, fontFamily = FontFamily.Cursive)
        Button(
            onClick = { onNavigateToScreen02() },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
        ) {
            Text(text = "Tela 2")
        }
        Button(
            onClick = { onNavigateToScreen03() },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
        ) {
            Text(text = "Tela 3")
        }
    }
}

@Composable
fun Tela02(onNavigateToScreen01: () -> Unit, onNavigateToScreen03: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(text = "Tela 02", fontSize = 36.sp, fontFamily = FontFamily.Cursive)
        Button(
            onClick = { onNavigateToScreen01() },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
        ) {
            Text(text = "Tela 1")
        }
        Button(
            onClick = { onNavigateToScreen03() },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
        ) {
            Text(text = "Tela 3")
        }
    }
}

@Composable
fun Tela03(onNavigateToScreen01: () -> Unit, onNavigateToScreen02: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(text = "Tela 03", fontSize = 36.sp, fontFamily = FontFamily.Cursive)
        Button(
            onClick = { onNavigateToScreen01() },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
        ) {
            Text(text = "Tela 1")
        }
        Button(
            onClick = { onNavigateToScreen02() },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
        ) {
            Text(text = "Tela 2")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyPreview() {
    NavigationComposeTheme {
        Tela01({}, {})
    }
}