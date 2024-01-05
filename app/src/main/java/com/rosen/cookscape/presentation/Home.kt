package com.rosen.cookscape.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.rosen.cookscape.R
import com.rosen.cookscape.ui.components.SearchTextField
import com.rosen.cookscape.ui.theme.AppBg
import com.rosen.cookscape.ui.theme.CookscapeTheme
import com.rosen.cookscape.ui.theme.Purple
import com.rosen.cookscape.ui.theme.TitleBlack
import com.rosen.cookscape.ui.theme.TransparentPurple
import com.rosen.cookscape.ui.theme.White

@Composable
fun Home(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = AppBg)
    ) {

        Header()

        Spacer(modifier = Modifier.height(16.dp))

        CategoryNavigation()

        Spacer(modifier = Modifier.height(16.dp))

        CategoryGrid(navController = navController)
    }
}

@Composable
fun Header() {
    var textValue by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(
                color = Purple,
                shape = RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp)
            )
            .padding(bottom = 24.dp)
    ) {

        Column {
            // Header
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, start = 24.dp, end = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    painter = painterResource(id = R.drawable.bubble),
                    contentDescription = null,
                    tint = White,
                    modifier = Modifier.size(32.dp)
                )

                Icon(
                    painter = painterResource(id = R.drawable.bell_outline),
                    contentDescription = null,
                    tint = White,
                    modifier = Modifier.size(32.dp)
                )

            }

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Hi Sonia",
                modifier = Modifier.padding(horizontal = 24.dp),
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium
                ),
            )

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Welcome Back \uD83D\uDC4F",
                modifier = Modifier.padding(horizontal = 24.dp),
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                ),
            )


            // Search bar
            Spacer(modifier = Modifier.height(16.dp))
            SearchTextField(
                modifier = Modifier
                    .padding(horizontal = 16.dp),
                value = textValue,
                hint = "what category are you searching for?",
                onValueChange = { textValue = it }
            )

        }

    }
}

@Composable
fun CategoryNavigation() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = "Categories",
            style = MaterialTheme.typography.bodyLarge.copy(
                color = TitleBlack,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            ),
        )

        Row {
            Icon(
                painter = painterResource(id = R.drawable.delete),
                contentDescription = null,
                tint = TransparentPurple,
                modifier = Modifier.size(32.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                painter = painterResource(id = R.drawable.edit),
                contentDescription = null,
                tint = TransparentPurple,
                modifier = Modifier.size(32.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                painter = painterResource(id = R.drawable.sync),
                contentDescription = null,
                tint = Purple,
                modifier = Modifier.size(32.dp)
            )
        }

    }
}

@Composable
fun CategoryGrid(navController: NavController) {

    val categories : MutableList<Category> = mutableListOf()
    categories.add(Category(textColor = Color(0xFFF9A03B), color = Color(0xFFFFF3C6), iconColor = Color(0xFFF9A03B), iconBackground = Color(0xFFFFFAE7), iconResId = R.drawable.bulb, category = "New Ideas"))
    categories.add(Category(textColor = Color(0xFF48A6F8), color = Color(0xFFD7EFFF), iconColor = Color(0xFF48A6F8), iconBackground = Color(0xFFF1F9FF), iconResId = R.drawable.music_note, category = "Music"))
    categories.add(Category(textColor = Color(0xFF7A5BF1), color = Color(0xFFE0D7FF), iconColor = Color(0xFF7A5BF1), iconBackground = Color(0xFFF4F1FF), iconResId = R.drawable.programming, category = "Programming"))
    categories.add(Category(textColor = Color(0xFFEE3FB9), color = Color(0xFFFBE1FB), iconColor = Color(0xFFEE3FB9), iconBackground = Color(0xFFFFEFFF), iconResId = R.drawable.cooking, category = "Cooking"))
    categories.add(Category(textColor = Color(0xFF34A27C), color = Color(0xFFB8EEDC), iconColor = Color(0xFF34A27C), iconBackground = Color(0xFFE4FFF6), iconResId = R.drawable.plane, category = "Travel"))
    categories.add(Category( textColor = Color(0xFFFE8C74), color = Color(0xFFFFDFCE), iconColor = Color(0xFFFE8C74), iconBackground = Color(0xFFFFF2EB), iconResId = R.drawable.sports, category = "Sports"))

    LazyVerticalGrid(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 72.dp),
        columns = GridCells.Fixed(2)
    ) {
        itemsIndexed(categories) { _, category ->
            CategoryItem(
                navController = navController,
                textColor = category.textColor,
                color = category.color,
                iconColor = category.iconColor,
                iconBackground = category.iconBackground,
                iconResId = category.iconResId,
                category = category.category
            )
        }
    }
}

data class Category(
    val textColor: Color,
    val color: Color,
    val iconColor: Color,
    val iconBackground: Color,
    val iconResId: Int,
    val category: String
)

@Composable
fun CategoryItem(
    navController: NavController,
    textColor: Color,
    color: Color,
    iconColor: Color,
    iconBackground: Color,
    iconResId: Int,
    category: String
) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(bounded = false),
                onClick = {
                    navController.navigate("category_detail/1")
                }
            ),
        colors = CardDefaults.cardColors(
            containerColor = color
        ),
        shape = RoundedCornerShape(24.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .background(color = iconBackground, shape = CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = iconResId),
                        contentDescription = null,
                        tint = iconColor,
                        modifier = Modifier.size(50.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = category,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = textColor,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    ),
                )

            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    CookscapeTheme {
        val navController = rememberNavController()
        Home(navController)
    }
}