package fingerfire.com.overwatch.features.heroes.data.response

data class HistoryResponse(
    val session: String,
    val description: String,
    val displayIcon: String,
) {
    var isExpanded: Boolean = false
}