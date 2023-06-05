//Composable function to render the content of the auto-complete field.
package com.fdj.players.ui.screens.leagues.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.fdj.players.models.League
class AutoCompleteField {

    /**
     * Composable function to render the content of the auto-complete field.
     *
     * @param leagues The list of leagues to display in the auto-complete field.
     * @param onItemClick Callback invoked when a league item is clicked.
     */
    @Composable
    fun content(leagues: List<League>, onItemClick: (League) -> Unit) {
        val searchText = remember { mutableStateOf(TextFieldValue("")) }

        // Filter the leagues based on the search text
        val filteredLeagues = leagues.filter {
            it.strLeague.contains(searchText.value.text, ignoreCase = true)
        }

        val showList = searchText.value.text.isNotBlank()

        Surface(color = MaterialTheme.colors.background) {
            Column {
                // Display the text field for search input
                TextField(
                    value = searchText.value,
                    onValueChange = { searchText.value = it },
                    modifier = Modifier.padding(16.dp)
                )

                // Display the list of filtered leagues if there is a search query
                if (showList) {
                    LazyColumn {
                        items(filteredLeagues) { league ->
                            // Display each league item as a clickable text
                            Text(
                                text = league.strLeague,
                                modifier = Modifier.clickable { onItemClick(league) }
                            )
                        }
                    }
                }
            }
        }
    }
}