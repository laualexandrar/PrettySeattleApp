package com.lroap.prettyseattle.view.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.firebase.firestore.FirebaseFirestore
import com.lroap.prettyseattle.R
import com.lroap.prettyseattle.model.Picture
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBar(findViewById(R.id.toolbarMain))
        configNav()
    }

    fun configNav (){

        NavigationUI.setupWithNavController(bnvMenu, Navigation.findNavController(this, R.id.fragContent))
    }

}

//        val jsonArr = JSONArray(
//    "[\n" +
//            "  {\n" +
//            "    \"description\": \"El tulip festival es uno de los eventos mas esperados en la primavera, campos de tulipanes llenos de colores, tulipanes de todos los tipos y un ambiente muy agradable.\",\n" +
//            "    \"image\": \"https://drive.google.com/open?id=1r1ei-hQqFGq02un3DH7TgHC9B1PVdnLM\",\n" +
//            "    \"place\": \"Rooze\",\n" +
//            "    \"name\": \"Tulip Festival\",\n" +
//            "    \"instagram\": \"pretty_seattle\",\n" +
//            "    \"city\": \"Mount Vernon\"\n" +
//            "  },\n" +
//            "  {\n" +
//            "    \"description\": \"El Troll de Fremont, es uno de los lugares más visitados en Seattle, fue creado para evitar la delincuencia debajo del puente y es uno de los lugares más icónicos de Seattle. Lo puedes encontrar en la película, 10 cosas que odio de ti.\",\n" +
//            "    \"image\": \"https://drive.google.com/open?id=1SYvjRWxIRqk8oHCJQ-3ZnjDdaraS5zCd\",\n" +
//            "    \"place\": \"Fremont\",\n" +
//            "    \"name\": \"Fremont Troll\",\n" +
//            "    \"instagram\": \"pretty_seattle\",\n" +
//            "    \"city\": \"Seattle\"\n" +
//            "  },\n" +
//            "  {\n" +
//            "    \"description\": \"Este lugar tiene una vista hermosa, un lugar perfecto para caminar al rededor de la playa y la naturaleza. Esta ubicado a tan solo dos horas de Seattle y es totalmente hermoso.\",\n" +
//            "    \"image\": \"https://drive.google.com/open?id=1Joa3PxsLgzoBP-QacC9u9I0S2OT_frcZ\",\n" +
//            "    \"place\": \"Anacortes\",\n" +
//            "    \"name\": \"Deception pass\",\n" +
//            "    \"instagram\": \"pretty_seattle\",\n" +
//            "    \"city\": \"Anacortes\"\n" +
//            "  },\n" +
//            "  {\n" +
//            "    \"description\": \"Si quieres conocer en tan solo 15 minutos muchas de las maravillas que te ofrece el estado de Washington, definitivamente debes venir a este lugar y vivir la experiencia.\",\n" +
//            "    \"image\": \"ttps://drive.google.com/open?id=1VfdbI27tv82FB8co1f4KlAm16vLSuJZ9\",\n" +
//            "    \"place\": \"Seattle Waterfront\",\n" +
//            "    \"name\": \"Wings Over Washington\",\n" +
//            "    \"instagram\": \"pretty_seattle\",\n" +
//            "    \"city\": \"Seattle\"\n" +
//            "  },\n" +
//            "  {\n" +
//            "    \"description\": \"Esta es una de las atracciones que puedes encontrar en Seattle, puedes tener una gran vista de la ciudad y es perfecta para ver los atardeceres.\",\n" +
//            "    \"image\": \"https://drive.google.com/open?id=1VwDebNklD_mFNoSA6_Sw7AQ9DOoHGDIr\",\n" +
//            "    \"place\": \"Seattle Waterfront\",\n" +
//            "    \"name\": \"Seattle GreatWheel\",\n" +
//            "    \"instagram\": \"pretty_seattle\",\n" +
//            "    \"city\": \"Seattle\"\n" +
//            "  },\n" +
//            "  {\n" +
//            "    \"description\": \"En el Seattle Watertaxi puedes ir a west Seattle desde Downtown Seattle.\",\n" +
//            "    \"image\": \"https://drive.google.com/open?id=1wN0qJ_aecv53wUECrIyQmUtwONJeTdcM\",\n" +
//            "    \"place\": \"Seattle\",\n" +
//            "    \"name\": \"Watertaxi\",\n" +
//            "    \"instagram\": \"pretty_seattle\",\n" +
//            "    \"city\": \"Seattle\"\n" +
//            "  }\n" +
//            "]"
//)

//val jsonArr2 = JSONArray(
//    "[\n" +
//            "  {\n" +
//            "    \"description\": \"Esta foto fue tomada en abril del 2019.\",\n" +
//            "    \"datetime\": 1564830000,\n" +
//            "    \"placename\": \"Rooze\",\n" +
//            "    \"activityname\": \"Tulip Festival\",\n" +
//            "    \"tag\": \"Natauraleza\"\n" +
//            "  },\n" +
//            "  {\n" +
//            "    \"description\": \"El Troll de Fremont, es uno de los lugares más visitados en Seattle, esta foto fue tomada en febrero del 2020.\",\n" +
//            "    \"datetime\": 1564830000,\n" +
//            "    \"placename\": \"Fremont\",\n" +
//            "    \"activityname\": \"Fremont Troll\",\n" +
//            "    \"tag\": \"Esculturas\"\n" +
//            "  },\n" +
//            "  {\n" +
//            "    \"description\": \"Este lugar tiene una vista hermosa.\",\n" +
//            "    \"datetime\": 1564830000,\n" +
//            "    \"placename\": \"Anacortes\",\n" +
//            "    \"activityname\": \"Deception pass\",\n" +
//            "    \"tag\": \"Naturaleza\"\n" +
//            "  },\n" +
//            "  {\n" +
//            "    \"description\": \"Aqui se muestran las maravillas que te ofrece el estado de Washington.\",\n" +
//            "    \"datetime\": 1564830000,\n" +
//            "    \"placename\": \"Seattle Waterfront\",\n" +
//            "    \"activityname\": \"Wings Over Washington\",\n" +
//            "    \"tag\": \"Atracciones\"\n" +
//            "  },\n" +
//            "  {\n" +
//            "    \"description\": \"Esta es una de las atracciones que puedes encontrar en Seattle.\",\n" +
//            "    \"datetime\": 1564830000,\n" +
//            "    \"placename\": \"Seattle Waterfront\",\n" +
//            "    \"activityname\": \"Seattle GreatWheel\",\n" +
//            "    \"tag\": \"Atracciones\"\n" +
//            "  },\n" +
//            "  {\n" +
//            "    \"description\": \"En el Seattle Watertaxi puedes ir a west Seattle desde Downtown Seattle.\",\n" +
//            "    \"datetime\": 1564830000,\n" +
//            "    \"placename\": \"Seattle WaterTaxi\",\n" +
//            "    \"activityname\": \"Watertaxi\",\n" +
//            "    \"tag\": \"Transporte\"\n" +
//            "  }\n" +
//            "]"
//)
//
//
//val firebaseFirestore = FirebaseFirestore.getInstance()
//for (i in 0 until jsonArr.length()) {
//    val aux = jsonArr.get(i) as JSONObject
//    var picture = Picture()
//    picture.name = aux.getString("name")
//    picture.place = aux.getString("place")
//    picture.city = aux.getString("city")
//    picture.description = aux.getString("description")
//    picture.instagram = aux.getString("instagram")
//    picture.image = aux.getString("image")
//
//    firebaseFirestore.collection("pictures").document().set(picture)
//}

//for (i in 0 until jsonArr2.length()) {
//    val aux = jsonArr2.get(i) as JSONObject
//    var event = Event()
//    event.placename = aux.getString("placename")
//    event.description = aux.getString("description")
//    event.tag = aux.getString("tag")
//    val cal = Calendar.getInstance()
//    cal.timeInMillis = aux.getLong("datetime") * 1000
//    event.datetime = cal.time
//    event.activityname = aux.getString("activityname")
//
//    firebaseFirestore.collection("events").document().set(event)
//
//}




