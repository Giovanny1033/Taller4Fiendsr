package com.example.taller4fiendsr.viewmodels

import android.content.Context
import androidx.lifecycle.MutableLiveData

class MainViewModel: ViewModel() {
    val profiles by lazy { MutableLiveData<List<ProfileInfor>>() }

    private val photos = listOf(
        "https://images.generated.photos/g-Jjt546lOmzbgwYmRj2Yu_W_wBUPr9z3URZnY5jYRM/rs:fit:512:512/wm:0.95:sowe:18:18:0.33/czM6Ly9pY29uczgu/Z3Bob3Rvcy1wcm9k/LmNvbmQvZTA4NDdi/MjMtM2JkNS00MjQ5/LTk2OWYtZDQwMzY0/YzhiNWJlLmpwZw.jpg",
        "https://images.generated.photos/Km-DjrpERe4PrMyn3rWdJLf0LOBEAdP6DF8UH2pAV4I/rs:fit:512:512/wm:0.95:sowe:18:18:0.33/czM6Ly9pY29uczgu/Z3Bob3Rvcy1wcm9k/LmNvbmQvMjJhNjVl/YTAtOWI1MC00YjAy/LTgxMTYtYzcxMWQ0/NDBiODQzLmpwZw.jpg",
        "https://images.generated.photos/5lEiIXoT8UkIfNkQ_gKVhbKBFB5opKEDsLHkt7V5fn8/rs:fit:512:512/wm:0.95:sowe:18:18:0.33/czM6Ly9pY29uczgu/Z3Bob3Rvcy1wcm9k/LmNvbmQvYTU3Yzhm/YTAtM2QxZS00NmE0/LTliNzMtYjcyMGFl/Y2NmM2U5LmpwZw.jpg",
        "https://images.generated.photos/Ail3TTDVQ7H80VcLPiZSB_CMH4NK7LBvYTx-11RshXw/rs:fit:512:512/wm:0.95:sowe:18:18:0.33/czM6Ly9pY29uczgu/Z3Bob3Rvcy1wcm9k/LmNvbmQvMGRiYjQz/ZTctM2JlNC00NGE3/LWIwNmMtNTkxYmJi/ZDRjYzNiLmpwZw.jpg",
        "https://images.generated.photos/5uxnXd_B__O30cXHt-zXaiqNr6_C9xEcYIk1IE4mjM4/rs:fit:512:512/wm:0.95:sowe:18:18:0.33/czM6Ly9pY29uczgu/Z3Bob3Rvcy1wcm9k/LmNvbmQvMTVmY2U4/NjItYWMyNi00YTQ4/LWE5M2MtNmFlMDJh/Y2IwY2UyLmpwZw.jpg",
        "https://images.generated.photos/qVRYxI8_zvb2ZohftHaAbm5gkoluxua0j-mR62wvo2g/rs:fit:512:512/wm:0.95:sowe:18:18:0.33/czM6Ly9pY29uczgu/Z3Bob3Rvcy1wcm9k/LmNvbmQvNGU2MjZl/YzUtMDA1OC00YzAz/LWIzNzctNWNlZTY4/YjIzZmE4LmpwZw.jpg",
        "https://images.generated.photos/Zjkk3BJoFeEoX29BTLliovTbddQ-kAfmbI8XaZTnrOU/rs:fit:512:512/wm:0.95:sowe:18:18:0.33/czM6Ly9pY29uczgu/Z3Bob3Rvcy1wcm9k/LmNvbmQvMzEzYTJk/YmItYzc5MS00NzUw/LThhMWYtZGNlOGY2/MjY0NzQyLmpwZw.jpg",
        "https://images.generated.photos/gQaLZ6aJXgZSxKVUe9M2rR-mHOMT9jev1VdDTg8og5Y/rs:fit:512:512/wm:0.95:sowe:18:18:0.33/czM6Ly9pY29uczgu/Z3Bob3Rvcy1wcm9k/LmNvbmQvYWE0ZGE5/OTktYzNhMS00YjVi/LThkNDktZDhmZGRj/YjhlZWRiLmpwZw.jpg",
        "https://images.generated.photos/K3Ixc-gkjdXskwssZPVuJa_CUN4POcb5GnnotLdMoaA/rs:fit:512:512/wm:0.95:sowe:18:18:0.33/czM6Ly9pY29uczgu/Z3Bob3Rvcy1wcm9k/LmNvbmQvNDliMmUy/ZjQtM2Q1Yy00ODk2/LTgzN2ItYjVhMDIx/ZGY4OTg5LmpwZw.jpg",
        "https://images.generated.photos/dFOrCTvuraXEWx7GnnU-t6ShvQX5RWcx0jSvOD0iobc/rs:fit:512:512/wm:0.95:sowe:18:18:0.33/czM6Ly9pY29uczgu/Z3Bob3Rvcy1wcm9k/LmNvbmQvYzUzNGEx/YTQtZWYzMy00MmU0/LWJjMjgtNmE2YzVm/N2M5ZTZmLmpwZw.jpg",

    )
    private val names = listOf(
        "Cristhian",
        "Sebastian",
        "Andres",
        "Laura",
        "Paula",
        "Valeria",
        "Leonardo",
        "Juana",
        "Esteban",
        "Lorena"
    )

    private val descriptions = listOf(
        "Hola, soy Cristhian, me gusta el fútbol y leer. Soy Ingeniero y puedo hacerte reír todos los días!",
        "Sebastian, soy Profesor aunque no parezca jajajja.",
        "Atractivo no soy, pero igual te interesa descubrir si soy simpático",
        "¿Te gustan las chicas malas? Yo soy mala en todo. Hasta jugando al xbox",
        "Capitana de mi propio barco, estoy buscando un miembro de la tripulación para viajar alrededor del mundo, Europa, mi ciudad o mi habitación. ¿Tienes un alma viajera? Pues ya somos dos",
        "¿Te gustan las chicas malas? Yo soy mala en todo. En el amor, en los estudios, en el trabajo…",
        "Demasiado joven para comprometerse y demasiado viejo para ligar. Es difícil ser un hombre de 30 años. Ah, ¿tú también estás en este caso? ¡Hagamos un clan de dos!",
        "Si te gustan las mujeres como los microondas soy tu chica. Fría por fuera, caliente por dentro.",
        "Cuando conozco a una chica atractiva lo primero que me fijo es en la inteligencia. Porque si no tiene es perfecta para mi.",
        "Haciendo simplemente una cosa, que se llama: LO QUE ME DA LA FACILIDAD"
    )

    fun generateProfiles(context: Context) {
        val list = mutableListOf<ProfileInfor>()
        for (i in 0..9) {
            list.add(
                ProfileInfor(
                    id = i.toString(),
                    photos[i],
                    names[i],
                    descriptions[i]
                )
            )
        }
        profiles.postValue(list)
    }

}