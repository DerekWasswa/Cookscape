package com.rosen.cookscape.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.rosen.cookscape.R
import com.rosen.cookscape.navigation.Route
import com.rosen.cookscape.ui.theme.CookscapeTheme
import com.rosen.cookscape.ui.theme.Purple
import com.rosen.cookscape.ui.theme.TransparentPurple
import com.rosen.cookscape.ui.theme.White


@Composable
fun BottomNavigationBar(navController: NavHostController) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val navBarScreens = listOf(
        Route.Home,
        Route.Bookmarks,
    )

    if (currentDestination?.route in navBarScreens.map { it.route })

        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.TopCenter
        ) {
            NavigationBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)),
                containerColor = White,
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(horizontal = 32.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    AddNavigationBarItem(
                        label = "Home",
                        iconResId = R.drawable.home_default,
                        focusedIconResId = R.drawable.home_active,
                        destinationRoute = Route.Home,
                        currentDestination = currentDestination,
                        navController = navController
                    )

                    AddNavigationBarItem(
                        label = "Favorites",
                        iconResId = R.drawable.kid_star_default,
                        focusedIconResId = R.drawable.kid_star_active,
                        destinationRoute = Route.Bookmarks,
                        currentDestination = currentDestination,
                        navController = navController
                    )

                }
            }

            Box(
                modifier = Modifier
                    .offset(0.dp, (-26).dp),
                contentAlignment = Alignment.Center
            ) {
                Card(
                    modifier = Modifier
                        .wrapContentSize()
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = rememberRipple(bounded = false),
                            onClick = {
                                navController.navigate("add_category_product")
                            }
                        ),
                    colors = CardDefaults.cardColors(
                        containerColor = Purple
                    ),
                    shape = CircleShape,
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 8.dp
                    )
                ) {

                    Box(
                        modifier = Modifier
                            .size(60.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = null,
                            tint = White,
                            modifier = Modifier.size(40.dp)
                        )
                    }

                }
            }
        }
}


@Composable
private fun RowScope.AddNavigationBarItem(
    label : String,
    iconResId: Int,
    focusedIconResId: Int,
    destinationRoute: Route,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    val selected = currentDestination?.hierarchy?.any { it.route == destinationRoute.route } == true

    val contentColor =
        if (selected) Purple else TransparentPurple

    Box(
        modifier = Modifier
            .clickable(onClick = {
                navController.navigate(destinationRoute.route) {
                    popUpTo(navController.graph.findStartDestination().id)
                    launchSingleTop = true
                }
            })
    ) {
        Row(
            modifier = Modifier
                .padding(start = 12.dp, end = 12.dp, top = 8.dp, bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Icon(
                painter = painterResource(id = if (selected) focusedIconResId else iconResId),
                contentDescription = "icon",
                tint = contentColor,
                modifier = Modifier.size(32.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
    CookscapeTheme {
        val navController = rememberNavController()
        BottomNavigationBar(navController = navController)
    }
}