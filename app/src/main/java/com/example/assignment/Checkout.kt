package com.example.assignment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Checkout : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent(){
            CheckoutScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CheckoutScreen(){
    val context = LocalContext.current
    Scaffold(
        topBar = @Composable {
            SmallTopAppBar(
                title = {
                    Text(
                        text = "Check out",
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Serif,
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        val intent = Intent(context, GioHang::class.java)
                        context.startActivity(intent)
                    }) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowLeft,
                            contentDescription = "Back"
                        )
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    titleContentColor = MaterialTheme.colorScheme.onSurface
                )
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 70.dp)
                .background(Color.White),
//            contentAlignment = Alignment.TopCenter
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 0.dp, start = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Shipping Adress",
                    style = TextStyle(fontSize = 20.sp),
                    color = Color.Gray,
                    fontWeight = FontWeight.SemiBold
                )
                IconButton(onClick = {
//                    val intent = Intent(context, Congrats::class.java)
//                    context.startActivity(intent)
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.edit),
                        contentDescription = "Edit",
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

            Box(modifier = Modifier
                .padding(start = 20.dp, top = 60.dp, end = 20.dp)
                .background(Color(0xFFF8F8FF))
            ) {


                Text(
                    text = "Bruno Fernandes",
                    style = TextStyle(fontSize = 20.sp),
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(top = 20.dp, start = 20.dp)
                )
                Text(
                    text = "25 rue Robert Latouche, Nice, 06200, Côte D’azur, France",
                    style = TextStyle(fontSize = 16.sp),
                    color = Color.Gray,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(top = 60.dp, start = 20.dp, bottom = 10.dp)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 200.dp, start = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Payment",
                    style = TextStyle(fontSize = 20.sp),
                    color = Color.Gray,
                    fontWeight = FontWeight.SemiBold
                )
                IconButton(onClick = {
//                    val intent = Intent(context, GioHang::class.java)
//                    context.startActivity(intent)
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.edit),
                        contentDescription = "Edit",
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

            Box(modifier = Modifier
                .padding(start = 20.dp, top = 260.dp, end = 20.dp)
                .size(height = 60.dp, width = 400.dp)
                .background(Color(0xFFF8F8FF))
            ) {


                Row(

                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.mastercard),
                        contentDescription = "Edit",
                        modifier = Modifier.size(50.dp).padding(top = 20.dp, start = 20.dp)
                    )
                    Text(
                        text = "**** **** **** 3947",
                        style = TextStyle(fontSize = 20.sp),
                        color = Color.Gray,
                        modifier = Modifier.padding(top = 20.dp, start = 20.dp),
                        fontWeight = FontWeight.SemiBold,
                    )
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 450.dp, start = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Delivery method",
                style = TextStyle(fontSize = 20.sp),
                color = Color.Gray,
                fontWeight = FontWeight.SemiBold
            )
            IconButton(onClick = {
//                    val intent = Intent(context, GioHang::class.java)
//                    context.startActivity(intent)
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.edit),
                    contentDescription = "Edit",
                    modifier = Modifier.size(20.dp)
                )
            }
        }

        Box(modifier = Modifier
            .padding(start = 20.dp, top = 500.dp, end = 20.dp)
            .size(height = 60.dp, width = 400.dp)
            .background(Color(0xFFF8F8FF))
        ) {

            Row(

                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.dhl),
                    contentDescription = "Edit",
                    modifier = Modifier.size(100.dp).padding(top = 5.dp, start = 20.dp)
                )
                Text(
                    text = "Fast (2-3 days)",
                    style = TextStyle(fontSize = 20.sp),
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 20.dp, start = 20.dp),
                    fontWeight = FontWeight.SemiBold,
                )
            }
        }


        Box(modifier = Modifier
            .padding(start = 20.dp, top = 580.dp, end = 20.dp)
            .size(height = 150.dp, width = 400.dp)
            .background(Color(0xFFF8F8FF))
        ) {

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Order : ",
                    style = TextStyle(fontSize = 20.sp),
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 20.dp, start = 20.dp),
                    fontWeight = FontWeight.SemiBold,
                )
                Text(
                    text = "$ 57.00",
                    style = TextStyle(fontSize = 20.sp),
                    color = Color.Black,
                    modifier = Modifier.padding(top = 20.dp, start = 20.dp),
                    fontWeight = FontWeight.SemiBold,
                )
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Delivery : ",
                    style = TextStyle(fontSize = 20.sp),
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 50.dp, start = 20.dp),
                    fontWeight = FontWeight.SemiBold,
                )
                Text(
                    text = "$ 5.00",
                    style = TextStyle(fontSize = 20.sp),
                    color = Color.Black,
                    modifier = Modifier.padding(top = 50.dp, start = 20.dp),
                    fontWeight = FontWeight.SemiBold,
                )
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Total : ",
                    style = TextStyle(fontSize = 20.sp),
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 80.dp, start = 20.dp),
                    fontWeight = FontWeight.SemiBold,
                )
                Text(
                    text = "$ 62.00",
                    style = TextStyle(fontSize = 20.sp),
                    color = Color.Black,
                    modifier = Modifier.padding(top = 80.dp, start = 20.dp),
                    fontWeight = FontWeight.SemiBold,
                )
            }

            Button(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .height(60.dp)
                    .offset(x = 1.5.dp, y = 150.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color("#242424".toColorInt())),
                onClick = {


                val intent = Intent(context, Congrats::class.java)

                context.startActivity(intent)


                }
            ) {
                Text(
                    text = "SUBMIT ORDER",
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp

                )
            }
        }
    }
    }




@Preview(showBackground = true)
@Composable
fun PreviewLayout6(){
    CheckoutScreen()
}