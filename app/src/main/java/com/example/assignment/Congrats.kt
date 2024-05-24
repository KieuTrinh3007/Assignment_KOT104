package com.example.assignment

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Congrats : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent(){
            CongratsScreen()
        }
    }
}

@Composable
fun CongratsScreen(){
    val context = LocalContext.current
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "SUCCESS !",
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp,
            fontFamily = FontFamily.Serif,
            modifier = Modifier.offset(x = 0.dp, y = -200.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.logo2),
            contentDescription = "Your image description",
            modifier = Modifier
                .fillMaxSize(0.5f)
                .offset(x = 5.dp, y = -70.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.tick),
            contentDescription = "Your image description",
            modifier = Modifier
                .fillMaxSize(0.1f)
                .offset(x = 5.dp, y = 30.dp)
        )
        Text(
            text = "Your order will be delivered soon.\n Thank you for choosing our app!",
            color = Color.Gray,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp,
            fontFamily = FontFamily.Default,
            modifier = Modifier.offset(x = 0.dp, y = 90.dp)
        )

        Button(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .height(60.dp)
                .offset(x = 1.5.dp, y = 180.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color("#242424".toColorInt())),
            onClick = {


//                val intent = Intent(context, Checkout::class.java)
//
//                context.startActivity(intent)


            }
        ) {
            Text(
                text = "Track your oders",
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp

            )
        }

        Button(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .height(60.dp)
                .offset(x = 1.5.dp, y = 260.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color("#E0E0E0".toColorInt())),
            onClick = {


                val intent = Intent(context, Home::class.java)

                context.startActivity(intent)


            }
        ) {
            Text(
                text = "BACK TO HOME",
                color = Color.Black,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp

            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLayout7(){
    CongratsScreen()
}