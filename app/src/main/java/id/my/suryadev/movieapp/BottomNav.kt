package id.my.suryadev.movieapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class NavPage(var name: String, var icon: ImageVector, var route: String)

object Routes {
    var HomePage = NavPage("Home", Icons.Outlined.Home, "home")
    var SearchPage = NavPage("Search", Icons.Outlined.Search, "searh")
    var ReviewPage = NavPage("Review", Icons.Outlined.Star, "review")

    val pages = listOf(HomePage, SearchPage, ReviewPage)
}

@Composable
fun NavbarItem(page: NavPage, selected: Boolean = false, modifier: Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(horizontal = 12.dp)
    ) {
        Icon(
            imageVector = page.icon,
            contentDescription = page.name,
            modifier = Modifier
                .padding(bottom = 8.dp)
                .size(24.dp),
            tint = if (selected) Color(0xFFF0EFEF) else Color(0xFFA3A4A5)
        )
        Text(page.name, fontSize = 12.sp, color = Color(0xFFA3A4A5))
    }
}

@Composable
fun BottomNavbar(
    selectedRoute: String = Routes.HomePage.route,
    onChange: (String) -> Unit = {}
) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .background(color = Color(0xFF191B1D))
            .padding(12.dp)
            .fillMaxWidth()
    ) {
        for (page in Routes.pages) {
            NavbarItem(
                page,
                selected = selectedRoute == page.route,
                modifier = Modifier.clickable {
                    onChange(page.route)
                }
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 350)
@Composable
fun PreviewNavbar(modifier: Modifier = Modifier) {
    BottomNavbar("home", onChange = {})
}