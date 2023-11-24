package com.example.littlelemon

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.littlelemon.ui.theme.karla

@Composable
fun Profile(navController: NavController) {
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences(USER_PROFILE, Context.MODE_PRIVATE)
    val firstName = sharedPreferences.getString(FIRST_NAME, "N/A")
    val lastName = sharedPreferences.getString(LAST_NAME, "N/A")
    val email = sharedPreferences.getString(EMAIL, "N/A")


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Row(Modifier.fillMaxWidth(0.6f)) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Profile Logo",
            )
        }

        Text(
            text = "Profile information",
            textAlign = TextAlign.Start,
            modifier = Modifier.fillMaxWidth().padding(15.dp),
            style = TextStyle(
                fontFamily = karla,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color(0xff495e57)
            )
        )

        Text("First Name: $firstName", modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp),
            style = TextStyle(
                fontFamily = karla,
                fontWeight = FontWeight.SemiBold,
                fontSize = 15.sp,
                color = Color(0xff495e57)
            ))
        Text("Last Name: $lastName", modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp),
            style = TextStyle(
                fontFamily = karla,
                fontWeight = FontWeight.SemiBold,
                fontSize = 15.sp,
                color = Color(0xff495e57)
            ))
        Text("Email: $email", modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp),
            style = TextStyle(
                fontFamily = karla,
                fontWeight = FontWeight.SemiBold,
                fontSize = 15.sp,
                color = Color(0xff495e57)
            ))

        Button(
            onClick = {
                sharedPreferences.edit().clear().apply()

                navController.navigate(OnboardingDestination.route) {
                    popUpTo(OnboardingDestination.route) { inclusive = true }
                }
            },
            colors = ButtonDefaults.buttonColors(Color(0xfff4ce14)),
            modifier = Modifier
                .fillMaxWidth().padding(horizontal = 20.dp)
                .height(50.dp)
        ) {
            Text("Log out", color = Color.Black)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    val navController = rememberNavController()
    Profile(navController)
}



