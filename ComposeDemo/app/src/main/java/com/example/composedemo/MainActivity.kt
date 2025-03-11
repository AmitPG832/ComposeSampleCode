package com.example.composedemo

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.composedemo.ui.theme.ComposeDemoTheme
import com.example.composedemo.ui.theme.ComposeList
import com.example.composedemo.ui.theme.DetailView
import com.example.composedemo.ui.theme.ItemList
import com.example.composedemo.ui.theme.ListDetail
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeDemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android", modifier = Modifier.padding(innerPadding)
                    )
//                    populateDetailList({
//                        println("vale isss $it")
//                    })
                    //ListCompose()


//                    ListDetail(){
//                      onButtonCLick(it)
//                    }

                    ComposeList {
                        onCLicked(it)
                    }
                }
            }
        }
    }
}

fun onCLicked(a : ItemList){

}

fun onButtonCLick(value : DetailView){
    Log.i("value isss on click", value.toString())
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!", modifier = modifier
    )
}

@Composable
fun populateDetailList(a: (String) -> Unit) {

    val state = remember { mutableStateOf("") }
    Column {
        Text(
            "Amit",
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            color = Color.Red,
            fontSize = 36.sp,
            textAlign = TextAlign.Center
        )
        Row(modifier = Modifier.padding(10.dp)) {
            Text(
                modifier = Modifier
                    .padding(end = 10.dp)
                    .fillMaxSize(.2f)
                    .wrapContentHeight(),
                text = "Name",
                textAlign = TextAlign.Center
            )
            TextField(value = state.value, onValueChange = {
                state.value = it
            })
        }
        inputList(a, state.value)
    }
}

@Composable
fun inputList(a: (String) -> Unit, value: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Red),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Button(
            onClick = {
                a.invoke(value)
            },


            ) {
            Text(text = "Submit")
        }
    }


}

@Preview(showBackground = true, widthDp = 300, heightDp = 300)
@Composable
fun constraintDemo() {

    ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
        val (t1, t2, t3, t4, t5) = createRefs()

        Text(text = "Text1",
            modifier = Modifier.constrainAs(t1) {
                start.linkTo(parent.start)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            })
        Text(text = "Text2",
            modifier = Modifier.constrainAs(t2) {
                start.linkTo(t1.end)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            }.background(Color.Gray))
        Text(text = "Text3",
            modifier = Modifier.constrainAs(t3) {
                start.linkTo(t2.end)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            }.background(Color.Red))
        Text(text = "Text4",
            modifier = Modifier.constrainAs(t4) {
                start.linkTo(t3.end)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            })
        Text(text = "Text5",
            modifier = Modifier.constrainAs(t5) {
                start.linkTo(t4.end)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            })

    }
}

@Composable
fun GreetingPreview() {
    ComposeDemoTheme {
        Greeting("Android")
    }
}