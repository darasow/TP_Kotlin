import retrofit2.Call
import retrofit2.http.GET

// Interface de l'API
interface Api {
    // Cette méthode effectue une requête GET vers l'endpoint "users"
    @GET("users")
    // Cette méthode indique que la requête renverra une liste d'objets User
    fun getUsers(): Call<List<User>>
}