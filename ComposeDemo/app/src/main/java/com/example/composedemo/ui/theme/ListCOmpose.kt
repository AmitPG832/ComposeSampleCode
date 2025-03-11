package com.example.composedemo.ui.theme

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composedemo.data.DetailList

@Preview(showBackground = true)
@Composable
fun ListCompose() {

    LazyColumn(content = {
        items(DetailListData()) { it ->
            listItems(it)
        }
    })
}

@Composable
fun listItems(data: DetailList.Movies) {
    Row(modifier = Modifier.padding(15.dp)) {
        Text(
            text = data.name,
            modifier = Modifier
                .padding(10.dp),
            fontSize = 15.sp
        )
        Text(
            text = data.year,
            modifier = Modifier
                .padding(10.dp),
            fontSize = 15.sp
        )
    }
}

fun DetailListData(): List<DetailList.Movies> {
    var list = mutableListOf<DetailList.Movies>(
        DetailList.Movies("Amit", "1990"),
        DetailList.Movies("Amit1", "1991"),
        DetailList.Movies("Amit2", "1992"),
        DetailList.Movies("Amit3", "1993"),
        DetailList.Movies("Amit4", "1994"),
        DetailList.Movies("Amit5", "1995"),
        DetailList.Movies("Amit6", "1996"),
        DetailList.Movies("Amit", "1990"),
        DetailList.Movies("Amit1", "1991"),
        DetailList.Movies("Amit2", "1992"),
        DetailList.Movies("Amit3", "1993"),
        DetailList.Movies("Amit4", "1994"),
        DetailList.Movies("Amit5", "1995"),
        DetailList.Movies("Amit6", "1996"),
        DetailList.Movies("Amit", "1990"),
        DetailList.Movies("Amit1", "1991"),
        DetailList.Movies("Amit2", "1992"),
        DetailList.Movies("Amit3", "1993"),
        DetailList.Movies("Amit4", "1994"),
        DetailList.Movies("Amit5", "1995"),
        DetailList.Movies("Amit6", "1996")
    )
    return list
}