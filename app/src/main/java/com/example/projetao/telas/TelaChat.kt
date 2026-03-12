package com.example.projetao

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TelaChat(voltar: () -> Unit) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var nome by remember { mutableStateOf("") }
    var isRegistering by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Button(
            onClick = { voltar() },
            modifier = Modifier
                .align(Alignment.Start)
                .padding(16.dp)
        ) {
            Text("⬅ Voltar")
        }

        Spacer(modifier = Modifier.height(30.dp))


        Text(
            text = "💬",
            fontSize = 64.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "Chaff",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1ABC9C)
        )

        Text(
            text = if (isRegistering) "Criar Conta" else "Bem-vindo",
            fontSize = 16.sp,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))


        if (isRegistering) {
            OutlinedTextField(
                value = nome,
                onValueChange = { nome = it },
                label = { Text("Nome Completo") },
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .padding(bottom = 12.dp),
                shape = RoundedCornerShape(8.dp)
            )
        }

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            leadingIcon = {
                Icon(Icons.Default.Email, contentDescription = "Email")
            },
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .padding(bottom = 12.dp),
            shape = RoundedCornerShape(8.dp)
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Senha") },
            leadingIcon = {
                Icon(Icons.Default.Lock, contentDescription = "Senha")
            },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .padding(bottom = 24.dp),
            shape = RoundedCornerShape(8.dp)
        )


        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .height(48.dp)
                .padding(bottom = 12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF1877F2)
            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = "Sign with f",
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        }


        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .height(48.dp)
                .padding(bottom = 24.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF1DA1F2)
            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = "𝕏 Sign with 𝕏",
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        }


        Button(
            onClick = {
                if (!isRegistering) {
                    // Login
                }
            },
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF1ABC9C)
            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = if (isRegistering) "Register" else "Log in",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(20.dp))


        Row(
            modifier = Modifier.padding(20.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = if (isRegistering) "Já tem conta? " else "Não tem conta? ",
                color = Color.Gray,
                fontSize = 14.sp
            )
            TextButton(
                onClick = { isRegistering = !isRegistering }
            ) {
                Text(
                    text = if (isRegistering) "Log in" else "Register",
                    color = Color(0xFF1ABC9C),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
    }
}

