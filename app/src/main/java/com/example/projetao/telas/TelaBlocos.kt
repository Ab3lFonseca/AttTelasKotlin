package com.example.projetao

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TelaBlocos(voltar: () -> Unit) {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Button(
            onClick = { voltar() },
            modifier = Modifier.padding(10.dp)
        ) {
            Text("⬅ Voltar")
        }

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {

            // COLUNA ESQUERDA
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            ) {

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .background(Color(0xFF6A7DB3))
                )

                Spacer(modifier = Modifier.height(4.dp))

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .background(Color(0xFFD64F8E))
                )
            }

            Spacer(modifier = Modifier.width(4.dp))

            // COLUNA DIREITA
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            ) {

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .background(Color(0xFFB51222))
                )

                Spacer(modifier = Modifier.height(4.dp))

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .background(Color.LightGray)
                )

                Spacer(modifier = Modifier.height(4.dp))

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .background(Color(0xFF1E2E6E))
                )
            }
        }
    }
}