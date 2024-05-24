package com.example.assignment

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.core.graphics.toColorInt




class DetailProduct : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent() {
            DetailScreen()
        }
    }
}

@Composable
fun DetailScreen() {
    val context = LocalContext.current
    var selectedColor by remember { mutableStateOf(Color.Black) }
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .alpha(0.3f)
                .size(400.dp)
        )

        Column(
            modifier = Modifier
                .padding(start = 17.dp, top = 42.dp)
        ) {
            IconButton(
                modifier = Modifier
                    .size(36.dp)
                    .shadow(elevation = 24.dp, shape = RoundedCornerShape(10.dp))
                    .background(color = Color.White, shape = RoundedCornerShape(10.dp)),
                onClick = {
                    val intent = Intent(context, Home::class.java)
                    context.startActivity(intent)
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowLeft,
                    contentDescription = "Back Icon",
                )
            }

            Column(
                modifier = Modifier
                    .padding(end = 10.dp, top = 130.dp)
                    .verticalScroll(rememberScrollState())
                    .padding(bottom = 6.dp)
                    .background(color = Color.White)
            ) {

                ProductColor(
                    color = Color(android.graphics.Color.parseColor("#FFFFFF")),
                    isSelected = selectedColor == Color(android.graphics.Color.parseColor("#FFFFFF")),
                    modifier = Modifier.size(40.dp).zIndex(1f)
                ) {
                    selectedColor = Color(android.graphics.Color.parseColor("#FFFFFF"))
                }

                ProductColor(
                    color = Color(android.graphics.Color.parseColor("#B4916C")),
                    isSelected = selectedColor == Color(android.graphics.Color.parseColor("#B4916C")),
                    modifier = Modifier.size(40.dp).zIndex(1f)
                ) {
                    selectedColor = Color(android.graphics.Color.parseColor("#B4916C"))
                }

                ProductColor(
                    color = Color(android.graphics.Color.parseColor("#E4CBAD")),
                    isSelected = selectedColor == Color(android.graphics.Color.parseColor("#E4CBAD")),
                    modifier = Modifier.size(40.dp).zIndex(1f)
                ) {
                    selectedColor = Color(android.graphics.Color.parseColor("#E4CBAD"))
                }
            }
        }


        Column {

                Image(
                    modifier = Modifier
                        .padding(start = 80.dp)
                        .size(440.dp),
                    painter = painterResource(id = R.drawable.sp2),
                    contentDescription = "Product Image"
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 22.dp)
                        .padding(top = 48.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(
                            text = "Minimal Stand",
                            fontSize = 24.sp,
                            fontFamily = FontFamily.Serif,
                            fontWeight = FontWeight.Medium,
                            style = TextStyle(
                                platformStyle = PlatformTextStyle(
                                    includeFontPadding = false
                                )
                            )
                        )

                        Text(
                            text = "$ 50",
                            fontSize = 30.sp,
                            modifier = Modifier.padding(top = 15.dp),
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Medium,
                            style = TextStyle(
                                platformStyle = PlatformTextStyle(
                                    includeFontPadding = false
                                )
                            )
                        )

//                    Text(
//                        modifier = Modifier
//                            .padding(top = 2.dp),
////                        text = "Product ${product.name}",
//                        text = "",
//                        fontSize = 22.sp,
//                        style = TextStyle(
//                            platformStyle = PlatformTextStyle(
//                                includeFontPadding = false
//                            )
//                        )
//                    )

                        Row(
                            modifier = Modifier
                                .padding(top = 15.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                modifier = Modifier
                                    .size(18.dp),
                                imageVector = Icons.Outlined.Star,
                                contentDescription = "Rating Icon",
                                tint = Color.Yellow
                            )

                            Text(
                                modifier = Modifier
                                    .padding(start = 4.dp),
                                textAlign = TextAlign.Center,
//                            text = product.rating.toString(),
                                text = "4.5",
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                                style = TextStyle(
                                    platformStyle = PlatformTextStyle(
                                        includeFontPadding = false
                                    )
                                )
                            )

                            Text(
                                modifier = Modifier
                                    .padding(start = 24.dp),
                                textAlign = TextAlign.Center,
//                            text = product.rating.toString(),
                                text = "(50 reviews)",
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp,
                                color = Color.Gray,
                                style = TextStyle(
                                    platformStyle = PlatformTextStyle(
                                        includeFontPadding = false
                                    )
                                )
                            )
                        }
                    }

                    Text(
                        modifier = Modifier
                            .padding(top = 4.dp),
//                    text = "$${product.price}",
                        text = "",
                        fontSize = 36.sp,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        )
                    )

                    IconButton(
                        modifier = Modifier
                            .padding(start = 22.dp)
                            .padding(top = 35.dp)
                            .shadow(elevation = 24.dp, shape = RoundedCornerShape(8.dp))
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
                            .padding(start = 15.dp)
                            .padding(top = 35.dp)
                            .shadow(elevation = 24.dp, shape = RoundedCornerShape(8.dp))
                            .background(
                                color = Color.White,
                                shape = RoundedCornerShape(5.dp)
                            )
                            .size(36.dp),
                        onClick = {}
                    ) {
                        Text(
                            text = "01",
                            fontSize = 20.sp,
                            style = MaterialTheme.typography.body1,
                            modifier = Modifier.padding(0.dp),
                        )
                    }

                    IconButton(
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .padding(top = 35.dp)
                            .shadow(elevation = 24.dp, shape = RoundedCornerShape(8.dp))
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
                            style = MaterialTheme.typography.body1,
                            modifier = Modifier.padding(0.dp),
                        )
                    }

                }


                Text(
                    modifier = Modifier
                        .padding(horizontal = 22.dp)
                        .padding(top = 24.dp),
                    text = "Minimal Stand is made of by natural wood. The design that is very simple and minimal. This is truly one of the best furnitures in any family for now. With 3 different colors, you can easily select the best match for your home. ",
                    lineHeight = 20.sp,
                    fontSize = 14.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.Justify,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    )
                )

                Spacer(modifier = Modifier.weight(1.0f))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp)
                        .padding(bottom = 24.dp)
                ) {
                    IconButton(
                        modifier = Modifier
                            .padding(start = 0.dp, end = 5.dp)
                            .padding(top = 5.dp)
                            .shadow(elevation = 24.dp, shape = RoundedCornerShape(8.dp))
                            .background(
                                color = Color(android.graphics.Color.parseColor("#E0E0E0")),
                                shape = RoundedCornerShape(5.dp)
                            )
                            .size(43.dp),
                        onClick = { }
                    ) {
                        Icon(
                            modifier = Modifier.size(24.dp),
                            painter = painterResource(R.drawable.favorite),
                            contentDescription = "Favorite Icon",
                        )
                    }

                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                            .padding(start = 8.dp)
                            .background(color = Color.Black, shape = RectangleShape),
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color("#242424".toColorInt())),
                        onClick = {
                            val intent = Intent(context, GioHang::class.java)

                            context.startActivity(intent)
                        }
                    ) {
                        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
                        Text(
                            text = "Add to cart",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }
        }


    }

    @Composable
    fun ProductColor(
        modifier: Modifier = Modifier,
        color: Color,
        isSelected: Boolean,
        onClick: () -> Unit
    ) {
        val borderColor = if (isSelected) Color(android.graphics.Color.parseColor("#CCCCCC")) else Color.Transparent

        Box(
            modifier = modifier
                .border(width = 3.dp, color = borderColor,shape = CircleShape)
                .padding(3.dp)
                .background(color, shape = CircleShape)
                .size(12.dp)
                .clickable(
                    onClick = onClick
                )
        )
    }

@Preview(showBackground = true)
@Composable
fun PreviewLayout4(){
    DetailScreen()
}
