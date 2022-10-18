import com.example.climahoje.Model.City

data class Root(
    val cod: String,
    val message: Long,
    val cnt: Long,
    val list: List<com.example.climahoje.Model.List>,
    val city: City,
): java.io.Serializable

