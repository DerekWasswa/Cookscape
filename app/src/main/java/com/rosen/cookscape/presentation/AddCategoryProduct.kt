package com.rosen.cookscape.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rosen.cookscape.R
import com.rosen.cookscape.ui.theme.CookscapeTheme
import com.rosen.cookscape.ui.theme.Purple
import com.rosen.cookscape.ui.theme.TitleBlack
import com.rosen.cookscape.ui.theme.TransparentPurple
import com.rosen.cookscape.ui.theme.White

@Composable
fun AddCategoryProduct() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Purple)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            AddProductHeader()
        }

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
                .padding(top = 30.dp),
            contentAlignment = Alignment.TopEnd
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color(0xFFF8F8FF),
                        shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)
                    )
            ) {

                Column(
                    modifier = Modifier
                        .padding(vertical = 24.dp)
                        .fillMaxSize(),
                ) {

                    // title
                    DetailsRow("Title", R.drawable.letter_h)
                    Spacer(modifier = Modifier.height(4.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp)
                            .background(color = White, shape = RoundedCornerShape(8.dp)),
                    ) {
                        Text(
                            text = "Cupcake",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp, vertical = 10.dp),
                            style = MaterialTheme.typography.bodyLarge.copy(
                                color = Color(0xFF8F8F8F),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            ),
                        )

                    }

                    // Url
                    Spacer(modifier = Modifier.height(16.dp))
                    DetailsRow("Url", R.drawable.link)
                    Spacer(modifier = Modifier.height(4.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp)
                            .background(color = White, shape = RoundedCornerShape(8.dp)),
                    ) {
                        Text(
                            text = "https://www.happycake.ir/recipe/cupcake/3...",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp, vertical = 10.dp),
                            style = MaterialTheme.typography.bodyLarge.copy(
                                color = Color(0xFF8F8F8F),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            ),
                        )

                    }

                    // description
                    Spacer(modifier = Modifier.height(16.dp))
                    DetailsRow("Description", R.drawable.description)
                    Spacer(modifier = Modifier.height(4.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp)
                            .background(color = White, shape = RoundedCornerShape(8.dp)),
                    ) {
                        Text(
                            text = "Preheat the oven to 350 degrees F (175 degrees C). Grease and " +
                                    "flour a 9-inch square cake pan. Cream sugar and butter together in a mixing bowl. Add " +
                                    "oven until the top springs back when lightly touched, 30 to 40 minutes.",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp, vertical = 10.dp),
                            style = MaterialTheme.typography.bodyLarge.copy(
                                color = Color(0xFF8F8F8F),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            ),
                        )

                    }

                    Spacer(modifier = Modifier.height(16.dp))
                    DetailsRow("Photos", R.drawable.photo)
                    Spacer(modifier = Modifier.height(4.dp))
                    Photos()

                    Spacer(modifier = Modifier.height(16.dp))
                    DetailActions()

                }

            }

            Box(
                modifier = Modifier
                    .offset((-30).dp, (-26).dp),
                contentAlignment = Alignment.Center
            ) {
                Row {

                    Card(
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = rememberRipple(bounded = false),
                                onClick = {

                                }
                            ),
                        colors = CardDefaults.cardColors(
                            containerColor = White
                        ),
                        shape = CircleShape,
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 8.dp
                        )
                    ) {

                        Box(
                            modifier = Modifier
                                .size(50.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.notifications_filled),
                                contentDescription = null,
                                tint = TransparentPurple,
                                modifier = Modifier.size(30.dp)
                            )
                        }

                    }

                    Spacer(modifier = Modifier.width(10.dp))

                    Card(
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = rememberRipple(bounded = false),
                                onClick = {

                                }
                            ),
                        colors = CardDefaults.cardColors(
                            containerColor = White
                        ),
                        shape = CircleShape,
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 8.dp
                        )
                    ) {

                        Box(
                            modifier = Modifier
                                .size(50.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.kid_star_filled),
                                contentDescription = null,
                                tint = Color(0xFFFF8A00),
                                modifier = Modifier.size(30.dp)
                            )
                        }

                    }
                }
            }


        }

    }

}

@Composable
fun Photos() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 24.dp)
            .background(
                color = Color(0xFFE7E4FF),
                shape = RoundedCornerShape(topStart = 16.dp, bottomStart = 16.dp)
            ),
    ) {

        val photos : MutableList<Int> = mutableListOf()
        photos.add(R.drawable.cake2)
        photos.add(R.drawable.cake6)
        photos.add(R.drawable.vanillacake2)
        photos.add(R.drawable.pancake2)
        photos.add(R.drawable.donat2)

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.width(16.dp))

            Box(
                modifier = Modifier
                    .size(70.dp)
                    .border(2.dp, color = Purple, shape = RoundedCornerShape(16.dp)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    tint = Purple,
                    modifier = Modifier.size(32.dp)
                )
            }

            LazyHorizontalGrid(
                modifier = Modifier
                    .height(100.dp),
                rows = GridCells.Fixed(1)
            ) {
                itemsIndexed(photos) { _, photo ->
                    Box(
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .wrapContentSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = photo),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .height(70.dp)
                                .width(70.dp)
                                .clip(shape = RoundedCornerShape(16.dp))
                        )
                    }
                }
            }
        }

    }
}

@Composable
fun AddProductHeader() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            painter = painterResource(id = R.drawable.back),
            contentDescription = null,
            tint = White,
            modifier = Modifier.size(24.dp)
        )

        Text(
            text = "Cupcake",
            modifier = Modifier.padding(horizontal = 24.dp),
            style = MaterialTheme.typography.bodyLarge.copy(
                color = White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            ),
        )

        Icon(
            imageVector = Icons.Outlined.Share,
            contentDescription = null,
            tint = White,
            modifier = Modifier.size(32.dp)
        )

    }
}

@Composable
fun DetailsRow(value: String, icon: Int) {
    Row(
        modifier = Modifier.padding(horizontal = 24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = TransparentPurple,
            modifier = Modifier.size(32.dp)
        )
        Text(
            text = value,
            modifier = Modifier.padding(horizontal = 8.dp),
            style = MaterialTheme.typography.bodyLarge.copy(
                color = TitleBlack,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            ),
        )
    }
}

@Composable
fun DetailActions() {
    Row(
        modifier = Modifier
            .padding(horizontal = 24.dp)
            .fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {


        OutlinedButton(
            onClick = { },
            border = BorderStroke(2.dp, Purple),
            shape = RoundedCornerShape(corner = CornerSize(8.dp)),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Purple,
            )
        ) {
            Text(
                text = "cansel",
                modifier = Modifier.padding(horizontal = 24.dp),
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = Purple,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                ),
            )
        }

        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(
                contentColor = White,
                containerColor = Purple
            ),
            shape = RoundedCornerShape(corner = CornerSize(8.dp))
        ) {
            Text(
                text = "save",
                modifier = Modifier.padding(horizontal = 24.dp),
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                ),
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun AddCategoryProductPreview() {
    CookscapeTheme {
        AddCategoryProduct()
    }
}