import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

fun main() {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://6559e1346981238d054cec1f.mockapi.io/")
        .addConverterFactory(JacksonConverterFactory.create())
        .build()

    val api = retrofit.create(Api::class.java)

    val response = api.getUsers().execute()

    if (response.isSuccessful) {
        // Afficher les utilisateurs dans la console
        val bod =  response.body()
        bod?.forEachIndexed { index, user ->
            println("User : ${index + 1} | name : ${user.name} | email : ${user.email} | password : ${user.password}")
        }
    } else {
        println("Erreur d'acces a l'API : ${response.code()}")
    }
}
