package com.example.assignment

import android.annotation.SuppressLint
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt

fun Context.getActivity(): ComponentActivity? = when (this) {
    is ComponentActivity -> this
    is ContextWrapper -> baseContext.getActivity()
    else -> null
}
class DangNhap : ComponentActivity() {

    var startForResult: ActivityResultLauncher<Intent>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activity = getActivity()

        startForResult = activity?.registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result: ActivityResult ->
            if (result.resultCode == RESULT_OK) {
                //  you will get result here in result.data
                val data = result.data?.getStringExtra("data")
                Toast.makeText(
                    baseContext,

                    data,
                    Toast.LENGTH_LONG

                ).show()
            }
        }
        setContent() {
            LoginScreen()
        }
    }
}

val KEY_EMAIL = "email"

@Composable
fun DrawLines() {
    Canvas(modifier = Modifier.size(150.dp)) {
        drawLine(
            color = Color.Gray,
            start = Offset(40f, -450f),
            end = Offset(size.width , -450f),
            strokeWidth = 1.dp.toPx()
        )

    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "RememberReturnType")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(startForResult: ActivityResultLauncher<Intent>? = null) {
    val context = LocalContext.current

    var emailValue by remember { mutableStateOf("") }
    var passwordValue by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }


    Scaffold(

    ) {

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {


                DrawLines()
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Your image description",
                    modifier = Modifier
                        .fillMaxSize(0.3f)
                        .offset(x = 5.dp, y = -300.dp)
                )
                DrawLines()
            }
            Text(
                text = "Hello !",
                color = Color.Gray,
                fontWeight = FontWeight.Normal,
                fontSize = 30.sp,
                fontFamily = FontFamily.Serif,
                modifier = Modifier.offset(x = -120.dp, y = -200.dp)
            )
            Text(
                text = "Welcome back !",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                fontFamily = FontFamily.Serif,
                modifier = Modifier.offset(x = -50.dp, y = -150.dp)
            )

            Spacer(modifier = Modifier.height(18.dp))


            TextField(
                value = emailValue,
                colors = TextFieldDefaults.textFieldColors(containerColor = Color.White),
                onValueChange = { emailValue = it },
                label = { Text("Email") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .offset(x = 0.dp, y = -70.dp),

                )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = passwordValue,
                colors = TextFieldDefaults.textFieldColors(containerColor = Color.White),
                onValueChange = { passwordValue = it },
                label = { Text("Password") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .offset(x = 0.dp, y = 10.dp),
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            painter = painterResource(id = if (passwordVisible) R.drawable.eye1 else R.drawable.eye),
                            contentDescription = if (passwordVisible) "Hide password" else "Show password"
                        )
                    }
                }
            )
            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .offset(x = 1.5.dp, y = 60.dp),

                contentAlignment = Alignment.Center
            ) {
                TextButton(
                    onClick = {}
                ) {
                    Text(
                        text = "Forgot Password",
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(top = 25.dp)


                    )
                }
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(48.dp)
                    .offset(x = 1.5.dp, y = 140.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color("#242424".toColorInt())),
                onClick = {
//                    if (emailValue.isNotBlank() && passwordValue.isNotBlank()) {
//                        Toast.makeText(
//                            context, "Login successful",
//                            Toast.LENGTH_LONG
//                        ).show()

                    val intent = Intent(context, Home::class.java)

//                        intent.putExtra(KEY_EMAIL, emailValue)
//
//                        startForResult?.launch(intent)
                    context.startActivity(intent)

//                    } else {
//                        Toast.makeText(
//                            context,
//
//                            "Vui lòng nhập đầy đủ thông tin",
//                            Toast.LENGTH_LONG
//
//                        ).show()
//                    }
                }
            ) {
                Text(
                    text = "Login",
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp

                )
            }


            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .offset(x = 0.dp, y = 180.dp),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
//                        Text(
//                            text = "Bạn chưa có tài khoản ? ",
//                            modifier = Modifier.padding(end = 0.dp)
//                        )
                    TextButton(
                        onClick = {
                            val intent = Intent(context, DangKy::class.java)
                            context.startActivity(intent)
                        }
                    ) {
                        Text(
                            text = "SIGN UP",
                            color = Color.Black,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.padding(top = 25.dp)


                        )
                    }
                }
            }

        }
    }

}



@Preview(showBackground = true)
@Composable
fun PreviewLayout(){
    LoginScreen()
}


