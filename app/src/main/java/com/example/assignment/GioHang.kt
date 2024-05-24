package com.example.assignment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
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

class GioHang : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent(){
            CartScreen()
        }
    }
}

data class Cart(val id: Int, val name: String, @DrawableRes val imageResource: Int, val price: String)


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen() {

    val context = LocalContext.current
    var code by remember { mutableStateOf("") }

    Scaffold(
        topBar = @Composable {
            SmallTopAppBar(
                title = {
                    Text(
                        text = "My cart",
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Serif,
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        val intent = Intent(context, DangNhap::class.java)
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
            contentAlignment = Alignment.TopCenter
        ) {
            AddCart()

        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 600.dp)
                .background(Color.White),
            contentAlignment = Alignment.TopCenter
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                OutlinedTextField(
                    value = code,
                    onValueChange = { code = it },
                    label = { Text(text = "Enter your promo code") },
                    modifier = Modifier.weight(1f)
                )

                IconButton(
                    modifier = Modifier
                        .padding(start = 15.dp, end = 5.dp, top = 10.dp)
                        .padding(top = 5.dp)
                        .shadow(elevation = 24.dp, shape = RoundedCornerShape(8.dp))
                        .background(
                            color = Color(android.graphics.Color.parseColor("#303030")),
                            shape = RoundedCornerShape(5.dp)
                        )
                        .size(43.dp),
                    onClick = { }
                ) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        imageVector = Icons.Filled.KeyboardArrowRight,
                        tint = Color.White,
                        contentDescription = "Favorite Icon",
                    )
                }

        }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 100.dp, start = 20.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = "Total",
                    style = TextStyle(fontSize = 20.sp),
                    color = Color.Gray,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "$ 57.00",
                    style = TextStyle(fontSize = 20.sp),
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(start = 240.dp),


                    )
            }

            Button(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(48.dp)
                    .offset(x = 1.5.dp, y = 140.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color("#242424".toColorInt())),
                onClick = {


                    val intent = Intent(context, Checkout::class.java)

                    context.startActivity(intent)


                }
            ) {
                Text(
                    text = "Check out",
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp

                )
            }
        }
    }
}

@Composable
fun AddCart() {
    val productList = listOf(
        Cart(1,"Black Simple Lamp", R.drawable.sp1, "$ 12.00"),
        Cart(2,"Minimal Stand", R.drawable.sp2, "$ 25.00"),
        Cart(3,"Coffee Chair", R.drawable.sp3, "$ 20.00"),

        // Thêm các sản phẩm khác vào đây
    )

//    val selectedProduct = remember { mutableStateOf<Product?>(null) }
    LazyColumn {
        itemsIndexed(items = productList.chunked(1)) { index, products ->
            Row(Modifier.fillMaxWidth()) {
                products.forEach { product ->
                    CartItem(product)
                }
            }
        }
    }

    }



@Composable
fun CartItem(product: Cart) {
    val context = LocalContext.current
    Column(Modifier.padding(8.dp)) {
        Row(
            Modifier
                .fillMaxWidth()
                .background(color = Color.White)

        ) {
            Image(
                painter = painterResource(id = product.imageResource),
                contentDescription = null,
                modifier = Modifier
                    .width(150.dp)
                    .height(120.dp)
                    .padding(vertical = 10.dp)
                    .clip(shape = RoundedCornerShape(20.dp))
            )
            Column(
                modifier = Modifier
                    .padding(start = 7.dp, top = 10.dp)
//                    .align(Alignment.CenterVertically)
            ) {


                    Text(
                        text = product.name,
                        style = TextStyle(fontSize = 16.sp),
                        color = Color.Gray,
                        fontWeight = FontWeight.SemiBold
                    )




                Text(
                    text = product.price,
                    style = TextStyle(fontSize = 18.sp, color = Color.Gray),
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )

                Row(
                    modifier = Modifier
                        .padding(top = 15.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    IconButton(
                        modifier = Modifier
                            .padding(start = 7.dp)
                            .padding(top = 10.dp)
//                            .shadow(elevation = 24.dp, shape = RoundedCornerShape(8.dp))
                            .background(
                                color = Color(android.graphics.Color.parseColor("#E0E0E0")),
                                shape = RoundedCornerShape(5.dp)
                            )
                            .size(36.dp),
                        onClick = {}
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Add,
                            contentDescription = "Back Icon",
                        )
                    }

                    IconButton(
                        modifier = Modifier
                            .padding(start = 18.dp)
                            .padding(top = 10.dp)
//                            .shadow(elevation = 24.dp, shape = RoundedCornerShape(8.dp))
                            .background(
                                color = Color.White,
                                shape = RoundedCornerShape(5.dp)
                            )
                            .size(36.dp),
                        onClick = {}
                    ) {
                        Text(
                            text = "01",
                            fontSize = 16.sp,
                            style = androidx.compose.material.MaterialTheme.typography.body1,
                            modifier = Modifier.padding(0.dp),
                        )
                    }

                    IconButton(
                        modifier = Modifier
                            .padding(start = 18.dp)
                            .padding(top = 10.dp)
//                            .shadow(elevation = 24.dp, shape = RoundedCornerShape(8.dp))
                            .background(
                                color = Color(android.graphics.Color.parseColor("#E0E0E0")),
                                shape = RoundedCornerShape(5.dp)
                            )
                            .size(36.dp),
                        onClick = {}
                    ) {
                        Text(
                            text = "-",
                            fontSize = 30.sp,
                            style = androidx.compose.material.MaterialTheme.typography.body1,
                            modifier = Modifier.padding(0.dp),
                        )
                    }

                }
                }

            IconButton(onClick = {
//                val intent = Intent(context, GioHang::class.java)
//                context.startActivity(intent)
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.delete),
                    contentDescription = "Huy",
                    modifier = Modifier.size(19.dp)
                )
            }
            }
        }
    }




@Preview(showBackground = true)
@Composable
fun PreviewLayout5(){
    CartScreen()
}

