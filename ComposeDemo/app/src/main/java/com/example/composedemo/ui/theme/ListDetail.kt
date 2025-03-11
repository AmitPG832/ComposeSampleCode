package com.example.composedemo.ui.theme

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composedemo.data.DetailList

data class DetailView(val name: String, val id: Int)

@Preview(showBackground = true)
@Composable
fun ListDetail(param: (DetailView) -> Unit) {

    LazyColumn(content = {
        items(getList()) {
            ListItem(it,param)
        }

    })
}

@Composable
fun ListItem(data: DetailView, param: (DetailView) -> Unit) {
    Row {
        Button(onClick = {
            param.invoke(data)
        }) {
            Text(
                text = data.name,
                modifier = Modifier
                    .padding(10.dp),
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,

                )
            Text(
                text = data.id.toString(),
                modifier = Modifier
                    .padding(10.dp),
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}


fun getList(): List<DetailView> {
    var list: MutableList<DetailView> = mutableListOf()
    list.add(DetailView("Amit", 1))
    list.add(DetailView("Amit", 1))
    list.add(DetailView("Amit", 1))
    list.add(DetailView("Amit", 1))
    list.add(DetailView("Amit", 1))
    list.add(DetailView("Amit", 1))
    list.add(DetailView("Amit", 1))

    return list

}


