package com.example.composedemo.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn//
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable//
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


data class ItemList(val name: String, val id: Int)

fun listValue(): List<ItemList> {
    var list: MutableList<ItemList> = mutableListOf()
    list.add(ItemList("a", 1))
    list.add(ItemList("b", 1))
    list.add(ItemList("c", 1))
    list.add(ItemList("d", 1))
    list.add(ItemList("ad", 1))
    list.add(ItemList("aw", 1))
    list.add(ItemList("aas", 1))

    return list

}

fun onCLicked(a : ItemList){}

@Composable
fun demoList(a : (ItemList) -> Unit){
    LazyColumn(content = {
        items(listValue()){

        }
    })
}





@Composable
fun ComposeList(a: (ItemList) -> Unit) {

    LazyColumn(content = {
        items(listValue()) {
            listDetail(it)
        }
    })
}

@Composable
fun listDetail(detailList: ItemList) {

    Column(
        modifier = Modifier
            .padding(12.dp)
            .background(Color.Red)
    ) {
        Button(onClick = {}) {
            Text(
                detailList.name,
                modifier = Modifier.padding(5.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
            Text(
                detailList.id.toString(),
                modifier = Modifier.padding(5.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
        }
    }

}