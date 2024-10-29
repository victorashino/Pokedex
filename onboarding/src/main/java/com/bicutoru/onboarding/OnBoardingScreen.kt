package com.bicutoru.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun OnBoardingScreen(
    navController: NavController
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFEFFF0)),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "Pokédex",
            fontSize = 74.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFFE70000),
            modifier = Modifier.padding(top = 128.dp)
        )

        Spacer(modifier = Modifier.weight(0.27f))

        Button(
            onClick = { navController.navigate(Screen.PokeList.route) },
            modifier = Modifier
                .padding(bottom = 64.dp)
                .size(width = 180.dp, height = 50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF69CDE3)
            ),
            elevation = ButtonDefaults.buttonElevation(1.dp)
        ) {
            Text(
                text = "Start",
                fontWeight = FontWeight.Medium,
                fontSize = 24.sp
            )
        }

        Spacer(modifier = Modifier.weight(0.14f))

        Text(
            text = "By Victor Ashino",
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 48.dp)
        )


    }
}