package com.rosen.cookscape.navigation

sealed class Route(val route: String) {
    object Home : Route("home")
    object Bookmarks : Route("bookmarks")
    object CategoryDetail : Route("category_detail")
    object AddCategoryProduct : Route("add_category_product")
}