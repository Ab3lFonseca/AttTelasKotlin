package com.example.projetao

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Categoria(
    val nome: String,
    val icone: androidx.compose.ui.graphics.vector.ImageVector,
    val cor: Color
)

@Composable
fun TelaCategorias(voltar: () -> Unit) {

    val categorias = listOf(
        Categoria("Woman", Icons.Default.Person, Color(0xFF6F8E8F)),
        Categoria("Man", Icons.Default.Person, Color(0xFF5F7F80)),
        Categoria("Baby", Icons.Default.Person, Color(0xFF4F6F70)),
        Categoria("Travel", Icons.Default.Person, Color(0xFF3F5F60)),
        Categoria("Tech", Icons.Default.Person, Color(0xFF2F4F50)),
        Categoria("Food&Drink", Icons.Default.Person, Color(0xFF203F40))
    )

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Button(
            onClick = { voltar() },
            modifier = Modifier.padding(10.dp)
        ) {
            Text("⬅ Voltar")
        }

        Text(
            text = "Categorias",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            items(categorias) { categoria ->

                Box(
                    modifier = Modifier
                        .height(150.dp)
                        .fillMaxWidth()
                        .background(categoria.cor),
                    contentAlignment = Alignment.Center
                ) {

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Icon(
                            imageVector = categoria.icone,
                            contentDescription = categoria.nome,
                            tint = Color.White,
                            modifier = Modifier.size(40.dp)
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = categoria.nome,
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}
