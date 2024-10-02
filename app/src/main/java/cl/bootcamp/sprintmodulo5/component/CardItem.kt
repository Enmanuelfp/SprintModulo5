package cl.bootcamp.sprintmodulo5.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ShoeCardItem(
    img: Painter,
    title: String,
    price: String,
    cantidad: Int,
    clickUp: ()->Unit,
    clickDown:()->Unit,
    clickDelete: ()->Unit
) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = img,
                    contentDescription = null,
                    modifier = Modifier
                        .size(90.dp)
                        .clip(RoundedCornerShape(5.dp))
                )
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
                Text(
                    text = "$price CLP",
                    fontWeight = FontWeight.Black,
                    fontSize = 25.sp

                )

            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = clickDown) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = null
                    )
                }
                Text(
                    text = "Cantidad $cantidad",
                    fontWeight = FontWeight.Black,
                    fontSize = 20.sp

                )
                IconButton(onClick = clickUp) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowUp,
                        contentDescription = null
                    )
                }

                IconButton(onClick = clickDelete) {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = null
                    )
                }
            }
        }

    }
}