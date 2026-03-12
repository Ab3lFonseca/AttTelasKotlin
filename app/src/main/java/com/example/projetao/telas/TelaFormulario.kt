package com.example.projetao

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Calendar

@Composable
fun TelaFormulario(voltar: () -> Unit) {

    var title by remember { mutableStateOf("") }
    var statusSelecionado by remember { mutableStateOf(false) }
    var prioritySelecionada by remember { mutableStateOf("High") }
    var dataSelecionada by remember { mutableStateOf("Escolha uma data") }
    var horaSelecionada by remember { mutableStateOf("Escolha um horário") }
    var mensagem by remember { mutableStateOf("") }

    val context = LocalContext.current
    val calendar = Calendar.getInstance()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {

        Button(onClick = { voltar() }) {
            Text("⬅ Voltar")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Criar Atividade",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text("Título", fontWeight = FontWeight.Bold)

        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Digite o título") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("Status", fontWeight = FontWeight.Bold)

        Row(verticalAlignment = Alignment.CenterVertically) {

            RadioButton(
                selected = !statusSelecionado,
                onClick = { statusSelecionado = false }
            )
            Text("Concluído")

            Spacer(modifier = Modifier.width(20.dp))

            RadioButton(
                selected = statusSelecionado,
                onClick = { statusSelecionado = true }
            )
            Text("Não Concluído")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Prioridade", fontWeight = FontWeight.Bold)

        Row(verticalAlignment = Alignment.CenterVertically) {

            RadioButton(
                selected = prioritySelecionada == "Low",
                onClick = { prioritySelecionada = "Low" }
            )
            Text("Baixa")

            Spacer(modifier = Modifier.width(20.dp))

            RadioButton(
                selected = prioritySelecionada == "Medium",
                onClick = { prioritySelecionada = "Medium" }
            )
            Text("Média")

            Spacer(modifier = Modifier.width(20.dp))

            RadioButton(
                selected = prioritySelecionada == "High",
                onClick = { prioritySelecionada = "High" }
            )
            Text("Alta")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                DatePickerDialog(
                    context,
                    { _, year, month, day ->
                        dataSelecionada = "$day/${month + 1}/$year"
                    },
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
                ).show()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Escolher Data: $dataSelecionada")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {
                TimePickerDialog(
                    context,
                    { _, hour, minute ->
                        horaSelecionada = String.format("%02d:%02d", hour, minute)
                    },
                    calendar.get(Calendar.HOUR_OF_DAY),
                    calendar.get(Calendar.MINUTE),
                    true
                ).show()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Escolher Horário: $horaSelecionada")
        }

        Spacer(modifier = Modifier.height(20.dp))


        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    "Resumo da Atividade",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.height(12.dp))

                Row(modifier = Modifier.fillMaxWidth()) {
                    Text("Título:", fontWeight = FontWeight.Bold, modifier = Modifier.weight(0.3f))
                    Text(if (title.isEmpty()) "Não informado" else title, modifier = Modifier.weight(0.7f))
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(modifier = Modifier.fillMaxWidth()) {
                    Text("Status:", fontWeight = FontWeight.Bold, modifier = Modifier.weight(0.3f))
                    Text(if (!statusSelecionado) "Concluído" else "Não Concluído", modifier = Modifier.weight(0.7f))
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(modifier = Modifier.fillMaxWidth()) {
                    Text("Prioridade:", fontWeight = FontWeight.Bold, modifier = Modifier.weight(0.3f))
                    Text(
                        when (prioritySelecionada) {
                            "Low" -> "Baixa"
                            "Medium" -> "Média"
                            "High" -> "Alta"
                            else -> prioritySelecionada
                        },
                        modifier = Modifier.weight(0.7f)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(modifier = Modifier.fillMaxWidth()) {
                    Text("Data:", fontWeight = FontWeight.Bold, modifier = Modifier.weight(0.3f))
                    Text(dataSelecionada, modifier = Modifier.weight(0.7f))
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(modifier = Modifier.fillMaxWidth()) {
                    Text("Horário:", fontWeight = FontWeight.Bold, modifier = Modifier.weight(0.3f))
                    Text(horaSelecionada, modifier = Modifier.weight(0.7f))
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.fillMaxWidth()
        ) {

            Button(
                onClick = {
                    title = ""
                    statusSelecionado = false
                    prioritySelecionada = "High"
                    dataSelecionada = "Escolha uma data"
                    horaSelecionada = "Escolha um horário"
                    mensagem = ""
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Limpar")
            }

            Button(
                onClick = {

                    mensagem =
                        if (title.isEmpty())
                            "Digite um título"
                        else if (dataSelecionada == "Escolha uma data")
                            "Escolha uma data"
                        else if (horaSelecionada == "Escolha um horário")
                            "Escolha um horário"
                        else
                            "Atividade salva com sucesso!"
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Salvar")
            }
        }

        if (mensagem.isNotEmpty()) {

            Spacer(modifier = Modifier.height(20.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = if (mensagem.contains("sucesso", ignoreCase = true)) 
                        MaterialTheme.colorScheme.primaryContainer 
                    else 
                        MaterialTheme.colorScheme.errorContainer
                )
            ) {
                Text(
                    mensagem,
                    modifier = Modifier.padding(16.dp),
                    color = if (mensagem.contains("sucesso", ignoreCase = true)) 
                        MaterialTheme.colorScheme.onPrimaryContainer 
                    else 
                        MaterialTheme.colorScheme.onErrorContainer
                )
            }
        }
    }
}