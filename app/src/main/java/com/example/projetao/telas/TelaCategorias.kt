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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Categoria(
    val nome: String,
    val icone: androidx.compose.ui.graphics.vector.ImageVector,
    val cor: Color
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaCategorias(voltar: () -> Unit) {

    val categorias = listOf(
        Categoria("Perfil", Icons.Default.Person, Color(0xFF5A8C8D)),
        Categoria("Rosto", Icons.Default.Face, Color(0xFF4A7C7D)),
        Categoria("Informações", Icons.Default.Info, Color(0xFF5A8C8D)),
        Categoria("Viagem", Icons.Default.LocationOn, Color(0xFF4A7C7D)),
        Categoria("Dispositivos", Icons.Default.Phone, Color(0xFF5A8C8D)),
        Categoria("Configurações", Icons.Default.Settings, Color(0xFF4A7C7D))
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Categories") },
                navigationIcon = {
                    IconButton(onClick = { voltar() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Voltar")
                    }
                }
            )
        }
    ) { padding ->

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            items(categorias) { categoria ->

                Box(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .fillMaxWidth()
                        .background(categoria.cor),
                    contentAlignment = Alignment.Center
                ) {

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {

                        Icon(
                            imageVector = categoria.icone,
                            contentDescription = categoria.nome,
                            tint = Color.White,
                            modifier = Modifier.size(70.dp)
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = categoria.nome,
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }
    }
}
