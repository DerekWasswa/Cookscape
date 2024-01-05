package com.rosen.cookscape.presentation

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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rosen.cookscape.R
import com.rosen.cookscape.ui.components.SearchTextField
import com.rosen.cookscape.ui.theme.AppBg
import com.rosen.cookscape.ui.theme.CookscapeTheme
import com.rosen.cookscape.ui.theme.PaleWhite
import com.rosen.cookscape.ui.theme.Purple
import com.rosen.cookscape.ui.theme.TitleBlack
import com.rosen.cookscape.ui.theme.TransparentPurple
import com.rosen.cookscape.ui.theme.White

@Composable
fun CategoryDetail(categoryId: String?) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = AppBg)
    ) {

        CategoryDetailHeader()

        Spacer(modifier = Modifier.height(16.dp))

        CategoryDetailNavigation()

        Spacer(modifier = Modifier.height(16.dp))

        CategoryProductsGrid()

    }

}

@Composable
fun CategoryDetailHeader() {
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
                    painter = painterResource(id = R.drawable.back),
                    contentDescription = null,
                    tint = White,
                    modifier = Modifier.size(24.dp)
                )

                Text(
                    text = "Cooking",
                    modifier = Modifier.padding(horizontal = 24.dp),
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    ),
                )

                Icon(
                    painter = painterResource(id = R.drawable.bell_outline),
                    contentDescription = null,
                    tint = White,
                    modifier = Modifier.size(32.dp)
                )

            }

            // Search bar
            Spacer(modifier = Modifier.height(24.dp))
            SearchTextField(
                modifier = Modifier
                    .padding(horizontal = 16.dp),
                value = textValue,
                hint = "what bookmark are you searching for?",
                onValueChange = { textValue = it }
            )

        }

    }
}

@Composable
fun CategoryDetailNavigation() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
    ) {

        Text(
            text = "Labels",
            style = MaterialTheme.typography.bodyLarge.copy(
                color = TitleBlack,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            ),
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .width(40.dp)
                    .height(32.dp)
                    .border(2.dp, color = Purple, shape = RoundedCornerShape(16.dp)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    tint = Purple,
                    modifier = Modifier.size(24.dp)
                )
            }

            Labels()
        }

        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "Bookmarks",
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
                    tint = Purple,
                    modifier = Modifier.size(32.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    painter = painterResource(id = R.drawable.logout),
                    contentDescription = null,
                    tint = Purple,
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

        Row {
            Icon(
                painter = painterResource(id = R.drawable.bookmark),
                contentDescription = null,
                tint = Color(0xFF929294),
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "154",
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = Color(0xFF929294),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                ),
            )
        }

    }
}

@Composable
fun CategoryProductsGrid() {

    val products : MutableList<CategoryProduct> = mutableListOf()
    products.add(CategoryProduct(imageResId = R.drawable.vanilacake1, category = "Vanilla Cake"))
    products.add(CategoryProduct(imageResId = R.drawable.cake2, category = "Cupcake"))
    products.add(CategoryProduct(imageResId = R.drawable.pancake2, category = "Pancake"))
    products.add(CategoryProduct(imageResId = R.drawable.donat1, category = "Donat"))
    products.add(CategoryProduct(imageResId = R.drawable.cake5, category = "Muffins"))
    products.add(CategoryProduct(imageResId = R.drawable.cake3, category = "Groupies"))

    LazyVerticalGrid(
        modifier = Modifier.padding(horizontal = 16.dp),
        columns = GridCells.Fixed(1)
    ) {
        itemsIndexed(products) { _, product ->
            ProductItem(
                imageResId = product.imageResId,
                product = product.category
            )
        }
    }
}

data class CategoryProduct(
    val imageResId: Int,
    val category: String
)

@Composable
fun ProductItem(
    imageResId: Int,
    product: String
) {
    var isBookmark by remember { mutableStateOf(false) }
    var isStar by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(bounded = false),
                onClick = {}
            ),
        colors = CardDefaults.cardColors(
            containerColor = White
        ),
        shape = RoundedCornerShape(24.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Row {

                Box(
                    modifier = Modifier
                        .size(80.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = imageResId),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(shape = RoundedCornerShape(16.dp))
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                Column(
                    modifier = Modifier.height(80.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = product,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            color = TitleBlack,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        ),
                    )

                    Row {
                        Icon(
                            painter = painterResource(id = R.drawable.notifications_filled),
                            contentDescription = null,
                            tint = if (isBookmark) Color(0xFFFF8A00) else TransparentPurple,
                            modifier = Modifier
                                .size(24.dp)
                                .clickable(
                                    interactionSource = remember { MutableInteractionSource() },
                                    indication = rememberRipple(bounded = false),
                                    onClick = { isBookmark = !isBookmark }
                                )
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Icon(
                            painter = painterResource(id = R.drawable.kid_star_filled),
                            contentDescription = null,
                            tint = if (isStar) Color(0xFFFF8A00) else TransparentPurple,
                            modifier = Modifier
                                .size(24.dp)
                                .clickable(
                                    interactionSource = remember { MutableInteractionSource() },
                                    indication = rememberRipple(bounded = false),
                                    onClick = { isStar = !isStar }
                                )
                        )
                    }
                }
            }

            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(color = Color(0xFFFF8A00), shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.door_open),
                    contentDescription = null,
                    tint = White,
                    modifier = Modifier.size(24.dp)
                )
            }

        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Labels() {
    val labels = listOf("All", "Cake", "Fast Food", "Kebab", "Chap")

    var selectedItem by remember {
        mutableStateOf(labels[1])
    }

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        itemsIndexed(labels) { _, label ->
            FilterChip(
                modifier = Modifier
                    .padding(start = 8.dp),
                selected = (label == selectedItem),
                onClick = {
                    selectedItem = label
                },
                label = {
                    Text(
                        text = label,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        ),
                    )
                },
                colors = FilterChipDefaults.filterChipColors(
                    containerColor = TransparentPurple,
                    selectedContainerColor = Purple,
                    selectedLabelColor = White,
                    labelColor = PaleWhite
                ),
                shape = RoundedCornerShape(16.dp),
                border = FilterChipDefaults.filterChipBorder(
                    borderWidth = 0.dp,
                    borderColor = Color.Transparent
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryDetailPreview() {
    CookscapeTheme {
        CategoryDetail("")
    }
}