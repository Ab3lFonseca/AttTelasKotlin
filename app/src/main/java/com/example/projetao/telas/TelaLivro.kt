package com.example.projetao

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaLivro(voltar: () -> Unit) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Book Info") }
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Button(onClick = { voltar() }) {
                Text("⬅ Voltar")
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Surface(
                    shape = CircleShape,
                    color = Color(0xFF2196F3),
                    modifier = Modifier.size(90.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Text("📚", fontSize = 40.sp)
                    }
                }

                Spacer(modifier = Modifier.width(15.dp))

                Column(modifier = Modifier.weight(1f)) {

                    Text("The Silkworm", style = MaterialTheme.typography.titleMedium)
                    Text("Robert Galbraith", style = MaterialTheme.typography.bodySmall)
                    Text("June 19, 2014", style = MaterialTheme.typography.bodySmall)

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(onClick = { }) {
                        Text("READ")
                    }
                }
            }

            Spacer(modifier = Modifier.height(25.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {

                Column(horizontalAlignment = Alignment.CenterHorizontally) {

                    Surface(
                        shape = CircleShape,
                        color = Color(0xFF2196F3),
                        modifier = Modifier.size(60.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Text("4.0", color = Color.White)
                        }
                    }

                    Text("3789 R.", fontSize = 12.sp)
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {

                    Surface(
                        shape = CircleShape,
                        color = Color(0xFF03A9F4),
                        modifier = Modifier.size(60.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Icon(Icons.Default.Search, contentDescription = null, tint = Color.White)
                        }
                    }

                    Text("Review", fontSize = 12.sp)
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {

                    Surface(
                        shape = CircleShape,
                        color = Color(0xFF4CAF50),
                        modifier = Modifier.size(60.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Icon(Icons.Default.ShoppingCart, contentDescription = null, tint = Color.White)
                        }
                    }

                    Text("More", fontSize = 12.sp)
                }
            }

            Spacer(modifier = Modifier.height(25.dp))

            Text(
                "Private investigator Cormoran Strike returns in a new mystery from Robert Galbraith."
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text("READ MORE", color = Color(0xFF2196F3))
        }
    }
}

